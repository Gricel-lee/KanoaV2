package uoy.mrs.uoy.mrs.error;

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
	
}
