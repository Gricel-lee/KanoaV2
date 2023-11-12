package uoy.mrs.uoy.mrs.auxiliary.scheduler.modelA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import parser.ast.ModulesFile;
import parser.ast.PropertiesFile;
import prism.Prism;
import prism.PrismDevNullLog;
import prism.PrismException;
import prism.PrismLog;
import prism.Result;
import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;
import uoy.mrs.uoy.mrs.types.impl.Allocation;
import uoy.mrs.uoy.mrs.types.impl.Permutation;
import uoy.mrs.uoy.mrs.types.impl.Robot;

public class MDPModelA {
	
	
	public static String createModelA(HashMap<String, Integer> robots2PermNum, ProblemSpecification p, Allocation a) {
		// a) get info
		// - total time available
		int TT = Utility.string2int(p.getParameters().timeAvailable); 
		
		// -list robot IDs in allocation
		ArrayList<String> robIDset = a.getRobotsList();
		
		/**Array permutation of tasks per robot*/		
		HashMap<String, Permutation> r_permutationTasks = getPerm(p,a,robots2PermNum);
		
		/**Array: robot id, task, duration: {"r1","t1","3.0"}*/
		ArrayList<String[]> timeTask = new ArrayList<String[]>();
		timeTask = get_timeTask(p,a);
		
		/**Array: travelling times - name 'l0' for initial location*/
		//String[] trip1 = {"r1","l0","t1","3"}; tTravel.add(trip1);
		ArrayList<String[]> tTravel = new ArrayList<String[]>();
		
		
		//=========================================================
		//BUILD PRISM MODEL:
				
		//Prism model:
		StringBuilder model = new StringBuilder();
		model.append("mdp\n\n");
		model.append("const int TT=").append(TT).append(";//total time available \n\n");
		//
		for(String rID:robIDset) {
			Permutation r_permutation = r_permutationTasks.get(rID);
			
			String t1ID= r_permutation.tasksInPerm.get(0);
			int time = r_permutation.getTravelTime(rID, t1ID);
			
			// - travel const
//			model.append("const int travel"+rID+"l0"+r_permutation.tasksInPerm.get(0)+"="+time +" ;\n");
//			for (int i = 0; i < r_permutation.tasksInPerm.size()-1; i++) {
//				t1ID= r_permutation.tasksInPerm.get(i);
//				String t2ID= r_permutation.tasksInPerm.get(i+1);
//				time = r_permutation.getTravelTime(t1ID, t2ID);
//				model.append("const int travel"+rID+t1ID+t2ID+"="+time +" ;\n");
//			}
			
			model.append("const int travel"+rID+t1ID+"="+time +" ;//l0-"+t1ID+"\n");
			for (int i = 0; i < r_permutation.tasksInPerm.size()-1; i++) {
				t1ID= r_permutation.tasksInPerm.get(i);
				String t2ID= r_permutation.tasksInPerm.get(i+1);
				time = r_permutation.getTravelTime(t1ID, t2ID);
				model.append("const int travel"+rID+t2ID+"="+time +" ;//"+t1ID+"-"+t2ID+"\n");
			}
		}
		
		
		// -- tasks time const
		for(Permutation r_perm: r_permutationTasks.values()) {
			for(String at:r_perm.tasksInPerm) {
				model.append("const int "+r_perm.robID+at+"Time="+ r_perm.getTasksDuration(at) +";\n");
			}
		}
		
		//
		for (Iterator<String[]> iterator = tTravel.iterator(); iterator.hasNext();) {
			String[] strings = (String[]) iterator.next();
			model.append("const int travel"+strings[0]+strings[1]+ strings[2]+"="+strings[3]+";\n");
		}
		//if idle
		for (int i = 0; i < robIDset.size(); i++) {
			String r = robIDset.get(i);
			Permutation r_perm = r_permutationTasks.get(r); 
			if(r_perm.idleTime > 0) {
				model.append("const int maxIdle"+r+"="+ r_perm.idleTime +";\n");}			
		}
		// -- formula done
		model.append("\nformula done=(");
		for (int i = 0; i < robIDset.size(); i++) {
			String r = robIDset.get(i);
			int n = a.numTasks(timeTask,r);
			model.append(r+"order="+n +"&");
		}
		model.deleteCharAt(model.length() - 1);
		model.append(");\n\n");
		// -- module
		for (int i = 0; i < robIDset.size(); i++) {
			String r = robIDset.get(i);
			model.append("module "+r+"\n");
			// -- state variables
			model.append(" "+ r +"order:[0.."+ a.numTasks(timeTask,r) +"];\n");
			model.append(" "+ r +"time:[0.."+ TT +"];\n");
			//if idle
			if(r_permutationTasks.get(r).idleTime > 0) {model.append(" "+r+"idleTime:[0..maxIdle"+r+"];\n");}
			
			for (int j = 0; j < r_permutationTasks.get(r).tasksInPerm.size(); j++) {//for each task
				// tasks' locations for travel
				String t1="";String t2="";
				if (j==0) {
					t1="l0"; //first starts at robot's location
					t2=r_permutationTasks.get(r).tasksInPerm.get(j); //second task (task instance id)
				}
				else {
					t1= r_permutationTasks.get(r).tasksInPerm.get(j-1);
					t2= r_permutationTasks.get(r).tasksInPerm.get(j);
				}
				//next task ------ transitions
				//label
				if(p.isJoint(t2)) {model.append(" ["+t2+"] ");}
				else {model.append(" ["+r+t2+"] ");}
				//guard - order and time
				model.append(r+"order="+j+" & ("+r+"time+"+r+t2+"Time+travel"+r+t2+"<=TT)");
				//guard - if joint task
				model.append( getGuardJoinTask(r,t2, r_permutationTasks, a, p) );
				//update
				model.append(" -> ("+r+"order'="+(j+1)+") & ("+r+"time'="+r+"time+"+r+t2+"Time+travel"+r+t2+");\n");	
				
			}
			//if idle
			if(r_permutationTasks.get(r).idleTime > 0) {model.append(" ["+r+"idle] "+r+"order!="+a.numTasks(timeTask,r)+" & ("+r+"time+1<=TT) & ("+r+"idleTime+1<=maxIdle"+r+") -> ("+r+"time'="+r+"time+1) & ("+r+"idleTime'="+r+"idleTime+1);\n");}
			
			model.append("endmodule\n\n");
		}
		//
		model.append("rewards \"idle\"\n //Note- there is no idle option for robot ri if maxIdleri==0 (computed beforehand)\n");
		for (int i = 0; i < robIDset.size(); i++) {
			String r = robIDset.get(i);
			//if idle
			if(r_permutationTasks.get(r).idleTime > 0) { model.append(" ["+r+"idle] true: 1;\n"); }
		}
		model.append("endrewards");
		
		//=========================================================
		//=========================================================
		//Save model
		//-File info
		//b) allocation num
		String allocNum = a.getNum();
		String outputFolder = Constants.prismFilesDir;
		String mdpFileName = "modelA_"+"All"+allocNum+"_Perm"+0 +".mdp";
		String mdpFilePath = outputFolder+mdpFileName;
		
		System.out.println(TT + " "+ outputFolder+mdpFilePath );
		
		//-Save to file
		createMDPFile(outputFolder,mdpFileName,model);

		//=========================================================
		//=========================================================
		//Run prism: adversary
		File file = new File(mdpFilePath);
		String property = "R{\"idle\"}min=?[F done]";
		RunPrism(file,property);
		
		//Run prism: 
		property = "Pmin=?[F done]";
		RunPrism(file,property);
		
		return mdpFilePath;
	}
	
	
	/**E.g.:" & (r1time+travelTi = r2time+travelTj)"*/
	private static String getGuardJoinTask(String r1, String atID, HashMap<String, Permutation> r_permutationTasks, Allocation a, ProblemSpecification p) {
		String s = "";
		//robots sharing task
		for (String r2: a.whichRobots(atID)) {
			if(!r1.equals(r2))
				s+=" & ("+r1+"time+travel"+r1+atID+" = "+r2+"time+travel"+r2+atID+")";
		}
		return s;
	}


