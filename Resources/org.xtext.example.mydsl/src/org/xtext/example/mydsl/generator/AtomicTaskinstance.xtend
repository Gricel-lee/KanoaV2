package org.xtext.example.mydsl.generator

import dsl.AtomicTask
import dsl.Location
import dsl.Robot

/** Atomic Task instance. Its identifier is the "type of atomic task + _ + counter". */
class AtomicTaskinstance{   
	public AtomicTask at; //type of atomic task (without instance, e.g. instance at11_3 is type at11 with count=3)
	public Integer count;
	public Location loc;
	public String parent; //id of instantiated parent task, e.g. ct1_11, or mission task, e.g. m1
	public Robot robot; //if pre-allocated to a robot within the mission constraints
	
	public Double start
	public Double end 
	public int retry
	
	def set(AtomicTask at, Integer count, String parent){
		this.at =  at
		this.count = count
		this.parent = parent
		this.loc = at.loc
		this.retry = at.retry
	}
	
	/*Get instance id */
	def getId(){
		return (this.at.name + "_" + this.count)
	}
	
	def print(){
		println("=== atomic task:" + this.getId() + " ===")
		println("parent:" + this.parent)
		println("location:" + this.loc.name)
		if (this.robot!==null){
			println("robot:" + this.getRobotId())
		}	
		if (this.start!==null){
			println("startTime:" + this.start)
		}
		if (this.end!==null){
			println("endTime:" + this.end)
		}
		if (!this.retry.equals(0)){
			println("retry:" + this.retry)
		}
		
	}
	
	def getRobotId(){
		return (this.robot.name)
	}
	
	/*Return the closest robot to the atomic task */
	def closestRobot() {
		
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}



