package uoy.mrs.uoy.mrs.types.impl;

import uoy.mrs.uoy.mrs.auxiliary.Utility;

public class MissionTaskInstance{
	
	private String id;
	private String[] ordered_children;
	private String ordered_children_str;
	
	//constructor
	public MissionTaskInstance(String id, String ordered_children) {
		this.id = id;
		this.ordered_children = Utility.stringToList(ordered_children);
		this.ordered_children_str = String.join(",", this.ordered_children);

	}

	
	
	public void print() {
		System.out.println("- Mission task "+id);
		System.out.println("child: " + ordered_children_str);
		return;
	}
	
	public static void main( String[] args )  throws Exception{
		System.out.println("Creating mission task");
		

	}


	
	public String[] getorderedChildren() {
		return ordered_children;
	}


	
	public String getID() {
		return id;
	}	

}