	/*Array permutation of tasks*/
	private static HashMap<String, Permutation> getPerm(ProblemSpecification p, Allocation a,
			HashMap<String, Integer> robots2PermNum) {
		
		HashMap<String, Permutation> permutation = new HashMap<>();
		// robots
		ArrayList<String> robIDset = a.getRobotsList();
		// 
		for (int i = 0; i < robIDset.size(); i++) {
			String rID = robIDset.get(i);
			
			System.out.println("robots2PermNum"+robots2PermNum.keySet());
			System.out.println("robots2PermNum"+robots2PermNum.values());
			
			Integer numPerm = robots2PermNum.get(rID);
			
			// permutation per robot
			Permutation perm = new Permutation(rID, p, a, numPerm);
			permutation.put(rID, perm);
		}
		return permutation;
	}

	

	public static double RunPrism(File f,String property) {
		double d = -999999;
		try {
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
		d = Double.parseDouble( rIdle.getResult().toString() );
		
		System.out.println("Prism formulae: "+ property+" =" + d);

		} catch (PrismException | FileNotFoundException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	
	/*Get array: robot id, task, duration: {"r1","t1","3"}*/
	private static ArrayList<String[]> get_timeTask(ProblemSpecification p, Allocation a) {
		ArrayList<String[]> timeTask = new ArrayList<String[]>();
		// - time completion tasks
		for (int i = 0; i < a.getRobotsList().size(); i++) {
			String rID = a.getRobotsList().get(i);
			for (int j = 0; j < a.robotToAtomicTasksIds.get(rID).size(); j++) {
				//get duration
				String tID = a.robotToAtomicTasksIds.get(rID).get(j);
				
				Robot r = p.getRobotsModel().getRob(rID);
				String duration = r.getTaskDuration(tID,p);
				String[] ritj = {rID,tID,duration};
				timeTask.add(ritj);
				
				//e.g. timeTask_i:r4,at1_1,4.0
				System.out.println("timeTask_i:"+ritj[0]+","+ritj[1]+","+ritj[2]);
				
			}
		}
		return timeTask;		
	}
	
	
	/**Time available to idle for a robot*/
	public static int checkRobotTimeToIdle(String robID, int TT, 
			ArrayList<String[]> tTravel, Allocation a, ProblemSpecification p) {
		int n=TT;
		
		System.out.println("\ntime for tasks - "+robID);
		Robot r = p.getRobotsModel().getRob(robID);
		
		//time for task
		
		//Get duration of tasks assigned to robot r in allocation a
		for (int i = 0; i < a.robotToAtomicTasksIds.get(robID).size(); i++) {
			String at = a.robotToAtomicTasksIds.get(robID).get(i); //e.g. at4_6
			int at_i_duration = r.getTaskDurationInt(at,p);
			n-=at_i_duration;
			
			//System.out.println(at_i+","+at_instantiated_i+","+at_i_duration); //e.g. at4,at4_6,2
		}
		//time for travelling
		for (Iterator<String[]> iterator = tTravel.iterator(); iterator.hasNext();) { //tTravel e.g.: 
			
			String[] it = iterator.next();
			String iterator_rID = it[0];
			String iterator_loc1 = it[1];
			String iterator_loc2 = it[2];
			String iterator_time = it[3];
			
			System.out.println("tTravel_i:"+iterator_rID+","+iterator_loc1+","+iterator_loc2+","+iterator_time);
			
			if(iterator_rID==robID) {
				System.out.println(n+"-"+iterator_time);
				n-=Utility.string2int(iterator_time);
			}
		}
		//time for travel and tasks exceeds time available
		if(n<0) {
			System.err.println("Robot "+robID+" requires more time to travel and do tasks ("+ (TT-n) +" needed) than time available, "+TT);
			System.exit(0);}
		return n;}

	
	/**Save MDP file*/
	public static void createMDPFile(String outputFolder,String newFileName,StringBuilder str) {
		String newPath = outputFolder+newFileName;
		Utility.checkPath(outputFolder);//check if folder exists
		Utility.createEmptyFile(newPath);//create file
		// Convert the StringBuilder to a String and save
        Utility.WriteToFile(newPath, str.toString());
	}
	
	
}
