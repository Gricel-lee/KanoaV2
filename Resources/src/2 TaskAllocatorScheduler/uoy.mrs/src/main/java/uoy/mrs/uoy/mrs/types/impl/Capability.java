package uoy.mrs.uoy.mrs.types.impl;

public class Capability {
	String atomicTaskID;
	String completionTime;
	String probSucc;
	
	public Capability(String atID, String time, String probSucc) {
		this.atomicTaskID = atID;
		this.completionTime = time;
		this.probSucc = probSucc;
	}
}
