package uoy.mrs.uoy.mrs.types.impl;

public class Parameters {
	//Objectives
	public Boolean minIdle = false;
	public Boolean minTravel = false;
	public Boolean maxSucc=false;
	//Parameters - Predefine values if not added into DSL
	public String timeAvailable = "24";
	public String numAlloc = "20";
	public String population = "50";
	public String evaluations = "50";
	public String ratesucc = "50";

	
	
	public String getTime() {
		return timeAvailable;
	}
}
