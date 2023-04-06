package uoy.mrs.uoy.mrs.auxiliary.jmetal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.uma.jmetal.problem.integerproblem.impl.AbstractIntegerProblem;
import org.uma.jmetal.solution.integersolution.IntegerSolution;
import org.uma.jmetal.solution.integersolution.impl.DefaultIntegerSolution;

import parser.ast.ModulesFile;
import parser.ast.PropertiesFile;
import prism.Prism;
import prism.PrismDevNullLog;
import prism.PrismException;
import prism.PrismLangException;
import prism.PrismLog;
import prism.Result;
import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.Utility;

/**
 * For an example, check org.uma.jmetal.problem.multiobjective.zdt ZDT1;
 * @author gris
 *
 */
public class PlanProblem extends AbstractIntegerProblem {
	
	
	private static final long serialVersionUID = 1L;
	
	
	Prism PRISM; // prism instance
	
	// counter for average times
	int countFeas = 0;
	int countIdle = 0;
	// timer
	long timerFeas = 0;
	long timerIdle = 0;


	int countEvalChrom;
	long timerEvalChrom;
	
	/** Constructor */
	public PlanProblem() {
		setName("PLANS");
		setNumberOfVariables(1);
	    setNumberOfObjectives(Constants.num_objectives);
	    setNumberOfConstraints(1);
	    
	    
		List<Integer> l = Arrays.asList(0);
		List<Integer> u = Arrays.asList(upper());
		setVariableBounds(l,u);
	    
	    // initialise PRISM engine     --- it takes 2ms less if initialized here, rather than from Constants.initializePrism
 		PrismLog mainLog = new PrismDevNullLog(); //new PrismFileLog("stdout");   // Create a log for PRISM output (hidden or stdout)
 		Prism prism = new Prism(mainLog);
 		try {
			prism.initialise();
		} catch (PrismException e) {
			e.printStackTrace();
		}
 		this.PRISM = prism;
 		
	}
	
	/**
	 * Get upper limit of gene
	 */
	public Integer upper() {
		
		File[] MDPs = Utility.getFilesWithExtension(Constants.prismFilesDir,".mdp");
		
		Set<String> set = new HashSet<String>(); //populate set
		
		for (File f: MDPs) {
			String[] fileName = Utility.getfileNameWithoutExtension(f.toString()).split("_");
			
			String part1 = fileName[0]; // allocation, e.g.: Allocation2
			String part2 = fileName[1]; // permutation e.g.: 9
			
			String fileAlloc_Permut = part1 + "_" + part2;
			
			set.add(fileAlloc_Permut);
		}
		List<String> list = new ArrayList<String>();
		list.addAll(set);
		Constants.allocperm_combinations = list;
		Integer max = set.size()-1; // 0 is lower, so rest 1
		return max;
	}
	
	
	
	/** Evaluate() method. Method for evaluating any solution of class IntegerSolution.
	 *  Description from org.uma.jmetal.problem.Problem:
	 * 	This method receives a solution, evaluates it, and returns the evaluated solution.
	 *  Example: org.uma.jmetal.problem.multiobjective.zdt ZDT1
	 * @return  solution - updated solution with objective values
	 */
	@Override
	public IntegerSolution evaluate(IntegerSolution solution)  {
		
		// 1) get gene 
		Integer gene = solution.variables().get(0);
		// check gene info
		String allocperm_combination = Constants.allocperm_combinations.get(gene);
		
		// get all MDP cluster files (for alloc-perm combination)
		File[] files =Utility.getFilesWithPrefix(Constants.prismFilesDir,allocperm_combination);
		
		// error
		if (files.length == 0) {
			System.err.println("ERROR: No MDP files found for Alloc_perm: " + allocperm_combination);
		}
		
		// print
		System.out.println("\n - Gene:" + gene + " allocation and permutation: " + allocperm_combination);
		//for (File fpm : files) { System.out.println(fpm.toString()); }
		
		// 2) evaluate gene
		double probSucc = 999;			// if not feasible, do not count in solutions, so this values are dummies
		double idle = 999;
		double travel = 999;
		double feasibility = getPrismFeasibility(files,PRISM); 
		double[] res;
		
		
		if (feasibility==1) {
			probSucc = getPrismProbSucc(files,PRISM);
			idle = getPrismIdle(files,PRISM);
			travel = getPrismTravel(files);
			
			res = new double[] {probSucc,idle,travel,feasibility}; //results
		}
		else {
			res = new double[] {probSucc,idle,travel,feasibility}; //results
		}
		
		//print
		System.out.println("probSuccess,idle,travel:"+
		String.valueOf(probSucc) + "," + String.valueOf(idle) + ","+ String.valueOf(travel));
		
		
		// 3) save results to solution object
		solution.objectives()[0] = res[0];
		solution.objectives()[1] = res[1];
		solution.objectives()[2] = res[2];
		solution.constraints()[0] = res[3];	 //constrain>0 means feasible solution
		
		solution.attributes().put("alloc_perm", allocperm_combination);
		
		//timer
		//System.out.println("Time to eval chromosome: "+ t + "ms");
		
		return solution;
	}
	
	
	
