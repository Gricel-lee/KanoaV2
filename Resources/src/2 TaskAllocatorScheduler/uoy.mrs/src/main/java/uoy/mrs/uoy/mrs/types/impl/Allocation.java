package uoy.mrs.uoy.mrs.types.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.error.KanoaErrorHandler;


public class Allocation {
	/**Map relation between robot and its assigned tasks*/
	HashMap<String, ArrayList<String>> robotToAtomicTasksIds = new HashMap<String, ArrayList<String>>();
	
	/**Map relation between atomic task and robot(s) that have to perform it. Use method '<em>whichRobots</em>' to access info.
	 * */
	HashMap<String, ArrayList<String>> atomicTaskIdToRobots = new HashMap<String, ArrayList<String>>();
	
	String num= "";
	String fileName="";

	ArrayList<ArrayList<String>> groupsOfRobot;
	
	//constructor
	public Allocation(HashMap<String, ArrayList<String>> robotToAtomicTasksIds, String fileName) {
		this.fileName = fileName;
		this.num = Utility.getNumOfAllocation(fileName);
		this.robotToAtomicTasksIds = robotToAtomicTasksIds;
	}
	
	/**Number of allocation*/
	public String getNum() {
		return num;
	}
	
	public Set<String> getRobots() {
		return this.robotToAtomicTasksIds.keySet();
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
}
