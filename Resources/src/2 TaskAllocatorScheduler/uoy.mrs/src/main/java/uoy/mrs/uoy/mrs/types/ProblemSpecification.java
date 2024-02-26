/* Gricel Vazquez
 * 2023
 */
package uoy.mrs.uoy.mrs.types;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.collections4.map.MultiKeyMap;

import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.XlmAllocParser;
import uoy.mrs.uoy.mrs.error.KanoaErrorHandler;
import uoy.mrs.uoy.mrs.types.impl.Allocation;
import uoy.mrs.uoy.mrs.types.impl.AtomicTaskInstance;
import uoy.mrs.uoy.mrs.types.impl.Capability;
import uoy.mrs.uoy.mrs.types.impl.CompoundTaskInstance;
import uoy.mrs.uoy.mrs.types.impl.Location;
import uoy.mrs.uoy.mrs.types.impl.MissionTaskInstance;
import uoy.mrs.uoy.mrs.types.impl.Parameters;
import uoy.mrs.uoy.mrs.types.impl.Robot;
import uoy.mrs.uoy.mrs.types.impl.RobotsModel;
import uoy.mrs.uoy.mrs.types.impl.ScheduleGA;
import uoy.mrs.uoy.mrs.types.impl.TaskInstances;
import uoy.mrs.uoy.mrs.types.impl.WorldModel;




public class ProblemSpecification{
	
	//Parameters
	Parameters parameters = new Parameters();
	//Task model instantiated
	TaskInstances tasksModelI = new TaskInstances();
	//World model
	WorldModel  worldModel = new WorldModel();
	//Robots model
	RobotsModel robotsModel = new RobotsModel();
	//Allocations
	ArrayList<Allocation> allocationList = new ArrayList<Allocation>();
	//Clusters - inside each allocation, getGroupsOfRobot()

	//Multiple Pareto-optimal solutions from GA loop, one for each allocation
	ArrayList<ScheduleGA> schedulesGAList = new ArrayList<ScheduleGA>();
		
	//Pareto-optimal solutions
	ArrayList<ScheduleGA> schedulesOptimal = new ArrayList<ScheduleGA>();
		
		
	//Tasks (not instantiated) (not used but JIC)
	MultiKeyMap<String, Object> atFromDSL = new MultiKeyMap<>(); //ats.get(at1) = 2,l1  - numrobots, location
	MultiKeyMap<String, Object> ctFromDSL = new MultiKeyMap<>(); //cts.get(ct1) = [at3,at2],"true,false" - subtasks,ordered,consecutive
	
	
	
	public TaskInstances getTasks() {
		return tasksModelI;
	}
	
	public Parameters getParameters() {
		return parameters;
	}
	
	public RobotsModel getRobotsModel() {
		return robotsModel;
	}
	
	public WorldModel getWorldModel() {
		return worldModel;
	}
	
	/**Check if a task identifier is from an atomic task*/
	public boolean isAtomic(String id) {
		if(this.tasksModelI.atList.keySet().contains(id))
			return true;
		return false;
	}

	/**Check if a task identifier is from a compound task*/
	public boolean isCompound(String id) {
		if(this.tasksModelI.ctList.keySet().contains(id))
			return true;
		return false;
	}
	
	/**Check if an atomic task identifier is joint */
	public boolean isJoint(String atID) {
		if(!this.tasksModelI.atList.keySet().contains(atID)) 
			KanoaErrorHandler.ErrorNotAnAtomicTask(atID);
		return this.tasksModelI.atList.get(atID).getjoint();
	}
	
	/**Check if an atomic task identifier is ordered.
	 * Requires pre-scheduling stage to be run before. */
	public boolean isATOrdered(String atID) {
		if(!this.tasksModelI.atList.keySet().contains(atID)) 
			KanoaErrorHandler.ErrorNotAnAtomicTask(atID);
		return this.tasksModelI.atList.get(atID).isOrdered_by_CTs_above();
	}
	
	/**Check if an atomic task identifier is ordered.
	 * Requires pre-scheduling stage to be run before. */
	public boolean isATConsec(String atID) {
		if(!this.tasksModelI.atList.keySet().contains(atID)) 
			KanoaErrorHandler.ErrorNotAnAtomicTask(atID);
		return this.tasksModelI.atList.get(atID).isConsec_by_CTs_above();
	}
	
	
	/**Get location to perform an atomic task instance*/
	public Location getATLocation(String atID) {
		Location loc = null;
		//get task
		AtomicTaskInstance at = tasksModelI.atList.get(atID);
		//get location
		loc = getWorldModel().getLoc( at.getloc() );
		//System.out.println("ID: "+ atID);
		//System.out.println(worldModel.locations );
	
		if(!this.tasksModelI.atList.keySet().contains(atID)) {
			//ERROR
			KanoaErrorHandler.ErrorRetrievingATLocation(atID);
		}
		if(loc==null) {
			//ERROR
			KanoaErrorHandler.ErrorRetrievingATLocation(atID);
		}
		return loc;
	}
	

