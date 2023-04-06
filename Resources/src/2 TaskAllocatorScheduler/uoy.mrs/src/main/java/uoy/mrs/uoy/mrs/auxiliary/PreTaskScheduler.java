package uoy.mrs.uoy.mrs.auxiliary;




public class PreTaskScheduler {
	
	
	/**
	 * Get transitive closure and Probabilistic models for each cluster of robots
	 * Python code called from: "resources/pythonScripts/start.py"
	 */
	public static void transClosure_Python() {		
		try {			
			//System.out.println("Time available to complete plan: "+RunApp.time_available);
			
			// 1) set process variables
    		ProcessBuilder procBuilder = new ProcessBuilder(
    				Constants.pythonDir, // python version to run
    				Constants.python_script, // python file: start.py
        			Constants.alloyoutputDir,
        			Constants.genMissionTree,
        			Constants.dslFile,
        			Constants.transClosureOutputDir, 
        			Constants.time_available,
        			Constants.verbose,
        			Constants.genWM,
        			Constants.outputDir);
    		
    		// 2) create process
    		Process process = null;    		//procBuilder.redirectErrorStream(true); // if errors need to be merged (https://docs.oracle.com/javase/7/docs/api/java/lang/ProcessBuilder.html#redirectErrorStream%28boolean%29)
    		
    		// 3) start python process and print memory
    		//System.out.println("(Memory: " + Runtime.getRuntime().freeMemory()+")");
    		process = procBuilder.start();
    		
    		//System.out.println("(Memory: " + Runtime.getRuntime().freeMemory()+")"); //*** if program suddenly stops, may be saturated memory: https://stackoverflow.com/questions/16907898/java-process-stops-in-the-middle-of-the-process
    		//System.out.println("Checking...");
    		
    		// 4) read output
    		Utility.readPython(process);
    		//System.out.println("---------Transitive Closure and MDP files completed.");
    		
    		// 5) end process
    		process.destroy();
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.exit(0);
		}
		
	}
	
	
	
		
}