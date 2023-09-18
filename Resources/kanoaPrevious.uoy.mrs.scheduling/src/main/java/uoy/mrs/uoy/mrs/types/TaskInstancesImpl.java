/* Gricel Vazquez
 * 2023
 */
package uoy.mrs.uoy.mrs.types;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.error.KanoaErrorHandler;


/**
 * Task model - implements '<em><b>Task Model</b></em>'.
 * Implements interface: {@link uoy.mrs.uoy.mrs.types.TaskInstances}.
 * @return the value of the '<em>TaskModel</em>'.
 */
public class TaskInstancesImpl implements TaskInstances{
	
	/**
	 * Constructor for the Tasks model.
	 * Retrieves mission info from pre-allocation stage.
	 */
	public TaskInstancesImpl(){
		System.out.println("Creating task model");
		//----------
		try {
	        BufferedReader in = new BufferedReader(new FileReader(Constants.genMissionTree));
	        System.out.println("Reading: "+ in.readLine()); // remove first line: "type,,id,,parent,,ordered_children,,location,,numrobots,,joint,,ordered,,consecutive,,start,,end,,instantiatedFrom"
	        String str;
	        while ((str = in.readLine())!= null) {
	        	String[] attrib=str.split(",,"); 
	            String type = attrib[0]; //type: mt, ct or at
	        	String id = attrib[1]; //instantiated identifier: e.g., for a task at1 instance 12, at1_12
	            //other attributes
	            String parent = attrib[2]; String ordered_children = attrib[3]; String location = attrib[4]; String numrobots = attrib[5];
	            String joint = attrib[6]; String ordered = attrib[7]; String consecutive = attrib[8]; String start = attrib[9]; String end = attrib[10];String inst = attrib[11];
	            
	            // Add id
	            idTasksList.add(id); //id
	            // -- Create class instance
	            if (type.equals("mt")) { //mt
	            	MissionTaskInstanceImpl mt = new MissionTaskInstanceImpl(id,ordered_children);
	            	TaskInstances.mtList.put(id,mt);
	            }
	            else if (type.equals("at")) { //at
	            	AtomicTaskInstanceImpl at = new AtomicTaskInstanceImpl(id, parent, location, numrobots, joint, start, end,inst);
	            	TaskInstances.atList.put(id,at);
	            }
	            else if (type.equals("ct")) { //ct
	            	CompoundTaskInstanceImpl ct = new CompoundTaskInstanceImpl(id,parent,ordered_children,ordered,consecutive,inst);
	            	TaskInstances.ctList.put(id,ct);
	            }
	          //----------
	        }
	        in.close();
	    }catch (IOException e) { KanoaErrorHandler.ErrorReadingTasksFromTasksTree();}
	}
	

	@Override
	public HashMap<String, MissionTaskInstanceImpl> getmissionTaskList() {
		return mtList;
	}

	@Override
	public HashMap<String, CompoundTaskInstanceImpl> getcompoundTaskList() {
		return ctList;
	}

	@Override
	public HashMap<String, AtomicTaskInstanceImpl> getatomicTaskList() {
		return atList;
	}

	@Override
	public List<String> getTasksList() {
		return idTasksList;
	}
	
	@Override
	public void print() {
		System.out.println("Tasks in model: "+idTasksList);
		System.out.println("TASKS MODEL Info:");
		System.out.println("--- Missions:");
		for(MissionTaskInstanceImpl mt: mtList.values()) {
			mt.print();
		}
		System.out.println("--- Compound tasks:");
		for(CompoundTaskInstanceImpl ct: ctList.values()) {
			ct.print();
		}
		System.out.println("--- Atomic tasks:");
		for(AtomicTaskInstanceImpl at: atList.values()) {
			at.print();
		}
		
		return;
	}
	
	
} 
