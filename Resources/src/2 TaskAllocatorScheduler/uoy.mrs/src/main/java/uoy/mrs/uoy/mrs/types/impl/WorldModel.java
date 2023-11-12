package uoy.mrs.uoy.mrs.types.impl;

import java.util.HashMap;

import org.apache.commons.collections4.map.MultiKeyMap;

public class WorldModel {
	
	//Locations and paths
	
	/**Map of locations ids to locations*/
	public HashMap<String,Location> locations = new HashMap<String,Location>();
	/**Map of two keys (loc1,loc2) to distance (path)*/
	MultiKeyMap<String, Object> paths = new MultiKeyMap<>(); //path.get(l1,l2) = 45.0 - distance
	

	public void addLoc(String id, Location loc) {
		this.locations.put(id, loc);
	}
	
	public void addPath(String loc1, String loc2, String dist) {
		this.paths.put(loc1, loc2, dist);
	}
	
	public Location getLoc(String id) {
		return locations.get(id);
	}
	
	public void print() {
		System.out.println("\n----WORLD MODEL----");
		for(Location l:locations.values()) {
			System.out.println("--- Location:");
			System.out.println(l.getID()+
					" x:"+ l.getx()+
					" y:"+ l.gety()
					);
		}
	}
	
}