	/* This creates solutions before running the algorithm.  For example, if population=20, creates 20 chromosomes (not evaluated yet), just their values. */
	@Override
	public IntegerSolution createSolution() { return new DefaultIntegerSolution(getNumberOfObjectives(), getNumberOfConstraints(),getBoundsForVariables()); }
	
	
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
	
	
	/**
	*   Check if schedulable:  
	*   Result of "Pmax=?[F done]", if 0, then not schedulable.
	*/
	private static double getPrismFeasibility(File[] fpms, Prism PRISM) {
		int feasibility = 0;
		for (File fpm : fpms) {
			// a) load to prism
			ModulesFile modulesFile = loadPrism(fpm,PRISM);
			// b) check if feasible
			Result result = null;
			try {
				PropertiesFile propertiesFile  = PRISM.parsePropertiesString(modulesFile, "Pmax=?[F done]");  //System.out.println(propertiesFile.getPropertyObject(0) + " " + result.getResult()); // Print result of "Pmax=?[F done]"
				result = PRISM.modelCheck(propertiesFile, propertiesFile.getPropertyObject(0));
			} catch (PrismException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			double prismResult = Double.parseDouble( result.getResult().toString() );
			// - No
			if (prismResult==0 | prismResult==0.0) {
				System.out.println("Not feasible.");
				feasibility = -1; // not feasible
				// end
				return feasibility;
				}
			// - Yes
			else if (prismResult==1 | prismResult==1.0) {
				feasibility = 1;
			}
			// - Error
			else { System.err.println("ERROR GETTING FEASIBILITY"); // ERROR if not 1 not 0
			   System.exit(0); }
		}
		// - Error
		if (feasibility == 0){ System.err.println("ERROR - GETTING FEASIBILITY"); // ERROR if not 1 or 0
		   System.exit(0); } 

		System.out.println("Feasible cluster plan! ");
		return feasibility;
	}
	
	
	/**
	*   Check "Pmin=?[G success]"
	*/
	private static double getPrismProbSucc(File[] fpms, Prism PRISM) {
		double probSucc = 1;
		for (File fpm : fpms) {
			// a) load to prism
			ModulesFile modulesFile = loadPrism(fpm,PRISM);
			// b) check if feasible
			Result result = null;
			try {
				PropertiesFile propertiesFile  = PRISM.parsePropertiesString(modulesFile, "Pmin=?[G success]");  //System.out.println(propertiesFile.getPropertyObject(0) + " " + result.getResult()); // Print result of "Pmax=?[F done]"
				result = PRISM.modelCheck(propertiesFile, propertiesFile.getPropertyObject(0));
			} catch (PrismException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			double prismResult = Double.parseDouble( result.getResult().toString() );
			probSucc = probSucc*prismResult;
		}
		return probSucc;
	}
	
	/**
	*   Check "R{"idle"}min=?[F done]"
	*/
	private static double getPrismIdle(File[] fpms, Prism PRISM) {
		double idle = 0;
		for (File fpm : fpms) {
			// a) load to prism
			ModulesFile modulesFile = loadPrism(fpm,PRISM);
			// b) check if feasible
			Result result = null;
			try {
				PropertiesFile propertiesFile  = PRISM.parsePropertiesString(modulesFile, "R{\"idle\"}min=?[F done]");  //System.out.println(propertiesFile.getPropertyObject(0) + " " + result.getResult()); // Print result of "Pmax=?[F done]"
				result = PRISM.modelCheck(propertiesFile, propertiesFile.getPropertyObject(0));
			} catch (PrismException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			double prismResult = Double.parseDouble( result.getResult().toString() );
			idle = idle+prismResult;
		}
		return idle;
	}
	
	/**
	*   Check "Pmin=?[G success]"
	*/
	private static double getPrismTravel(File[] fpms) {
		double travel = 1;
		for (File fpm : fpms) {
			
			String[] lst = Utility.getFileLastLine(fpm.toString()).split(Pattern.quote("//"));
			double result = Double.valueOf(lst[1]);
			
			travel = travel+result;
		}
		return travel;
	}
	

}