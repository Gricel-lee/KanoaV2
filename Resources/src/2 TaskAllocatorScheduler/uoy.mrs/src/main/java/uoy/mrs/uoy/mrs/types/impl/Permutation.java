package uoy.mrs.uoy.mrs.types.impl;

import java.util.ArrayList;
import java.util.List;

import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.PermutationGenerator;
import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.error.KanoaErrorHandler;
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
	
	
	public Permutation(String robID, ProblemSpecification p, Allocation a,
			Integer numPerm) {
		this.robID = robID;
		this.robot = p.getRobotsModel().getRob(robID);
		this.numPerm  = numPerm;
		this.a = a;
		this.p = p;
		this.tasksInPerm = getTasksPerm(a.robotToAtomicTasksIds.get(robID),numPerm);
		
		if(Constants.verbose) {
		System.out.println();
		System.out.println("Robot: " +robID+ " , permutation num: "+this.numPerm);
		System.out.println("perm. tasks:"+this.tasksInPerm);
		}
		
		this.idleTime = getRobotIdleTime(robID,p,a);
		
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
		// - time travelling
		this.TTravel = getTotalTravelTime(p,a);
		// - idle
		int T_available_for_idling = TT-TTasks-this.TTravel;
		if( Constants.maxIdle < T_available_for_idling) //check if the idle limit in condif.properties file. Take the smaller to reduce MDP state space.
			return Constants.maxIdle;
		return T_available_for_idling;
	}
	
	/**Get duration of tasks assigned to robot r in allocation a*/
	public Integer getTotalTasksTime(ProblemSpecification p, Allocation a) {
		
		if(Constants.verbose) {System.out.println("Completion times:");}
		
		int TTasks = 0;
		//Get duration of tasks assigned to robot r in allocation a
		for (int i = 0; i < a.robotToAtomicTasksIds.get(this.robID).size(); i++) {
			String at_instantiated_i = a.robotToAtomicTasksIds.get(this.robID).get(i); //e.g. at4_6
			int at_i_duration = robot.getTaskDurationInt(at_instantiated_i,p);
			TTasks+=at_i_duration;
			//System.out.println(at_i+","+at_instantiated_i+","+at_i_duration); //e.g. at4,at4_6,2
			
			if(Constants.verbose) {System.out.println(at_instantiated_i+": "+at_i_duration);} //e.g. at4_6,2
		}
		return TTasks;
	}
	
	
	/**Get duration of travelling*/
	public Integer getTotalTravelTime(ProblemSpecification p, Allocation a) {
		int TTravel = 0;
		
		Location robotloc = robot.getLoc();
		int distance = -100; //between two locations to visit
		int travelTime = -1; //distance to complete tasks * velocity
		
		//Get duration of travelling between tasks assigned to robot r in allocation a
		// a) travel cost from init loc (l0) to task1
		String t1ID = tasksInPerm.get(0);
		Location at1Location = p.getATLocation(t1ID);
		
		// -add travel cost
		travelTime = getTravelTime(robotloc,at1Location);
		distance = getDistance(robotloc,at1Location);
		TTravel += travelTime;
		
		if(Constants.verbose) {System.out.println(robID + " travel from l0 to "+at1Location.getID()+ " in "+travelTime + " time units, distance="+distance);}
		
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
			travelTime = getTravelTime(at1Location,at2Location);
			distance = getDistance(at1Location,at2Location);
			
			if(Constants.verbose) {System.out.println(robID + " travel from "+t1ID+" to "+t2ID+ " in "+travelTime + " time units, distance="+distance);}
			
			TTravel +=travelTime;
		}
		
		return TTravel;
	}
	
	
	/**Get time travelling between two locations as an "integer" (time units) for this robot.
	 * travel time = dist/vel
	 * */
	public int getTravelTime(Location loc1, Location loc2) {
		int distance = getDistance(loc1,loc2);
		int travelCost = dist2travelTime(distance);
		return travelCost;
	}
	
	private int dist2travelTime(int distance) {
		if(robot.getVelocity()<=0) {KanoaErrorHandler.RobotVelocityError(robot.getID());}
		int travelCost = (int) Math.ceil((double)distance / robot.getVelocity());//Utility.string2int( Double.toString( distance / robot.getVelocity() ) ); //travel cost/time = dist/vel
		if(travelCost<0) {travelCost=0;} //as a safe-guard
		return travelCost;
	}
	
	
	
	/** TravelTime - from two strings.
	 * @input tid = ID of a task instance or ID of the robot to get distance from robot's initial location*/
	public int getTravelTime(String t1ID_or_robotID, String t2ID) {
		Location loc1;
		//-task1
		//if robot id
		if(t1ID_or_robotID.equals(this.robID)) {
			loc1 = robot.getLoc();
		}
		//if task id
		else { loc1 =  p.getATLocation(t1ID_or_robotID); }
		
		//-task2
		Location loc2 = p.getATLocation(t2ID);
		
		return getTravelTime(loc1, loc2);
	}

	/**Get distance between two locations as an "integer"*/
	public static int getDistance(Location loc1, Location loc2) {
		 // Parse the coordinates as doubles
		double x1 = Utility.string2double( loc1.getx() );
		double x2 = Utility.string2double( loc2.getx() );
		double y1 = Utility.string2double( loc1.gety() );
		double y2 = Utility.string2double( loc2.gety() );
		// Calculate the Euclidean distance
        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        
        int intdistance = (int) Math.round(distance);  //rounding to closest:
        //int intdistance = (int) distance;  //truncating
        
        if(intdistance<0) {intdistance=0;} //as a safe-guard
        return intdistance;
	}
	
	

	public void print() {
		System.out.println("perm "+numPerm+" for robot "+robID+" in alloc "+a.getNum());
	}

	
	
	

	
	
	
	
}
