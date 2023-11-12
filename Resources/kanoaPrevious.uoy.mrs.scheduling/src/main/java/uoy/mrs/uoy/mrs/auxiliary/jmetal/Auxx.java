package uoy.mrs.uoy.mrs.auxiliary.jmetal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Pattern;

import org.uma.jmetal.solution.integersolution.IntegerSolution;

import parser.ast.ModulesFile;
import parser.ast.PropertiesFile;
import prism.Prism;
import prism.PrismException;
import prism.PrismLangException;
import prism.Result;
import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.Timer;
import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.types.Allocation;
import uoy.mrs.uoy.mrs.types.SolutionData;



/**
 * @author gris
 *
 */
public class Auxx {
	
	public static String getGenesString(IntegerSolution solution) {
		String str = "(";
		String genesString = null;
		
		// if only one gene (one robot)
		if (solution.variables().size()==1) {
			Integer s = solution.variables().get(0); //get gene value 
			genesString = str + String.valueOf(s) + ",)"; //comma is needed at the end to be read as a tuple in python
		}
		// 2 or more robots
		else {
			for (int i = 0; i < solution.variables().size(); i++) {
				Integer s = solution.variables().get(i); //get gene value
				str = str + String.valueOf(s) + ",";
			}
			genesString = str.substring(0,str.length()-1) + ")";
			
		}
		return genesString;
	}
	
	
	
	
	public static boolean runPython(String genesVal, Allocation allocation) {
		
		ProcessBuilder procBuilder = new ProcessBuilder(
				Constants.pythonDir, // python version to run
				Constants.python_script, // python file: start.py
    			Constants.alloyoutputDir,
    			Constants.genMissionTree,
    			Constants.dslFile,
    			Constants.transClosureOutputDir, 
    			//Constants.time_available,
    			Constants.verbose.toString(),
    			Constants.genWM,
    			Constants.outputDir,
				// NEW INPUTS (compared to prescheduler)
				"MDPCreate", 							//to execute MDP part in Python
				allocation.file,
				Constants.prismFilesDir,
				allocation.getRobotsStr(),
				genesVal
				);
		
		// 2.1) create process
		Process process = null;    		//procBuilder.redirectErrorStream(true); // if errors need to be merged (https://docs.oracle.com/javase/7/docs/api/java/lang/ProcessBuilder.html#redirectErrorStream%28boolean%29)
		
		// 2.2) start python process and print memory
		try {
			process = procBuilder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 2.3) read output and check if feasible given each robot's order of tasks
		boolean feasible = Utility.readPythonAndFeasibility(process); // feasibility 1, true is possible
		// 2.4) end process
		process.destroy();
		return feasible;
	}
	
	
	public static double[] evalChromosomeMDP(IntegerSolution solution, String genesVal, Allocation allocation, Prism PRISM) {
		// timer
		long startTime = System.nanoTime();
		
		// initiate other variables
		double probSucc = 1;
		double idle = 0;
		double travel = 0;
		double feasibility = 100; // feasibility of the whole allocation, negative means it is feasible
		
		// 1) Create MDP and check if robots permutations ok (separately)
		boolean feasible = runPython(genesVal, allocation);
		
		// 2) Get mdp files (for each cluster) - if no files, print error
		File[] files =Utility.getFilesFromChromosome(Constants.prismFilesDir, genesVal);
		
		if (files.length == 0) {
			System.err.println("ERROR: No MDP files found for permutation: " + genesVal);
		}
		
		// 3) If files were created, before running prism, check if each robots' perm. is possible
		if (!feasible) {
			//System.out.println("Not feasible 		 (1)by a robot(s) permutation"); // printed in Python
			feasibility = 1; // positive means not feasible
			// end
			double[] res = {probSucc,idle,travel,feasibility};
			return res;
		}
		
		
		
		ModulesFile modulesFile = null;
		
		// 5) Check feasibility (by checking Prism formula)
		for (File fpm : files) { //for each cluster
			// 5.1) prism
			modulesFile = loadPrism(fpm,PRISM);
			
			// 5.2) check if feasible
			double prismResult = getPrismFeasibility(fpm,PRISM, modulesFile);		// check value from Prism is 0 or 1
			// - not feasible
			if (prismResult==0 | prismResult==0.0) {
				System.out.println("Not feasible 		 (2)by combination of robots)");
				feasibility = 1; // positive means not feasible
				// end 
				double[] res = {probSucc,idle,travel,feasibility};
				return res;
				}
			// - feasible
			else if (prismResult==1 | prismResult==1.0) {
				feasibility = -1;
			}
			// - error
			else { System.err.println("ERROR GETTING FEASIBILITY"); // ERROR if not 1 not 0
				   System.exit(0); } 
			
		}
		// ERROR - feasibility not changed
		if (feasibility == 100){ System.err.println("ERROR - GETTING FEASIBILITY"); // ERROR if not 1 or 0
		   System.exit(0); } 
		
		// 6) Get allocation info - idle, travel, prob.
		if (feasibility==-1) {   // if feasible (negative number)
			
			// - print plan found
			System.out.println("Feasible PLAN! - clusters' files:");
			for (File fpm : files) {
				System.out.println("           "+fpm);
			}
			
			// count solution
			Constants.countSolution();
			
			// 6.1) add each cluster info
			for (File fpm : files) { //for each cluster in allocation
				// - get results from PRISM
				double[] results = getPrismResults(fpm,genesVal,PRISM, modulesFile);
				// - add results
				probSucc = probSucc*results[0];
				idle = idle + results[1];
				travel = travel + results[2];
				// - save MDP file
				saveFile(fpm, Constants.countallsolutions);
			}
			
			//6.2) results list
			double[] res = {probSucc,idle,travel,feasibility};
			
			// - save
			long time = Timer.getTime_no_restart(); //only not restarted as it is printed later (and restarted)
			saveFile(res,allocation,genesVal,time); // to file
			SolutionData sol = new SolutionData(probSucc,idle,travel,feasibility,allocation,genesVal);
			Constants.addSolution(sol); // to variable
			
			return res;
		}
		
		// 4) Remove objectives not required to compute
		//if (Constants.objectiveProb=="false"){probSucc = -1;}
		//if (Constants.objectiveIdle=="false"){idle = -1;}
		//if (Constants.objectiveTravel=="false"){travel = -1;}
		
		
		
		
		//System.exit(0);
		
		long t = (System.nanoTime() - startTime)/1000000;
		//this.countEvalChrom = this.countEvalChrom +1;
		//this.timerEvalChrom = this.timerEvalChrom + t;
		
		
		//System.out.println("======Avr time to eval chromosome: "+ this.timerEvalChrom/this.countEvalChrom + "ms");
		
		return null;
	}
	
	
	private static ModulesFile loadPrism(File f, Prism PRISM) {
		// 1) Parse and load a PRISM model
		ModulesFile modulesFile = null;
		try {
			modulesFile = PRISM.parseModelFile(f);
			PRISM.loadPRISMModel(modulesFile);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PrismLangException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PrismException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return modulesFile;
	}
	
	
	static void saveFile() { // called at the beggining of GA
		Utility.WriteToFile(Constants.allsolutionsData,
				"prob,idle,travel,feasible,allocation,clusters,permutation,time");
		Utility.WriteToFile(Constants.allsolutionsMDPFiles,
				"file,solutionNum");
		return;
	}
	
	private static void saveFile(double[] res, Allocation allocation, String genesVal, long time) {
		String str = "";
		for (double r: res) {
			str += String.valueOf(r) ;
			str += ",";
		}
		str = str.substring(0, str.length() - 1) ;
		
		Utility.WriteToFile(Constants.allsolutionsData,
				str + ","
				+ allocation.name + ","
				+ allocation.clustersStr.replace(',', ' ') + ","
				+ genesVal.replace(',', ' ') + ","
				+ String.valueOf(time)
				);
	}
	
	private static void saveFile(File file, int countallsolutions) { // save each cluster
		Utility.WriteToFile(Constants.allsolutionsMDPFiles,file.toString()+","+String.valueOf(countallsolutions));
	}
		
	
	private static double getPrismFeasibility(File fpm, Prism PRISM, ModulesFile modulesFile) {
		// 2) Get if schedulable 		//Result of "Pmax=?[F done]", if 0, then not schedulable
		Result result = null;
		try {
			PropertiesFile propertiesFile  = PRISM.parsePropertiesString(modulesFile, "Pmax=?[F done]");  //System.out.println(propertiesFile.getPropertyObject(0) + " " + result.getResult()); // Print result of "Pmax=?[F done]"
			
			result = PRISM.modelCheck(propertiesFile, propertiesFile.getPropertyObject(0));
		} catch (PrismException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("CHECKING IF FEAS"+result);
		
		double d = Double.parseDouble( result.getResult().toString() );
		return d;
	}
	
	
	/**
	 * @param fpm - MDP file .pm
	 * @return
	 * @throws PrismException
	 * @throws FileNotFoundException
	 */
	private static double[] getPrismResults(File fpm,String genesVal, Prism PRISM, ModulesFile modulesFile) {
		// init results
		double prob = 100000;
		double idle = 100000;
		double travel = 100000;
		
		
		// 2) Get if schedulable 		//Result of "Pmax=?[F done]", if 0, then not schedulable
		long startTime = System.nanoTime(); 
		
		PropertiesFile propertiesFile;
		Result result = null;
		try {
			propertiesFile = PRISM.parsePropertiesString(modulesFile, "Pmax=?[F done]");
			result = PRISM.modelCheck(propertiesFile, propertiesFile.getPropertyObject(0));
		} catch (PrismLangException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  //System.out.println(propertiesFile.getPropertyObject(0) + " " + result.getResult()); // Print result of "Pmax=?[F done]"
		catch (PrismException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double d = Double.parseDouble( result.getResult().toString() );
		double schedulable = 1;
		/*
		long t = (System.nanoTime() - startTime)/1000000;
		this.countFeas = this.countFeas +1;
		this.timerFeas = this.timerFeas + t;
		
		System.out.println("==Time4feasible: "+ this.timerFeas/this.countFeas + "ms" + "         - Pmax=?[F done] ");
		*/
		
		if (d==0 | d==0.0) { schedulable = 1;} // if positive, non-schedulable MDP
		
		// 3) Get prob, idle and travel
		else if (schedulable==1){
			// 3.1) Get probability of succ and travelling cost     - read last line (e.g. //40//0.40824, where first is travel, then prob success)
			
			
			String[] lst = Utility.getFileLastLine(fpm.toString()).split(Pattern.quote("//"));
			prob = Double.valueOf(lst[2]);
			travel = Double.valueOf(lst[1]);
			
			// 3.2) Get idle time from PRISM policy synthesis
			Result resultI;
			if (Constants.objectiveIdle != "false") {
				startTime = System.nanoTime(); 
				try {
					propertiesFile  = PRISM.parsePropertiesString(modulesFile, "R{\"idle\"}min=?[F done]");
					resultI = PRISM.modelCheck(propertiesFile, propertiesFile.getPropertyObject(0));
					idle = Double.valueOf(resultI.getResult().toString());
					
				} catch (PrismLangException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PrismException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//res.add( Double.valueOf(resultI.getResultString()) );
				/*
				t = (System.nanoTime() - startTime)/1000000;
				this.countIdle = this.countIdle +1;
				this.timerIdle = this.timerIdle + t;
				
				System.out.println("==Time4idle: "+ this.timerIdle/this.countIdle + "ms"+ "         - R{\"idle\"}min=?[F done] ");
				*/
			}
		}
		/*
		else {
			// delete mdp & leave values as 100000
			if (fpm.delete()){} // file deleted
			else { System.err.println("ERROR deleting non-schedulable MDP "+fpm.toString()); System.exit(0);}
		}*/
		
		
		// print
		//System.out.println("Schedulable: "+String.valueOf(schedulable));
		System.out.println("Prob: "+ String.valueOf(prob) + "  Idle: "+ String.valueOf(idle) + "  Travel: "+ String.valueOf(travel));
		
		
		double[] var = new double[]{prob,idle,travel,schedulable}; 
		return var;

		
	}
	
	
	
}
