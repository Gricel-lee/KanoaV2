package uoy.mrs.uoy.mrs.types.impl;

import java.util.ArrayList;
import java.util.List;

import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.PermutationGenerator;
import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;

public class Permutation {
	
	public String robID;
	public Robot robot;
	public List<String> tasksInPerm; //atomic tasks in order
	public Integer numPerm; 		 //number of permutation
	public Allocation a;
	public ProblemSpecification p;
	public Integer idleTime;
	
	public int TTravel = 0;
	
	public boolean isFeasible_AllPathsExist;
	
	
	public Permutation(String robID, ProblemSpecification p, Allocation a, Integer numPerm) {
		this.robID = robID;
		this.robot = p.getRobotsModel().getRob(robID);
		this.numPerm  = numPerm;
		this.a = a;
		this.p = p;
		this.tasksInPerm = getTasksPerm(a.robotToAtomicTasksIds.get(robID),numPerm);
		this.TTravel = getTotalTravelTime(p,a);
		this.idleTime = getRobotIdleTime(robID,p,a);
		//check if all paths to travel between locations exist
		this.isFeasible_AllPathsExist = checkfeasible_ifAllPathsExist();
	}
	
	
	private boolean checkfeasible_ifAllPathsExist() {
		// b) travel from task j to j+1 in robot
		for (int j = 0; j < tasksInPerm.size()-1; j++) {
			// - travel cost from task1 to task 2
			//task 1
			String t1ID = tasksInPerm.get(j);
			Location at1Location = p.getATLocation(t1ID);
			//task2
			String t2ID = tasksInPerm.get(j+1);
			Location at2Location = p.getATLocation(t2ID);
			// -add travel cost
			boolean feasible = p.getWorldModel().checkPathExist_inDSL_orEuclidean(at1Location,at2Location);
			if(!feasible)
				return false;
		}
		return true;
	}

	/**Get list of tasks assigned to robot in specific order using */
	private static List<String> getTasksPerm(ArrayList<String> arrayList, Integer numPermr) {
		return PermutationGenerator.nthPermutation(arrayList,numPermr);
	}
	
	/**Get tasks duration. 
	 * @input atID, example: at1_2*/
	public int getTasksDuration(String atID) {
		return this.robot.getTaskDurationInt(atID,p);
	}
	
	/**Get possible time to spare (idle) by robot. Negative number means it cannot complete tasks and travel within time available.*/
	private Integer getRobotIdleTime(String robID, ProblemSpecification p, Allocation a) {
		// - total time available
		int TT = Utility.string2int(p.getParameters().timeAvailable); 
		// - time doing tasks
		int TTasks = getTotalTasksTime(p,a);
		// - idle = total - time doing tasks - time travelling
		int T_available_for_idling = TT- TTasks- this.TTravel;
		if( Constants.maxIdle < T_available_for_idling) //check if the idle limit in config.properties file. Take the smaller to reduce MDP state space.
			return Constants.maxIdle;
		return T_available_for_idling;
	}
	
