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
	
	
	Allocation a1; // save info about allocation
	
	ProblemSpecification p;
	
	Prism PRISM; // prism instance
	
	ModulesFile modulesFile; //modules from prism
	
	// counter for average times
	int countFeas = 0;
	int countTotal = 0;
	
	/** a) Constructor */
	public AllocationProblem(Allocation a, ProblemSpecification p) {
		setName("Allocation"+a.getNum());
		setNumberOfVariables(a.getNumRobots());
	    setNumberOfObjectives(p.getParameters().getNumObjectives());
	    //setNumberOfConstraints(1); // as JMetal not consider constraints to remove solutions but as a quality parameter (the less constraints violated the better), not considered here -- before: constraint meant permutation must be feasible
		setVariableBounds(getLowerBounds(a), getUpperBounds(a));
		// set local variables
	    this.a1 = a; this.p = p;
	    // initialise PRISM engine     --- it takes 2ms less if initialised here, rather than from Constants.initializePrism
 		PrismLog mainLog = new PrismDevNullLog(); //new PrismFileLog("stdout");   // Create a log for PRISM output (hidden or stdout)
 		Prism prism = new Prism(mainLog);
 		
 		//configure memory    - from example: prism.getSettings().set(PrismSettings.PRISM_EXPORT_ADV, "DTMC");
 		try {prism.getSettings().set(PrismSettings.PRISM_CUDD_MAX_MEM , "30g");}
 		catch (PrismException e2) {KanoaErrorHandler.ErrorSetUpPrism(e2);}
 				
 		try {prism.initialise();}
 		catch (PrismException e1) {KanoaErrorHandler.PrismNotInitialising(e1,"Try 1");}
 		
 		try {prism.initialise();}
 		catch (PrismException e) {KanoaErrorHandler.PrismNotInitialising(e,"Try 2");} //sometimes retry required
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
		for(String r:a.getRobotsList()) {
			int nTasks = a.getNumTaskPermutations(r);
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
		// get genes as string
		String permutationString = getGenesString(solution);
		// get attributes
		double[] attr = Scheduler.getAttrib(p,a1,permutationString); //permutationString e.g., (5,3,1,2,58)

		// save to JMetal solution
		for(int i=0; i<attr.length ; i++) { solution.objectives()[i] = attr[i];}//System.out.println(solution.objectives()[i]);}
		//count fesible solutions
		if(attr[0]!= (double) Utility.infiniteInt ) {countFeas+=1;countTotal+=1;}//System.out.println("feasible");}
		else {countTotal+=1;}
		
		//get time
		long time = Timer.getTime_restart();
		System.out.println("Time to eval chromosome: "+ time + "ms");
		// add solution info in JMetal
		solution.attributes().put("perm", permutationString);
		solution.attributes().put("attr", p.getParameters().getListObjectiveStrings());
		solution.attributes().put("time", time);
		return solution;
	  }
	
	
	public static String getGenesString(IntegerSolution solution) {
		String genesStr = "(";
		for (int i = 0; i < solution.variables().size(); i++) {
			Integer s = solution.variables().get(i); //get gene value
			genesStr = genesStr + String.valueOf(s) + ",";}
		return genesStr.substring(0,genesStr.length()-1) + ")";
	}
	
	
	

}
