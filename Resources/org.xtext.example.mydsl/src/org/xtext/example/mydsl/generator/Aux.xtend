package org.xtext.example.mydsl.generator

import dsl.Robot
import java.util.List
import dsl.Location
import dsl.ProblemSpecification
import dsl.AtomicTask
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.ArrayList
import dsl.SpaceXYRobot
import java.util.Collections

/*Auxiliary functions. */
class Aux{
	
	
	/**Get closest robot to atomic task */
	def static Robot getClosestRobot(String atID, GlobalVar gv){
		var atInstance = gv.atomicList.get(atID) //atID  e.g., at1_3
		var Location loc = atInstance.loc
		var double x_at = loc.x
		var double y_at = loc.y
		var List<Robot> robots = gv.resource.allContents.filter(Robot).toList()
		
		var Robot closestR = null
		var Double closestD = null
		
		for (Robot r: robots){
			//check if robot has capability to do task
			var itcan = ""
			itcan = checkIfRobotCanDoAtomicTask(r, atInstance)
			//println("robot "+r.name+" can do task "+atID + "?: "+ itcan)
			//if robot can do task
			if (itcan==="true"){
				//check Euclidian distance
				var Pair<Double, Double> coordAT = new Pair( x_at , y_at )
				var Pair<Double, Double> coordRob = new Pair( r.initLoc.x , r.initLoc.y )
				var dist = distance(coordAT,coordRob) //get euclidian distance to task sqr()
				//add if it is the closest
				if (closestR===null){ closestR = r;  closestD = dist }
				else{
					if (dist<closestD){ closestR = r; closestD = dist }
				}
			}
		}
		if(closestR===null){throw new UnsupportedOperationException("ERROR. No robot found to perform task:" + atInstance.at.name )}
		return closestR
	}
	
	def static checkIfRobotCanDoAtomicTask(Robot r, AtomicTaskinstance atInstance){
		var itcan = ""
		for (cap:r.capabilities){
			if (cap.at.name == atInstance.at.name ){itcan="true"}
		}
		return itcan
	}
	
	
	/** Euclidian distance */
	def static double distance (Pair<Double, Double> coord1 , Pair<Double, Double> coord2) {
	    var double deltaX = coord1.getKey() - coord2.getKey();
	    var double deltaY = coord1.getValue() - coord2.getValue();
	    var double result = Math.sqrt(deltaX*deltaX + deltaY*deltaY);
	    return result; 
	}
	
	
	/** Allocate atomic task to robot, if robot can perform task */
	def static allocateATtoRobot(String atID, Robot r, GlobalVar gv){
		var atInstance = gv.atomicList.get(atID)
		var itcan = ""
		itcan = checkIfRobotCanDoAtomicTask(r, atInstance)
		
		if (itcan==="true"){
			gv.atomicList.get(atID).robot = r
		}
		else{throw new UnsupportedOperationException("ERROR. Not possible to assign task:" + atID + " to robot " + r.name + "\nCheck mission constraints allocating tasks to robots.")}
	}
	
	
	/**number of robots */
	def static getRobots_atName(String at, ProblemSpecification root) {
		for (t: root.tasksModel){
			switch t{
				AtomicTask:{
					if (t.name==at){return t.robots}
		}}}
	// ERROR
	throw new UnsupportedOperationException("ERROR: num of robots don't found for task "+at)
	}
	
	
	/**create new file */
	def static generateFile(String fileName, String finalString, GlobalVar gv){
		gv.fsa.deleteFile(fileName);
		gv.fsa.generateFile(fileName, finalString)
	}
	
	
	def static String readFile(String filePath) throws IOException {
		var Path path = Paths.get(filePath);
		System.out.println(path);
		return Files.readString(path);	
	}
	
	/** Cast object -> int -> string */
	def static cast2Int(Double xy) { 
			var String s = xy.toString();
			var int dot = s.indexOf("."); //this finds the first occurrence of "." //in string thus giving you the index of where it is in the string
			var String integerPart;
			if (dot!= -1) {integerPart= s.substring(0 ,dot);}
			else {integerPart = "0"}
			return integerPart
	}
	
	/**List of atomic tasks needed - NOT instantiated and possibly repeated (e.g., at1_1, at1_1 will return [at1,at1] */
	def static List<AtomicTask> at_in_mission(GlobalVar gv){
		var List<AtomicTask> at_in_mission = new ArrayList();
		for (atomic: gv.atomicList.values()){
			at_in_mission.add(atomic.at)
		}
		return at_in_mission
	}
	
	/**Log base 2 */
	def static double log2(double v) {
	    return Math.log(v) / Math.log(2);
	}
	
	/**Integers Scope for Alloy model */
	def static Integer getAlloyIntScope(GlobalVar gv){
		var ArrayList<Double> n = new ArrayList<Double>
		// numbers from task locations
		for (atomic: gv.atomicList.values()){
			n.add(atomic.loc.x)
			n.add(atomic.loc.y)
		}
		//numbers from mission constraints (SpaceXYRobot
		// 1 SpaceXYRobot
		val constrantListXY = gv.resource.allContents.filter(SpaceXYRobot).toList();
		for(c: constrantListXY) {
			n.add(c.getVal())
		}
		
		val max = Math.ceil((log2(Collections.max(n) + 1) +1)).intValue();
		
		return max
	}
	
}