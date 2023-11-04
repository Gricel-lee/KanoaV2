/* Gricel Vazquez
 * 2023
 */
package uoy.mrs.uoy.mrs.types.impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Model</b></em>'.
 * <!-- end-user-doc -->
 * @return the value of the '<em>TaskModel</em>'.
 * @see dsl.DslPackage#getProblemSpecification()
 */
public class TaskInstances{
	
	/**
	 * List of tasks identifiers
	 */
	public final ArrayList<String> allTasksid = new ArrayList<String>();
	
	
	/**
	 * Mission tasks
	 * @return the map relation '<em>mtList</em>' from identifiers to mission tasks.
	 */
	public final HashMap<String, MissionTaskInstance> mtList = new HashMap<String, MissionTaskInstance>();
	
	/**
	 * Compound tasks (instantiated)
	 * @return the map relation '<em>ctList</em>' from identifiers to compound tasks.
	 */
	public final HashMap<String, CompoundTaskInstance> ctList = new HashMap<String, CompoundTaskInstance>();
	/**
	 * Atomic tasks (instantiated)
	 * @return the map relation '<em>atList</em>' from identifiers to atomic tasks.
	 */
	public final HashMap<String, AtomicTaskInstance> atList = new HashMap<String, AtomicTaskInstance>();
	
	

	public final ArrayList<String> getmtIDs() {return new ArrayList<String>( mtList.keySet());}

	public final ArrayList<String> getctIDs() {return new ArrayList<String>(ctList.keySet());}

	public final ArrayList<String> getatIDs() {return new ArrayList<String>(atList.keySet());}
	
	
	public final Collection<MissionTaskInstance> getmtValues() {return mtList.values();}

	public final Collection<CompoundTaskInstance> getctValues() {return ctList.values();}

	public final Collection<AtomicTaskInstance> getatValues() {return atList.values();}
	
	
	
	public void print() {
		System.out.println("\n----TASKS MODEL----");
		System.out.println("All tasks in model: "+allTasksid);
		System.out.println("--- Missions:");
		for(MissionTaskInstance mt: mtList.values()) {
			mt.print();
		}
		System.out.println("--- Compound tasks:");
		for(CompoundTaskInstance ct: ctList.values()) {
			ct.print();
		}
		System.out.println("--- Atomic tasks:");
		for(AtomicTaskInstance at: atList.values()) {
			at.print();
		}
		
		return;
	}
	
	
	
	/**Check compound tasks constraints*/
	public void checkprintingCTconstraints() {

    	for (Iterator iterator = ctList.values().iterator(); iterator.hasNext();) {
    		CompoundTaskInstance ct = (CompoundTaskInstance) iterator.next();
    		
    		if(ct.isordered()) {
    			System.out.println("ordered");
    			System.out.println(ct.getID() +" is " +  ct.getordered());
        	}
    		if(ct.isconsecutive()) {
    			System.out.println("consec");
    			System.out.println(ct.getID() +" is " +  ct.getconsecutive());
        	}
    	}
	}
	
	
} 
