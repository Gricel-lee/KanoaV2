package uoy.mrs.uoy.mrs.types.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;

public class CompoundTaskInstance{
	
	private String id;
	private String parent;
	private String[] ordered_children;
	private String ordered;
	private String consecutive;
	private String inst;
	private String ordered_children_str;
	
	private ArrayList<String> reachable_atomictasks = new ArrayList<String>();

	public CompoundTaskInstance(String id, String parent, String ordered_children, String ordered,
			String consecutive, String inst) {
		//id,,parent,,ordered_children,,location,,numrobots,,joint,,ordered,,consecutive,,start,,end
		// e.g. ct,,ct1_2,,ct2_1,,['at3_4,at2_5'],,NaN,,NaN,,NaN,,false,,false,,NaN,,NaN
		this.id = id;
		this.parent = parent;
		this.ordered_children = Utility.stringToList(ordered_children);
		this.ordered_children_str = String.join(",", this.ordered_children);
		this.ordered = ordered;
		this.consecutive = consecutive;
		this.inst = inst;
	}


	
	public void print() {
		System.out.println("- Compound task "+id);
		System.out.println("parent: "+ parent);
		System.out.println("children: " + ordered_children_str);
		System.out.println("ordered: "+ordered);
		System.out.println("consecutive: "+consecutive);
		return;
	}

	
	public String getID() {
		return id;
	}



	
	public String getparent() {
		return parent;
	}



	
	public String[] getorderedChildren() {
		return ordered_children;
	}



	
	public String getordered() {
		return ordered;
	}



	
	public String getconsecutive() {
		return consecutive;
	}
	
	public Boolean isordered() {
		if(this.ordered.equals("True") || this.ordered.equals("true")) {return true;}
		
		return false;
	}
	
	public Boolean isconsecutive() {
		if(this.consecutive.equals("True") || this.consecutive.equals("true")) {return true;}
		
		return false;
	}
	
	
	/**Check if atomic task exists in subtasks*/
	public Boolean isatomicTaskInSubtasks(String atID) {
		for (String str : getorderedChildren()) {
            if (str.equals(atID)) {
                return true;
            }
        }
		return false;
	}
	
	/**Get first n subtasks*/
	public String[] getfirstNsubtasks(int n) {
		String[] result = new String[n];
		for (int i = 0; i < n; i++) { result[i] = ordered_children[i]; }
		return result;
	}
	 
	
	
	
	public String getInst() {
		return inst;
	}
	
	
	
	public ArrayList<String> getAtomicTasksReachable(ProblemSpecification p){
		// - if computed before - saved in AtomicTaskIdToRobots
		if(!reachable_atomictasks.isEmpty()) {
			return reachable_atomictasks;
		}
		
		// - if not computed before
		ArrayList<String> atList = new ArrayList<String>();
		
		Queue<String> queue = new LinkedList<>();
		for (String subTask : this.ordered_children) {queue.add(subTask);}
		while (!queue.isEmpty()) {
			String poll = queue.poll();
			if(p.isAtomic(poll)) {atList.add(poll);}
			else {
				CompoundTaskInstance ct = p.getTasks().ctList.get(poll);//compound subtask
				for (String subTask : ct.ordered_children) {queue.add(subTask);}//add subtask subtasks to queue
			}
		}
		reachable_atomictasks = atList;
		return reachable_atomictasks;
	}
}
