package uoy.mrs.uoy.mrs.auxiliary.scheduler.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
import uoy.mrs.uoy.mrs.types.impl.AtomicTaskInstance;
import uoy.mrs.uoy.mrs.types.impl.Location;
import uoy.mrs.uoy.mrs.types.impl.Permutation;
import uoy.mrs.uoy.mrs.types.impl.Robot;

public class MDPModelA {
	
	private static int getIdle(File file, String property) {
		int idle = -1;
		idle =  (int) MDPModelA.RunPrism(file,property);  //<-- return the idle time (computed using PRISM PMC)
		return idle;
	}
	

	
	/**Join idle time for all groups - create model A for each group*/
	public static int checkModelA(HashMap<String, Permutation> r_permutationTasks, ProblemSpecification p, Allocation a, String geneString, HashMap<String, Integer> r_permNum) {
		//--Starting Model A
		int totalIdle = 0;
		
		System.out.print("ModelA (idle)- ");
		//for each group, check if path feasible
		for (int i=0 ; i< a.getGroupsOfRobot().size(); i++) {
			
			File file = createModelA_groupi(r_permutationTasks,p,a,geneString,i);
			
			int idle = getIdle(file, "R{\"idle\"}min=?[F done]"); // - Prism PMC
			
			//if not feasible
			if(idle==Utility.infiniteInt) { //Infinite = 2147483647
				if(Constants.verbose) {System.out.print("g"+i + ":not feasible.\nNot feasible.\n");}
				return idle;
			}
			//feasible
			else {
				if(Constants.verbose) {System.out.print("g"+i + ":"+idle+", ");}
			}
			//if feasible
			totalIdle += idle;

			
			
		}
		
		System.out.print("Total idle:"+ totalIdle);
		return totalIdle;
	}
	
	
	
