package uoy.mrs.uoy.mrs.types.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Set;



public class Robot{
	
	private String id;
	private Location loc;
	
	/**keys: atomic task ID*/
	private HashMap<String,Capability> capabilities;
	
	
	//constructor
		public Robot(String id, Location loc, HashMap<String,Capability> capabilities) {
			this.id = id;
			this.loc = loc;
			this.capabilities = capabilities;
			
		}
		
	


	public String getID() {
		return id;
	}
	
	
	public Location getLoc() {
		return loc;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getCandoAtomicTasks(){
		return List.copyOf(capabilities.keySet());
	}
	
	public Capability getCap(String atID) {
		return capabilities.get(atID);
	}
	
	public void print() {
		
	}
}
