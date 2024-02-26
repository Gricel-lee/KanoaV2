package uoy.mrs.uoy.mrs.auxiliary;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import prism.Prism;
import prism.PrismDevNullLog;
import prism.PrismException;
import prism.PrismLog;
import uoy.mrs.uoy.mrs.error.KanoaErrorHandler;
import uoy.mrs.uoy.mrs.types.DepricatedAllocation;
import uoy.mrs.uoy.mrs.types.DepricatedSolutionData;


public class Constants {
	public static Properties properties = new Properties();
	//@Deprecated: DSL info is extracted in Xtend saved in the infoDSL.text file
	//public static String dslFile;
	public static String infoDSLFile;
	public static String genFile;
	public static String genWM;
	public static String genMissionTree;
	public static String genAlloyModel;
	
	public static int maxIdle;
	
	public static String num_instances; 
	public static String num_evaluations;
	public static String num_population;
	
	public static String outputDir;
	public static String allAllocations;
	public static String alloyoutputDir;
	public static String allocClustersCSVFile;
	public static String prismFilesDir;
	public static String permutationsFile;
	public static String allsolutionsMDPFiles;
	public static String allsolutionsData;
	
	
	//databases
	public static String solutionsDatabasesDir;
	//Database 1 = optimised solutions
	public static String db1_optimisedSolutions; //optimalData.csv"
	//Database 2 = all feasible solutions
	public static String db2_feasibleSolutions;//feasible.csv";
	//Database 3 = infeasible solutions - possible values of not-feasible column: "somePathsDontExist", "idlingOrTaskConstraints", 
	public static String db3_infeaibleSolutions;///infeasibleData.csv";
	//Database 1 = optimised solutions
	public static String db4_paretoSolutions; //optimalData.csv"
		
	
	public static String alloc_perm;
	
	
	public static Integer countallsolutions;
	
	public static String pythonDir;
	public static String python_script; 
	public static String python_script_tasks;

	public static String plot_pareto;
	public static Boolean euclidian_path_distances;
	public static Boolean verbose = true;
	
	public static int maxPermutations;
	
	//@Depricated: Objectives to consider.
	//Moved to be part of the problem specifications.
	//public static String objectiveProb;
	//public static String objectiveIdle;
	//public static String objectiveTravel;
	//public static Integer num_objectives;
	//public static List<Integer> bool_objectives;
	
	// Alloy output related VARIABLES:
	public static int num_instances_found;  // number of Alloy instances found
	public static ArrayList<String> alloyFilesOutput; // Alloy instances .xml found
	public static ArrayList<DepricatedAllocation> allocationsList; // instances of allocations
	
	// Initialised prism
	public static Prism PRISM;
	
	// Combinations of alloc-perm found, e.g.: allocperm_combinations=(Allocation1_1,Allocation_2,...)
	public static List<String> allocperm_combinations; 
	
	// GA Results for each allocation
	public static ArrayList<DepricatedSolutionData> allocationSchedules;
	
	public static String filespath; 
	