	/**Create MDP model*/
	public static File createModelA_groupi(HashMap<String, Permutation> r_permutationTasks, ProblemSpecification p, Allocation a, String geneString, int group_i) {
		
		// a) get info
		// - total time available
		int TT = Utility.string2int(p.getParameters().timeAvailable); 
		
		// -list robot IDs in allocation     		
		ArrayList<String> group_robID = a.getGroupsOfRobot().get(group_i);   //ArrayList<String> robIDset = a.getRobotsList(); //if one MDP for all robots
		
		/**Array: robot id, task, duration: {"r1","t1","3.0"}*/
		ArrayList<String[]> timeTask = new ArrayList<String[]>();
		timeTask = get_timeTask(p,a,group_robID);
		
		/**Array: travelling times - name 'l0' for initial location*/
		//String[] trip1 = {"r1","l0","t1","3"}; tTravel.add(trip1);
		ArrayList<String[]> tTravel = new ArrayList<String[]>();
		
		//extra info to add 
		String info = "";
		
		//=========================================================
		//BUILD PRISM MODEL:
				
		//Prism model:
		StringBuilder model = new StringBuilder();
		model.append("mdp\n\n");
		model.append("const int TT=").append(TT).append(";//total time available \n\n");
		//
		
		//***MISSING HERE! -> check model B, already done there-> check all paths exists
		
		//
		for(String rID:group_robID) {
			Permutation r_permutation = r_permutationTasks.get(rID);
			//task
			String t1ID= r_permutation.tasksInPerm.get(0);
			//locations
			Location robotLocation = r_permutation.robot.getLoc();
			Location t1IDLocation = p.getATLocation(t1ID);
			//time and distance
			int time = p.getWorldModel().getTravelTime(robotLocation, t1IDLocation,r_permutation.robot);
			int distance = p.getWorldModel().getPathDistance(robotLocation,t1IDLocation);
			model.append("//"+rID+" velocity:"+r_permutation.robot.getVelocity()+"\n");
			model.append("const int travel"+rID+t1ID+"="+time +" ;// from location: "+robotLocation.getID() +" (robot initial loc) to location: "+ t1IDLocation.getID()+" ("+t1ID+")"+ "    distance:"+distance+"\n");
			
			for (int i = 0; i < r_permutation.tasksInPerm.size()-1; i++) {
				//tasks
				t1ID= r_permutation.tasksInPerm.get(i);
				String t2ID= r_permutation.tasksInPerm.get(i+1);
				//locations of tasks
				t1IDLocation = p.getATLocation(t1ID);
				Location t2IDLocation = p.getATLocation(t2ID);
				//time and distance
				time = p.getWorldModel().getTravelTime(t1IDLocation, t2IDLocation, r_permutation.robot);
				distance = p.getWorldModel().getPathDistance(t1IDLocation,t2IDLocation);
				
				model.append("const int travel"+rID+t2ID+"="+time +" ;// from location: "+t1IDLocation.getID() +" ("+t1ID+") to location: "+ t2IDLocation.getID()+"("+t2ID+")"+ "    distance:"+distance+"\n");

			}
		}
		
		
		// -- tasks time const
		
		//group
		for(Permutation r_perm: r_permutationTasks.values()) {
			for(String at:r_perm.tasksInPerm) {
				if (group_robID.contains(r_perm.robID))
					model.append("const int "+r_perm.robID+at+"Time="+ r_perm.getTasksDuration(at) +";\n");
			}
		}
		
		//
		for (Iterator<String[]> iterator = tTravel.iterator(); iterator.hasNext();) {
			String[] strings = (String[]) iterator.next();
			model.append("const int travel"+strings[0]+strings[1]+ strings[2]+"="+strings[3]+";\n");
		}
		//if idle
		for (int i = 0; i < group_robID.size(); i++) {
			String r = group_robID.get(i);
			Permutation r_perm = r_permutationTasks.get(r); 
			if(r_perm.idleTime > 0) {
				model.append("const int maxIdle"+r+"="+ r_perm.idleTime +";\n");}
		}
		//---------------------------------------
		// -- formula done
		model.append("\nformula done=(");
		for (int i = 0; i < group_robID.size(); i++) {
			String rID = group_robID.get(i);
			int n = a.numTasks(timeTask,rID);
			model.append(rID+"order="+n +"&");
		}
		model.deleteCharAt(model.length() - 1);
		model.append(");\n\n");
		//---------------------------------------
		// --formulae for "ordered" tasks				"formula r1t1Done = r1order>=k+1 ; //ordered task"
		model.append("//formulae for ordered tasks\n");
		for(String at : getListOfAtomicTasksThatGoBeforeOthers(p,a) ) {
			//if joint task, assigned to multiple robots
			for(String r: a.whichRobots(at)) {
				int i = r_permutationTasks.get(r).tasksInPerm.indexOf(at); //index of task in robot tasks' permutation
				model.append("formula "+ r +at+"Done = "+ r +"order>="+(i+1)+" ;\n");
			}
		}
		model.append("\n\n");
		//--------------------------------------- 
		// --formulae for "consecutive" tasks				"formula r1t2Just = r1order=j+1; //consec. task"
		model.append("//formulae for consecutive tasks\n");
		for(String at : getListOfAtomicTasksThatGo_JUST_BeforeOthers(p,a) ) {
			//if joint task, assigned to multiple robots
			for(String r: a.whichRobots(at)) {
				int i = r_permutationTasks.get(r).tasksInPerm.indexOf(at); //index of task in robot tasks' permutation
				model.append("formula "+ r +at+"Just = "+ r +"order>="+(i+1)+" ;\n");
			}
		}
		model.append("\n\n");
		model.append("\n\n");
		
		
		//---------------------------------------
		// -- modules
		for (int i = 0; i < group_robID.size(); i++) {
			String r = group_robID.get(i);
			Permutation r_perm = r_permutationTasks.get(r);
			
			model.append("module "+r+"\n");
			// -- state variables
			model.append(" "+ r +"order:[0.."+ a.numTasks(timeTask,r) +"];\n");
			model.append(" "+ r +"time:[0.."+ TT +"];\n");
			//if idle
			if(r_perm.idleTime > 0) {model.append(" "+r+"idleTime:[0..maxIdle"+r+"];\n");}
			
			for (int j = 0; j < r_perm.tasksInPerm.size(); j++) {//for each task
				 String t2=r_perm.tasksInPerm.get(j); //t2 is the task to be completed when transition taken
				//---------------------------------------
				// ------ transitions (next task)
				//label
				if(p.isJoint(t2)) {model.append(" ["+t2+"] ");}
				else {model.append(" ["+r+t2+"] ");}
				//---------------------------------------
				//guard - order and time
				model.append(r+"order="+j+" & ("+r+"time+"+r+t2+"Time+travel"+r+t2+"<=TT)");
				//---------------------------------------
				//guard - if joint task
				model.append( getGuardJoinTask(r,t2, r_permutationTasks, a, p) );
				
				//---------------------------------------
				// --guard - if ordered   	"& (r2time+travelr2T2 >= r1time) & (r1t1Done)"
				String s =  " & ("+r+"time+travel"+r+t2+" >= ";
				for(String atBefore : p.getTasks().atList.get(t2).getdoneBefore_ord()) {//for each task to be done before
					//robot Assigned To Task Before
					for(String rATBefore: a.whichRobots(atBefore)) { // if joint task before, then add guard for each robot
						model.append(s);
						model.append( rATBefore + "time) & ("+rATBefore + atBefore + "Done)" );
					}
				}
				//---------------------------------------
				// --guard - if consecutive   	"& (r1t2Just)  & (r2time+travelr2T2 = r1time)" 
				  // --NOTE: when the task before is a joint task, not necessary to add the constraint to every robot, one is enough to check the task as done
				  // --However, we must check which robot takes longer to complete the task, so we start this task after the last robot performing the
				  // --joint task before completes it.
				String taskBefore = p.getTasks().atList.get(t2).getjustDone_con();
				if(taskBefore!=null) {
					String robotWithTaskBefore = getRobotLongestTimeToCompleteJointTask(taskBefore,r_permutationTasks,p,a);
					model.append("& ("+robotWithTaskBefore+taskBefore+"Just) & ("+r+"time+travel"+r+taskBefore+" = "+r+"time)"); 
					
				}
				
				//---------------------------------------
				// --guard - time constraint      "& (r1time+travelr1T4 >= 10)" or "& (r1time+travelr1T5+r1t5Time <= 15)"
				 AtomicTaskInstance task_t2 = p.getTasks().atList.get(t2);
				// start
				String start = task_t2.getstart();
				if(!start.equals("None")) {
					info+="\n //"+ t2+" start time: " +start;
					model.append("& ("+r+"time+travel"+r+t2+" >= "+Utility.string2int(start)+")");
				}
				// end
				String end = task_t2.getend();
				if(!end.equals("None")) {
					info+="\n //"+ t2+" end time: " +end;
					model.append("& ("+r+"time+travel"+r+t2+"+"+r+t2+"Time <= "+ Utility.string2int(end) +")");
				}
				
				//---------------------------------------
				//update
				model.append(" -> ("+r+"order'="+(j+1)+") & ("+r+"time'="+r+"time+"+r+t2+"Time+travel"+r+t2+");\n");	
				
			}
			//if idle
			if(r_permutationTasks.get(r).idleTime > 0) {model.append(" ["+r+"idle] "+r+"order!="+a.numTasks(timeTask,r)+" & ("+r+"time+1<=TT) & ("+r+"idleTime+1<=maxIdle"+r+") -> ("+r+"time'="+r+"time+1) & ("+r+"idleTime'="+r+"idleTime+1);\n");}
			
			model.append("endmodule\n\n");
		}
		//---------------------------------------
		// -- reward
		model.append("rewards \"idle\"\n //Note- there is no idle option for robot ri if maxIdleri==0 (computed beforehand)\n");
		for (int i = 0; i < group_robID.size(); i++) {
			String r = group_robID.get(i);
			//if idle
			if(r_permutationTasks.get(r).idleTime > 0) { model.append(" ["+r+"idle] true: 1;\n"); }
		}
		model.append("endrewards");
		
		model.append("\n\n\n"+info);
		//=========================================================
		//=========================================================
		//Save model
		//-File info
		//b) allocation num
		String allocNum = a.getNum();
		String outputFolder = Constants.prismFilesDir;
		String mdpFileName = "modelA_"+allocNum+"_"+ geneString+"_"+group_i +".mdp";
		String mdpFilePath = outputFolder+mdpFileName;
		
		//System.out.println("MDP: "+ outputFolder+mdpFilePath );
		
		//-Save to file
		createMDPFile(outputFolder,mdpFileName,model);
		
		File file = new File(mdpFilePath);
		return file;
		
	}
	
	
	/**
	 * @return */
	private static ArrayList<String> getListOfAtomicTasksThatGoBeforeOthers(ProblemSpecification p, Allocation a) {
		ArrayList<String> all = new ArrayList<String>();
		for(AtomicTaskInstance at: p.getTasks().atList.values()) {
			all.addAll( p.getTasks().atList.get(at.getID()).getdoneBefore_ord() );
		}
		// hashSet from the ArrayList to remove duplicates
        HashSet<String> uniqueSet = new HashSet<>(all);
        // new ArrayList from the unique elements in the HashSet
        return new ArrayList<>(uniqueSet);
        
	}
	
	
	/**
	 * get list of all tasks that have to be done before others
	 */
	private static ArrayList<String> getListOfAtomicTasksThatGo_JUST_BeforeOthers(ProblemSpecification p, Allocation a){
		ArrayList<String> all = new ArrayList<String>();
		for(AtomicTaskInstance at: p.getTasks().atList.values()) {
			String t_before = p.getTasks().atList.get(at.getID()).getjustDone_con();
			if(t_before!=null)
				all.add( p.getTasks().atList.get(at.getID()).getjustDone_con() );
		}
		// hashSet from the ArrayList to remove duplicates
        HashSet<String> uniqueSet = new HashSet<>(all);
        // new ArrayList from the unique elements in the HashSet
        return new ArrayList<>(uniqueSet);
	}
	
	
	private static String getRobotLongestTimeToCompleteJointTask(String taskBefore, HashMap<String, Permutation> r_permutationTasks, ProblemSpecification p, Allocation a) {
		String robotWithTaskBefore = "";
		int dur=0;
		for(String r: a.whichRobots(taskBefore)) {
			Permutation r_perm = r_permutationTasks.get(r);
			 int dur2 = r_perm.getTasksDuration(taskBefore);
			 if(dur2>dur) {
				 robotWithTaskBefore = r_perm.robID;
				 dur = dur2;
			 }
		}
		return robotWithTaskBefore;
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
		
		//System.out.println("Prism formulae: "+ property+" =" + d);

		} catch (PrismException | FileNotFoundException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	
	/*Get array: robot id, task, duration: {"r1","t1","3"}*/
	private static ArrayList<String[]> get_timeTask(ProblemSpecification p, Allocation a, ArrayList<String> robIDset) {
		ArrayList<String[]> timeTask = new ArrayList<String[]>();
		// - time completion tasks
		for (int i = 0; i < robIDset.size(); i++) {
			String rID = robIDset.get(i);
			for (int j = 0; j < a.robotToAtomicTasksIds.get(rID).size(); j++) {
				//get duration
				String tID = a.robotToAtomicTasksIds.get(rID).get(j);
				
				Robot r = p.getRobotsModel().getRob(rID);
				String duration = r.getTaskDuration(tID,p);
				String[] ritj = {rID,tID,duration};
				timeTask.add(ritj);
				
				//e.g. timeTask_i:r4,at1_1,4.0
				//System.out.println("timeTask_i:"+ritj[0]+","+ritj[1]+","+ritj[2]);
				
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
