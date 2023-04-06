package uoy.mrs.uoy.mrs.auxiliary;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import prism.Prism;
import prism.PrismDevNullLog;
import prism.PrismException;
import prism.PrismLog;
import uoy.mrs.uoy.mrs.types.Allocation;
import uoy.mrs.uoy.mrs.types.SolutionData;

public class Constants {
	public static Properties properties;
	public static String configProp;
	public static String dslFile;
	public static String genFile;
	public static String genWM;
	public static String genMissionTree;
	public static String genAlloyModel;

	public static String time_available;
	public static String num_instances; 
	public static String num_evaluations;
	public static String num_population;
	
	public static String outputDir;
	public static String allAllocations;
	public static String alloyoutputDir;
	public static String transClosureOutputDir;
	public static String allocationsCSVFile;
	public static String prismFilesDir;
	public static String permutationsFile;
	public static String allsolutionsMDPFiles;
	public static String allsolutionsData;
	public static String optimisedSolutionsData;
	
	
	
	public static Integer countallsolutions;
	
	public static String pythonDir;
	public static String python_script; 
	public static String python_script_tasks;

	public static String plot_pareto;
	public static String verbose = "true";
	
	public static int maxPermutations;
	
	// Objectives to consider
	public static String objectiveProb;
	public static String objectiveIdle;
	public static String objectiveTravel;
	public static Integer num_objectives;
	public static List<Integer> bool_objectives;
	
	// Alloy output related VARIABLES:
	public static int num_instances_found;  // number of Alloy instances found
	public static ArrayList<String> alloyFilesOutput; // Alloy instances .xml found
	public static ArrayList<Allocation> allocationsList; // instances of allocations
	
	// Initialised prism
	public static Prism PRISM;
	
	// Combinations of alloc-perm found, e.g.: allocperm_combinations=(Allocation1_1,Allocation_2,...)
	public static List<String> allocperm_combinations; 
	
	// GA Results for each allocation
	public static ArrayList<SolutionData> allocationSchedules;
	
	
	
	/**
	 * Uploads variables from config.properties and dsl file
	 * @param file config.properties file; usually resources/dslmodel/hospitalDSL.mydsl
	 * @throws exeption
	 */
	public static void setProperties(String file) throws Exception{
		
		// Configuration file
		
		configProp = file;
		
		// Load properties
		
		properties = new Properties(); //e.g. {JAVA=/Library/Java/JavaVirtualMachines/jdk-18.jdk/Contents/Home/bin/java, PROPERTIES_FILE=/Users/gris/eclipse-workspace/uoy.mrs/models/EvoModels/6_0PM.props, PYTHON3_DIRECTORY=/usr/bin/python3  , PROBLEM=6_0PM, ALGORITHM=NSGAII, MODEL_TEMPLATE_FILE=/Users/gris/eclipse-workspace/uoy.mrs/models/EvoModels/6_0PM.pm, MAX_EVALUATIONS=4, MODEL_CHECKING_ENGINE_LIBS_DIRECTORY=/Users/gris/eclipse-workspace/uoy.mrs/libs/runtime, PROCESSORS=2, VERBOSE=false, MODEL_CHECKING_ENGINE=/Users/gris/eclipse-workspace/uoy.mrs/libs/PrismExecutor.jar, POPULATION_SIZE=4, PLOT_PARETO_FRONT=false}
		
		properties.load(new FileInputStream(configProp));
		
		// From Config.properties
		
		dslFile = getProperty("DSL_FILE");
		
		outputDir = getProperty("OUTPUT_DIR");
		
		allAllocations = outputDir + "./AllAllocations.csv";
		
		alloyoutputDir = outputDir + "/Alloy/";
		
		transClosureOutputDir = outputDir + "/Clusters/";
		
		allocationsCSVFile = Constants.outputDir + "./Allocations.csv";
		
		prismFilesDir = outputDir + "/PrismFiles/";
		
		permutationsFile = outputDir + "/permutations.csv";
		 
		allsolutionsMDPFiles = outputDir + "/Solutions/allMPDs.txt";

		allsolutionsData = outputDir + "/Solutions/allData.csv";
		
		optimisedSolutionsData = outputDir + "/Solutions/optimalData.csv";
		
		countallsolutions = 0; //counter of all possible schedules
		
		genWM = getProperty("GENERATED_FILES") + "/worldmodel.txt";
		
		genMissionTree = getProperty("GENERATED_FILES") + "/modelMissionsTree.txt";
		
		genAlloyModel = getProperty("GENERATED_FILES") + "/modelAllocation.als";
		
		pythonDir = getProperty("PYTHON3_DIRECTORY");
		
		// Objectives
		
		objectiveProb = getProperty("OBJECTIVE_PROB");
		
		objectiveIdle = getProperty("OBJECTIVE_IDLE");
		
		objectiveTravel = getProperty("OBJECTIVE_TRAVEL");
		
		num_objectives = getNumObjectives();
		
		bool_objectives = getObjectiveBoolList();
		
		
		// From DSL file
		
		time_available = Utility.ReadDSLnumber("time available","24",dslFile);
		
		num_instances = getProperty("ALLOCATIONS_SIZE");
		
		num_evaluations = getProperty("MAX_EVALUATIONS");
		
		num_population = getProperty("POPULATION_SIZE");
		
		plot_pareto = getProperty("PLOT_PARETO_FRONT");
		
		// Others

		python_script = System.getProperty("user.dir")+"/pythonScripts/start.py";//do not modifiable
		
		python_script_tasks = System.getProperty("user.dir")+"/pythonScripts/PYTHONSCRIPT/startTasks.py";
		 
		
		// Initialize others
		
		allocationsList = new ArrayList<>();
		
		allocationSchedules = new ArrayList<>();
		
		PRISM =  initializePrism();
		
		maxPermutations = 3628800; //=10!, max. number possible for which perm. is possible to calculate by the tool (not sure if by Python or Java)
		
	}
	
	
	public static void addSolution(SolutionData sol) {
		allocationSchedules.add(sol);
	}
	
