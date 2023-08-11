package org.xtext.example.mydsl.generator

import org.eclipse.emf.ecore.resource.Resource
import java.nio.file.Path
import java.nio.file.Files
import java.io.IOException
import dsl.ProblemSpecification
import dsl.AtomicTask
import dsl.CompoundTask
import java.util.List
import java.util.ArrayList
import dsl.Robot
import dsl.TasksModel
import dsl.TaskTime
import java.util.Hashtable
import dsl.Capability
import java.util.HashSet
import java.util.Set
import java.util.Enumeration
import dsl.SpaceXYRobot
import dsl.AllocateT
import dsl.Closest
import dsl.MaxTasks
import dsl.MissionTask

//***
class AlloyFile{
	
	
	def static createAlloyFile(Tree tree, Resource resource) {
		// variables
		var path_sigAlloyDeclaration = "/Users/grisv/GitHub/KanoaV2/Resources/org.xtext.example.mydsl/src/org/xtext/example/mydsl/generator//";
		// read header .als file
		var s = readFile(path_sigAlloyDeclaration+"sigAlloyDeclaration.txt")
		
		
		// -- Robots
		val rList = resource.allContents.filter(Robot).toList();
		var List<AtomicTask> at_missions = tree.gv.at_in_mission
		var Set<AtomicTask> at_unique = new HashSet<AtomicTask>(at_missions); // save unique at
		var s_r =""; var s_cap = "";  //var s_fact =""
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
			s_f += "\nfact{all a:"+ at.name +" | #do.a="+ getRobots_atName(at.name,root) +"}	// number of robots needed"
		}
		s += s_t.substring(0,s_t.length-1) + " extends AtomicTask {}"
		s += s_f
		// add individual (may be repeated) atomic tasks needed
		var taskInstancesLoc = tree.gv.atLoc
		var Enumeration<String> atInstances = tree.gv.atLoc.keys()
		while (atInstances.hasMoreElements()){
			
			var atInstance = atInstances.nextElement()
			var atLoc = taskInstancesLoc.get ( atInstance )
			var at = atInstance.split("_").get(0);
			
			//var at = at_missions.get(i);
			s+="\none sig " + atInstance + " extends "+ at +"{}"
			var x = org.xtext.example.mydsl.generator.AlloyFile.cast2Int(atLoc.x)
			var y = org.xtext.example.mydsl.generator.AlloyFile.cast2Int(atLoc.y)
			s+=" {x="+ x +" y="+ y +"}"
			
		}
		
		// at instances -- //this is removed as "one" was added to the signature - it also avoids (for some hidden reason in Alloy) repetition of outputs
		//atInstances = tree.gv.atLoc.keys()
		//s+="\nfact{"
		//while (atInstances.hasMoreElements()){ // add each needed AT once
		//	s+="#" + atInstances.nextElement() + "=1\n"
		//}
		//s +="}"
		
		// -- predicate
		s += "\n\n// ----------------PREDICATE:\n"
		// add atomic tasks
		s += "\npred TaskAllocation{"
		
		s += "\n}"
		
		
		
		
		
		//-- qos
		s += "\n\n// ----------------CONSTRAINTS:\n"
		
		// 1 SpaceXYRobot
		val constrantListXY = resource.allContents.filter(SpaceXYRobot);
		while(constrantListXY.hasNext()) {
			var lg = "";  val c = constrantListXY.next(); // constraint xy i
			if (c.lowerGreater.toString()=="lower"){ lg="<" }
			else if (c.lowerGreater.toString()=="greater"){ lg=">" }
			else(throw new UnsupportedOperationException("ERROR retrieving constraint SpaceXY for robot"+ c.robot)	)
			val v = c.getVal() //access with get as val is not allowed
			s += "\n fact{ all r:" + c.robot.name + "| all c:r.capability | all do:c.do | do." + c.coordinate + lg + cast2Int(v) + "}"
		}
		//-example assertation
		//assert oneR { no r:r3  | r.capability.do.x<=7 }
		//check oneR for 7 Int, 11 Capability, exactly 17 AtomicTask, 5 Robot
		
		
		//2 AllocateT
		val constrantListAlloc = resource.allContents.filter(AllocateT);
		while(constrantListAlloc.hasNext()) {
			val c = constrantListAlloc.next(); //
			
			if(c.at!==null){
				s+="\n fact {all at: " + c.at.name + "| one d: do.at | d in " + c.robot.name + ".capability}"
				
				
			}
			
			if(c.ct!==null){
				
				var List<AtomicTask> atsub = tree.gv.getatomictasksinCT(c.ct)
				for (at:atsub){
					s+="\n fact {all at: " + at.name + "| one d: do.at | d in " + c.robot.name + ".capability}"
				}
			}
			
			if(c.mt!==null){
				var tintances = tree.gv.missionTask2atomicTasksInstances.get(c.mt)
				for (String i : tintances){
					//s+="\n fact { do." + i +" in " + c.robot.name + ".capability}"
					s+="\n fact { one d: do." + i +" | d in " + c.robot.name + ".capability}"
				}
			}//tree.gv.missionTask2atomicTasksInstances}
			
		}
		
