package org.xtext.example.mydsl.generator

import dsl.AtomicTask
import dsl.CompoundTask
import dsl.Location
import dsl.MissionTask
import dsl.Robot
import dsl.TaskTime
import dsl.TasksModel
import java.util.ArrayList
import java.util.Hashtable
import java.util.List
import java.util.ListIterator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2

/** Create global variables */
 class GlobalVar {
   /** Counter for instances of atomic tasks*/
   public int countATpython = 0
   /** Counter for instances of compound tasks*/
   public int countCTpython = 0
   /** Header for the Task Tree file*/
   public String dbTaskTree = "id,,parent,,ordered_children,,location,,numrobots,,joint,,ordered,,consecutive,,start,,end"; 
   /** List of tasks' start time - if constraint is specified a task*/
   public Hashtable<String, Double> startTime = new Hashtable();
   /** List of tasks' end time - if constraint is specified for a task*/
   public Hashtable<String, Double> endTime = new Hashtable();
   
   /** List atomic tasks locations*/
   public Hashtable<String, Location> atLoc = new Hashtable();
   
   /**List of atomic tasks needed for the mission */
   public List<AtomicTask> at_in_mission = new ArrayList();
   
   /**List of tasks instances in mission */
   public Hashtable<MissionTask, ArrayList<String>>missionTask2atomicTasksInstances = new Hashtable();
   
   
   /**Atomic task instances */
   public Hashtable<String,CompoundTaskInstance> compoundTaskInstances = new Hashtable();
   
   
   /**fsa */
   public IFileSystemAccess2 fsa;
   
   /** Alloy integer scope */
   public var alloyIntScope = 7
		
   public Resource resource
   
   def setFsa(IFileSystemAccess2 fsa){
   	this.fsa = fsa
   }
   
   /** Reset variables */
   def reset(){
   	countATpython = 0
   	countCTpython = 0
   	dbTaskTree = "id,,parent,,ordered_children,,location,,numrobots,,joint,,ordered,,consecutive";
   	startTime = new Hashtable();
	endTime = new Hashtable();
	atLoc = new Hashtable();
   }
		
   /** Get list of initial and end tasks' time constraints */
	def checkEndStartTimes(Resource resource) {
		this.resource = resource
		// list of task time constraints
		var ttimeList = resource.allContents.filter(TaskTime);
		var tID = ""
		while(ttimeList.hasNext()) {
			//task time constraint
			val tt = ttimeList.next();
			//get task id
			if (tt.at!==null){tID=tt.at.name}
			if (tt.ct!==null){ tID=tt.ct.name }
			if (tt.mt!==null){ tID=tt.mt.name }
			// save as start or end
			if (tt.startEnd.toString()=="start"){ this.startTime.put(tID,tt.time) }
			if (tt.startEnd.toString()=="end"){ this.endTime.put(tID,tt.time)}
			//println("\nTask: "+ tID); print(" has " + tt.startEnd + tt.time.toString())
		}
	}
	
	/**Get list of atomic tasks reachable from a compound task, recursively */
	def List<AtomicTask> getatomictasksinCT(CompoundTask ct){
		var List<AtomicTask> ats_in_ct = new ArrayList();
		for (TasksModel subt: ct.canDoTask){
			switch subt{
				AtomicTask:{ 
					ats_in_ct.add(subt)
				}
				CompoundTask:{ 
					var List<AtomicTask> newList = new ArrayList<AtomicTask>( getatomictasksinCT(subt) );
					ats_in_ct.addAll(newList);
				}
			}
		}
		return ats_in_ct
	}
	
	/**Get closest robot to atomic task */
	def Robot getClosestRobot(String atInstance){
		val loc = this.atLoc
		
		var Robot closestR = null
		var Double closestD = null
		
		for (Robot r: resource.allContents.filter(Robot).toList()){ //for each robot
			
			//check if robot has capability to do task
			var ithas = ""
			for (i:r.capabilities){
				if (i.at.name == at_from_atInstance(atInstance)){ithas="true"}
			}
			//if robot can do task
			if (ithas==="true"){
				//check Euclidian distance
				var Pair<Double, Double> coordAT = new Pair( loc.get(atInstance).x , loc.get(atInstance).y ) 
				var Pair<Double, Double> coordRob = new Pair( r.initLoc.x , r.initLoc.y )
				var dist = distance(coordAT,coordRob) //get euclidian distance to task sqr()
				//add if it is the closest
				if (closestR===null){
					closestR = r;  closestD = dist	
				}
				else{
					if (dist<closestD){
						closestR = r; closestD = dist	
					}
				}
			}
		}
		return closestR
	}
	
	/** Euclidian distance */
	def double distance (Pair<Double, Double> coord1 , Pair<Double, Double> coord2) {
	    var double deltaX = coord1.getKey() - coord2.getKey();
	    var double deltaY = coord1.getValue() - coord2.getValue();
	    var double result = Math.sqrt(deltaX*deltaX + deltaY*deltaY);
	    return result; 
	}
	
	/** Return atomic task id without instance number */
	def String at_from_atInstance(String atInstance){
		var String s = atInstance.substring(0, atInstance.lastIndexOf("_"));
		return s
	}
	
	//Not needed, JIC
	/** Return atomic task without instance number */
	def AtomicTask at_from_atInstanceT(String atInstance){
		var String s = atInstance.substring(0, atInstance.lastIndexOf("_"));
		
		for (AtomicTask at: resource.allContents.filter(AtomicTask).toList()){
			if(at.name ==s){
				return at
			}
		}
		throw new UnsupportedOperationException("ERROR - retrieving task for instance " + s)	
	}
	
	
	
	/** Get atomic task instances for all instances of a compound task type ct */
	def List<String> getInstanceChildrenFromCTintance(CompoundTask ct){
		
		var all_ctInstances_IDs = compoundTaskInstances.keys()
		
		println("All ct instances:" + all_ctInstances_IDs)
		
		var List<String> children
		
		// ----1 Get children of all CT instances
		//for each compound task instance
		while (all_ctInstances_IDs.hasMoreElements() ){ //check ct instance i
			//get info
			var n = all_ctInstances_IDs.nextElement() //ctInstance name
			var ctInstance = compoundTaskInstances.get(n) //get info
			
			//if it is the type of compound tasks to get, add all children
			if (ctInstance.ct==ct){
				//get children
				children.addAll(ctInstance.subtasksInstances)
			}
		}
		
		// ---2 Get atomic tasks recursively
		var List<String> at
		//for each children
		for (ch: children){
			//if compound task, adds its children
			if ( compoundTaskInstances.containsKey(ch) )
			{ children.addAll(compoundTaskInstances.get(ch).subtasksInstances) }
			else{ at.add(ch) }	
		}
		
		return at
	}
	
}


