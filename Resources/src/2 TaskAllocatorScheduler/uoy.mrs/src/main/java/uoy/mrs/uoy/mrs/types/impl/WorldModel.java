package uoy.mrs.uoy.mrs.types.impl;

import java.util.HashMap;

import org.apache.commons.collections4.map.MultiKeyMap;

public class WorldModel {
	
	//Locations and paths
	HashMap<String,Location> locations = new HashMap<String,Location>();
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
		
}