	/**
	 * Uploads variables from config.properties and dsl file
	 * @param file config.properties file; usually resources/dslmodel/hospitalDSL.mydsl
	 * @throws exeption
	 */
	public static void setProperties(String configProp) throws Exception{
		
		// Configuration file
		filespath = new File(configProp).getParentFile().toString();
		
		// Load properties
		properties.load(new FileInputStream(configProp)); //e.g. {JAVA=/Library/Java/JavaVirtualMachines/jdk-18.jdk/Contents/Home/bin/java, PROPERTIES_FILE=/Users/gris/eclipse-workspace/uoy.mrs/models/EvoModels/6_0PM.props, PYTHON3_DIRECTORY=/usr/bin/python3  , PROBLEM=6_0PM, ALGORITHM=NSGAII, MODEL_TEMPLATE_FILE=/Users/gris/eclipse-workspace/uoy.mrs/models/EvoModels/6_0PM.pm, MAX_EVALUATIONS=4, MODEL_CHECKING_ENGINE_LIBS_DIRECTORY=/Users/gris/eclipse-workspace/uoy.mrs/libs/runtime, PROCESSORS=2, VERBOSE=false, MODEL_CHECKING_ENGINE=/Users/gris/eclipse-workspace/uoy.mrs/libs/PrismExecutor.jar, POPULATION_SIZE=4, PLOT_PARETO_FRONT=false}
		
		
		// From Config.properties
		
		verbose = Utility.string2boolean(getProperty("VERBOSE"));
		
		//@Deprecated: DSL info is extracted in Xtend saved in the infoDSL.text file
		//dslFile = filespath + '/' + getProperty("DSL_FILE");
		
		infoDSLFile = filespath + '/' + getProperty("PREALLOC_FILES_DIR") + "/infoDSL.txt";
		
		outputDir = System.getProperty("user.dir")+ '/' + filespath + "/results";
		
		allAllocations = outputDir + "./AllAllocations.csv";
		
		alloyoutputDir = outputDir + "/Alloy/";
		
		solutionsDatabasesDir = outputDir + "/Solutions";
		
		allocClustersCSVFile = outputDir + "/Solutions/AllocInfo.txt";
		
		prismFilesDir = outputDir + "/PrismFiles/";
		
		permutationsFile = outputDir + "/permutations.csv";
		 
		allsolutionsMDPFiles = outputDir + "/Solutions/allMPDs.txt";

		allsolutionsData = outputDir + "/Solutions/allData.csv";
		
		//Database 1 = optimised solutions
		db1_optimisedSolutions = outputDir + "/Solutions/optimal.txt";
		//Database 2 = all feasible solutions
		db2_feasibleSolutions = outputDir + "/Solutions/feasible.txt";
		//Database 3 = infeasible solutions
		db3_infeaibleSolutions = outputDir + "/Solutions/infeasible.txt";
		//Database 4 = Pareto optimal accross all solutions
		db4_paretoSolutions = outputDir + "/Solutions/Pareto.txt";
		
		
		countallsolutions = 0; //counter of all possible schedules
		
		//@Depricated GENERATED_FILES, now PREALLOC_FILES_DIR
		String genFiles = filespath + '/' + getProperty("PREALLOC_FILES_DIR");
		
		genWM = genFiles + "/worldmodel.txt";
		
		genMissionTree = genFiles + "/modelMissionsTree.txt";
		
		genAlloyModel = genFiles + "/modelAllocation.als";
		
		pythonDir = getProperty("PYTHON3_DIRECTORY");
		
		maxIdle = Utility.string2int( getProperty("MAX_IDLE") );
		
		//@Depricated Objectives
		//Moved to be part of the problem specifications.
		//objectiveProb = getProperty("OBJECTIVE_PROB");
		//objectiveIdle = getProperty("OBJECTIVE_IDLE");
		//objectiveTravel = getProperty("OBJECTIVE_TRAVEL");
		
		num_instances = getProperty("ALLOCATIONS_SIZE");
		
		num_evaluations = getProperty("MAX_EVALUATIONS");
		
		num_population = getProperty("POPULATION_SIZE");

		plot_pareto = getProperty("PLOT_PARETO_FRONT");
		
		// iff true, calculates all Euclidian distances between locations in world model.
		// If path not explicitly declared in world model, it is added with distance=Euclidian distance beween locations, successOfTravelling=100 %
		euclidian_path_distances = Utility.string2boolean( getProperty("ALLOW_PATH_DISTANCE_EUCLIDIAN") );
		// Others

		python_script = System.getProperty("user.dir")+"/pythonScripts/start.py";//do not modifiable
		
		python_script_tasks = System.getProperty("user.dir")+"/pythonScripts/PYTHONSCRIPT/startTasks.py";
		 
		
		// Initialise others
		
		allocationsList = new ArrayList<>();
		
		allocationSchedules = new ArrayList<>();
		
		//PRISM =  initializePrism();
		
		maxPermutations = 3628800; //=10!, max. number possible for which perm. is possible to calculate by the tool (not sure if by Python or Java)
		
	}
	
	
	public static void setalloyFilesOutput(ArrayList<String> xmlfiles) {
		//.xml files
		alloyFilesOutput = xmlfiles;
		//number of allocations found
		num_instances_found  = alloyFilesOutput.size();
		// print .xml files found
//		if(Constants.verbose) {
//			System.out.println("- allocations returned: " + alloyFilesOutput.size());
//			for (String i : alloyFilesOutput) { System.out.println(i); } }
	}
	
	
	
	/**Initialise PRISM engine*/
	public static Prism initializePrism() {
		PrismLog mainLog = new PrismDevNullLog(); //new PrismFileLog("stdout");   // Create a log for PRISM output (hidden or stdout)
		Prism prism = new Prism(mainLog);
		try {
			prism.initialise();
		} catch (PrismException e) {e.printStackTrace();}
		return prism;
	}
	
	
	/**
	 * Get variable from config.properties
	 * @param key Name of the property to get
	 * @return
	 */
	public static String getProperty (String key){
		//JAVA>8
		//String result = properties.getProperty(key).strip(); 
		//JAVA8
		String result = properties.getProperty(key).trim().replaceAll("^\\s+|\\s+$", "");
		//ERROR
		if (result == null) {
			KanoaErrorHandler.ErrorNoPropertyInConfigPropFile(key);
		}
		return result;		
	}
	
	
	/**
	 * Get variable from infoDSL.txt
	 * @param key Name of the property to get
	 * @return
	 */
	public static String getDSLInfo (String key){
		//JAVA>8
		//String result = properties.getProperty(key).strip(); 
		//JAVA8
		String result = properties.getProperty(key).trim().replaceAll("^\\s+|\\s+$", "");
		
		if (result == null) {
			System.err.println("ERROR: NO "+key+" found in config.prop " );
			throw new IllegalArgumentException(key.toUpperCase() + " name not found!");}
		return result;		
	}
	
	

}
