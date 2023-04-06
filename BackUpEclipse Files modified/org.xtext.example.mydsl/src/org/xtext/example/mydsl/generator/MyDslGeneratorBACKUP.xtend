/*
 * Author: Gricel Vazquez
 * Date: 10-02-2022
 */
package org.xtext.example.mydsl.generator

import java.io.IOException
import java.nio.file.Files
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.xtext.example.mydsl.myDsl.ProblemSpecification
import org.xtext.example.mydsl.myDsl.AtomicTask
import org.xtext.example.mydsl.myDsl.CompoundTask
import org.xtext.example.mydsl.myDsl.AtomicTaskLoc
import org.xtext.example.mydsl.myDsl.CompTaskOneLoc
import org.xtext.example.mydsl.myDsl.CompTaskNoLoc
import org.xtext.example.mydsl.myDsl.AtomicTaskNoLoc
import org.xtext.example.mydsl.myDsl.Location
import java.nio.file.Path
import java.util.ArrayList
import java.util.List
import java.util.Set
import java.util.HashSet
import org.xtext.example.mydsl.myDsl.AllRobotsXX
import org.xtext.example.mydsl.myDsl.AllRobotsX
import org.xtext.example.mydsl.myDsl.RobotsXX
import org.xtext.example.mydsl.myDsl.RobotsX
import org.xtext.example.mydsl.myDsl.AllRobotsDeploy
import org.xtext.example.mydsl.myDsl.NumAllocations
import org.xtext.example.mydsl.myDsl.NumPopulation
import org.xtext.example.mydsl.myDsl.NumEvaluations
import org.xtext.example.mydsl.myDsl.TasksModel
import org.xtext.example.mydsl.myDsl.Paths
import org.xtext.example.mydsl.myDsl.Robot

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
 

 
class MyDslGeneratorBACKUP extends AbstractGenerator {
	var s = ""
	var s_cap = ""
	var s_fact =""
	var count_capabilities = 0
	// *** Import variable path from somewhere else
	//System.out.println("Working Directory = " + System.getProperty("user.dir"));
	var p  =System.getProperty("user.dir");
	
	
	
	var path_sigAlloyDeclaration = "//Users//grisv//GitHub//KanoaV2//Resources//org.xtext.example.mydsl//src//org//xtext//example//mydsl//generator//" 
	//Windows:
	//var path_sigAlloyDeclaration = // "C://Users//grist//eclipse-workspace//MRS//org.xtext.example.mydsl//src//org//xtext//example//mydsl//generator//"
	//Mac:
	//var path_sigAlloyDeclaration = "//Users//grisv//GitHub//KanoaV2//Resources//org.xtext.example.mydsl//src//org//xtext//example//mydsl//generator//" 
	
							   
	var alloyIntScope = 7 //***scope of int in Alloy
	
	// for python, needed after allocation
	var dfAllocation = "id,,parent,,ordered_children,,location,,runbyrobot,,joint,,ordered,,consecutive"
	
	
	
	def static void main(String[] args) {
    	println("Hello World")
    	var p  =System.getProperty("user.dir");
    	println(p)
  	}
	
	
	// open root
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		// -- instance tree
		val root = resource?.allContents?.head as ProblemSpecification;
		s += readFile(path_sigAlloyDeclaration+"sigAlloyDeclaration.txt")
		
