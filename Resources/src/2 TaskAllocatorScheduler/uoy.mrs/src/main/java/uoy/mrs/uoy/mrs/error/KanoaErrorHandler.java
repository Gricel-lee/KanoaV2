package uoy.mrs.uoy.mrs.error;

import java.io.IOError;
import java.util.HashMap;

import prism.PrismException;
import uoy.mrs.uoy.mrs.types.impl.Allocation;
import uoy.mrs.uoy.mrs.types.impl.Permutation;

public class KanoaErrorHandler {
	
	public static void NotAlloyFilePath() {
		System.err.println("ERROR 01: Path to Alloy Input file not found \n"
				+ "\nCheck uoy.mrs.uoy.mrs.scheduling.auxiliary Constants.*DSLFILE");
		System.exit(1);
	}
	
	public static void ErrorReadingTasksFromTasksTree(Exception e) {
		System.err.println(e);
		System.err.println("Error while creating TaskModel (TaskModelImpl class)."
				+ "Possible error in taskTree from pre-allocation stage. Check file.");
		System.exit(1);
	}

	public static void ErrorReadinginfoDSLFile(Exception e) {
		System.err.println(e);
		System.err.println("Error reading file infoDSL.txt from pre-allocation stage.");
		System.exit(1);
	}

	public static void DSLFileTypeUnkown(Exception e,String fileDSL, String type) {
		System.err.println(e);
		System.err.println("Error reading file: "+ fileDSL +". Unknown type: "+type);
		System.exit(1);
	}

	public static void RobotNotFoundForTaskInAllocation(String taskID,String fileName) {
		System.err.println("Error finding robot for task: "+taskID + " allocation:"+fileName);
		throw new IOError(null); //stop and print trace
	}

	public static void NoObjectivesDeclared() {
		System.err.println("No objectives found in DSL mission specification. At least one most be declared: idle time, probability of sucess and/or travelling cost.");
		System.exit(1);
	}

	public static void ErrorTravelProbabilityOutsideBounds(String loc1, String loc2) {
		System.err.println("Error. Probability not in [0,1] for travelling from location: "+loc1 + " to allocation:"+loc2);
		throw new IOError(null); //stop and print trace
		
	}

	public static void ErrorSetUpPrism(PrismException e2) {
		System.err.println("Error configuring Prism.");
		System.exit(0);
		e2.printStackTrace();
		
	}
	
	public static void PrismNotInitialising(PrismException e1, String string) {
		e1.printStackTrace();
		System.err.println("Error initialising Prism. "+string);
		System.exit(0); //retry
	}

	public static void ErrorGettingParent(String tID) {
		System.err.println("Error getting parent of atomic task "+tID);
		throw new IOError(null); //stop and print trace
		
	}

	public static void ErrorNoPropertyInConfigPropFile(String key) {
		System.err.println("ERROR: NO "+key+" found in config.prop " );
		throw new IllegalArgumentException(key.toUpperCase() + " name not found!");		
	}

	public static void ErrorRobotCannotDoTask(String id, String tID) {
		System.err.println("Robot "+id+" does not have capability to do "+tID);
		throw new IOError(null); //stop and print trace
	}
	
	public static void NoAllocationsFound() {
		System.err.println("PROCESS FINISHED. No feasible allocations found by the task allocator.");
		throw new IOError(null); //stop and print trace
	}

	public static void ErrorRetrievingATLocation(String id) {
		System.err.println("ERROR: Trying to retrieve location of: "+id+". Expecting an atomic task.");
		throw new IOError(null); //stop and print trace
	}

	public static void RobotVelocityError(String id) {
		System.err.println("ERROR: Velocity of robot "+id+" has to be greater than 0.");
		throw new IOError(null); //stop and print trace
	}

	public static void ErrorNotAnAtomicTask(String id) {
		System.err.println("ERROR: Expecting an atomic task: "+id+".");
		throw new IOError(null); //stop and print trace
	}

	public static void NoPathExistsToCompleteRunTestPermutation(HashMap<String, Integer> robots2PermNum, Permutation perm, Allocation a1) {
		System.err.println("ERROR: Paths do not exists to complete permutation "+ perm.numPerm + " for robot "+ perm.robID +" in alloction "+a1.getNum());
		System.err.println("tasks: "+ perm.tasksInPerm );
		System.out.println("a) robots to permutation Number"+robots2PermNum.keySet()); //e.g.: robots2PermNum[r2, r3, r4, r5, r1]
		System.out.println("b) robots to permutation Number"+robots2PermNum.values()); //e.g.: robots2PermNum[1, 1, 2, 2, 3628800]
		System.out.println("Check paths of robot:"+perm.robID);
		//throw new IOError(null); //stop and print trace
	}

	public static void ErrorExpectingPathInDSL(String loc1, String loc2) {
		System.err.println("ERROR In Code: Path expected to be in DSL: "+loc1+" to "+loc2);
		throw new IOError(null); //stop and print trace
	}

	public static void ErrorObjectiveNotRecognised(String string) {
		System.err.println("ERROR: Objective not recognised. Expecting one of these {minIdle,minTravel,maxSucc}, but read: "+string);
		throw new IOError(null); //stop and print trace
	}

	public static void notEven(String numDescription, int num) {
		System.err.println("Number "+numDescription+" has to be even, no "+num);
		throw new IOError(null); //stop and print trace
	}


	

	
}