	/**Get duration of tasks assigned to robot r in allocation a*/
	public Integer getTotalTasksTime(ProblemSpecification p, Allocation a) {
		//if(Constants.verbose) {System.out.println("Completion times:");}
		int TTasks = 0;
		//Get duration of tasks assigned to robot r in allocation a
		for (int i = 0; i < a.robotToAtomicTasksIds.get(this.robID).size(); i++) {
			String at_instantiated_i = a.robotToAtomicTasksIds.get(this.robID).get(i); //e.g. at4_6
			int at_i_duration = robot.getTaskDurationInt(at_instantiated_i,p);
			TTasks+=at_i_duration;
			//System.out.println(at_i+","+at_instantiated_i+","+at_i_duration); //e.g. at4,at4_6,2
			//if(Constants.verbose) {System.out.println(at_instantiated_i+": "+at_i_duration);} //e.g. at4_6,2
		}
		return TTasks;
	}
	
	
	/**Get duration of travelling*/
	public Integer getTotalTravelTime(ProblemSpecification p, Allocation a) {
		int TTravel = 0;
		
		Location robotloc = robot.getLoc();
		int travelTime = -1; //distance to complete tasks * velocity
		
		//Get duration of travelling between tasks assigned to robot r in allocation a
		// a) travel cost from init loc (l0) to task1
		String t1ID = tasksInPerm.get(0);
		Location at1Location = p.getATLocation(t1ID);
		
		// -add travel cost
		travelTime = p.getWorldModel().getTravelTime(robotloc,at1Location,robot);
		TTravel += travelTime;
		
		//e.g.: r2 travel from l0 to room2 in 3 time units, distance=6
		//int distance = getDistance(robotloc,at1Location);
		//if(Constants.verbose) {System.out.println(robID + " travel from l0 to "+at1Location.getID()+ " in "+travelTime + " time units, distance="+distance);}
		
		// b) travel from task j to j+1 in robot
		for (int j = 0; j < tasksInPerm.size()-1; j++) {
			// - travel cost from task1 to task 2
			//task 1
			t1ID = tasksInPerm.get(j);
			at1Location = p.getATLocation(t1ID);
			//task2
			String t2ID = tasksInPerm.get(j+1);
			Location at2Location = p.getATLocation(t2ID);
			// -add travel cost
			travelTime = p.getWorldModel().getTravelTime(at1Location,at2Location,robot);
			//distance = getDistance(at1Location,at2Location);
			//print
			//System.out.println("  "+robID + " travel from "+t1ID+" to "+t2ID+ " in "+travelTime + " time units, distance="+distance);
			TTravel +=travelTime;
		}
		return TTravel;
	}
	
	
	/** TravelTime:
	 *  in world model.
	 */

	/**Print*/
	public void print() {
		System.out.println("\nPERMUTATION:");
		System.out.println("-Robot "+robID+". Permutation: "+numPerm+" "+" in allocation "+a.getNum());
		System.out.println(" -sequence of tasks:"+this.tasksInPerm);
		printTasksTime(p,a);
		printTravelTime(p,a);
	}

	/**Print task completion times*/
	public void printTasksTime(ProblemSpecification p, Allocation a) {
		
		System.out.println(" -task completion times:");
		
		//Get duration of tasks assigned to robot r in allocation a
		for (int i = 0; i < a.robotToAtomicTasksIds.get(this.robID).size(); i++) {
			String at_instantiated_i = a.robotToAtomicTasksIds.get(this.robID).get(i); //e.g. at4_6
			int at_i_duration = robot.getTaskDurationInt(at_instantiated_i,p);
			System.out.println("  "+at_instantiated_i+": "+at_i_duration); //e.g. at4_6,2
		}
	}
	
	
	/**Print duration of travelling. 
	 * Similar to: this.getTotalTravelTime() but for -print- purposes.*/
	public void printTravelTime(ProblemSpecification p, Allocation a) {
		System.out.println("\n -Printing travelling times and distances:");
		Location robotloc = robot.getLoc();
		//Get duration of travelling between tasks assigned to robot r in allocation a
		// a) travel cost from init loc (l0) to task1
		String t1ID = tasksInPerm.get(0);
		Location at1Location = p.getATLocation(t1ID);
		// travel cost
		int travelTime = p.getWorldModel().getTravelTime(robotloc,at1Location,robot);
		int distance = p.getWorldModel().getPathDistance(robotloc,at1Location);
		
		
		//print
		System.out.println("  "+robID + " travel from l0 to "+at1Location.getID()+ " in "+travelTime + " time units, distance="+distance);//e.g.: r2 travel from l0 to room2 in 3 time units, distance=6
		// b) travel from task j to j+1 in robot
		for (int j = 0; j < tasksInPerm.size()-1; j++) {
			// - travel cost from task1 to task 2
			//task 1
			t1ID = tasksInPerm.get(j);
			at1Location = p.getATLocation(t1ID);
			//task2
			String t2ID = tasksInPerm.get(j+1);
			Location at2Location = p.getATLocation(t2ID);
			//travel cost
			travelTime = p.getWorldModel().getTravelTime(at1Location,at2Location,robot);
			distance = p.getWorldModel().getPathDistance(at1Location,at2Location);
			//print
			System.out.println("  "+robID + " travel from "+t1ID+" to "+t2ID+ " in "+travelTime + " time units, distance="+distance);
			
		}
	}	

	
	
	
	
}
