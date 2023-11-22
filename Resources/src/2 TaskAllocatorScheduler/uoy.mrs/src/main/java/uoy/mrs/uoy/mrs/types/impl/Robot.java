package uoy.mrs.uoy.mrs.types.impl;

import java.util.ArrayList;
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
		//JAVA >8
		//return List.copyOf(capabilities.keySet());
		//JAVA8
		return new ArrayList<>(capabilities.keySet());
	}
	
	

	/**Check if the atID is instantiated or not - then return capabit*/
	public Capability getCapability(String atID, ProblemSpecification p) {
		Capability cap;
		// if atID not instantiated (at1), it should be in the list of the robot capabilities (if robot can do it)
		if( capabilities.keySet().contains(atID) )
			return capabilities.get(atID);
		//if not (at1_1), get task not instantiated (at1), then get capability
		else {
			String taskNotInstantiatedID = p.getTasks().atList.get(atID).getInst();
			cap = capabilities.get(taskNotInstantiatedID);
		}
		//ERROR - if robot cannot do task, then null
		if(cap.equals(null)) { KanoaErrorHandler.ErrorRobotCannotDoTask(getID(), atID); }
		return cap;
	}
	

	/**Get time required by robot to complete a (instantiated) atomic task
	 * input example: at4_1 */
	public String getTaskDuration(String atID,ProblemSpecification p) {
		return getCapability(atID,p).completionTime;
	}
	
	/**Get time required by robot to complete a task as Int
	 * input example: at4_1 */
	public int getTaskDurationInt(String atID,ProblemSpecification p) {
		return Utility.string2int( getCapability(atID,p).completionTime );
	}
	
	
	
	public void print(ProblemSpecification p) {
		System.out.println("--- Robot:");
		System.out.println(this.getID()+
				" location:" + this.getLoc().getID()+
				" cando:"+ this.getCandoAtomicTasks()+
				" velocity:"+ this.getVelocity()
				);
		for(String at : this.getCandoAtomicTasks()) {
			Capability cap = this.getCapability(at,p);
			System.out.println("capability to do task: "+ cap.atomicTaskID_notInstantiated+
					" probSucc: " + cap.getprobSucc()+
					" completionTime: "+cap.completionTime
					);
			
		}
	}
}
