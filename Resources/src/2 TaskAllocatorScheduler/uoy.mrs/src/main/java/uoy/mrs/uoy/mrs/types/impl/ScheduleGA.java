package uoy.mrs.uoy.mrs.types.impl;

import java.util.ArrayList;
import java.util.HashMap;

public class ScheduleGA {
	
	private int id;
	private String time;
	private ArrayList<String> robots;
	private String numAlloc;
	private String perm;
	private HashMap<String, Double> attr;
	
	//constructor
	/**This is a Pareto optimal solution for one allocation, found by the GA loop.
	 * Accessible from problemSpecification.getSchedulesGA.*/
	public ScheduleGA(int id, ArrayList<String> rob,String numAlloc,String perm, HashMap<String, Double> attr,String time) {
		this.id = id;
		this.robots = rob;
		this.numAlloc = numAlloc;
		this.perm = (String) perm;
		this.attr = attr;
		this.time = time;
	}	
	
	public void print() {
		System.out.println("GA Solution num "+id + " alloc "+numAlloc+ " perm "+perm + ", attr: "+attr+ ". Time: "+time);
	}

	public int getID() {
		return id;
	}

	public String getTime() {
		return time;
	}
	
	public HashMap<String, Double> getAttr() {
		return attr;
	}
	
	public String getAllocNum() {
		return numAlloc;
	}
	
	public String getPerm() {
		return perm;
	}
	public ArrayList<String> getRob() {
		return robots;
	}
	
	
	
}
