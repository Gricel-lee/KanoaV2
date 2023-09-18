/* Gricel Vazquez
 * 2023
 */
package uoy.mrs.uoy.mrs.types;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.collections4.map.MultiKeyMap;

import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.error.KanoaErrorHandler;




public class ProblemSpecification{
	
	//Tasks 
	static TaskInstancesImpl taskInstances = null;
	//Robots
	static HashMap<String,RobotImpl> robots = new HashMap<String,RobotImpl>();
	//Locations and paths
	static HashMap<String,LocationImpl> locations = new HashMap<String,LocationImpl>();
	static MultiKeyMap<String, Object> paths = new MultiKeyMap<>(); //path.get(l1,l2) = 45.0 - distance
	//Tasks (not instantiated)
	static MultiKeyMap<String, Object> at = new MultiKeyMap<>(); //ats.get(at1) = 2,l1  - numrobots, location
	static MultiKeyMap<String, Object> ct = new MultiKeyMap<>(); //cts.get(ct1) = [at3,at2],"true,false" - subtasks,ordered,consecutive
	//Allocations
	static HashMap<String, AllocationImpl> allocList = new HashMap<String,AllocationImpl>();
	//Objectives
	static Boolean minIdle = false;
	static Boolean minTravel = false;
	static Boolean maxSucc=false;
	//Parameters - Predefine values if not added into DSL
	static String timeAvailable = "24";
	static String numAlloc = "20";
	static String population = "50";
	static String evaluations = "50";
	static String ratesucc = "50";
	
	//Allocation Files
	static ArrayList<String> alloyFilesOutput;
	static int num_instances_found;
	
	/**
	 * @return 
	 * 
	 */
	public static void initialise() {
		//add task instances
		taskInstances = new TaskInstancesImpl();
		//add DSL info
		readDSLinfo();
	}
	
	
	
	
	public static void setalloyFilesOutput(ArrayList<String> xmlfiles) {
		//.xml files
		alloyFilesOutput = xmlfiles;
		//number of allocations found
		num_instances_found  = alloyFilesOutput.size();
		// print .xml files found
		if(Constants.verbose) {
			System.out.println("- allocations returned: " + alloyFilesOutput.size());
			for (String i : alloyFilesOutput) { System.out.println(i); } }
		getAllocInfo();
	}
	
	public static void getAllocInfo() {
	//add allocations
	for (String i : alloyFilesOutput) {
		XlmListParser x = new XlmListParser();
		x.another(i);
	}
}
	
	
	public static String getTime() {
		return timeAvailable;
	}
	
	public TaskInstances getTasks() {
		return taskInstances;
	}



	public HashMap<String, RobotImpl> getRobots() {
		return robots;
	}
	
	
	private static void readDSLinfo() {
		// Read file infoDSL.txt
		try (BufferedReader in = new BufferedReader(new FileReader(Constants.infoDSLFile))) {
			String str;
	        while ((str = in.readLine())!= null) {
	        	String[] attrib=str.split(",,");
	        	String type = attrib[0]; //loc, path, ct, at, robot, objectives
	        							 //and optional: time,numAlloc,population,evaluations,ratesucc
	        	if(type=="loc") {locations.put(attrib[1], new LocationImpl(attrib[1], attrib[2], attrib[3]));}
	        	if(type=="path") {paths.put(attrib[1], attrib[2], attrib[3]);}
	        	if(type=="ct") {at.put(attrib[1], attrib[2], attrib[3]);}
	        	if(type=="at") {ct.put(attrib[1], attrib[2], attrib[3]+","+attrib[4]);}
	        	if(type=="robot") {robots.put(attrib[1], new RobotImpl(attrib[1], locations.get(attrib[2]),attrib[3]));} //locations are saved first, so order of infoDSL.txt file matter
	        	if(type=="objectives") {
	        		if(attrib[1].contains("minIdle")){minIdle=true;}
	        		if(attrib[1].contains("minTravel")){minTravel=true;}
	        		if(attrib[1].contains("maxSucc")){maxSucc=true;}
	        	}
	        	if(type=="time") {timeAvailable=attrib[1];} //only if added in DSL
	        	if(type=="numAlloc") {System.out.println(type);} //only if added in DSL
	        	if(type=="population") {System.out.println(type);} //only if added in DSL
	        	if(type=="evaluations") {System.out.println(type);} //only if added in DSL
	        	if(type=="ratesucc") {System.out.println(type);} //only if added in DSL
	        	
	        }
		}catch (IOException e) { KanoaErrorHandler.ErrorReadinginfoDSLFile(e);}
		
		if(Constants.verbose) { taskInstances.print();}
	}
} 
