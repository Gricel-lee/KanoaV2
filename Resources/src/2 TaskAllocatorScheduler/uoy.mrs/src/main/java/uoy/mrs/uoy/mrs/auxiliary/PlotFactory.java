package uoy.mrs.uoy.mrs.auxiliary;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import uoy.mrs.uoy.mrs.RunApp;
import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.Utility;

public class PlotFactory {

	
	public static void plotParetoFront(int objectivesNum) {
		try {
			System.out.println("\nGenerating Pareto Front plot");
			if (objectivesNum == 2)
				plotParetoFront(true);
			else if (objectivesNum == 3)
				plotParetoFront(false);
			else
				throw new Exception("Plot pareto front only available for 2 or 3 objectives");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	
	

	private static void plotParetoFront(boolean twoD) {	
		try {			
			String scriptFile = Constants.python_script;
		
			if (twoD)
				scriptFile += "/plotFront2D.py";
			else
				scriptFile += "/plotFront3D.py";
			//System.out.println("Time available to complete plan: "+RunApp.time_available);
			
			// 1) set process variables
			ProcessBuilder procBuilder = new ProcessBuilder(
					Constants.pythonDir,
					scriptFile,
	    			"hi.txt");
			
			// 2) create process
			Process process = null;    		//procBuilder.redirectErrorStream(true); // if errors need to be merged (https://docs.oracle.com/javase/7/docs/api/java/lang/ProcessBuilder.html#redirectErrorStream%28boolean%29)
			
			// 3) start python process and print memory
			process = procBuilder.start();
			Utility.readPython(process);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		//System.out.println("Transitive closure done.");
	}
	
}