		//3 Closest
		val constrantListClosest = resource.allContents.filter(Closest);
		while(constrantListClosest.hasNext()) {
			val c = constrantListClosest.next(); //
			//contraints all tasks
			if(c.all!==null){ 
			
				atInstances = tree.gv.atLoc.keys()
				while (atInstances.hasMoreElements()){
					var i = atInstances.nextElement()
					var r = tree.gv.getClosestRobot(i) //closestRobot
					s+="\n fact { one d: do." + i +" | d in " + r.name + ".capability}"	
				}
			}
			//atomic task
			else if(c.at!==null){
				var all_atInstances = tree.gv.atLoc.keys()
				while (all_atInstances.hasMoreElements()){
					var i = all_atInstances.nextElement()
					
					//if instance is instance of the atomic task
					if ( tree.gv.at_from_atInstance(i) == c.at){
						var r = tree.gv.getClosestRobot(i) //closestRobot
						s+="\n fact { one d: do." + i +" | d in " + r.name + ".capability}"	
					}
				}
			}
			//compound task
			else if(c.ct!==null){
				//get atomic tasks instances in generic compound task
				var ctType_all_at_children_instances = tree.gv.getInstanceChildrenFromCTintance(c.ct)
				
				for (i: ctType_all_at_children_instances){
					var r = tree.gv.getClosestRobot(i) //closestRobot
					s+="\n fact { one d: do." + i +" | d in " + r.name + ".capability}"	
				}
			}
			
			//mission task
			else if(c.mt!==null){
				
				var mission_atList = tree.gv.missionTask2atomicTasksInstances
				for (i: mission_atList.get(c.mt)){
					var iAT = tree.gv.at_from_atInstance(i)
					var r = tree.gv.getClosestRobot(iAT) //closestRobot
					s+="\n fact { one d: do." + i +" | d in " + r.name + ".capability}"	
				}
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
				
				println(" READ HERE WAHT IS IT: " + c.all)
			
				for (r : rList){
					s+= "\n fact { all r:"+ r.name +" | #(r.capability.do ) <= "+c.num +"}"
				} } 
			
		}
		
		
		// -- run command
		s += "\n\n// ----------------RUN COMMAND:\n"
		s+= "\nrun TaskAllocation for"
		s+= "\n"+ tree.gv.alloyIntScope+" Int,"
		s+= " " + count_capabilities + " Capability," 
		s+= " " + "exactly " + at_missions.length +" AtomicTask," 
		//if (checkAllRobotDeployed==1){ // add robots (exactly if all deployed)
		//	s+= "\nexactly " + root.robotsModel.robots.toList.length + " Robot,"  + "// deploy all robots"
		//}
		//else{ // not all robots deployed
			s+= " " + root.robotsModel.toList.length + " Robot"
		//}
		
		
		
		
		tree.generateFile('modelAllocation.als', s) // -- generate file
		
	}
	
	
	
	/** Cast object -> int -> string */
	def static cast2Int(Double xy) { 
			var String s = xy.toString();
			var int dot = s.indexOf("."); //this finds the first occurrence of "." //in string thus giving you the index of where it is in the string
			var String integerPart;
			if (dot!= -1) {integerPart= s.substring(0 ,dot);}
			else {integerPart = "0"}
			return integerPart
	}
	
	/**number of robots */
	def static getRobots_atName(String at, ProblemSpecification root) {
		for (t: root.tasksModel){
			switch t{
				AtomicTask:{
					if (t.name==at){return t.robots}
		}}}
	// ERROR
	throw new UnsupportedOperationException("ERROR: num of robots don't found for task "+at)
	}
	
	//--  
	def static String readFile(String filePath) throws IOException {
		var Path path = java.nio.file.Paths.get(filePath);
		System.out.println(path);
		return Files.readString(path);	
	}
	
}
