package org.xtext.example.mydsl.generator

import dsl.AtomicTask
import dsl.CompoundTask
import dsl.MissionTask
import java.util.ArrayList
import java.util.List
import java.util.ListIterator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import dsl.Constraints
import dsl.AllocateT
import dsl.Closest
import dsl.Robot
import dsl.TaskTime

/**Atomic task instance */
class CompoundTaskInstances{
	// info
	/** Compound task */
	public var CompoundTask ct
	/**Instance number */
	public var Integer inum
	/** subtasks instantiated IDs*/
	public var List<String> subtasksInstances
	 /** Parent ID */
	public var String parentId
	
}




/**Tasks tree - extract information from DSL*/
class Preallocation{
	
	
	/** Global variables */
	public val GlobalVar gv = new GlobalVar()
	
	
	
	/** Create tree */
	new(Resource resource, IFileSystemAccess2 fsa, String outputFileName){
		//STAGE 1
		instantiateTasks(resource,fsa)
		//STAGE 2
		overrideLocationFromMissionTasks()
		//STAGE 3
		assignPreallocatedTasksToRobots()
		//STAGE 4
		assignInitEndTimesOfAtomicTasks()
		
		//Print tasks tree info
		printAll()
		//Print list of all tasks isntaces (ordered of appearance from mission tasks)
		println(gv.tasksList)
	}
	
	
	
	
	
	

	
	// =====================
	/**STEP1. Instantiate tasks. Starting from mission tasks.*/
	def instantiateTasks(Resource resource, IFileSystemAccess2 fsa){
		gv.fsa = fsa;
		gv.resource = resource;
		val mtList = resource.allContents.filter(MissionTask);
		while(mtList.hasNext()) { val mt = mtList.next();
			switch mt{
				MissionTask:{
					
					if (mt.at !== null){ // if atomic task
						gv.counterAT+=1;
						//create mission task instance (with child)
						var mt_instance = new MissionTaskInstance(); mt_instance.set(mt,mt.at.name+"_" + gv.counterAT)
						gv.missionList.put(mt.name , mt_instance); gv.tasksList.add(mt.name)
						// atomic task instance
						var at_instance = new AtomicTaskinstance(); at_instance.set(mt.at , gv.counterAT , mt.name)						
						gv.atomicList.put(mt.at.name+"_" + gv.counterAT , at_instance); gv.tasksList.add(mt.at.name+"_" + gv.counterAT)
					}
					else if (mt.ct !== null){ //if compound task
						gv.counterCT+=1
						//create mission task instance (with child)
						var mt_instance = new MissionTaskInstance(); mt_instance.set(mt,mt.ct.name+"_" + gv.counterCT)
						gv.missionList.put(mt.name , mt_instance); gv.tasksList.add(mt.name)
						// compound task
						addRecursivellySubtasks(mt.ct,mt.name, gv.counterCT)
					}}}}
	}
	
	
	// =====================
	/**STEP2. Rewrite location of subtasks from mission tasks with locations. */
	def overrideLocationFromMissionTasks(){
		val mtList = gv.resource.allContents.filter(MissionTask);
		while(mtList.hasNext()) { val mt = mtList.next();
			println("\n")
			switch mt{
				MissionTask:{
					if(mt.loc!== null){
						for (at:gv.missionList.get(mt.name).getatomicInstancesReachable(gv)){//for each atomic subtasks
							gv.atomicList.get(at).loc = mt.loc
							println("*Mission "+mt.name + " changed location of atomic task instance " + at
								+ " to " + mt.loc.name)
						}}}}}
	}
	
	
	
	
	// =====================
	/**STEP 3. Preallocation tasks assigned to robots */
	def private assignPreallocatedTasksToRobots() {
		//check for pre-allocated tasks 	
		val conList = gv.resource.allContents.filter(Constraints);
		while(conList.hasNext()) { val con = conList.next();
			println("\n")
			switch con{
				AllocateT:{
					//- allocate robot to mission task
					if(con.mt!==null){
						var atReachable = gv.missionList.get(con.mt.name).getatomicInstancesReachable(gv)
						for(atID:atReachable){
							Aux.allocateATtoRobot(atID, con.robot, gv)
							println("*Preallocation: "+atID + " allocated to "+con.robot.name+" - (by constraint: allocate task "+con.mt.name+" to robot "+con.robot.name+")")
						}}
					//- allocate robot to atomic task (to all instances of the atomic task)
					else if(con.at!==null){
						for(atInstance:gv.atomicList.values()){
							if (atInstance.at.name==con.at.name){
								var atID = atInstance.getId()
								Aux.allocateATtoRobot(atID, con.robot, gv)
								println("*Preallocation: "+atID + " allocated to "+con.robot.name+" - (by constraint: allocate task "+con.at.name+" to robot "+con.robot.name+")")
							}}}
					//- allocate robot to compound task (to all instances of the compound task)
					else if(con.ct!==null){
						for(ctInstance:gv.compoundList.values()){
							if (ctInstance.ct===con.ct){
								for(atID:ctInstance.getatSubtasks(gv)){
									Aux.allocateATtoRobot(atID, con.robot, gv)
									println("*Preallocation: "+atID + " allocated to "+con.robot.name+" - (by constraint: allocate task "+con.ct.name+" to robot "+con.robot.name+")")
								}}}}
					//error
					else{throw new UnsupportedOperationException("ERROR. No task found on mission constraint:" + con )}
					 
				}
				Closest:{
					//- allocate mission task to closest robot
					if(con.mt!==null){
						var atReachable = gv.missionList.get(con.mt.name).getatomicInstancesReachable(gv)
						for(atID:atReachable){
							var Robot r = Aux.getClosestRobot(atID,gv)
							gv.atomicList.get(atID).robot = r
							println("*Preallocation: "+atID + " allocated to "+r.name+" - (by constraint: allocate task "+con.mt.name+" to closest robot.)")
						}
					}
					//- allocate atomic task type to closest robot (all instances of)
					else if(con.at!==null){
						for(atInstance:gv.atomicList.values()){ if (atInstance.at.name==con.at.name){
							var atID = atInstance.getId()
							var Robot r = Aux.getClosestRobot(atID,gv)
							gv.atomicList.get(atID).robot = r
							println("*Preallocation: "+atID + " allocated to "+r.name+" - (by constraint: allocate task "+con.at.name+" to closest robot.)")
						}}							
					}
					//- allocate compound task type to closest robot (all instances of)
					else if(con.ct!==null){
						for(ctInstance:gv.compoundList.values()){
							if (ctInstance.ct===con.ct){
								for(atID:ctInstance.getatSubtasks(gv)){
									var Robot r = Aux.getClosestRobot(atID,gv)
									gv.atomicList.get(atID).robot = r
									println("*Preallocation: "+atID + " allocated to "+r.name+" - (by constraint: allocate task "+con.ct.name+" to closest robot.)")
								}}}
					}
					//- allocate all tasks to closest robots
					else{
						for(atID:gv.atomicList.keySet()){
							var Robot r = Aux.getClosestRobot(atID,gv)
							gv.atomicList.get(atID).robot = r
							println("*Preallocation: "+atID + " allocated to "+r.name+" - (by constraint: allocate all tasks to closest robot.)")
						}
					}
				}
				
			}}
	}
	
	
	
