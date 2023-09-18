package org.xtext.example.mydsl.generator

import dsl.CompoundTask
import java.util.List
import java.util.ArrayList

/** Compound Task instance */
class CompoundTaskInstance{
	public CompoundTask ct;
	public Integer count;
	public String parent; //id of instantiated parent task, e.g. ct1_11, or mission task, e.g. m1
	public List<String> children;  
	public String ordered;
	public String consecutive
	
	ArrayList<String> atReachable = new ArrayList<String>(); //*only available after all tasks are instantiated (STAGE 1) and this.getatomicInstancesReachable is called
	
	
	//private
	
	def set(CompoundTask ct, Integer count, String parent, List<String> children){
		this.ct =  ct;
		this.count = count;
		this.parent = parent;
		this.children = children;
		this.ordered = String.valueOf(ct.ordered);
		this.consecutive = String.valueOf(ct.consecutive);
	}
		
	/*Get instance id */
	def getId(){
		return (this.ct.name + "_" + this.count)
	}
	
	def print(){
		println("=== compound task:" + this.getId() + " ===")
		println("parent:" + this.parent)
		println("children:" + this.children)
		if (!this.atReachable.isEmpty()){println("atomic tasks reachable:" + this.atReachable)}
	}
	
	
	/*Get atomic reachable subtasks */
	def getatSubtasks(GlobalVar gv){
		if (this.atReachable.isEmpty()){this.getatomicInstancesReachable(gv)}
		return this.atReachable
	}
	
	
	/*Get reachable instances of atomic tasks */
	def getatomicInstancesReachable(GlobalVar gv){
		if (this.atReachable.isEmpty()){ this.atReachable.addAll( this.getatomicInstancesReachable(gv, this.getId()) )}
		if (this.atReachable.isEmpty()){throw new UnsupportedOperationException("ERROR: getatomicInstancesReachable on compound task:" + this.getId() + " returned empty.")}
		return this.atReachable
	}
	
	/*Compute reachable instances of atomic tasks. Complete STEP 1 before to ensure all children instances are added.*/
	private def ArrayList<String> getatomicInstancesReachable(GlobalVar gv, String ctIdInstance){
		//check children recursively until all atomic tasks reachable are retrieved
		var atId_reachable = new ArrayList<String>()
		for (id: gv.compoundList.get(ctIdInstance).children){
			//if atomic task - (add)
			if ( gv.atomicList.containsKey(id) ){atId_reachable.add(id)}
			//if compound task - (get its children)
			else if ( gv.compoundList.containsKey(id) ){atId_reachable.addAll(getatomicInstancesReachable(gv,id))}
		}return atId_reachable
	}
	
}