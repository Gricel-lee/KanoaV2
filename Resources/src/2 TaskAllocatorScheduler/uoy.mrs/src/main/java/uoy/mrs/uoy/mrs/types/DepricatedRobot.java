package uoy.mrs.uoy.mrs.types;

import java.util.regex.Pattern;

class DepricatedRobot {
	
	public String id;
	public String tasks; //e.g. "['at1_move_0', 'at1_move_1']"
	public int numTasks;
	  
	/** Constructor
	 * @param robotID */
	public DepricatedRobot(String robotID) {
		id = robotID;
	}
	/** Constructor
	 * @param robotID
	 * @param tsks */
	public DepricatedRobot(String robotID, String tsks) {
		id = robotID;
		setTasks(tsks);
	}


	public void print() {
		System.out.println("-------ROBOT INFO");
		System.out.println("|id: " + id);
		System.out.println("|tasks: " + tasks);
		System.out.println("|numTasks: " + numTasks);
	}
	
	
	public void setTasks(String tsks) {   //e.g. t="['at1_move_0', 'at1_move_1']"
		tasks = tsks;
		numTasks = tasks.split(Pattern.quote(",")).length;
	}
}