		// -- get data: atomic tasks needed for missions (even if repeated) + robots, x and y of each
		var List<AtomicTask> at_missions = new ArrayList();
		var List<Double> at_x = new ArrayList();
		var List<Double> at_y = new ArrayList();
		var List at_r = new ArrayList();
		var Set<AtomicTask> at_unique // unique atomic tasks needed for missions
		// python var
		var countATpython = 0
		var countCTpython = 0
		for (m: root.mission.toList){
			
			switch m{
				AtomicTaskNoLoc:{
					var loc = findATloc(m.at , root)
					at_missions.add(m.at) 	 // add at
					at_x.add(loc.x)			 // add location x
					at_y.add(loc.y)			 // add location y
					at_r.add(m.at.robots)	 // add num robots needed
					//----for python:
					var id = m.name
					var par = "NaN"
					var child = "[\'" + m.at.name + "_" + countATpython +"\']"
					var runbyrobot = "NaN"
					var joint = "NaN"
					var order = "NaN"
					var consec= "NaN"
					var location = "NaN"
					dfAllocation += missionTreeString(id, par, child, location, runbyrobot, joint, order , consec)
	 
					id = m.at.name +"_"+countATpython
					par = m.name 
					child = "NaN"
					joint = Joint(m.at)
					location = loc.name 
					dfAllocation += missionTreeString(id, par, child, location, runbyrobot, joint, order , consec)
					countATpython += 1
					//----for python 
				}
				
				AtomicTaskLoc:{
					var loc = m.loc
					at_missions.add(m.at) 	 // add at
					at_x.add(loc.x)			 // add location x
					at_y.add(loc.y)			 // add location y
					at_r.add(m.at.robots)	 // add num robots needed
					
					//----for python:
					var id = m.name
					var par = "NaN"
					var child = "[\'" + m.at.name + "_" + countATpython +"\']"
					var runbyrobot = "NaN"
					var joint = "NaN"
					var order = "NaN"
					var consec= "NaN"
					var location = "NaN"
					dfAllocation += missionTreeString(id, par, child, location, runbyrobot, joint, order , consec)
					
					id = m.at.name +"_"+countATpython
					par = m.name 
					child = "NaN"
					joint = Joint(m.at)
					location = loc.name 
					dfAllocation += missionTreeString(id, par, child, location, runbyrobot, joint, order , consec)
					
					countATpython += 1
					//----for python 
				}
						 
				CompTaskNoLoc:{
					//----for python:
					var id = m.name
					var par = "NaN"
					var child = " [\'" + m.ct.name + "_" + countCTpython +"\']"
					var runbyrobot = "NaN"
					var joint = "NaN"
					var order = "NaN"
					var consec= "NaN"
					var location = "NaN"
					dfAllocation += missionTreeString(id, par, child, location, runbyrobot, joint, order , consec)
					
					var loc = findCTOneloc(m.ct,root)
					var a = getCtSubtasksDF(countATpython,countCTpython, m.ct,root,m.name,loc.name)
					dfAllocation += a.get(0)
					countATpython = a.get(1) as Integer
					countCTpython = a.get(2) as Integer
					//----for python 
					
					//s += getCtSubtasks(m.ct,root)
					var List<AtomicTask> ATsubtasks = getCtSubtasks(m.ct,root)
					for (at:ATsubtasks){
						at_missions.add(at) 	 // add at
						at_x.add(loc.x)			 // add location x
						at_y.add(loc.y)			 // add location y
						at_r.add(at.robots)	 // add num robots needed
					}
				}
				
				CompTaskOneLoc:{
					//----for python:
					var id = m.name
					var par = "NaN"
					var child = " [\'" + m.ct.name + "_" + countCTpython +"\']"
					var runbyrobot = "NaN"
					var joint = "NaN"
					var order = "NaN"
					var consec= "NaN"
					var location = "NaN"
					dfAllocation += missionTreeString(id, par, child, location, runbyrobot, joint, order , consec)
					
					var loc = m.loc
					var a = getCtSubtasksDF(countATpython,countCTpython, m.ct,root,m.name,loc.name)
					dfAllocation += a.get(0)
					countATpython = a.get(1) as Integer
					countCTpython = a.get(2) as Integer + 1
					//----for python 
					
					
					//s += getCtSubtasks(m.ct,root)
					var List<AtomicTask> ATsubtasks = getCtSubtasks(m.ct,root)
					for (at:ATsubtasks){
						at_missions.add(at) 	 // add at
						at_x.add(loc.x)			 // add location x
						at_y.add(loc.y)			 // add location y
						at_r.add(at.robots)	 // add num robots needed
					}
				}
			}
		}
		
		//create missions to tasks (tree) file (to read by python code) 
		generateFile('modelMissionsTree.txt', dfAllocation, fsa)
		dfAllocation = ""
		
		// -- create different files depending on:
		// 1) QoS : none related to Alloy
		
		// 2) QoS: over time
		
		// 3) QoS: over distance x
		
		// 4) QoS: over distance y
		
		// 5) QoS: over distance x,y
		
		// -- robots
		at_unique = new HashSet<AtomicTask>(at_missions); // save unique at
		