/**Atomic task instance */
class CompoundTaskInstance{
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
class Tree{
	
	
	/** Create Global variables */
	public val GlobalVar gv = new GlobalVar()
	
	/** Create tree */
	def createTree(Resource resource, IFileSystemAccess2 fsa){
					
		gv.fsa = fsa;
		// 1 get tasks constraints
		gv.checkEndStartTimes(resource)
		// 2 mission tasks
		val mtList = resource.allContents.filter(MissionTask);
		// get mission i
		while(mtList.hasNext()) {
			val m = mtList.next(); // mission i
			
			println("\nGetting mission:" + m.name );
			
			switch m{
				MissionTask:{
					//-- Get location
					var Location mlocation = null
					if (m.loc !== null){mlocation = m.loc}
					
					//--Get constraints
					var mstart = "null"
					var mend = "null"
					if (gv.startTime.containsKey(m.name)){mstart=gv.startTime.get(m.name).toString()}
					if (gv.endTime.containsKey(m.name)){mend=gv.endTime.get(m.name).toString()}
						
					//-- If Compound task
					if (m.ct !== null){ //compound task
						gv.countCTpython += 1
						var childStr = " [\'" + m.ct.name + "_" + gv.countCTpython +"\']" //child
						//-- Save mission -missionTreeString(id, par, child, location, numrobots, joint, order , consec, endTime, startTime)
						gv.dbTaskTree += missionTreeString(m.name, "NaN", childStr , "NaN", "NaN", "NaN", "NaN" , "NaN", "null", "null")  //missions have no location
						//-- Recursive save subtasks - (parent id, task, task instance, location, start, end)
						recursiveAddSubTasks(m.name, m.ct, gv.countCTpython, mlocation, mstart, mend, m);
					}
					//-- If Atomic Task
					else if (m.at !== null){ //atomic task
						//-- Save mission -missionTreeString(id, par, child, location, numrobots, joint, order , consec, endTime, startTime)
						gv.countATpython+=1;  var n = gv.countATpython
						var childStr = " [\'" + m.at.name + "_" + n +"\']" //child
						gv.dbTaskTree += missionTreeString(m.name, "NaN", childStr , "NaN", "NaN", "NaN", "NaN" , "NaN", "null", "null") //missions have no location
						
						//-- Save atomic task
						addAtomicTask(gv, m.at, n, m.name, mlocation, mstart, mend, m)						
					}
					else
						throw new UnsupportedOperationException("ERROR - no compound or atomic task found in mission task")	
				}
			}
		}
	}
	
	
	
