package uoy.mrs.uoy.mrs.types.impl;


import java.util.ArrayList;
import java.util.HashMap;

import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.error.KanoaErrorHandler;


public class Allocation {
	/**Map relation between robot and its assigned tasks*/
	public HashMap<String, ArrayList<String>> robotToAtomicTasksIds = new HashMap<String, ArrayList<String>>();
	
	/**Map relation between atomic task and robot(s) that have to perform it. Use method '<em>whichRobots</em>' to access info.**/
	HashMap<String, ArrayList<String>> atomicTaskIdToRobots = new HashMap<String, ArrayList<String>>();
	
	String num= "";
	String fileName="";

	ArrayList<ArrayList<String>> groupsOfRobot;

	/**Ordered list of robots in allocation (order matter for genes in GA)*/
	private ArrayList<String> robotsList;
	
	//constructor
	public Allocation(HashMap<String, ArrayList<String>> robotToAtomicTasksIds, String fileName) {
		this.fileName = fileName;
		this.num = getNumOfAllocation(fileName);
		this.robotToAtomicTasksIds = robotToAtomicTasksIds;
		this.robotsList  = new ArrayList<String>(robotToAtomicTasksIds.keySet());
	}
	
	/**Get number of allocation from .xml name*/
	public static String getNumOfAllocation(String fileName) {
		String s ="";
		String[] f =fileName.split("//");
		s = f[f.length-1].replace(".xml", "").replace("Allocation", "");;
		return s;
	}

	/**Get tasks allocated to robot**/
	public ArrayList<String> getTasks(String robot){
		return robotToAtomicTasksIds.get(robot);
	}
	
	/**Num of tasks allocated to a robot*/
	public int numTasks(ArrayList<String[]> tTask,String robID) {
		return robotToAtomicTasksIds.get(robID).size();
	}
	
	
	/**Number of allocation*/
	public String getNum() {
		return num;
	}
	
	public String getFile() {
		return fileName;
	}
	
//	
//	public Set<String> getRobots() {
//		return this.robotToAtomicTasksIds.keySet();
//	}
	
	public Integer getNumRobots() {
		return this.robotToAtomicTasksIds.keySet().size();
	}
	
	
	/**Returns the list of robots in charge of completing a atomic task instance in the current allocation.*/
	public ArrayList<String> whichRobots(String taskID) {
		// - if computed before - saved in AtomicTaskIdToRobots
		if(atomicTaskIdToRobots.keySet().contains(taskID)) {
			return atomicTaskIdToRobots.get(taskID);
		}
		
		// - if not computed before
		//list of robots in charge of completing task
		ArrayList<String> robots = new ArrayList<String>();
		//get robots in charge of task
		for (String r: robotToAtomicTasksIds.keySet()){
			if(robotToAtomicTasksIds.get(r).contains(taskID)) {
				robots.add(r);
			}
		}
		if(robots.isEmpty()) {KanoaErrorHandler.RobotNotFoundForTaskInAllocation(taskID,fileName);}
		
		// add to list
		atomicTaskIdToRobots.put(taskID, robots);
		
		return atomicTaskIdToRobots.get(taskID);
	}
	
	public void print() {
		System.out.println("--- Allocation: "+num);
		System.out.println(robotToAtomicTasksIds +"                 file: "+ fileName);
	}
	
	/*Set groups/clusters of robot. Done in the pre-scheduling stage*/
	public void setGroupsOfRobot(ArrayList<ArrayList<String>> groupsOfRobot) {
		this.groupsOfRobot = groupsOfRobot;
		
	}
	
	/*Get groups of robots (to be modelled together as they share task dependencies). Available after pre-scheduling stage.*/
	public ArrayList<ArrayList<String>> getGroupsOfRobot() {
		return groupsOfRobot;
	}
	
	/*Get number of permutations of the tasks assigned to robot*/
	public int getNumTaskPermutations(String robotID) {
		return Utility.getFactorial(getTasks(robotID).size());
	}
	
	/**Ordered list of robots in allocation - order matterns for GA*/
	public ArrayList<String> getRobotsList() {
		return robotsList;
	}	
}