	// =====================
	/**STEP 4. Check time constraints (end/start time) */
	def private assignInitEndTimesOfAtomicTasks() {
		val timeConstraints = gv.resource.allContents.filter(TaskTime).toList();
		for (tcon : timeConstraints){
			println("\n")
			//- mission task
			if(tcon.mt!==null){
				var atReachable = gv.missionList.get(tcon.mt.name).getatomicInstancesReachable(gv)
				for(atID:atReachable){
					//start
					if (tcon.startEnd.getName()=='start'){
						gv.atomicList.get(atID).start = tcon.time
						println("*Start time "+ tcon.time +" for : "+atID + " - (by constraint: task "+tcon.mt.name+" with start time "+ tcon.time +" )")
					}
					//end
					else if(tcon.startEnd.getName()=='end'){
						gv.atomicList.get(atID).end = tcon.time
						println("*End time "+ tcon.time +" for : "+atID + " - (by constraint: task "+tcon.mt.name+" with end time "+ tcon.time +" )")
					}
				}
			}
			//- atomic task
			else if(tcon.at!==null){
				for(atInstance:gv.atomicList.values()){ if (atInstance.at.name==tcon.at.name){
					var atID = atInstance.getId()
					//start
					if (tcon.startEnd.getName()=='start'){
						gv.atomicList.get(atID).start = tcon.time
						println("*Start time "+ tcon.time +" for : "+atID + " - (by constraint: task "+tcon.at.name+" with start time "+ tcon.time +" )")
					}
					//end
					else if(tcon.startEnd.getName()=='end'){
						gv.atomicList.get(atID).end = tcon.time
						println("*End time "+ tcon.time +" for : "+atID + " - (by constraint: task "+tcon.at.name+" with end time "+ tcon.time +" )")
					}		
				
				}}
			}
			//- compound task
			else if(tcon.ct!==null){
				for(ctInstance:gv.compoundList.values()){
					if (ctInstance.ct===tcon.ct){
						for(atID:ctInstance.getatSubtasks(gv)){
							//start
							if (tcon.startEnd.getName()=='start'){
								gv.atomicList.get(atID).start = tcon.time
								println("*Start time "+ tcon.time +" for : "+atID + " - (by constraint: task "+tcon.ct.name+" with start time "+ tcon.time +" )")
							}
							//end
							else if(tcon.startEnd.getName()=='end'){
								gv.atomicList.get(atID).end = tcon.time
								println("*End time "+ tcon.time +" for : "+atID + " - (by constraint: task "+tcon.ct.name+" with end time "+ tcon.time +" )")
							}	
				}}}
			}
		}		
	}
	
