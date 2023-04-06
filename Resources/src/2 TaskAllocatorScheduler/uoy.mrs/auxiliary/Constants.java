package uoy.mrs.uoy.mrs.auxiliary;

public class Constants {
	
	public static String HOME_DIR= System.getProperty("user.dir")+"/";// OR EXPLICITLY: "/home/evochecker/Desktop/Eclipse-EvoChecker/uoy.mrs/";
	public static String EVOCHECKER_OUTPUT_DIR = "/Users/gris/eclipse-workspace/uoy.mrs/data/";
	public static final String PYTHON_SCRIPT = System.getProperty("user.dir")+"/"+"resources/pythonScripts/start.py";//do not modifiable
	public static String DSLFILE = HOME_DIR+"resources/dslmodel/file1.mydsl";
	public static String MISSIONSTREEFILE = HOME_DIR+"resources/dslmodel/src-gen/modelMissionsTree.txt";
	public static String WORLDTXTFILE = HOME_DIR+"resources/dslmodel/src-gen/worldmodel.txt";
	public static String ALLOYFILE = HOME_DIR+"resources/dslmodel/src-gen/modelAllocation.als";
	public static String ALLOYOUTPUT_DIR = HOME_DIR+"models/Alloy/";
	public static String EVOINPUT_DIR = HOME_DIR+"models/EvoModels/";
	public static String EVOCONFIGPROP = HOME_DIR+"models/evoConfig/";
	public static String TRANSITIVECLOSURE_DIR = HOME_DIR+"models/TransClousure/";
	public static String SAVEDATA = "True"; //save data from transitive closure into "repoTC.csv"
	public static String NUM_PERMUTATIONS = "10"; // number of permutations to create EvoChecker file, "-1" means all
	
	
	
	/* Reset resources directory to a relative path
	 * @input:  relative_path
	 * @example: relative_path = "tests/Example1" 
	 */
	public static void resetResourcesDir(String relative_path) {
		HOME_DIR= System.getProperty("user.dir")+"/"+relative_path+"/";
		DSLFILE = HOME_DIR+"resources/dslmodel/hospitalDSL.mydsl";
		MISSIONSTREEFILE = HOME_DIR+"resources/dslmodel/src-gen/modelMissionsTree.txt";
		WORLDTXTFILE = HOME_DIR+"resources/dslmodel/src-gen/worldmodel.txt";
		ALLOYFILE = HOME_DIR+"resources/dslmodel/src-gen/modelAllocation.als";
		ALLOYOUTPUT_DIR = HOME_DIR+"models/Alloy/";
		EVOINPUT_DIR = HOME_DIR+"models/EvoModels/";
		EVOCONFIGPROP = HOME_DIR+"models/evoConfig/";
		TRANSITIVECLOSURE_DIR = HOME_DIR+"models/TransClousure/";
	}
	
	
}
