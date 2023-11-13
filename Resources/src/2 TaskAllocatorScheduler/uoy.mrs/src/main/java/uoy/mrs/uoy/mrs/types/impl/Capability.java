package uoy.mrs.uoy.mrs.types.impl;

public class Capability {
	public String atomicTaskID;
	public String completionTime;
	public String probSucc;
	
	public Capability(String atID, String time, String probSucc) {
		this.atomicTaskID = atID;
		this.completionTime = time;
		this.probSucc = probSucc;
	}
}
