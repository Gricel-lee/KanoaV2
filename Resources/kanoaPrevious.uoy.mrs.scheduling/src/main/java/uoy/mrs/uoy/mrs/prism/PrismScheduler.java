package uoy.mrs.uoy.mrs.prism;


import java.io.File;
import java.util.ArrayList;

import parser.ast.ModulesFile;
import parser.ast.PropertiesFile;
import prism.Prism;
import prism.PrismDevNullLog;
import prism.PrismLog;
import prism.Result;
import uoy.mrs.uoy.mrs.alloy.Alloy;
import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.Utility;

public class PrismScheduler {
	/**

	public static boolean delete = true; // delete .pm files non-schedulable
	
	//List of Alloy instances found
	private static ArrayList<String> alloy_instances_found;
	
	//Run Alloy
	public static void getSchedules() throws Exception {
		getFeasiblePermutations();
	}
	
	public static void getFeasiblePermutations() throws Exception {
		System.out.println("---------Getting schedules------");
		// Create files
		Utility.checkPath(Constants.PARETO_FILE); Utility.checkPath(Constants.SET_FILE);
		Utility.CreateFile(Constants.PARETO_FILE); Utility.CreateFile(Constants.SET_FILE);
		
		Utility.WriteToFile(Constants.PARETO_FILE , "travel,idle,probFail");
		
		//Get possible schedules and values
		File[] pm =Utility.getFilesWithExtension(Constants.EVOINPUT_DIR, ".mdp");
		for (File f : pm) {
			//System.out.println("MDPs");
			//System.out.println("file:"+f.toString());
		}
		
		// delete .props - (not used for now)
		File[] fprops = Utility.getFilesWithExtension(Constants.EVOINPUT_DIR, ".props");
		for (File fp : fprops){fp.delete();}
		
		for (File f : pm) {
			
			// Initialise PRISM engine 
			PrismLog mainLog = new PrismDevNullLog(); //new PrismFileLog("stdout");   // Create a log for PRISM output (hidden or stdout)
			Prism prism = new Prism(mainLog);
			prism.initialise();

			// Parse and load a PRISM model 
			ModulesFile modulesFile = prism.parseModelFile(f);
			prism.loadPRISMModel(modulesFile);

			// Result of "Pmax=?[F done]", if 0, then not schedulable
			PropertiesFile propertiesFile  = prism.parsePropertiesString(modulesFile, "Pmax=?[F done]");
			Result result = prism.modelCheck(propertiesFile, propertiesFile.getPropertyObject(0));
			//System.out.println("file:"+f.toString());
			//System.out.println(propertiesFile.getPropertyObject(0) + " " + result.getResult()); // Print result of "Pmax=?[F done]"
			double d = Double.parseDouble( result.getResult().toString() );
			
			
			// NOT Possible Schedule - remove
			//----- Change to false if don't want to remove non-schedulable MDPs
			//------
			if (d==0 | d==0.0) {
				
				//System.out.println("Non-schedulable MDP: "+f.toString());
				// Delete file
				if (delete){
					if (f.delete()){ // file deleted
						//System.out.println("Deleting  file.");
					}
					else {
						System.err.println("ERROR deleting non-schedulable MDP "+f.toString());
						System.exit(0);
					}
				}
			}
			// Schedules! - get properties values
			else {
				
				propertiesFile  = prism.parsePropertiesString(modulesFile, "R{\"travel\"}min=?[F done]"); //System.out.println(propertiesFile.getPropertyObject(0));
				Result result1 = prism.modelCheck(propertiesFile, propertiesFile.getPropertyObject(0));
				
				propertiesFile  = prism.parsePropertiesString(modulesFile, "R{\"idle\"}min=?[F done]");
				Result result2 = prism.modelCheck(propertiesFile, propertiesFile.getPropertyObject(0));
				
				propertiesFile  = prism.parsePropertiesString(modulesFile, "Pmin=?[G fail]");
				Result result3 = prism.modelCheck(propertiesFile, propertiesFile.getPropertyObject(0));
				
				System.out.println("R{\"travel\"}min=? " +result1.getResult()+ " R{\"idle\"}min=? " + result2.getResult()+  " Pmin=? " + result3.getResult() + " || Schedulable MDP: "+f.toString());
				
				Utility.WriteToFile(Constants.PARETO_FILE , result1 + "," + result2 + "," + result3);
				Utility.WriteToFile(Constants.SET_FILE , f.toString());
				
			}
			
		}
		
	}*/
	
}
