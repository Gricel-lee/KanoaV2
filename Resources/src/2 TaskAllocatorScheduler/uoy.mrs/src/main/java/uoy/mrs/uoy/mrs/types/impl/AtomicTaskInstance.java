package uoy.mrs.uoy.mrs.types.impl;

import java.util.ArrayList;

import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;

public class AtomicTaskInstance{

	
	private String id;
	private String parent;
	private String location;
	private String numrobots;
	private String joint;
	private String start;
	private String end;
	private String inst;
	private String retry; //number of retries as a string
	/**If not empty. this atomic task is CONSECUTIVE constrained to the tasks in this list. I.e., they must be done before doing this task*/
	private String justDone_con;
	/**If not empty. this atomic task is ORDERED constrained to the tasks in this list. I.e., they must be done before doing this task*/
	private ArrayList<String> doneBefore_ord = new ArrayList<String>();
	private ArrayList<CompoundTaskInstance> compoundTasksAboveTask = new ArrayList<CompoundTaskInstance>();
	
	public AtomicTaskInstance(String id, String parent, String location, String numrobots, String joint, String start, String end, String inst, String retry) {
		//type,,id,,parent,,ordered_children,,location,,numrobots,,joint,,ordered,,consecutive,,start,,end,,instantiatedFrom,,reachableAtomicTasks
		// e.g.at,,at1_1,,m1,,NaN,,room1,,2,,True,,NaN,,NaN,,None,,None,,at1,,NaN
		this.id = id;
		this.parent = parent;
		this.location = location;
		this.numrobots = numrobots;
		this.joint=joint;
		this.start=start;
		this.end=end;
		this.inst = inst;
		this.retry = retry;
	}
	
	
	public void print() {
		System.out.println("- Atomic task "+id);
		System.out.println("parent: "+ parent);
		System.out.println("location: " + location);
		System.out.println("numrobots: "+numrobots);
		System.out.println("joint: "+joint);
		System.out.println("start: "+start);
		System.out.println("end: "+end);
		System.out.println("instance of: " + inst);
		System.out.println("num of retry allowed: "+retry);
		return;
	}
	
	public int getRetry() {
		return Utility.string2int(this.retry);
	}

	
	public String getID() {
		return this.id;
	}

	
	public String getparent() {
		return parent;
	}

	
	public String getloc() {
		return location;
	}

	
	public String getnumrob() {
		return numrobots;
	}

	
	public boolean getjoint() {
		return Utility.string2boolean(joint);
	}
	
	
	public String getstart() {
		return start;
	}

	
	public String getend() {
		return end;
	}
	
	
	public String getjustDone_con() {
		return justDone_con;
	}
	
	//check if tasks added to be done before (ordered)
	public boolean isOrdered_by_CTs_above() {
		return doneBefore_ord.size()>0;  
	}
	//check if there is a task to be done Just before (consecutive)
	public boolean isConsec_by_CTs_above() {
		return justDone_con!=null;
	}
	
	
	public ArrayList<String> getdoneBefore_ord() {
		return doneBefore_ord;
	}
	
	/**
	 * Get list of all compound tasks before atomic or compound task  tID, until (not including) mission task.
	 * Special case: Returns "null" if an atomic task has a mission task as parent.
	 * @example atomic task at2_8 has parent ct1_4. Task ct1_4 has parent ct2_3,
	 * hence, for at2_8 this function returns [ct2_3 , ct1_4].
	 * The last task is the immediately above (parent) task.
	 */
	public ArrayList<CompoundTaskInstance> getCompoundTasksAboveTask(ProblemSpecification p){
		if(compoundTasksAboveTask==null) { //if null, no tasks above
			return compoundTasksAboveTask; 
		}
		if(compoundTasksAboveTask.isEmpty()) {//if empty, has't compute task above
			ArrayList<CompoundTaskInstance> l = p.computeCompoundTasksAboveTask(this.id);
			compoundTasksAboveTask = l;
		}
		return compoundTasksAboveTask;
	}
	
	
	// - this requires getCompoundTasksAboveTask to be run first
	public void printCompoundTasksAboveTask() {
		ArrayList<CompoundTaskInstance> l = compoundTasksAboveTask; //list of CT tasks above
		if(l!=null){
			String s = "";
			s+=" -atomic task "+ this.id + " CT above: [";
			for (int i = 0; i < l.size(); i++) {
				s+= l.get(i).getID() + ", ";
			}System.out.println(s.substring(0, s.length() - 2)+"]");}
		else {System.out.println(" -atomic task: "+ this.id + " has no CT above");}
	}
	
	

	/**Transfered constraints from constrained compound tasks above this atomic task.
	 * Computed in the pre-scheduling stage.*/
	public void setJustDone(String ctId_OfInstantiatedTaskToBeCompletedJustBefore) {
		this.justDone_con = ctId_OfInstantiatedTaskToBeCompletedJustBefore;
	}
	
	/**Transfered constraints from constrained compound tasks above this atomic task.
	 * Computed in the pre-scheduling stage.*/
	public void setDoneBefore(ArrayList<String> ctId_List_OfInstantiatedTaskToBeDoneBefore) {
		this.doneBefore_ord.addAll(ctId_List_OfInstantiatedTaskToBeDoneBefore);
	}
	/**Transfered constraints from constrained compound tasks above this atomic task.
	 * Computed in the pre-scheduling stage.*/
	public void setDoneBefore(String ctId_OfInstantiatedTaskToBeDoneBeforeThisAT) {
		this.doneBefore_ord.add(ctId_OfInstantiatedTaskToBeDoneBeforeThisAT);
	}
    
	
	
	public String getInst() {
		return inst;
	}
	
	
	
}
