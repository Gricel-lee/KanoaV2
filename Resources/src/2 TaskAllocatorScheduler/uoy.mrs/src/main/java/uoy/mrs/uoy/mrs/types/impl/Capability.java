package uoy.mrs.uoy.mrs.types.impl;

import uoy.mrs.uoy.mrs.auxiliary.Utility;

public class Capability {
	public String atomicTaskID_notInstantiated;
	public String completionTime;
	private String probSucc;
	
	public Capability(String atID, String time, String probSucc) {
		this.atomicTaskID_notInstantiated = atID;
		this.completionTime = time;
		this.probSucc = probSucc;
	}

	public double getprobSucc() {
		return Utility.string2double(probSucc)/100;
	}
}
