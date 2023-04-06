package uoy.mrs.uoy.mrs.auxiliary.jmetal;

import org.uma.jmetal.problem.integerproblem.impl.AbstractIntegerProblem;
import org.uma.jmetal.solution.integersolution.IntegerSolution;
import org.uma.jmetal.solution.integersolution.impl.DefaultIntegerSolution;

import parser.ast.ModulesFile;
import prism.Prism;
import prism.PrismDevNullLog;
import prism.PrismException;
import prism.PrismLog;
import prism.PrismSettings;
import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.Timer;
import uoy.mrs.uoy.mrs.types.Allocation;

/**
 * For an example, check org.uma.jmetal.problem.multiobjective.zdt ZDT1;
 * @author gris
 *
 */
public class AllocationProblem extends AbstractIntegerProblem {
	
	
	private static final long serialVersionUID = 1L;
	
	
	Allocation allocation; // save info about allocation
	
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
	
	/** Constructor */
	public AllocationProblem(Allocation a) {
		setName(a.name);
		setNumberOfVariables(a.getNumRobots());
	    setNumberOfObjectives(Constants.num_objectives);
	    setNumberOfConstraints(1);
		setVariableBounds(a.lowerBounds, a.upperBounds);
	    // set allocation
	    allocation = a;
	    // initialise PRISM engine     --- it takes 2ms less if initialized here, rather than from Constants.initializePrism
 		PrismLog mainLog = new PrismDevNullLog(); //new PrismFileLog("stdout");   // Create a log for PRISM output (hidden or stdout)
 		Prism prism = new Prism(mainLog);
 		
 		//configure memory   - from example: prism.getSettings().set(PrismSettings.PRISM_EXPORT_ADV, "DTMC");
 		try {
			prism.getSettings().set(PrismSettings.PRISM_CUDD_MAX_MEM , "30g");
		} catch (PrismException e2) {
			// TODO Auto-generated catch block
			System.err.println("Error configuring Prism.");
			System.exit(0);
			e2.printStackTrace();
		}
 				
 		try {
			prism.initialise();
		} catch (PrismException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.err.println("Error initialising Prism.");
			System.exit(0);
		}
 		
 		try {
			prism.initialise();
		} catch (PrismException e) {
			e.printStackTrace();
		}
 		this.PRISM = prism;
 		
	}
	
	
	
	/** Evaluate() method. Method for evaluating any solution of class IntegerSolution.
	 *  Description from org.uma.jmetal.problem.Problem:
	 * 	This method receives a solution, evaluates it, and returns the evaluated solution.
	 *  Example: org.uma.jmetal.problem.multiobjective.zdt ZDT1
	 * @return  solution - updated solution with objective values
	 */
	@Override
	public IntegerSolution evaluate(IntegerSolution solution)  {
		
		
		// 1) get genes as string
		String genesString = Auxx.getGenesString(solution);
		System.out.println("\n- Genes:" + genesString + " - " + this.allocation.name);
		
		// 2) evaluate gene
		double[] res = Auxx.evalChromosomeMDP(solution,genesString,allocation,PRISM); //results
			
		// 3) save results to solution object
		solution.objectives()[0] = res[0];
		solution.objectives()[1] = res[1];
		solution.objectives()[2] = res[2];
		solution.constraints()[0] = res[3];	 //constrained by feasible permutation	
		
		// add file info
		
		long time = Timer.getTime_restart();
		solution.attributes().put("file", allocation.file);
		solution.attributes().put("time", time);
		
		//print timer
		System.out.println("Time to eval chromosome: "+ time + "ms");
		
		return solution;
	  }
	
	
	
	/* This creates solutions before running the algorithm.  For example, if population=20, creates 20 chromosomes (not evaluated yet), just their values. */
	@Override
	public IntegerSolution createSolution() { return new DefaultIntegerSolution(getNumberOfObjectives(), getNumberOfConstraints(),getBoundsForVariables()); }
	

}