		var s_r =""
		s += "\n\n// ----------------ROBOTS:\n"
		for (r : root.robotsModel.robots.toList){
			s+= "\nsig "+r.name+" extends Robot{}\n"
			s+= "{disj[capability ,  Capability"
			s_r = "#"+r.name+"<=1 and"//fact
			for (t: r.robots2tasksPerformance.toList){
				if (at_unique.contains(t.at)){
					s+= "-"+ r.name + t.at.name
					//capabilities:
					s_cap+="\nsig "+ r.name + t.at.name+" extends Capability{}\n"
					s_cap+="{all d:do | d in "+ t.at.name+"}"
					s_fact += "#" + r.name + t.at.name + "<=1\n"
					count_capabilities+=1 // count (later needed)
			}}
			s+="]}"
			s+="\nfact{"+s_r.substring(0, s_r.length() - 4)+"}"
		}
		
		// -- capabilities
		s += "\n\n// ----------------CAPABILITIES:\n"
		s+=s_cap
		s+= "\n\nfact{"+s_fact+"} // robot capabilities appear once (if robot appears, and if capab. tasks assigned)"
		
		// -- atomic tasks
		s += "\n\n// ----------------ATOMIC TASKS:\n"
		
		
		// add to alloy unique atomic tasks
		
		s += "\n"+ "abstract sig "
		var s_t = ""
		var s_f = ""
		for (var int i= 0; i<at_unique.length; i++){
			var at = at_unique.get(i).name
			s_t += at +","
			s_f += "\nfact{all a:"+ at +" | #do.a="+ getRobots_atName(at,root) +"}	// number of robots needed"
			//fact{all at:AtomicTask | #do.at=1} //all atomic tasks are assigned to the robots[org.xtext.example.mydsl.myDsl.impl.AtomicTaskImpl@10cbd16c (name: at4_notify, criticality: false, description: null) (robots: 1), org.xtext.example.mydsl.myDsl.impl.AtomicTaskImpl@41838090 (name: at2_floor, criticality: false, description: null) (robots: 1), org.xtext.example.mydsl.myDsl.impl.AtomicTaskImpl@303715ca (name: at3_sanit, criticality: false, description: null) (robots: 1)][org.xtext.example.mydsl.myDsl.impl.AtomicTaskImpl@10cbd16c (name: at4_notify, criticality: false, description: null) (robots: 1), org.xtext.example.mydsl.myDsl.impl.AtomicTaskImpl@41838090 (name: at2_floor, criticality: false, description: null) (robots: 1), org.xtext.example.mydsl.myDsl.impl.AtomicTaskImpl@303715ca (name: at3_sanit, criticality: false, description: null) (robots: 1)][org.xtext.example.mydsl.myDsl.impl.AtomicTaskImpl@10cbd16c (name: at4_notify, criticality: false, description: null) (robots: 1), org.xtext.example.mydsl.myDsl.impl.AtomicTaskImpl@41838090 (name: at2_floor, criticality: false, description: null) (robots: 1), org.xtext.example.mydsl.myDsl.impl.AtomicTaskImpl@303715ca (name: at3_sanit, criticality: false, description: null) (robots: 1)][org.xtext.example.mydsl.myDsl.impl.AtomicTaskImpl@10cbd16c (name: at4_notify, criticality: false, description: null) (robots: 1), org.xtext.example.mydsl.myDsl.impl.AtomicTaskImpl@41838090 (name: at2_floor, criticality: false, description: null) (robots: 1), org.xtext.example.mydsl.myDsl.impl.AtomicTaskImpl@303715ca (name: at3_sanit, criticality: false, description: null) (robots: 1)]
		}
		s += s_t.substring(0,s_t.length-1) + " extends AtomicTask {}"
		s += s_f
		// add individual (may be repeated) atomic tasks needed
		for (var i=0 ; i<at_missions.length;i++){
			s+="\nsig " + at_missions.get(i).name + "_" + i + " extends "+ at_missions.get(i).name+"{}"
			var x = cast2IntXY(at_x.get(i))
			var y = cast2IntXY(at_y.get(i))
			s+="\n{x="+ x +"\ny="+ y +"}"
			
			
		}
		