	/**Increment counter*/
	public static void countSolution() {
		countallsolutions = countallsolutions+1;
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
	
	
	private static Integer getNumObjectives() {
		Integer n = 3;
		if (objectiveProb == "false") {
			n--;}
		if (objectiveIdle == "false") {
			n--;}
		if (objectiveTravel == "false") {
			n--;}
		
		// add ERROR: if !"false", !"true" & !null
		
		return n;
	}
	
	
	
	/**
	 * Boolean list: pit[ProbSucc, Idle, Travel]
	 * @return
	 */
	public static List<Integer> getObjectiveBoolList() {
		int[] b = {1,1,1};
		
		if( Constants.objectiveProb == "false") {b[0]=0;}
		if (Constants.objectiveIdle == "false") {b[1]=0;}
		if (Constants.objectiveTravel == "false"){b[2]=0;}
		
		List<Integer>  boolList = new ArrayList<Integer>(b.length);
		
		for (int i : b){
			boolList.add(i);
		}
		
		return boolList;
	}
	
	

	/**
	 * Get variable from config.properties
	 * @param key Name of the property to get
	 * @return
	 */
	public static String getProperty (String key){
		String result = properties.getProperty(key).strip(); 
		if (result == null) {
			System.err.println("ERROR: NO "+key+" found in config.prop " );
			throw new IllegalArgumentException(key.toUpperCase() + " name not found!");}
		return result;		
	}
	
	
	public static void setalloyFilesOutput(ArrayList<String> xmlfiles) {
		alloyFilesOutput = xmlfiles;
		num_instances_found  = alloyFilesOutput.size();
	}
	
	
	//do later
	public static void test_if_directories_exist(String key){
		
	}


	public static void setAllocationsList(ArrayList<Allocation> allocations) {
		allocationsList = allocations;
		
	}
	
	
/*	
	//public static String DSLFILE = HOME_DIR+"resources/dslmodel/file1.mydsl";
	
	public static String HOME_DIR= System.getProperty("user.dir")+"/";// OR EXPLICITLY: "/home/evochecker/Desktop/Eclipse-EvoChecker/uoy.mrs/";
	//public static String EVOCHECKER_OUTPUT_DIR = "/Users/gris/eclipse-workspace/uoy.mrs/data/";
	public static final String PYTHON_SCRIPT = System.getProperty("user.dir")+"/"+"resources/pythonScripts/start.py";//do not modifiable
	public static final String PYTHON_PLOT_SCRIPT = System.getProperty("user.dir")+"/"+"scripts";//do not modifiable
	
	public static final String PYTHON3 = "/Users/gris/opt/anaconda3/bin/python";
	//"/usr/local/bin/python3";
	
	public static final String PARETO_FILE = HOME_DIR+"models/Pareto/front.txt";
	public static final String SET_FILE = HOME_DIR+"models/Pareto/set.txt";
	public static String MISSIONSTREEFILE = HOME_DIR+"resources/dslmodel/src-gen/modelMissionsTree.txt";
	public static String WORLDTXTFILE = HOME_DIR+"resources/dslmodel/src-gen/worldmodel.txt";
	public static String ALLOYFILE = HOME_DIR+"resources/dslmodel/src-gen/modelAllocation.als";
	public static String ALLOYOUTPUT_DIR = HOME_DIR+"models/Alloy/";
	public static String EVOINPUT_DIR = HOME_DIR+"models/EvoModels/";
	public static String EVOCONFIGPROP = HOME_DIR+"models/evoConfig/";
	public static String TRANSITIVECLOSURE_DIR = HOME_DIR+"models/TransClousure/";
	public static String SAVEDATA = "True"; //save data from transitive closure into "repoTC.csv"
	public static String NUM_PERMUTATIONS = "-1"; // number of permutations to create EvoChecker file, "-1" means all
	
	
	public static void resetResourcesDir(String relative_path) {
		HOME_DIR= System.getProperty("user.dir")+"/"+relative_path+"/";
		//DSLFILE = HOME_DIR+"resources/dslmodel/hospitalDSL.mydsl";
		MISSIONSTREEFILE = HOME_DIR+"resources/dslmodel/src-gen/modelMissionsTree.txt";
		WORLDTXTFILE = HOME_DIR+"resources/dslmodel/src-gen/worldmodel.txt";
		ALLOYFILE = HOME_DIR+"resources/dslmodel/src-gen/modelAllocation.als";
		ALLOYOUTPUT_DIR = HOME_DIR+"models/Alloy/";
		EVOINPUT_DIR = HOME_DIR+"models/EvoModels/";
		EVOCONFIGPROP = HOME_DIR+"models/evoConfig/";
		TRANSITIVECLOSURE_DIR = HOME_DIR+"models/TransClousure/";
	}
	
	
	*/
	
	
}
