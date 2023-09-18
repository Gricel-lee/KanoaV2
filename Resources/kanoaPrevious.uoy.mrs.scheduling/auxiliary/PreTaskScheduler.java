package uoy.mrs.uoy.mrs.auxiliary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import uoy.mrs.uoy.mrs.RunApp;



public class PreTaskScheduler {
	
	
	/**
	 * Get transitive closure and Probabilistic models for each cluster of robots
	 * Python code called from: "resources/pythonScripts/start.py"
	 */
	public static void transClosure_and_MDPfiles_Python() {		
		try {			
			//System.out.println("Time available to complete plan: "+RunApp.time_available);
			
			// 1) set process variables
    		ProcessBuilder procBuilder = new ProcessBuilder(
    				"python3",
    				Constants.PYTHON_SCRIPT,
        			Constants.ALLOYOUTPUT_DIR,
        			Constants.MISSIONSTREEFILE,
        			RunApp.dslFile,
        			Constants.TRANSITIVECLOSURE_DIR,
        			Constants.EVOINPUT_DIR,
        			RunApp.time_available,
        			Constants.SAVEDATA,
        			Constants.WORLDTXTFILE,
        			Constants.NUM_PERMUTATIONS);
    		
    		// 2) create process
    		Process process = null;    		//procBuilder.redirectErrorStream(true); // if errors need to be merged (https://docs.oracle.com/javase/7/docs/api/java/lang/ProcessBuilder.html#redirectErrorStream%28boolean%29)
    		
    		// 3) start python process and print memory
    		System.out.println("(Memory: " + Runtime.getRuntime().freeMemory()+")");
    		process = procBuilder.start();
    		System.out.println("Transitive Closure and MDP files completed.");
    		System.out.println("(Memory: " + Runtime.getRuntime().freeMemory()+")"); //*** if program suddenly stops, may be saturated memory: https://stackoverflow.com/questions/16907898/java-process-stops-in-the-middle-of-the-process
    		System.out.println("Checking Instantiation Feedback...");
    		
    		// 4) read output
    		readPython(process);

    	} catch (Exception e) {
    		e.printStackTrace();
    		System.exit(0);
		}
		
		//System.out.println("Transitive closure done.");
	}
	
	
	public static void readPython(Process process) throws IOException {
		String lines=null;
		
		
    	
		// 4.1) read python output
    	BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    	while ((lines=reader.readLine())!=null) {
    		System.out.println(lines);
    	}
    	
    	// 4.2) read python errors
    	BufferedReader readerErr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
    	if (readerErr.readLine()!=null) {
    		while ((lines=readerErr.readLine())!=null) {
        		System.err.println(lines);
        	}
    		System.err.println("Solve the problem above from Python code.");
    		System.exit(0);
    	}
    	
    	Utility.pauseIt(2000);
	}
	
	
	
	public static ArrayList<String> CreateEvoConfigFile(File[] evochecker_pm_files, String population, String evaluations) {
		ArrayList<String>  evo_problem_ids = new ArrayList<String>();
		
		for (File filepm : evochecker_pm_files) {
			//e.g. model ="1_0PM.pm"; = allocation 1, transitive closure 0
			
			String evofile = Utility.fileToString(filepm);
			//System.out.println(filepm);
			
			String id = Utility.getfileNameWithoutExtension(evofile); 
			String path = Constants.EVOINPUT_DIR;
			
			// properties file name
			String propFile = path + id + ".props";//e.g. "1_2PM" means Allocation 1, Trans Closure 2
			
			
			// create config.properties file
			configProperties(id,evofile,propFile,population,evaluations);

			evo_problem_ids.add(id);
		}
		return evo_problem_ids;
	}
	

	
	public static void configProperties(String id, String modelFile, String propFile, String population, String evaluations) {
		
		
		String configFile = Constants.EVOCONFIGPROP + id +"config.properties";
		Utility.checkPath(configFile);
		Utility.CreateFile(configFile);
		
		String processors = "2";
		
		String algorithm = "NSGAII"; // RANDOM, NSGAII, SPEA2, MOCELL
		
		try {
			// write to output file
			FileWriter fw = new FileWriter(configFile, true);
			fw.write(//+ "#Step 1:Set problem name\n"
					 "PROBLEM = "+ id +"\n"
					//+ "#FILES\n"
					+ "MODEL_TEMPLATE_FILE = "+ modelFile +"\n"
					+ "PROPERTIES_FILE = "+ propFile +"\n"
					//+ "#Step2 : Set the algorithm (MOGA or Random) to run\n"
					+ "ALGORITHM = "+ algorithm +"\n"
					+ "INTEGER_MUTATION_PROBABILITY = 0.8\n"
					//+ "#Step 3: Set the population for the MOGAs\n"
					+ "POPULATION_SIZE = "+ population +"\n"
					//+ "#Step 4: Set the maximum number of evaluations #original num: 5000\n"
					+ "MAX_EVALUATIONS = "+ evaluations +"\n"
					//+ "#Step 5: Set the number of processors (for parallel execution) #original num: 1\n"
					+ "PROCESSORS = "+ processors +"\n"
					//+ "#Step 6: Set plotting settings    \n"
					+ "PLOT_PARETO_FRONT = false\n"
					//+ "	#Note: requires Python3; original: /usr/local/bin/python3\n"
					+ "PYTHON3_DIRECTORY = /usr/bin/python3  \n"
					//+ "#Step 7: Set additional settings #Changed by gris to True from False\n"
					+ "VERBOSE = false\n"
					
					+ "EVOCHECKER_TYPE = NORMAL\n"
					+ "	EVOCHECKER_ENGINE = PRISM\n"
					+ "RUNS = 30\n"
					//+ "#Step 8 : Other parameters\n"
					+ "MODEL_CHECKING_ENGINE = libs/PrismExecutor.jar");
			//fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0); // end program
		}
		
	}

		
}