		// -- predicate
		s += "\n\n// ----------------PREDICATE:\n"
		// add atomic tasks
		s += "\npred TaskAllocation{"
		
		s += "\n}"
		
		// -- qos
		s += "\n\n// ----------------CONSTRAINTS:\n"
		var checkAllRobotDeployed =0
		for(q: root.qos){
			switch q{
				AllRobotsXX:{
					s += "\nfact{no r:Robot | r.capability.do."+q.coordinate+"<"+cast2IntXY(q.xy1)+" or r.capability.do."+q.coordinate+">"+cast2IntXY(q.xy2)+"} // ["+q.coordinate+"1,"+q.coordinate+"2] constraint over all robots"
				}
				AllRobotsX:{
					var sign = ""
					if (q.type=="greater than"){
						sign ="<="
					}
					else if (q.type=="lower than"){
						sign = ">="
					}
					else if (q.type=="geq"){
						sign = "<"
					}
					else if (q.type=="leq"){
						sign = ">"
					}
					s += "\nfact{no r:Robot | r.capability.do."+q.coordinate + sign + cast2IntXY(q.xy)+"} // "+q.coordinate+" constraint over all robots"
					
				}
				RobotsXX:{
					s += "\nfact{no r:"+ q.robot.name+" | r.capability.do."+q.coordinate+"<"+cast2IntXY(q.xy1)+" or r.capability.do."+q.coordinate+">"+cast2IntXY(q.xy2)+"} // ["+q.coordinate+"1,"+q.coordinate+"2] constraint "
				}
				RobotsX:{
					var sign = ""
					if (q.type=="greater than"){
						sign ="<="
					}
					else if (q.type=="lower than"){
						sign = ">="
					}
					else if (q.type=="geq"){
						sign = "<"
					}
					else if (q.type=="leq"){
						sign = ">"
					}
					s += "\nfact{no r:"+q.robot.name+" | r.capability.do."+ q.coordinate + sign + cast2IntXY(q.xy)+"} // "+ q.coordinate+" constraint"
				}
				AllRobotsDeploy:{
					checkAllRobotDeployed = 1
				}
				NumAllocations:{ // number of Alloy allocations to (try to) find
					var numAlloyInstancesToGet = q.number
				}
				NumPopulation:{ // number of Alloy 
					var numPopulationToGet = q.number
				}
				NumEvaluations:{ // number of Alloy
					var numEvaluationsToGet = q.number
				}
			}
		}
		
