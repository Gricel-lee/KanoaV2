package uoy.mrs.uoy.mrs.types;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import uoy.mrs.uoy.mrs.auxiliary.Utility;

public class DepricatedAllocation {
	
	public String file;
	public String name;
	public String num_robots;
	public String clustersStr;
	public List<DepricatedRobot> robots = new ArrayList<DepricatedRobot>();
	public List<String> robotIDs = new ArrayList<String>();
	public List<List<String>> clusters;
	public int num_objectives;
	public List<Integer> lowerBounds = new ArrayList<Integer>();
	public List<Integer> upperBounds = new ArrayList<Integer>();
	
	/**constructor*/
	public DepricatedAllocation(String allocFile) {
		file = allocFile;
	}
	
	/**constructor*/
	public DepricatedAllocation() {}
	
	
	/**
	 * Add Robot Instances.
	 * This function is based on the info gathered in the Allcation.csv generated from python.
	 * @param sInit - example,  r1:['at1_move_0', 'at1_move_1']::r5:['at1_move_0', 'at1_move_1']:
	 */
	public void getRobotList(String sInit) {
		//System.out.println("INIT: " + sInit);
		String[] robots_n_tasks = sInit.split("::");
		
		for (String rt : robots_n_tasks) { //e.g. 1:['at1_move_0', 'at1_move_1']
			final String[] list = rt.split(":");
			String robotID = list[0];
			String tasks = list[1];
			// create robot
			DepricatedRobot r = new DepricatedRobot(robotID,tasks);
			// add robot to allocation
			robots.add(r);
		}
		// Set list of IDs
		getRobotIDs();
		// Set bounds after adding robots
		setBounds();
	}
	
	
	/**Get list of robot IDs*/
	public void getRobotIDs() {
		for (DepricatedRobot r: robots) {
			robotIDs.add(r.id);
		}
	}
	
	/**Get list of robot IDs as a string*/
	public String getRobotsStr() {
		String s = "[";
		for (DepricatedRobot r: robots) {
			s = s + "\"" +r.id +"\"" + ",";
		}
		return s.substring(0,s.length()-1) + "]";
	}
	
	
	/**
	 * Set bounds after adding robots.
	 * These lower and upper bounds are use for each gene (i.e., robot) value (i.e., num of tasks)
	 * in the genetic algorithm.
	 */
	public void setBounds() {
		for (int i=0 ; i<getNumRobots() ; i++) {
			DepricatedRobot r = robots.get(i);  	   // get ith robot	
			lowerBounds.add(0); 		   // lower bound = 0
			
			upperBounds.add((int) (Utility.getFactorial(r.numTasks)-1)); // set upper bound as numTasks factorial-1
		}
		
	}
	
	
	public int getNumRobots() {
		return (Integer.parseInt(this.num_robots ));
	}
	
	
	public void print() {
		System.out.println("\n ---"+name+"-----");
        System.out.println("| file: " + file);
        System.out.println("| num robots: " + num_robots);
        System.out.println("| cluster(s): " + clustersStr);
        for (DepricatedRobot r: robots) {
        	r.print();
        }
        System.out.println(" --------------------");
	}
	
}
