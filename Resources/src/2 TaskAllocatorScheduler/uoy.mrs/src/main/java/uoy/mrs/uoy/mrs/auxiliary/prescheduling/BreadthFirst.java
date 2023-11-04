package uoy.mrs.uoy.mrs.auxiliary.prescheduling;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;
import uoy.mrs.uoy.mrs.types.impl.MissionTaskInstance;

/**
 * Get list of constrained tasks encountered first by Breadth-First Search.
 * Pre-scheduling stage.
 * @param problem specification
 */
public class BreadthFirst {
	public static ArrayList<String> breadthFirstTree(ProblemSpecification p) {
		

    	ArrayList<String> constrainedTasks = new ArrayList<String>();
    	
    	Queue<String> queue = new LinkedList<>();
    	
    	for( MissionTaskInstance mt: p.getTasks().mtList.values()) {
    		for(String chString : mt.getorderedChildren()) {
        		queue.add(chString); //add mission tasks children    			
    		}
    	}
    	
    	while (!queue.isEmpty()) {
    		String poll = queue.poll();
    		//if atomic task - add to final solution
    		if(p.isAtomic(poll)) {
    			constrainedTasks.add(poll);
    		}
    		//else (compound task)
    		if(p.isCompound(poll)) {
    			if(p.isCompoundConstrained(poll)){
    				constrainedTasks.add(poll);
    			}
    			else {
    				for(String chString : p.getTasks().ctList.get(poll).getorderedChildren()) {
    	        		queue.add(chString); //add mission tasks children    			
    	    		}
    			}
    			
    		}
    	}
    	
    	if(Constants.verbose) {System.out.println("a) Constrained Task found by Breadth-First Traversal: "+constrainedTasks.toString());}
    	return constrainedTasks;
    }
}