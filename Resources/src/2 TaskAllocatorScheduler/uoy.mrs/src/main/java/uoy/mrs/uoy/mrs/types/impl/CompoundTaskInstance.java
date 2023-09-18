package uoy.mrs.uoy.mrs.types.impl;

import uoy.mrs.uoy.mrs.auxiliary.Utility;

public class CompoundTaskInstance{
	
	private String id;
	private String parent;
	private String[] ordered_children;
	private String ordered;
	private String consecutive;
	private String inst;
	
	private String ordered_children_str;
	


	public CompoundTaskInstance(String id, String parent, String ordered_children, String ordered,
			String consecutive, String inst) {
		//id,,parent,,ordered_children,,location,,numrobots,,joint,,ordered,,consecutive,,start,,end
		// e.g. ct,,ct1_2,,ct2_1,,['at3_4,at2_5'],,NaN,,NaN,,NaN,,false,,false,,NaN,,NaN
		this.id = id;
		this.parent = parent;
		this.ordered_children = Utility.stringToList(ordered_children);
		this.ordered_children_str = String.join(",", this.ordered_children);
		this.ordered = ordered;
		this.consecutive = consecutive;
		this.inst = inst;
	}


	
	public void print() {
		System.out.println("- Compound task "+id);
		System.out.println("parent: "+ parent);
		System.out.println("children: " + ordered_children_str);
		System.out.println("ordered: "+ordered);
		System.out.println("consecutive: "+consecutive);
		return;
	}

	
	public String getID() {
		return id;
	}



	
	public String getparent() {
		return parent;
	}



	
	public String[] getorderedChildren() {
		return ordered_children;
	}



	
	public String getordered() {
		return ordered;
	}



	
	public String getconsecutive() {
		return consecutive;
	}
	
	public Boolean isordered() {
		return Boolean.parseBoolean(ordered);
	}
	
	public Boolean isconsecutive() {
		return Boolean.parseBoolean(consecutive);
	}

	
	public String getInst() {
		return inst;
	}
}