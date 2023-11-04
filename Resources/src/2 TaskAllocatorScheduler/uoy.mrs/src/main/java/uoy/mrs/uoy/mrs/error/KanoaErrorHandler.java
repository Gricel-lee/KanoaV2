package uoy.mrs.uoy.mrs.error;

import prism.PrismException;
import uoy.mrs.uoy.mrs.types.impl.AtomicTaskInstance;

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
		System.exit(1);
	}

	public static void NoObjectivesDeclared() {
		System.err.println("No objectives found in DSL mission specification. At least one most be declared: idle time, probability of sucess and/or travelling cost.");
		System.exit(1);
	}
	

	public static void ErrorSetUpPrism(PrismException e2) {
		System.err.println("Error configuring Prism.");
		System.exit(0);
		e2.printStackTrace();
		
	}
	
	public static void PrismNotInitialising(PrismException e1, String string) {
		e1.printStackTrace();
		System.err.println("Error initialising Prism. "+string);
		System.exit(0); //Retry
	}

	public static void ErrorGettingParent(String tID) {
		System.err.println("Error getting parent of atomic task "+tID);
		System.exit(1);
		
	}

	
}