		// -- run command
		s += "\n\n// ----------------RUN COMMAND:\n"
		s+= "\nrun TaskAllocation for"
		s+= "\n"+alloyIntScope+" Int,"
		s+= "\n" + count_capabilities + " Capability," 
		s+= "\n" + "exactly " + at_missions.length +" AtomicTask," 
		if (checkAllRobotDeployed==1){ // add robots (exactly if all deployed)
			s+= "\nexactly " + root.robotsModel.robots.toList.length + " Robot,"  + "// deploy all robots"
		}
		else{ // not all robots deployed
			s+= "\n" + root.robotsModel.robots.toList.length + " Robot"
		}
		for (var i=0 ; i<at_missions.length;i++){ // add each needed AT once
			s+=",\nexactly 1 " + at_missions.get(i).name + "_" + i
		}
		generateFile('modelAllocation.als', s, fsa) // -- generate file
		s = ""
		// 4) QoS: time and distance
		
		
		
		
		// Genetare file for paths in location
		var sw= WorldM(resource)
		generateFile('worldmodel.txt', sw, fsa) // -- generate file
		sw = ""
		
	}
	
	//******** ****************** ********//
	//******** Required Functions ********//
	
	def WorldM(Resource resource){
		val root = resource?.allContents?.head as ProblemSpecification;
		var sw = ""
		for(wm: root.worldModel){
			switch wm{
				Paths:{
					sw += wm.loc1.name+ "," + wm.loc2.name+ "," + wm.distance + "\n"
				}
			}
		}
		for (r : root.robotsModel.robots.toList){
			switch r{
				Robot:{
					sw += r.name+ "," + r.initLoc.name + "\n"
				}
			}
		}
		sw = sw.substring(0,sw.length-1)
		return sw
	}
	
	/** Cast object -> int -> string */
	def cast2IntXY(Double xy) { 
			var String s = xy.toString();
			var int dot = s.indexOf("."); //this finds the first occurrence of "." //in string thus giving you the index of where it is in the string
			var String integerPart;
			if (dot!= -1) {integerPart= s.substring(0 ,dot);}
			else {integerPart = "0"}
			return integerPart
	}
	
	def getRobots_atName(String at, ProblemSpecification root) {
		for (t: root.tasksModel){
			switch t{
				AtomicTask:{
					if (t.name==at){return t.robots}
		}}}
	// Handled ERROR
	throw new UnsupportedOperationException("ERROR: num of robots don't found for task "+at)
	}
	
	
	
	/** Get subtasks of compound task */
	def ArrayList<AtomicTask> getCtSubtasks(CompoundTask ct, ProblemSpecification root) {
		//var EList<AtomicTask> at new LinkedList<AtomicTask>();
		var ArrayList<AtomicTask> at = new ArrayList<AtomicTask>();
		if (ct.canDoTask.length>1){	// check that all compound tasks have more than two subtasks
			for (subtask : ct.canDoTask.toList){ // for each subtask
				switch subtask{
					CompoundTask:{
						at.addAll(getCtSubtasks(subtask,root))
					}
					AtomicTask:{at.add(subtask)}
				}
			}
		return at
		}
		// Handled ERROR
		throw new UnsupportedOperationException("ERROR: All compound tasks need at least 2 subtasks ")
	}
	
	
	
	/** Get subtasks of compound task for Python*/
	def List getCtSubtasksDF(int countATpython, int countCTpython, CompoundTask ct, ProblemSpecification root, String parent, String loc) {
		var ArrayList<AtomicTask> at = new ArrayList<AtomicTask>();
		var s = "";
		var countAT = countATpython
		var countCT = countCTpython
		
		if (ct.canDoTask.length>1){	// check that all compound tasks have more than two subtasks
			
			// ---for python: cts
			/**'''Get 
		           id parent    ordered_children        runbyrobot  joint ordered consecutive   location
		    0    t4$0     NA           ['ct2$0']               NaN  NaN     NaN         NaN     NaN
		    1    t2$0     NA           ['ct1$2']               NaN  NaN     NaN         NaN     NaN
		    2    t3$0     NA           ['at3$0']               NaN  NaN     NaN         NaN     NaN
		    3    t1$0     NA           ['ct1$1']               NaN  NaN     NaN         NaN     NaN
		    4   ct2$0   t4$0  ['at4$0', 'ct1$0']               NaN  NaN     True        True    NaN
		    5   ct1$2   t2$0  ['at1$0', 'at2$0']               NaN  NaN     False       True    NaN
		    6   at3$0   t3$0                 NaN  ['r4$0', 'r3$0']  True    NaN         NaN     l9
		    7   ct1$1   t1$0  ['at1$1', 'at2$1']               NaN  NaN     False       True    NaN
		    8   at4$0  ct2$0                 NaN          ['r2$0']  NaN     NaN         NaN     l10
		    9   at2$2  ct1$0                 NaN          ['r2$0']  NaN    True         True    l13
		    10  at1$2  ct1$0                 NaN          ['r2$0']  NaN     NaN         NaN     l9...
		    '''*/
			//-------python ct
			var num_current_ct = countCT
			
			var id = ct.name + "_" + countCT
			var par = parent
			var child = ""
			
			// get children numbers
			var Nat = countAT
			var Nct = countCT + 1 // child is next ct
			
			for (ct_subt : ct.canDoTask.toList){
				
				if (typeTask(ct_subt) == "atomic"){
					child += "\'"+ct_subt.name+"_"+ Nat +"\',"
					Nat += 1
				}
				else if (typeTask(ct_subt) == "compound"){
					child += "\'"+ct_subt.name+"_"+ Nct +"\',"
					Nct += 1
				}
				
			}
			child = "[" + child.substring(0,child.length()-1) + "]"
			var runbyrobot = "NaN"
			var joint = "NaN"
			var order = Order(ct)
			var consec= Consecutive(ct) 
			var location = loc
			dfAllocation += missionTreeString(id, par, child, location, runbyrobot, joint, order , consec)
			
			//------python
			
			
			// for each subtask
			for (subtask : ct.canDoTask.toList){ // for each subtask
				switch subtask{
					// compound
					CompoundTask:{
						var List<Object> l = getCtSubtasksDF(countAT,countCT+1,subtask,root,ct.name + "_" + countCT,location);
						s+= l.get(0)
						countAT = l.get(1) as Integer
						countCT = l.get(2) as Integer
						////////////////IM HERE!! WHY at and ct numbers dont continue 0,1,2,3... 
						
					}
					
					
					// atomic (add them directly into the list)
					AtomicTask:{
						//----for python:
						id = subtask.name +"_"+countAT
						par = ct.name + "_"+ num_current_ct //parent is the current compound task 
						child = "NaN"
						joint = Joint(subtask)
						location = loc 
						dfAllocation += missionTreeString(id, par, child, location, runbyrobot, joint, order , consec)
						
						countAT += 1
						//----for python 
						
					}
				}
			}
		
		var List<Object> list = new ArrayList<Object>();
		list.add(s)
		list.add(countAT)
		list.add(countCT)
		return list
		}
		// Handled ERROR
		throw new UnsupportedOperationException("ERROR: All compound tasks need at least 2 subtasks ")
	}
	
	def typeTask(TasksModel t) {
		switch t{
			AtomicTask:{
				return "atomic"
			}
			CompoundTask:{
				return "compound"
			}
			
		}
		// Handled ERROR
		throw new UnsupportedOperationException("ERROR: Task not identified as atomic nor compound")
	}
	
	
	
	
	
	/** In missions: find the number of robots of an atomic task */
	def findATnumRobots(AtomicTask at, ProblemSpecification root) {
		for (t :root.tasksModel){
				switch t{
					AtomicTask:{
						if (t.name==at.name){return t.robots}
		}}}
		// Handled ERROR
		throw new UnsupportedOperationException("ERROR: Location needs to be declared for "+at.name)
	}
	
	/**In missions: find the location of an atomic task **/
	def findATloc(AtomicTask at, ProblemSpecification root) {
		for (t :root.tasksModel){
				switch t{
					AtomicTask:{
						if (t.name==at.name){return t.loc}
		}}}
		// Handled ERROR
		throw new UnsupportedOperationException("ERROR: Location needs to be declared for "+at.name)
	}

	/**Find location of (one loc) compound task **/
	def Location findCTOneloc(CompoundTask ct, ProblemSpecification root) {
		for (t :root.tasksModel){
				switch t{
					CompoundTask:{
						if (t.name==ct.name){
							return ct.location
						}
		}}}
		// Handled ERROR
		throw new UnsupportedOperationException("ERROR: Location needs to be declared for "+ct.name)
	}


	def generateFile(String fileName, String finalString, IFileSystemAccess2 fsa){
		fsa.generateFile(fileName, finalString)
	}
		
	def static String readFile(String filePath) throws IOException {
		var Path path = java.nio.file.Paths.get(filePath);
		System.out.println(path);
		return Files.readString(path);
		
	}
	
	
	def Joint(AtomicTask task) {
		if (task.robots>1){
			return "True"
		}
		else{
			return "False"
		}
	}
	
	def Consecutive(CompoundTask task) {
		if (task.consecutive){
			return "True"
		}
		else{
			return "False"
		}
	}
	
	def Order(CompoundTask task) {
		if (task.ordered){
			return "True"
		}
		else{
			return "False"
		}
	}
	
	/** Row in .txt file used for a dataframe df in python */
	def missionTreeString(String id, String par, String child,
	 String location, String runbyrobot, String joint,
	 String order , String consec){
	 	// .replaceAll("\\s+","") removes white spaces
	 	
	 	var separator = ",,"
		var dfAllocationLine = "\n"+ 
		id.replaceAll("\\s+","") + separator +
		par.replaceAll("\\s+","") + separator +
		child.replaceAll("\\s+","")+ separator +
		location.replaceAll("\\s+","") + separator +
		runbyrobot.replaceAll("\\s+","")+ separator +
		joint.replaceAll("\\s+","") + separator +
		order.replaceAll("\\s+","") + separator +
		consec.replaceAll("\\s+","")
		return dfAllocationLine
	}
	

}