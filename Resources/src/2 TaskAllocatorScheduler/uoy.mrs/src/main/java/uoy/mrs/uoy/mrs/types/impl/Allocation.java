package uoy.mrs.uoy.mrs.types.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.error.KanoaErrorHandler;


public class Allocation {
	HashMap<String, ArrayList<String>> robotToAtomicTasksIds = new HashMap<String, ArrayList<String>>();
	
	String num= "";
	String fileName="";
	
	
	//constructor
	public Allocation(HashMap<String, ArrayList<String>> robotToAtomicTasksIds, String fileName) {
		this.fileName = fileName;
		this.num = Utility.getNumOfAllocation(fileName);
		this.robotToAtomicTasksIds = robotToAtomicTasksIds;
	}
	
	public String getNum() {
		return num;
	}
	
	public Set<String> getRobots() {
		return this.robotToAtomicTasksIds.keySet();
	}
	
	public String whichRobot(String taskID) {
		for (String r: robotToAtomicTasksIds.keySet()){
			if(robotToAtomicTasksIds.get(r).contains(taskID)) {
				return r;
			}
		}
		KanoaErrorHandler.RobotNotFoundForTaskInAllocation(taskID,fileName);
		return null;
	}
	
	public void print() {
		System.out.println("--- Allocation: "+num);
		System.out.println(robotToAtomicTasksIds +"                 file: "+ fileName);
	}
}
