/* MRS -- Gricel Vazquez
 * 2022
 * 
 * Main class. Run multi-robot system (MRS) task allocation and scheduling.
*/


package uoy.mrs.uoy.mrs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import parser.ast.ModulesFile;
import parser.ast.PropertiesFile;
import prism.Prism;
import prism.PrismDevNullLog;
import prism.PrismException;
import prism.PrismLog;
import prism.Result;
/*
 * Create an MDP model from allocation and permutation of tasks
 * */
public class runPrismModel{
	
	/**Num of tasks allocated to a robot*/
	public static int numTasks(ArrayList<String[]> tTask,String robID) {
		Integer n = 0;
		for (int i = 0; i < tTask.size(); i++) {
			if (tTask.get(i)[0].equals(robID)) {n++;}}
		return n;
	}
	/**List of robots*/
	public static String[] robIDList(ArrayList<String[]> tTask) {
		Set<String> robSet = new HashSet<>();
		for (int i = 0; i < tTask.size(); i++) {
			robSet.add(tTask.get(i)[0]);}
		return robSet.toArray(new String[0]);
	}
	/**Number of robot*/
	public static int numRob(ArrayList<String[]> tTask) {return robIDList(tTask).length;}
	/**Time to do task by a robot*/
	public static String getTimeTask(String robID, String taskID, ArrayList<String[]> tTask) {
		for (Iterator<String[]> iterator = tTask.iterator(); iterator.hasNext();) {
			String[] robTaskTime = (String[]) iterator.next();
			if (robTaskTime[0]==robID) {
				if(robTaskTime[1]==taskID) {
					return robTaskTime[2];
				}}}
		System.err.println("Check getTimeTask");
		return null;
	}
	/**Time available to idle for a robot*/
	public static int checkRobotTimeToIdle(String robID, int TT, ArrayList<String[]> tTask, ArrayList<String[]> tTravel) {
		int n=TT;
		//time for task
		for (Iterator<String[]> iterator = tTask.iterator(); iterator.hasNext();) {
			String[] strings = (String[]) iterator.next();
			if(strings[0]==robID) {n-=Integer.parseInt(strings[2]);}}
		//time for travelling
		for (Iterator<String[]> iterator = tTravel.iterator(); iterator.hasNext();) {
			String[] strings = (String[]) iterator.next();
			if(strings[0]==robID) {n-=Integer.parseInt(strings[3]);}}
		//time for travel and tasks exceeds time available
		if(n<0) {
			System.err.println("Robot "+robID+" requires more time to travel and do tasks ("+ (TT-n) +" needed) than time available, "+TT);
			System.exit(0);}
		return n;}
	/**Save to file*/
	public static void save2File(StringBuilder sb,String filePath) {
		// Convert the StringBuilder to a String
        String content = sb.toString();
        // Use FileWriter to write the content to the file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("Content saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	/*Array: robot id, task, duration: {"r1","t1","3"}*/
	public static ArrayList<String[]> tTask = new ArrayList<String[]>();
	/*Array permutation of tasks: "r1", new String[]{"t1", "t2"}*/
	public static Map<String, String[]> permutation = new HashMap<>();
	/*Idle time limits*/
	public static Map<String, Integer> idleTime = new HashMap<>();
	
	
	//list[] to arraylist
	//ArrayList<String> arraylist = new ArrayList<>(Arrays.asList(l));
	
	
	/**======================== Main ========================= */
	public static void main( String[] args )  throws Exception{
		
		//=========================================================
		//========== Variables defined by user:
		//a) total time
		int TT = 12; 
		

		// b) tasks
		ArrayList<String> subtasks1 = new ArrayList<>(Arrays.asList("t1", "t2", "t3","t4"));
		Compound ct1= new Compound("ct1",subtasks1,true,false);
		
		
		// b) time completion tasks
		String[] r1t1 = {"r1","t1","3"}; tTask.add(r1t1);
		String[] r1t2 = {"r1","t2","3"}; tTask.add(r1t2);
		String[] r2t3 = {"r2","t3","3"}; tTask.add(r2t3);
		String[] r2t4 = {"r2","t4","3"}; tTask.add(r2t4);
		
		// c) task permutations
		permutation.put("r1", new String[]{"t1", "t2"});
		permutation.put("r2", new String[]{"t3", "t4"});
		
		// d) travelling times - name 'l0' for initial location
		ArrayList<String[]> tTravel = new ArrayList<String[]>();
		String[] trip1 = {"r1","l0","t1","3"}; tTravel.add(trip1);
		String[] trip2 = {"r1","t1","t2","3"}; tTravel.add(trip2);
		String[] trip3 = {"r2","l0","t3","3"}; tTravel.add(trip3);
		String[] trip4 = {"r2","t3","t4","3"}; tTravel.add(trip4);
		//=========================================================
		
		//=========================================================
		//BUILD PRISM MODEL:
		//get list robot IDs
		String[] robIDset = robIDList(tTask);
		
		//compute idle time
		for (int i = 0; i < robIDset.length; i++) {
			String r = robIDset[i];
			idleTime.put(r, checkRobotTimeToIdle(r, TT, tTask, tTravel));
		}
		//Prism model:
		StringBuilder model = new StringBuilder();
		model.append("mdp\n\n");
		model.append("const int TT=").append(TT).append(";\n\n");
		//
		for (Iterator<String[]> iterator = tTask.iterator(); iterator.hasNext();) {
			String[] strings = (String[]) iterator.next();
			model.append("const int "+strings[0]+strings[1]+"Time="+ strings[2]+";\n");
		}
		//
		for (Iterator<String[]> iterator = tTravel.iterator(); iterator.hasNext();) {
			String[] strings = (String[]) iterator.next();
			model.append("const int travel"+strings[0]+strings[1]+ strings[2]+"="+strings[3]+";\n");
		}
		//if idle
		for (int i = 0; i < robIDset.length; i++) {
			String r = robIDset[i];
			if(idleTime.get(robIDset[i]) != 0) {
				model.append("const int maxIdle"+r+"="+ idleTime.get(robIDset[i]) +";\n");}			
		}
		//
		model.append("\nformula done=(");
		for (int i = 0; i < robIDset.length; i++) {
			String r = robIDset[i];
			int n = numTasks(tTask,r);
			model.append(r+"order="+n +"&");
		}
		model.deleteCharAt(model.length() - 1);
		model.append(");\n\n");
		//
		for (int i = 0; i < robIDset.length; i++) {
			String r = robIDset[i];
			model.append("module "+r+"\n");
			model.append(" "+ r +"order:[0.."+ numTasks(tTask,r) +"];\n");
			model.append(" "+ r +"time:[0.."+ TT +"];\n");
			//if idle
			if(idleTime.get(robIDset[i]) != 0) {model.append(" "+r+"idleTime:[0..maxIdle"+r+"];\n");}
			
			for (int j = 0; j < permutation.get(r).length; j++) {//for each task
				//location
				String rloc="";
				if (j==0) {rloc="l0";}
				else {rloc=permutation.get(r)[j-1];}
				//next task
				String t = permutation.get(r)[j];
				
				model.append(" ["+r+t+"] "+r+"order="+j+" & ("+r+"time+"+r+t+"Time+travel"+r+rloc+t+"<=TT)"
				+" -> ("+r+"order'="+(j+1)+") & ("+r+"time'="+r+"time+"+r+t+"Time+travel"+r+rloc+t+");\n");	
			}
			//if idle
			if(idleTime.get(robIDset[i]) != 0) {model.append(" ["+r+"idle] "+r+"order!="+numTasks(tTask,r)+" & ("+r+"time+1<=TT) & ("+r+"idleTime+1<=maxIdle"+r+") -> ("+r+"time'="+r+"time+1) & ("+r+"idleTime'="+r+"idleTime+1);\n");}
			
			model.append("endmodule\n\n");
		}
		//
		model.append("rewards \"idle\"\n //Note- there is no idle option for robot ri if maxIdleri==0 (computed beforehand)\n"
				+ "\n");
		for (int i = 0; i < robIDset.length; i++) {
			String r = robIDset[i];
			//if idle
			if(idleTime.get(robIDset[i]) != 0) { model.append(" ["+r+"idle] true: 1;\n"); }
		}
		model.append("endrewards");
		//=========================================================
		//Save model
		String filePath = "modelRobots.mdp";
		save2File(model,filePath);
		
		
		//=========================================================
		//Run prism: adversary
		File file = new File(filePath);
		String property = "R{\"idle\"}min=?[F done]";
		RunPrism(file,property);
		//=========================================================
		//Visualise adversary
		
		// Print
		System.out.println(model);

	}
	
	
	
	private static Object asList(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
	public static double RunPrism(File f,String property) throws PrismException, FileNotFoundException {
		// a) Initialise PRISM engine 
		PrismLog mainLog = new PrismDevNullLog(); //new PrismFileLog("stdout");   // Create a log for PRISM output (hidden or stdout)
		Prism prism = new Prism(mainLog);
		prism.initialise();
		// Parse and load a PRISM model 
		ModulesFile modulesFile = prism.parseModelFile(f); 
		prism.loadPRISMModel(modulesFile);
		// b) Result of "Pmax=?[F done]", if 0, then not schedulable
		PropertiesFile propertiesFile  = prism.parsePropertiesString(modulesFile, property);
		Result rIdle = prism.modelCheck(propertiesFile, propertiesFile.getPropertyObject(0));
		
		
		//PropertiesFile propertiesFile  = prism.parsePropertiesString(modulesFile, "Pmax=?[F done]");
		//Result result = prism.modelCheck(propertiesFile, propertiesFile.getPropertyObject(0));
		double d = Double.parseDouble( rIdle.getResult().toString() );
		
		System.out.println("Prism formulae: "+ property+" =" + d);
		return d;
	}
	
	
}
