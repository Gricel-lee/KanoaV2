package uoy.mrs.uoy.mrs.types.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections4.map.MultiKeyMap;

import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.error.KanoaErrorHandler;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;



public class Robot{
	
	private String id;
	private Location loc;
	private String velocity;
	
	/**keys: atomic task ID*/
	private HashMap<String,Capability> capabilities;
	
	/**time to travel. Keys: task1,task2. Value:travel cost between tasks.
	 * travel time between tasks or from initial location "l0"*/
	private MultiKeyMap<String, Integer> tTravel = new MultiKeyMap<String, Integer> ();;
	
	/**travel time between tasks or from initial location "l0"*/
	public void setTravelTime(String loc1, String loc2, Integer dist) {
		// Adding values to the map using two string keys
        tTravel.put(loc1, loc2, dist);
	}
	
	/**travel time between tasks or from initial location "l0"*/
	public Integer getTravelTime(String loc1,String loc2) {
		return tTravel.get(loc1,loc2);
	}
	
	//constructor
		public Robot(String id, Location loc, String vel, HashMap<String,Capability> capabilities) {
			this.id = id;
			this.loc = loc;
			this.velocity = vel;
			this.capabilities = capabilities;
			
		}
	
	public String getID() {
		return id;
	}
	
	public String getVelocityString() {
		return velocity;
	}
	
	
	public double getVelocity() {
		return Utility.string2double(velocity);
	}
	
	public Location getLoc() {
		return loc;
	}
	
	public List<String> getCandoAtomicTasks(){
		return List.copyOf(capabilities.keySet());
	}
	
	public Capability getCapabilities(String atID) {
		return capabilities.get(atID);
	}
	
	
	

	/**Get time required by robot to complete a task
	 * input example: at4_1 */
	public String getTaskDuration(String tID,ProblemSpecification p) {
		String taskNotInstantiatedID = p.getTasks().atList.get(tID).getInst();
		if(!capabilities.containsKey(taskNotInstantiatedID)) {
			KanoaErrorHandler.ErrorRobotCannotDoTask(id,taskNotInstantiatedID); }
		return getCapabilities(taskNotInstantiatedID).completionTime;
	}
	
	/**Get time required by robot to complete a task as Int
	 * input example: at4_1 */
	public int getTaskDurationInt(String tID,ProblemSpecification p) {
		String taskNotInstantiatedID = p.getTasks().atList.get(tID).getInst();
		if(!capabilities.containsKey(taskNotInstantiatedID)) {
			KanoaErrorHandler.ErrorRobotCannotDoTask(id,taskNotInstantiatedID); }
		return Utility.string2int(getCapabilities(taskNotInstantiatedID).completionTime);
	}
	
	
	
	
	
	public void print() {
		
	}
}
