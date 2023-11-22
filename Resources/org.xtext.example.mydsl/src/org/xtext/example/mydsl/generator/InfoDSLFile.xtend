package org.xtext.example.mydsl.generator

import dsl.AtomicTask
import dsl.Capability
import dsl.CompoundTask
import dsl.Location
import dsl.Mission
import dsl.Paths
import dsl.RateSucc
import dsl.Robot
import org.eclipse.emf.ecore.resource.Resource

class InfoDSLFile {
	/*
	 * Example of info in this file: (the last 5 are optional)
	 * loc,l1,2.0,3.0
	 * loc,l2,1.0,7.0
	 * path,l1,l2,3.0
	 * path,l1,room1,31.0
	 * at,at1,2,l1
	 * at,at2,1,l1
	 * ct,ct1,[at3,at2,],false,false
	 * ct,ct2,[at4,ct1,],true,false
	 * robot,r1,l1,{[at2,5.0,99.0][at3,4.0,99.0][at4,2.0,99.0]}
	 * robot,r5,l5,{[at1,4.0,99.0]}
	 * objectives,[minIdle, minTravel, maxSucc]
	 * time,120
	 * numAlloc,10
	 * population,100
	 * evaluations,20
	 * ratesucc,95.0
	 */
	
	
	def static createFile(Preallocation tree, Resource resource, String path) {
		var gv = tree.gv
		var String s="";
		// - loc
		val loc = gv.resource.allContents.filter(Location).toList();
		for (Location l : loc){
				s += "loc,," + l.name +",," + l.x + ",," + l.y + "\n"
		}
		// - paths
		val paths = gv.resource.allContents.filter(Paths).toList();
		for (Paths p : paths){
			
			var double success = p.success
			
			if (success < 0) {Errors.negativeSuccRate(p)} // Error: success rate cannot be negative
			else if (success > 100) {Errors.morethan100SuccRate(p)} // Error: success rate cannot be negative
			else if(success.equals(0.0)){//no success rate declared
				s += "path,," + p.loc1.name + ",," + p.loc2.name + ",," + String.valueOf(p.distance) + ",,NAN\n"}
			else if(p.success.equals(-0.0)){//success rate declared, treated as 0
				s += "path,," + p.loc1.name + ",," + p.loc2.name + ",," + String.valueOf(p.distance) + ",,0.0\n"}
			else{
				s+= "path,," + p.loc1.name + ",," + p.loc2.name + ",," + String.valueOf(p.distance)+",,"
				s+=success
				s+="\n"
			}	
		}
		// - at
		val ats = gv.resource.allContents.filter(AtomicTask).toList();
		for (AtomicTask at : ats){
				s += "at,," + at.name + ",," + at.robots + ",," + at.loc.name + "\n"
		}
		
		// - ct
		val cts = gv.resource.allContents.filter(CompoundTask).toList();
		var subt = "";
		for (CompoundTask ct : cts){
			subt="["
			for(a: ct.canDoTask.toList()){
				switch a{
					AtomicTask:{subt+=a.name+","}
					CompoundTask:{subt+=a.name+","}
			}}
			subt = subt.substring(0,subt.length()-1)
			s += "ct,," + ct.name + ",," + subt + "],," + ct.ordered + ",," + ct.consecutive + "\n"
		}
		
		// - robots
		val robs = gv.resource.allContents.filter(Robot).toList();
		for (Robot r : robs){
			s += "robot,," +r.name + ",," + r.getInitLoc().name + ",," + "{"
			for (Capability c: r.getCapabilities){
				s += "["+c.at.name + "," + c.time + "," + c.success+"]"
			}
			s += "}"+ ",," + r.velocity +"\n"
		}
		
		// - objectives and parameters
		val ms = gv.resource.allContents.filter(Mission).toList();
		for (Mission m : ms){
			//objectives: it could be any combination of 1, 2, or all 3 objectives, e.g.: [minIdle, minTravel, maxSucc]
			s += "objectives,," + m.getObj().toString() + "\n"
			//parameters
			if(m.time!==0){s+="time,,"+m.time+ "\n"}
			if(m.numAlloc!==0){s+="numAlloc,,"+m.numAlloc+ "\n"}
			if(m.population!==0){s+="population,,"+m.population+ "\n"}
			if(m.evaluations!==0){s+="evaluations,,"+m.evaluations+ "\n"}
			
		}
		// - constraints: rateSucc  (the rest is already in tasks or allocation: spaceXY | taskTime | allocateT | closest | maxTasks)
		val rs = gv.resource.allContents.filter(RateSucc).toList();
		if(!rs.isEmpty()){s += "ratesucc,," + rs.get(0).rateSucc + "\n"}
		
		
		s=s.substring(0, s.length()-1);
		
		Aux.generateFile('infoDSL.txt', s, tree.gv) // -- generate file
	}
}