package uoy.mrs.uoy.mrs.types.impl;

import java.util.ArrayList;

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
	private String justDone;
	private ArrayList<String> doneBefore = new ArrayList<String>();
	private ArrayList<CompoundTaskInstance> compoundTasksAboveTask = new ArrayList<CompoundTaskInstance>();
	
	public AtomicTaskInstance(String id, String parent, String location, String numrobots, String joint, String start, String end, String inst) {
		//id,,parent,,ordered_children,,location,,numrobots,,joint,,ordered,,consecutive,,start,,end
		// e.g.at,,at1_1,,m1,,NaN,,room1,,2,,True,,NaN,,NaN,,80.0,,114.0
		
		this.id = id;
		this.parent = parent;
		this.location = location;
		this.numrobots = numrobots;
		this.joint=joint;
		this.start=start;
		this.end=end;
		this.inst = inst;
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
		return;
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

	
	public String getjoint() {
		return joint;
	}

	
	public String getstart() {
		return start;
	}

	
	public String getend() {
		return end;
	}
	
	
	public String getjustDone() {
		return justDone;
	}
	
	public ArrayList<String> getdoneBefore() {
		return doneBefore;
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
	public void setJustDone(String ctId_OfInstantiatedTaskToBeCompletedJustBeforeThisAT) {
		this.justDone = ctId_OfInstantiatedTaskToBeCompletedJustBeforeThisAT;
	}
	
	/**Transfered constraints from constrained compound tasks above this atomic task.
	 * Computed in the pre-scheduling stage.*/
	public void setDoneBefore(ArrayList<String> ctId_List_OfInstantiatedTaskToBeDoneBeforeThisAT) {
		this.doneBefore.addAll(ctId_List_OfInstantiatedTaskToBeDoneBeforeThisAT);
	}
	/**Transfered constraints from constrained compound tasks above this atomic task.
	 * Computed in the pre-scheduling stage.*/
	public void setDoneBefore(String ctId_OfInstantiatedTaskToBeDoneBeforeThisAT) {
		this.doneBefore.add(ctId_OfInstantiatedTaskToBeDoneBeforeThisAT);
	}
    
	
	
	public String getInst() {
		return inst;
	}
	
	
	
}
