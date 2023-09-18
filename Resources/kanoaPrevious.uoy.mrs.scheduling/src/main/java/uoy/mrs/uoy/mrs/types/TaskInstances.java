/* Gricel Vazquez
 * 2023
 */
package uoy.mrs.uoy.mrs.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Model</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see dsl.DslPackage#getProblemSpecification()
 */
public interface TaskInstances {
	
	public static final ArrayList<String> idTasksList = new ArrayList<String>();
	
	/**
	 * Time available
	 * @return the map relation '<em>mtList</em>' from identifiers to mission tasks.
	 */
	public static final HashMap<String, MissionTaskInstanceImpl> mtList = new HashMap<String, MissionTaskInstanceImpl>();
	/**
	 * Time available
	 * @return the map relation '<em>ctList</em>' from identifiers to compound tasks.
	 */
	public static final HashMap<String, CompoundTaskInstanceImpl> ctList = new HashMap<String, CompoundTaskInstanceImpl>();
	/**
	 * Time available
	 * @return the map relation '<em>atList</em>' from identifiers to atomic tasks.
	 */
	public static final HashMap<String, AtomicTaskInstanceImpl> atList = new HashMap<String, AtomicTaskInstanceImpl>();
	
	
	
	/**
	 * Mission tasks HashMap, with their identifiers as keys. 
	 */
	
	HashMap<String, MissionTaskInstanceImpl> getmissionTaskList();
	
	
	/**
	 * Compound tasks HashMap, with their identifiers as keys. 
	 */
	
	HashMap<String, CompoundTaskInstanceImpl> getcompoundTaskList();
	
	
	/**
	 * Atomic tasks HashMap, with their identifiers as keys. 
	 */
	
	HashMap<String, AtomicTaskInstanceImpl> getatomicTaskList();
	
	
	/**
	 * List of all tasks identifiers instances
	 * e.g.: for task at1, two instances would be: at1_1, at1_2
	 */
	List<String> getTasksList();
	
	
	void print();
	
	
} 
