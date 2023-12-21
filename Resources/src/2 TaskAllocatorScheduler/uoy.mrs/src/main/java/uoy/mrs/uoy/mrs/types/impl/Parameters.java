package uoy.mrs.uoy.mrs.types.impl;

import java.util.ArrayList;

import uoy.mrs.uoy.mrs.error.KanoaErrorHandler;

public class Parameters {
	//Objectives - read as part of the Problem Specification
	private Boolean minIdle = false;
	private Boolean minTravel = false;
	private Boolean maxSucc=false;
	//Parameters - Predefine values if not added into DSL
	public String timeAvailable = "24";
	public String ratesucc = "0"; //prob. >=0
	
	//@Depricated - pass to config.properties file
	//public String numAlloc = "20";
	//public String population = "50";
	//public String evaluations = "50";
	
	public String getTime() {
		return timeAvailable;
	}
	
	/**Get objective*/
	public Boolean getObjective_minIdle() {return minIdle;}
	/**Get objective*/
	public Boolean getObjective_minTravel() {return minTravel;}
	/**Get objective*/
	public Boolean getObjective_maxSucc() {return maxSucc;}
	
	
	/**Get number of objectives*/
	public Integer getNumObjectives() {
		Integer n = 0;
		if(this.minIdle) {n+=1;} if(this.minTravel) {n+=1;} if(this.maxSucc) {n+=1;}
		//Error
		if (n==0) {KanoaErrorHandler.NoObjectivesDeclared();}
		return n;
	}
	
	
	/**Get list of objectives (order coincide with objectives in GA - Jmetal*/
	public ArrayList<String> getListObjectiveStrings(){
		ArrayList<String> objs = new ArrayList<String>();
		if (minIdle) {objs.add("minIdle");}
		if (minTravel) {objs.add("minTravel");}
		if (maxSucc) {objs.add("maxSucc");}
		return objs;
	}
	
	/**Set objective minimise idle*/
	public void setObjective_minIdle(Boolean b) {minIdle=b;}
	/**Set objective minimise travel*/
	public void setObjective_minTravel(Boolean b) {minTravel=b;}
	/**Set objective maximise success*/
	public void setObjective_maxSucc(Boolean b) {maxSucc=b;}
}