	/**Recursive save subtasks - (parent id, task, task count instance, mission location, parent start and end time constraints) */
	def void recursiveAddSubTasks(String parentId, CompoundTask task, int i, Location missionLoc, String startParent, String endParent, MissionTask topMission) {
		
		//println("For task: " + task.name + " with parent start at: " + startParent + " and ends at: " + endParent)
		
		//--1 subtasks
		var List<String> subtasks_id = new ArrayList(); // string
		
		// subtasks instances
		var List<Integer> subtaskcounter = new ArrayList<Integer>;//instance of compound subtasks IMPORTANT: order matter!
		
		
		
		for (t:task.canDoTask){ // subtasks
			switch t{
				AtomicTask:{gv.countATpython+=1;  subtasks_id.add(t.name +"_"+ gv.countATpython); subtaskcounter.add(gv.countATpython) }
				CompoundTask:{gv.countCTpython+=1; subtasks_id.add(t.name +"_"+ gv.countCTpython); subtaskcounter.add(gv.countCTpython) } } }
		var ctName = task.name + "_" + i; // name instantiated
		
		//-- 2 Save -missionTreeString(id, par, child, location, numrobots, joint, order , consec, endTime, startTime)
		gv.dbTaskTree += missionTreeString(ctName, parentId, '[\''+subtasks_id.join('\',\'')+'\']' , "NaN", "NaN", "NaN", task.ordered.toString() , task.consecutive.toString(), "null", "null") //CT has no location, no task constraints
		
		
		//create compound task
		var CompoundTaskInstance ctInstance = new CompoundTaskInstance
		ctInstance.ct = task
		ctInstance.inum = i
		ctInstance.subtasksInstances =  subtasks_id
		ctInstance.parentId = parentId
		gv.compoundTaskInstances.put(ctName , ctInstance)
		
		
		//-- 3 Get compound task Time constraint
		//if parent has constraint
		var startCT = "null";
		var endCT = "null";
		//start
		if (startParent!=="null"){startCT=startParent} //if parent has constraint
		else if (gv.startTime.containsKey(task.name)){ startCT=gv.startTime.get(task.name).toString() } //if parent has no constraint, but compound task
		//end
		if (endParent!=="null"){endCT=endParent} //if parent has constraint
		else if (gv.endTime.containsKey(task.name)){ endCT=gv.endTime.get(task.name).toString() } //if parent has no constraint, but compound task
		
		
		//-- 4 Recursive add subtasks
		var ListIterator<Integer> sbc =  subtaskcounter.listIterator() //iterate instances number of subtasks
		for (t:task.canDoTask){
			switch t{
				//atomic task
				AtomicTask:{ addAtomicTask( gv, t, sbc.next(), ctName, missionLoc, startCT, endCT, topMission)	}
				//compound task
				CompoundTask:{
					// --recursively add to database (parent id, task, task count instance, location)
					gv.countCTpython += 1
					recursiveAddSubTasks(ctName, t, sbc.next() , missionLoc, startCT, endCT, topMission);
					
				}
			}
		}		
	}
	
	
	/** Add atomic task to tree */
	def static addAtomicTask(GlobalVar gv, AtomicTask t, int i, String parent, Location missionLoc, String startParent, String endParent, MissionTask mission){
		//-- a1 Get info
		gv.at_in_mission.add(t) 	 //add to list of necessary atomic tasks
		
		////
		var atName = t.name + "_" + i; //task instance
		var missonAtInstances = gv.missionTask2atomicTasksInstances
		if (missonAtInstances.containsKey(mission)){
			var ArrayList<String> b = missonAtInstances.get(mission)// tasksSoFar
			b.add(atName)
			gv.missionTask2atomicTasksInstances.put(mission,b)// add instance to mission
		}
		else{
			var ArrayList<String> b = new ArrayList<String>() // tasksSoFar (none)
			b.add(atName)
			gv.missionTask2atomicTasksInstances.put(mission,b) // add instance to mission
		}
		
		////
		
		var location = t.loc; if (missionLoc!==null){ location = missionLoc} // location: if mission has location, overwrite
		var joint = "false"; if(t.robots>1){joint="true"}
		gv.atLoc.put(atName,location) //save location of atomic task
		
		//--Get constraints
		//-- a1.1 start time constraints
		var start = "null";
		if (startParent!=="null"){start=startParent} //if parent has constraint
		else if (startParent==="null"){ //check if task is constrained
			if (gv.startTime.containsKey(t.name)){start=gv.startTime.get(t.name).toString() } }
		//ERROR
		else{ throw new UnsupportedOperationException("ERROR - cannot retrieved end time constraint for atomic task "+t.name) }
		
		//-- a1.2 end time constraints
		var end = "null"
		if (endParent!=="null"){end=endParent} //if parent has constraint
		else if (endParent==="null"){  //if parent has no constraint
			if (gv.endTime.containsKey(t.name)){end=gv.endTime.get(t.name).toString() } }
		//ERROR
		else{ throw new UnsupportedOperationException("ERROR - cannot retrieved start time constraint for atomic task "+t.name) }
		
					
		//-- Save -missionTreeString(id, par, child, location, numrobots, joint, order , consec, endTime, startTime)
		gv.dbTaskTree += missionTreeString(atName, parent, "NaN" , location.name, t.robots.toString(), joint, "NaN", "NaN", start, end) //CT has no location
		
		 	
	}
	
	
	
	
	
	/** Row in .txt file used for a dataframe df in python */
	def static missionTreeString(String id, String par, String child,
	 String location, String numrobots, String joint,
	 String order , String consec, String end , String start){
	 	// .replaceAll("\\s+","") removes white spaces
	 	
	 	var separator = ",,"
		var dfAllocationLine = "\n"+ 
		id.replaceAll("\\s+","") + separator +
		par.replaceAll("\\s+","") + separator +
		child.replaceAll("\\s+","")+ separator +
		location.replaceAll("\\s+","") + separator +
		numrobots.replaceAll("\\s+","")+ separator +
		joint.replaceAll("\\s+","") + separator +
		order.replaceAll("\\s+","") + separator +
		consec.replaceAll("\\s+","") + separator +
		end.replaceAll("\\s+","") + separator +
		start.replaceAll("\\s+","")
		return dfAllocationLine
	}
	
	
	/** Generate tree file*/
	def generateTreeFile(String fileName){
		gv.fsa.deleteFile(fileName);
		this.generateFile(fileName, gv.dbTaskTree)
	}
	
	def generateFile(String fileName, String finalString){
		gv.fsa.deleteFile(fileName);
		gv.fsa.generateFile(fileName, finalString)
	}
}

