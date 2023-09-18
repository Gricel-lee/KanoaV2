package uoy.mrs.uoy.mrs.types.impl;



public class AtomicTaskInstance{

	
	private String id;
	private String parent;
	private String location;
	private String numrobots;
	private String joint;
	private String start;
	private String end;
	private String inst;
	
	public AtomicTaskInstance(String id, String parent, String location, String numrobots, String joint, String start, String end, String inst) {
		//id,,parent,,ordered_children,,location,,numrobots,,joint,,ordered,,consecutive,,start,,end
		// e.g.at,,at1_1,,m1,,NaN,,room1,,2,,True,,NaN,,NaN,,80.0,,114.0
		
		this.id = id;
		this.parent = parent;
		this.location = location;
		this.numrobots = numrobots;
		this.joint=joint;
		this.start=start;
		this.end=end;
		this.inst = inst;
	}
	
	
	public void print() {
		System.out.println("- Atomic task "+id);
		System.out.println("parent: "+ parent);
		System.out.println("location: " + location);
		System.out.println("numrobots: "+numrobots);
		System.out.println("joint: "+joint);
		System.out.println("start: "+start);
		System.out.println("end: "+end);
		System.out.println("instance of: " + inst);
		return;
	}

	
	public String getID() {
		return this.id;
	}

	
	public String getparent() {
		return parent;
	}

	
	public String getloc() {
		return location;
	}

	
	public String getnumrob() {
		return numrobots;
	}

	
	public String getjoint() {
		return joint;
	}

	
	public String getstart() {
		return start;
	}

	
	public String getend() {
		return end;
	}
	

	
	public String getInst() {
		return inst;
	}
}