	/**Check if compound task identifier is contrained*/
	public boolean isCompoundConstrained(String id) {
		if( this.getTasks().ctList.get(id).isordered() || this.getTasks().ctList.get(id).isconsecutive()){return true;}
		return false;
	}

	/**
	 * Read allocation files - i.e., Alloy output.
	 * @return 
	 * @implNote Method this.initialise() must have been run first.
	 * Note: Robots in allocations are added in the pre-scheduling stage.
	 * */
	public ArrayList<Allocation> getAllocations() {
		//allocations added already
		if (!allocationList.isEmpty()) {return allocationList;}
		
		//add allocations
		for (String i : Constants.alloyFilesOutput) {
			XlmAllocParser xmlreadAlloc = new XlmAllocParser();
			allocationList.add(xmlreadAlloc.parse(i,this));
		}
		return allocationList;
	}
	
	public int	getNumAllocations() {
		return allocationList.size();
	}
	
	public Boolean isThereAllocationsFound() { //not tested
		if (getNumAllocations()>=0) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	/**
	 * Get list of all compound tasks before atomic or compound task  tID, until (not including) mission task.
	 * Special case: Returns "null" if an atomic task has a mission task as parent.
	 * @example atomic task at2_8 has parent ct1_4. Task ct1_4 has parent ct2_3,
	 * hence, for at2_8 this function returns [ct2_3 , ct1_4].
	 * The last task is the immediately above (parent) task.
	 */
	public ArrayList<CompoundTaskInstance> computeCompoundTasksAboveTask(String tID){
		//list of compound tasks above task
		ArrayList<CompoundTaskInstance> parentsList = new ArrayList<CompoundTaskInstance>();
		
		String parentID = null;
		// a) get parent
		//if is atomic task
		if(isAtomic(tID)) {
			parentID = getTasks().atList.get(tID).getparent();}
		//if is compound task
		if(isCompound(tID)) {
			parentID = getTasks().ctList.get(tID).getparent();}
		// - if parent is a mission tasks - return null (no parent)
		if(tasksModelI.mtList.containsKey(parentID)){return null;}
		
		//ERROR --no parent found
		if(parentID==null) {KanoaErrorHandler.ErrorGettingParent(tID);}
		
		
		// - if parent is constraint task (not mission task)
		// recursively get compound tasks through parent relations
		if (getTasks().getctIDs().contains(parentID)) {
			//add parent
			parentsList.add(getTasks().ctList.get(parentID));
			//add parents of parent
			ArrayList<CompoundTaskInstance> l = computeCompoundTasksAboveTask(parentID);
			if(l!=null){parentsList.addAll(0, l);}
		}
		return parentsList;
	}
	
	
	
	/**
	 * Read DSL and TasksTree files from DSL.
	 */
	public void initialise(String fileDSL,String fileMissionTree) {
		//------------------------------------------
		// ------ 1) Read file infoDSL.txt
		try (BufferedReader in = new BufferedReader(new FileReader(fileDSL))) {
			String str;
	        while ((str = in.readLine())!= null) {
	        	//String is divided by ,,
	        	String[] attrib=str.split(",,");
	        	//First argument is the "type"
	        	//- types: loc, path, ct, at, robot, objectives
	        	//- optional types: time,numAlloc,population,evaluations,ratesucc
	        	String type = attrib[0];
	        	// e.g.: loc,,8.0,,7.0
	        	if("loc".equals(type)) {worldModel.addLoc(attrib[1], new Location(attrib[1], attrib[2], attrib[3]));}
	        	
	        	// e.g.: path,,l1,,l2,,3.0
	        	else if("path".equals(type)) {worldModel.addPath(attrib[1], attrib[2], attrib[3], attrib[4]);}
	        	//e.g.: at,,at1,,2,,l1
	        	else if(type=="ct") {atFromDSL.put(attrib[1], attrib[2], attrib[3]);}
	        	//e.g.: ct,,ct1,,[at3,at2],,false,,false
	        	else if(type=="at") {ctFromDSL.put(attrib[1], attrib[2], attrib[3]+","+attrib[4]);}
	        	
	        	//e.g.: robot,,r1,,l1,,{[at2,5.0,99.0][at3,4.0,99.0][at4,2.0,99.0]}
	        	else if("robot".equals(type)) {
	        		HashMap<String,Capability> capabilities = new HashMap<String,Capability>();
	        		//e.g.: {[at2,5.0,99.0][at3,4.0,99.0][at4,2.0,99.0]}
	        		String allCapString = attrib[3].replaceAll("\\]","").replaceAll("\\{", "").replaceAll("\\}", "");
	        		//e.g.: [at2,5.0,99.0[at3,4.0,99.0[at4,2.0,99.0
	        		String[] capStringList = allCapString.substring(1, allCapString.length()).split("\\["); // Split by '['. Remove first one.
	        		for (String capString : capStringList) {
	                    
	                    //e.g.: at2,5.0,99.0
	                    String[] cAttrib = capString.split(",");
	                    
	                    //System.out.println(capString);
	                    //System.out.println("1: "+cAttrib[0]);
	                    //System.out.println("2: "+cAttrib[1]);
	                    //System.out.println("3: "+cAttrib[2]);
	                    
	                    //e.g.: cAttrib[0] = at2 -atID //cAttrib[1] = 5.0 -time //cAttrib[2] = 99.0-probability*100
	        			capabilities.put(cAttrib[0], new Capability(cAttrib[0],cAttrib[1],cAttrib[2]));
	        		}
	        		
	        		
	        		String velocity = attrib[4]; 
	        		
	        		
	        		getRobotsModel().addRobot(attrib[1],			//id
	        				new Robot(attrib[1], 					//create robot with id
	        						worldModel.getLoc(attrib[2]),   //location
	        						velocity,                         //velocity
	        						capabilities)                   //capabilities
	        				);}//Note: locations are saved first, needed here, so order of infoDSL.txt file matter.
	        	// e.g.: objectives,,[minIdle, minTravel, maxSucc]
	        	else if("objectives".equals(type)) {
	        		if(attrib[1].contains("minIdle")){parameters.setObjective_minIdle(true);}
	        		if(attrib[1].contains("minTravel")){parameters.setObjective_minTravel(true);}
	        		if(attrib[1].contains("maxSucc")){parameters.setObjective_maxSucc(true);}}	        	
	        	// e.g.: time,,120
	        	else if("time".equals(type)) {parameters.timeAvailable=attrib[1];} //only if added in DSL
	        	
	        	
	        	//@Deprecated
	        	// e.g.: numAlloc,,10
	        	//else if("numAlloc".equals(type)) {parameters.numAlloc=attrib[1];} //only if added in DSL
	        	// e.g.: population,,100
	        	//else if("population".equals(type)) {parameters.population=attrib[1];} //only if added in DSL
	        	// e.g.: evaluations,,20
	        	//else if("evaluations".equals(type)) {parameters.evaluations=attrib[1];} //only if added in DSL
	        	// e.g.: ratesucc,,95.0
	        	//else if("ratesucc".equals(type)) {parameters.ratesucc=attrib[1];} //only if added in DSL
	        	//error
	        	//else {KanoaErrorHandler.DSLFileTypeUnkown(fileDSL,type);}
	        	
	        }}catch (IOException e) { KanoaErrorHandler.ErrorReadinginfoDSLFile(e);}
		
		//------------------------------------------
		// ------ 2) Read file modelMissionsTree.txt
		System.out.println("Reading task's tree");
		try {
	        BufferedReader in = new BufferedReader(new FileReader(fileMissionTree));
	        in.readLine();//System.out.println("Reading: "+ in.readLine()); // remove first line: "type,,id,,parent,,ordered_children,,location,,numrobots,,joint,,ordered,,consecutive,,start,,end,,instantiatedFrom,,reachableAtomicTasks,,retry"    //reachableAtomicTasks not used as computed in the pre-scheduling stage
	        String str;
	        while ((str = in.readLine())!= null) {
	        	String[] attrib=str.split(",,"); 
	            String type = attrib[0]; //type: mt, ct or at
	        	String id = attrib[1]; //instantiated identifier: e.g., for a task at1 instance 12, at1_12
	            //other attributes
	            String parent = attrib[2]; String ordered_children = attrib[3]; String location = attrib[4]; String numrobots = attrib[5];
	            String joint = attrib[6]; String ordered = attrib[7]; String consecutive = attrib[8]; String start = attrib[9]; String end = attrib[10];String inst = attrib[11];
	            String retry = attrib[13];
	            
	            // Add id
	            tasksModelI.allTasksid.add(id); //id
	            // -- Create class instance
	            if ("mt".equals(type)) { //mt
	            	MissionTaskInstance mt = new MissionTaskInstance(id,ordered_children);
	            	tasksModelI.mtList.put(id,mt);}
	            else if ("at".equals(type)) { //at
	            	AtomicTaskInstance at = new AtomicTaskInstance(id, parent, location, numrobots, joint, start, end,inst,retry);
	            	tasksModelI.atList.put(id,at);}
	            else if ("ct".equals(type)) { //ct
	            	CompoundTaskInstance ct = new CompoundTaskInstance(id,parent,ordered_children,ordered,consecutive,inst);
	            	tasksModelI.ctList.put(id,ct);}
	        }
	        in.close();
	    }catch (IOException e) { KanoaErrorHandler.ErrorReadingTasksFromTasksTree(e);}
		
		//------------------------------------------
		// ------ 3)Print
		if(Constants.verbose) {
			tasksModelI.print();
			getRobotsModel().print(this);
			getWorldModel().print();
		}
	}

	public void addScheduleGA(ScheduleGA sch) {
		schedulesGAList.add(sch);
	}
	
	public ArrayList<ScheduleGA> getSchedulesGA() {	
		return schedulesGAList;
	}
	
	public void setOptimalSchedules(ArrayList<ScheduleGA> s){
		schedulesOptimal = s;
	}
	

} 
