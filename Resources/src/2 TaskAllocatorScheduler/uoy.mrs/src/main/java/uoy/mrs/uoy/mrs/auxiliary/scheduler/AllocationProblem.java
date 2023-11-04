package uoy.mrs.uoy.mrs.auxiliary.scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.uma.jmetal.problem.integerproblem.impl.AbstractIntegerProblem;
import org.uma.jmetal.solution.integersolution.IntegerSolution;
import org.uma.jmetal.solution.integersolution.impl.DefaultIntegerSolution;

import parser.ast.ModulesFile;
import prism.Prism;
import prism.PrismDevNullLog;
import prism.PrismException;
import prism.PrismLog;
import prism.PrismSettings;
import uoy.mrs.uoy.mrs.auxiliary.Timer;
import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.error.KanoaErrorHandler;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;
import uoy.mrs.uoy.mrs.types.impl.Allocation;

/**
 * For an example, check org.uma.jmetal.problem.multiobjective.zdt ZDT1;
 * 
 */
public class AllocationProblem extends AbstractIntegerProblem {
	
	
	private static final long serialVersionUID = 1L;
	
	
	Allocation allocation; // save info about allocation
	
	ProblemSpecification p;
	
	Prism PRISM; // prism instance
	
	ModulesFile modulesFile; //modules from prism
	
	// counter for average times
	int countFeas = 0;
	int countIdle = 0;
	// timer
	long timerFeas = 0;
	long timerIdle = 0;


	int countEvalChrom;
	long timerEvalChrom;
	
	/** a) Constructor */
	public AllocationProblem(Allocation a, ProblemSpecification p) {
		setName("Allocation"+a.getNum());
		setNumberOfVariables(a.getNumRobots());
	    setNumberOfObjectives(p.getParameters().getNumObjectives());
	    setNumberOfConstraints(1); //constraint: permutation must be feasible
		setVariableBounds(getLowerBounds(a), getUpperBounds(a));
		// set local variables
	    this.allocation = a;
	    this.p = p;
	    // initialise PRISM engine     --- it takes 2ms less if initialised here, rather than from Constants.initializePrism
 		PrismLog mainLog = new PrismDevNullLog(); //new PrismFileLog("stdout");   // Create a log for PRISM output (hidden or stdout)
 		Prism prism = new Prism(mainLog);
 		
 		//configure memory    - from example: prism.getSettings().set(PrismSettings.PRISM_EXPORT_ADV, "DTMC");
 		try {prism.getSettings().set(PrismSettings.PRISM_CUDD_MAX_MEM , "30g");}
 		catch (PrismException e2) {KanoaErrorHandler.ErrorSetUpPrism(e2);}
 				
 		try {prism.initialise();}
 		catch (PrismException e1) {KanoaErrorHandler.PrismNotInitialising(e1,"Try 1");}
 		
 		try {prism.initialise();}
 		catch (PrismException e) {KanoaErrorHandler.PrismNotInitialising(e,"Try 2");}
 		this.PRISM = prism;
 		
	}
	
	/**Upper bounds is an array of size = number of robots
	 * and numbers being the number of possible permutations
	 * of each robot's tasks.
	 * For example, for two robot with three tasks each:
	 * bounds = [3!,3!] = [6,6]
	 * . */
	public  List<Integer> getUpperBounds(Allocation a) {
		ArrayList<Integer> bounds = new ArrayList<Integer>();
		for(String r:a.getRobots()) {
			int nTasks = Utility.getFactorial(a.getTasks(r).size());
			bounds.add(nTasks);
		}
		return (List<Integer>) bounds;
	}
	/**Lower bounds is an array of size = number of robots
	 * and 1's, as they start with permutation number 1. 
	 * For example, for two robot with three tasks each:
	 * = [1,1] */
	public List<Integer> getLowerBounds(Allocation a){
		return new ArrayList<Integer>(Collections.nCopies(a.getNumRobots(),1));
	}
	
	
	
	/** b) Evaluate() method. Method for evaluating any solution of class IntegerSolution.
	 *  Description from org.uma.jmetal.problem.Problem:
	 * 	This method receives a solution, evaluates it, and returns the evaluated solution.
	 *  Example: org.uma.jmetal.problem.multiobjective.zdt ZDT1
	 * @return  solution - updated solution with objective values
	 */
	@Override
	public IntegerSolution evaluate(IntegerSolution solution)  {
		
		
		// 1) get genes as string
		String genesString = getGenesString(solution);
		System.out.println("\n:: Genes:" + genesString + "  ::Alloc:" + this.allocation.getNum());
		
		// 2) evaluate gene
		double[] res = Auxx.evalChromosomeMDP(solution,genesString,allocation,PRISM,p); //results

		// 3) save results to solution object
		for(int i=0; i<res.length-1 ; i++) {
			System.out.println("::obj result"+i+": "+res[i]);
			solution.objectives()[i] = res[i];
		}
		System.out.println("::constraint 0:"+res[res.length-1]);
		solution.constraints()[0] = res[res.length-1];// res[res.length-1];	 //constrained by feasible permutation	
		
		// add file info
		
		long time = Timer.getTime_restart();
		solution.attributes().put("fileAlloc", allocation.getFile());
		solution.attributes().put("allocNum", allocation.getNum());
		solution.attributes().put("atributes", p.getParameters().getListObjectiveStrings());
		solution.attributes().put("time", time);
		
		//print timer
		System.out.println("Time to eval chromosome: "+ time + "ms");
		
		return solution;
	  }
	
	
	public static String getGenesString(IntegerSolution solution) {
		String genesStr = "(";
		String genesString = null;
		for (int i = 0; i < solution.variables().size(); i++) {
			Integer s = solution.variables().get(i); //get gene value
			genesStr = genesStr + String.valueOf(s) + ",";}
		return genesStr.substring(0,genesStr.length()-1) + ")";
	}
	
	
	
	/* This creates solutions before running the algorithm.  For example, if population=20, creates 20 chromosomes (not evaluated yet), just their values. */
	@Override
	public IntegerSolution createSolution() { return new DefaultIntegerSolution(getNumberOfObjectives(), getNumberOfConstraints(),getBoundsForVariables()); }
	

}
