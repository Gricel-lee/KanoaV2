package org.xtext.example.mydsl.generator

import dsl.AtomicTask
import dsl.MaxTasks
import dsl.ProblemSpecification
import dsl.Robot
import dsl.SpaceXYRobot

import java.util.HashSet
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.resource.Resource

//***
class AlloyFile{
	
	
	def static createAlloyFile(Preallocation tree, Resource resource, String path) {
		// variables
		val GlobalVar gv = tree.gv;
		var path_sigAlloyDeclaration = path;
		
		// read header .als file
		var s = Aux.readFile(path_sigAlloyDeclaration+"sigAlloyDeclaration.txt")
		
		// -- Robots
		val rList = resource.allContents.filter(Robot).toList();
		
		
		var List<AtomicTask> at_missions = Aux.at_in_mission(gv)
		var Set<AtomicTask> at_unique = new HashSet<AtomicTask>(at_missions); // save unique at
		var s_cap = "";  //var s_fact =""
		var count_capabilities = 0
		
		
		s += "\n\n// ----------------ROBOTS:\n"
		//robots
		for (r : rList){
			s+= "\nlone sig "+r.name+" extends Robot{}\n"
			s+= "{disj[capability ,  Capability"
			//s_r = "#"+r.name+"<=1 and"//fact
			for (t: r.capabilities.toList){
				if (at_unique.contains(t.at)){
					s+= "-"+ r.name + t.at.name
					//capabilities:
					s_cap+="\nlone sig "+ r.name + t.at.name+" extends Capability{}\n"
					s_cap+="{all d:do | d in "+ t.at.name+"}"
					//s_fact += "#" + r.name + t.at.name + "<=1\n" //this is removed as lone was added to the signature - it also avoids (for some hidden reason in Alloy) repetition of outputs
					count_capabilities+=1 // count (later needed)
			}}
			s+="]}"
			//fact changed for "lone"
			//s+="\nfact{"+s_r.substring(0, s_r.length() - 4)+"}"
		}
		
		
		// -- capabilities
		s += "\n\n// ----------------CAPABILITIES:\n"
		s+=s_cap
		//s+= "\n\nfact{"+s_fact+"} // robot capabilities appear once (if robot appears, and if capab. tasks assigned)"
		
		// -- atomic tasks
		s += "\n\n// ----------------ATOMIC TASKS:\n"
		
		// add to alloy unique atomic tasks
		
		s += "\n"+ "abstract sig "
		var s_t = ""
		var s_f = ""
		val root = resource?.allContents?.head as ProblemSpecification;
		for (var int i= 0; i<at_unique.length; i++){
			var at = at_unique.get(i)
			//var atName = at.name
			s_t += at.name +","
			s_f += "\nfact{all a:"+ at.name +" | #do.a="+ Aux.getRobots_atName(at.name,root) +"}	// number of robots needed"
		}
		s += s_t.substring(0,s_t.length-1) + " extends AtomicTask {}"
		s += s_f
		// add individual (may be repeated) atomic tasks needed
		//var taskInstancesLoc = gv.atLoc
		
		for (atInstance: gv.atomicList.keySet()){
			var x = Aux.cast2Int(gv.atomicList.get(atInstance).loc.x)
			var y = Aux.cast2Int(gv.atomicList.get(atInstance).loc.y)
			var at = gv.atomicList.get(atInstance).at.name
			s+="\none sig " + atInstance + " extends "+ at +"{}"
			s+=" {x="+ x +" y="+ y +"} //do at location " + gv.atomicList.get(atInstance).loc.name
		} // NOTE: "one" was added to the signature - it avoids (for some hidden reasons in Alloy) repetition of outputs

		// -- predicate
		s += "\n\n// ----------------PREDICATE:\n"
		// add atomic tasks
		s += "\npred TaskAllocation{"
		
		s += "\n}"
		
		
		
		
		
		//-- qos
		s += "\n\n// ----------------CONSTRAINTS:\n"
		
		// 1 SpaceXYRobot
		
		val constrantListXY = gv.resource.allContents.filter(SpaceXYRobot).toList();
		for(c: constrantListXY) {  // constraint xy i
			var lg = "";  
			if (c.lowerGreater.toString()=="lower"){ lg="<" }
			else if (c.lowerGreater.toString()=="greater"){ lg=">" }
			else(throw new UnsupportedOperationException("ERROR retrieving constraint SpaceXY for robot"+ c.robot)	)
			val v = c.getVal() //access with get as val is not allowed
			s += "\n fact{ all r:" + c.robot.name + "| all c:r.capability | all do:c.do | do." + c.coordinate + lg + Aux.cast2Int(v) + "}"
		}
		//-example assertation
		//assert oneR { no r:r3  | r.capability.do.x<=7 }
		//check oneR for 7 Int, 11 Capability, exactly 17 AtomicTask, 5 Robot
		
		
		//2,3 AllocateT and Closest - create facts for atomic tasks that have a robot assigned
		for(atID: gv.atomicList.keySet()){
			var atInstance = gv.atomicList.get(atID) 
			if (atInstance.robot!==null){
				s+="\n fact {all at: " + atID + "| one d: do.at | d in " + atInstance.robot.name + ".capability}"
			}
		}
		
		
		//4 MaxTasks
		val constrantListMaxTasks = resource.allContents.filter(MaxTasks);
		while(constrantListMaxTasks.hasNext()) {
			val c = constrantListMaxTasks.next(); //
			if(c.robot!==null){ //constraint robot
				s+= "\n fact { all r:"+ c.robot.name +" | #(r.capability.do ) <= "+c.num +"}"
			}
			else if(c.all!==null){ //constraint all robots
				for (r : rList){
					s+= "\n fact { all r:"+ r.name +" | #(r.capability.do ) <= "+c.num +"}"
				} }
		}
		
		
		// -- run command
		s += "\n\n// ----------------RUN COMMAND:\n"
		s+= "\nrun TaskAllocation for"
		s+= "\n"+ Aux.getAlloyIntScope(gv)+" Int,"
		s+= " " + count_capabilities + " Capability," 
		s+= " " + "exactly " + at_missions.length +" AtomicTask," 
		s+= " " + root.robotsModel.toList.length + " Robot"
		
		Aux.generateFile('modelAllocation.als', s, gv) // -- generate file
		
	}
}
