package uoy.mrs.uoy.mrs.types.impl;

import java.util.HashMap;

import uoy.mrs.uoy.mrs.types.ProblemSpecification;

public class RobotsModel {
	
	//Robots
	HashMap<String,Robot> robots = new HashMap<String,Robot>();
	
	
	public void addRobot(String id, Robot r) {
		this.robots.put(id, r);
	}
	
	public Robot getRob(String id) {
		return robots.get(id);
	}
	
	public void print(ProblemSpecification p) {
		System.out.println("\n----ROBOTS MODEL----");
		System.out.println("Robots in model: "+robots.keySet());
		for(Robot r:robots.values()) {
			r.print(p);
		}
	}
}
