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

public class PrismSchedulerFromPython {
	

	public static boolean delete = true; // delete .pm files non-schedulable
	
	public static String getFeasiblePermutations() throws Exception {
		System.out.println("---------Getting schedules------");
		// Create files
		//Utility.checkPath(Constants.PARETO_FILE); Utility.checkPath(Constants.SET_FILE);
		//Utility.CreateFile(Constants.PARETO_FILE); Utility.CreateFile(Constants.SET_FILE);
		
		//Utility.WriteToFile(Constants.PARETO_FILE , "travel,idle,probFail");
		
		/**Get schedules **/
		File[] pm =Utility.getFilesWithExtension(Constants.prismFilesDir, ".mdp");
		
		if (pm.length!=1){
			System.err.println("ERROR: 0 or more than 1 MDP file found when 1 expected at "+Constants.prismFilesDir);
			System.exit(0);
		}
		

		
		// Props file
		//File fprops = Utility.getFilesWithExtension(Constants.EVOINPUT_DIR, ".props")[0];
		//System.out.println("MDPs");
		//System.out.println("file:"+f.toString());
		
		// MDP file
		for (File f : pm) {
			
			// a) Initialise PRISM engine 
			PrismLog mainLog = new PrismDevNullLog(); //new PrismFileLog("stdout");   // Create a log for PRISM output (hidden or stdout)
			Prism prism = new Prism(mainLog);
			prism.initialise();
			// Parse and load a PRISM model 
			ModulesFile modulesFile = prism.parseModelFile(f); 
			prism.loadPRISMModel(modulesFile);

			// b) Result of "Pmax=?[F done]", if 0, then not schedulable
			PropertiesFile propertiesFile  = prism.parsePropertiesString(modulesFile, "Pmax=?[F done]");
			Result result = prism.modelCheck(propertiesFile, propertiesFile.getPropertyObject(0));
			double d = Double.parseDouble( result.getResult().toString() );
			
			// c.1) NOT Possible to Schedule
			//------
			if (d==0 | d==0.0) {
				return "[-1,-1,-1]";
			}
			// c.2) Schedulable
			else {
				// get properties values
				propertiesFile  = prism.parsePropertiesString(modulesFile, "R{\"travel\"}min=?[F done]"); //System.out.println(propertiesFile.getPropertyObject(0));
				Result rTravel = prism.modelCheck(propertiesFile, propertiesFile.getPropertyObject(0));
				
				propertiesFile  = prism.parsePropertiesString(modulesFile, "R{\"idle\"}min=?[F done]");
				Result rIdle = prism.modelCheck(propertiesFile, propertiesFile.getPropertyObject(0));
				
				propertiesFile  = prism.parsePropertiesString(modulesFile, "Pmin=?[G fail]");
				Result rProb = prism.modelCheck(propertiesFile, propertiesFile.getPropertyObject(0));
				
				System.out.println("R{\"travel\"}min=? " +rTravel.getResult()+ " R{\"idle\"}min=? " + rIdle.getResult()+  " Pmin=? " + rProb.getResult() + " || Schedulable MDP: "+f.toString());
				
				//Utility.WriteToFile(Constants.PARETO_FILE , rTravel + "," + rIdle + "," + rProb);
				//Utility.WriteToFile(Constants.SET_FILE , f.toString());
				

				// delete mdp
				for (File fp : pm){fp.delete();}
				String res = "[" + (String) rTravel.getResult() +"," + (String) rTravel.getResult() +","+ (String) rProb.getResult() + "]";
				return res;
			}
			
		}
		
		return null;
		
	}
	
}
