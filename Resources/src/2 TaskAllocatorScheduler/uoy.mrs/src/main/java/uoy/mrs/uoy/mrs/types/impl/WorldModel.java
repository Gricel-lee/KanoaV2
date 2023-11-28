package uoy.mrs.uoy.mrs.types.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


import org.apache.commons.collections4.map.MultiKeyMap;

import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.error.KanoaErrorHandler;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;

public class WorldModel {
	
	//Locations and paths
	
	/**Map of locations ids to locations*/
	public HashMap<String,Location> locations = new HashMap<String,Location>();
	/**Map to paths
	 * retrieve values: Path retrievedPath = multiKeyMap.get(new MultiKey("key1a", "key1b"));
	 * 
	 * */ 
	public Map<MultiKey, Path>  paths = new HashMap<>();
	

	public void addLoc(String id, Location loc) {
		this.locations.put(id, loc);
	}
	
	//e.g.: path,,l1,,l2,,3.0,,NAN
	//      path,,l1,,l3,,3.0,,98.0
	public void addPath(String loc1, String loc2, String dist, String succRate) {
		Path newpath = new Path(loc1,loc2,dist,succRate2prob(loc1,loc2,succRate));
		MultiKey key = new MultiKey(loc1, loc2); //key for MultiKey class object
		this.paths.put(key,newpath);
	}
	
	
	
	public static void main( String[] args )  throws Exception{
		System.out.println("Hi");
		String loc1 = "1";
		String loc2 = "2";
		Path newpath = new Path(loc1,loc2,"3",0.9);
		MultiKey key = new MultiKey(loc1, loc2);
		
		Map<MultiKey, Path>  pppaths = new HashMap<>();
		
		pppaths.put(key, newpath);
		
		MultiKey key2 = new MultiKey(loc1, loc2);
		if (pppaths.containsKey(key)) {
			System.out.println("YES");
		}
		for(MultiKey m:pppaths.keySet()) {
			System.out.println(m.getKey1());
			System.out.println(m.getKey2());
		}
	}
	
	
	/**Check if path declared in DSL*/
	public boolean checkPathExist_inDSL(Location loc1, Location loc2) {
		//MultiKey keyToCheck = new MultiKey(loc1.getID(),loc2.getID());
		for(MultiKey m:paths.keySet())					 //coded as for/if because not working-> if (paths.containsKey(keyToCheck)) {return true;}
			if(m.getKey1().equals(loc1.getID()) && m.getKey2().equals(loc2.getID()) )
				return true;
		return false;
	}
	
	/**Check if path declared in DSL OR automatically generated as Euclidean set as True in config.properties file*/
	public boolean checkPathExist_inDSL_orEuclidean(Location loc1, Location loc2) {
		if (checkPathExist_inDSL(loc1,loc2))
			return true;
		if(Constants.euclidian_path_distances)
			return true;
		return false;
	}
	
	/**Get the distance between two locations.
	 * a) if declared in DSL
	 * b) if not declared in DLS but Euclidean distance calculation allowed
	 * c) path does not exists = -1
	 * */
	public int getPathDistance(Location loc1, Location loc2) {
		int distance = -1;
		//if path in World Model
		if(checkPathExist_inDSL(loc1,loc2)) {
			distance = Utility.string2int( getPath(loc1.getID(), loc2.getID()).dist );
		}
		//if path NOT in World Model but Eclidean distance allowed in config.properties, then probability of transitioning = 1
		else if(Constants.euclidian_path_distances)
			distance = getEuclidianDistance(loc1,loc2);
		//else: path does not exists (-1)
		return distance;
	}
	
	
	

	public Path getPath(String loc1, String loc2) {
		for(Path path: paths.values()) { 		//coded as for/if because not working->  Path retrievedPath = this.paths.get(new MultiKey(loc1, loc2));
			if(path.loc1.equals(loc1)) {
				if(path.loc2.equals(loc2)) {
					return path;
				}
			}
		}
		KanoaErrorHandler.ErrorExpectingPathInDSL(loc1,loc2);
		return null;
	}
	
	/**Get the probability of travelling between two locations.
	 * a) if declared in DSL
	 * b) if not declared in DSL but Euclidean distance calculation allowed in config.properties, probability=1
	 * c) path does not exists = -1
	 * */
	public double getProbabilityPathTravel(String loc1, String loc2, ProblemSpecification p) {
		//if path in World Model
		if(checkPathExist_inDSL(getLoc(loc1),getLoc(loc2)))
			return getPath(loc1, loc2).probSucc;
		//if path NOT in World Model but Eclidean distance allowed, then probability of travel successfully = 1
		if(Constants.euclidian_path_distances)
			return 1;
		//else: path does not exists
		return -1;
	}
	
	
	
	/**Get time travelling between two locations as an "integer" (time units) for this robot.
	 * travel time = dist/vel,
	 * Note: check first if permutation is feasible, i.e., all paths exist.
	 * */
	public int getTravelTime(Location loc1, Location loc2, Robot robot) {
		int distance = getPathDistance(loc1,loc2);
		int travelCost = dist2travelTime(distance, robot);
		return travelCost;
	}
	
	/**Get time to travel*/
	private int dist2travelTime(int distance, Robot robot) {
		if(robot.getVelocity()<=0) {KanoaErrorHandler.RobotVelocityError(robot.getID());}
		int travelCost = (int) Math.ceil((double)distance / robot.getVelocity());//Utility.string2int( Double.toString( distance / robot.getVelocity() ) ); //travel cost/time = dist/vel
		if(travelCost<0) {travelCost=0;} //as a safe-guard
		return travelCost;
	}
	
	
	
	
	/**Get Euclidean distance between two locations as an integer*/
	public static int getEuclidianDistance(Location loc1, Location loc2) {
		 // Parse the coordinates as doubles
		double x1 = Utility.string2double( loc1.getx() );
		double x2 = Utility.string2double( loc2.getx() );
		double y1 = Utility.string2double( loc1.gety() );
		double y2 = Utility.string2double( loc2.gety() );
		// Calculate the Euclidean distance
		return Utility.getEuclidianDistance(x1, x2, y1, y2);
	}
	
	/** Use to read DSL output.
	 * e.g.: l1,l2,NAN   <- no probability declared (NAN) = 100% success rate
	 *       l1,l3,98.0
	 * */
	private double succRate2prob(String loc1, String loc2,String succRate) {
		double prob = 0;
		if(succRate.equals("NAN")) { return 1; }
		prob= Utility.string2double(succRate)/100;
		//ERROR
		if(prob<0 || prob>1) {KanoaErrorHandler.ErrorTravelProbabilityOutsideBounds(loc1,loc2);}
		return prob;
		
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
		System.out.println("--- Paths:");
		for(Path path : paths.values()) {
			path.print();
		}
	}

	
}