	// =====================
	/** Print tasks info. */
	def printAll(){
		for(String id: gv.tasksList){
			println("\n")
			if(gv.atomicList.keySet().contains(id)){ gv.atomicList.get(id).print() }
			else if(gv.compoundList.keySet().contains(id)){ gv.compoundList.get(id).print() }
			else if(gv.missionList.keySet().contains(id)){ gv.missionList.get(id).print() }
		}
	}
	
	
	// =====================
	/**Recursively add tasks subtasks */
	def private addRecursivellySubtasks(CompoundTask ct, String parent, Integer instance) {
		// 1) Add compound task
		
		var List<String> children = new ArrayList();
		// subtasks instances numbers
		var List<Integer> subtaskcounter = new ArrayList<Integer>;//instance of compound subtasks IMPORTANT: order matter!
		
		for (t:ct.canDoTask){ // subtasks numbers
			switch t{
				AtomicTask:{gv.counterAT+=1;  children.add(t.name +"_"+ gv.counterAT); subtaskcounter.add(gv.counterAT) }
				CompoundTask:{gv.counterCT+=1; children.add(t.name +"_"+ gv.counterCT); subtaskcounter.add(gv.counterCT) } } }
		
		// add compound task instance 								-- NOTE: It first get the children instances to preserve the order of how info is printed when DSL runs.
		var ct_instance = new CompoundTaskInstance(); ct_instance.set(ct, instance, parent, children)
		gv.compoundList.put(ct.name+"_"+instance , ct_instance); gv.tasksList.add(ct.name+"_"+instance)
		
		
		// subtasks instantiated
		var ListIterator<Integer> sbc =  subtaskcounter.listIterator() //iterate instances number of subtasks
		for (t:ct.canDoTask){ // subtasks
			var num = sbc.next() //instance number of subtask
			switch t{
				AtomicTask:{
					// atomic task instance
					var at_instance = new AtomicTaskinstance(); at_instance.set(t , num , ct.name+"_"+instance)
					gv.atomicList.put(t.name+"_" + num , at_instance); gv.tasksList.add(t.name+"_"+num)
		
				}
				CompoundTask:{	//compound task recursively 
					addRecursivellySubtasks(t , ct.name+"_"+instance , num)
				} 
				} }
	}
}