package uoy.mrs.uoy.mrs.auxiliary.jmetal;

import java.util.List;

import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAII;
import org.uma.jmetal.example.AlgorithmRunner;
import org.uma.jmetal.operator.crossover.CrossoverOperator;
import org.uma.jmetal.operator.crossover.impl.IntegerSBXCrossover;
import org.uma.jmetal.operator.mutation.MutationOperator;
import org.uma.jmetal.operator.mutation.impl.IntegerPolynomialMutation;
import org.uma.jmetal.operator.selection.impl.RandomSelection;
import org.uma.jmetal.solution.integersolution.IntegerSolution;
import org.uma.jmetal.util.AbstractAlgorithmRunner;
import org.uma.jmetal.util.JMetalLogger;
import org.uma.jmetal.util.evaluator.impl.MultiThreadedSolutionListEvaluator;
import org.uma.jmetal.util.evaluator.impl.SequentialSolutionListEvaluator;

import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.Timer;
import uoy.mrs.uoy.mrs.types.Allocation;
public class AllocationScheduler extends AbstractAlgorithmRunner{
	
	static List<Allocation> allocations;
	
	// 1) set allocations
	public static void setAllocations(List<Allocation> a) {
		allocations  =a;
	}
	
	// 2) run for all allocations
	public static void run() {
		Auxx.saveFile(); // initiate solutions file
		// - run GA for each allocations
		for (Allocation a: allocations) {
			runner(a);
		}
		
	}
	
	// 3) GA runner
	@SuppressWarnings("rawtypes")
	public static void runner(Allocation a) {
		
		// a) set MRS problem									// based on https://jmetal.readthedocs.io/en/latest/experimentation.html
		AllocationProblem problem = new AllocationProblem(a);
		// print
		
		//System.out.println("Scheduler name:" + problem.getName());
		//System.out.println("Num of Objectives:"+problem.getNumberOfObjectives());
		//System.out.println("Num Constraints:" + problem.getNumberOfConstraints());
		//System.out.println("Num of Variables (robots):"+problem.getNumberOfVariables());
		
		// crossover
		double crossoverProbability = 0.95;
		double crossoverDistributionIndex = 5.0;
		CrossoverOperator<IntegerSolution> crossover = new IntegerSBXCrossover(crossoverProbability, crossoverDistributionIndex); //CrossoverOperator<DoubleSolution> crossover = new SBXCrossover(crossoverProbability, crossoverDistributionIndex);
		// mutation
		double mutationProbability = 1.0 / problem.getNumberOfVariables();
		double mutationDistributionIndex = 10.0;
		MutationOperator<IntegerSolution> mutation = new IntegerPolynomialMutation(mutationProbability, mutationDistributionIndex);  //MutationOperator<DoubleSolution> mutation = new PolynomialMutation(mutationProbability, mutationDistributionIndex);
		
		//new PolynomialMutation(1.0/problem.getNumberOfVariables() , 20 )
		//Termination termination = new TerminationByEvaluations(75000);
		//Ranking<DoubleSolution> ranking = new MergeNonDominatedSortRanking<>();
		
		int populationSize = Integer.parseInt(Constants.num_population);		
		
		// b) set NSGAII algorithm
		@SuppressWarnings("unchecked")   // solutions are DOUBLE, genes are INTEGERS
		Algorithm<List<IntegerSolution>> algorithm = new NSGAII( // following example of builder from: org.uma.jmetal.algorithm.multiobjective.nsgaii
											problem,
											Integer.parseInt(Constants.num_evaluations),//maxEvaluations
											populationSize, //populationSize
											populationSize, //matingPoolSize
											populationSize, //offspringSize
											crossover, //crossoverOperator
											mutation, //mutationOperator  - second parameter: distribution index: he distribution index η in the SBX operator controls the distance between two offsprings and two parents. If the value of η is large, the probability that the generated offsprings are closer to the two parents is greater; if the value of η is relatively small, the probability that the generated offsprings are farther away from the two parents is greater. 
											new RandomSelection(), //selectionOperator     - I selected randomed based on results table from: https://www.researchgate.net/publication/2372815_Comparison_of_Selection_Methods_for_Evolutionary_Optimization
											//new MultiThreadedSolutionListEvaluator<AllocationProblem>(1) //not working
											new SequentialSolutionListEvaluator<AllocationProblem>() // evaluator
											);
		
		
		// c) ------ run GA algorithm	-------					// instead of algorithm.run(); to get more info
		AlgorithmRunner algorithmRunner = new AlgorithmRunner.Executor(algorithm).execute() ;
		
		// d) read and save solutions
		List<IntegerSolution> populationSolution = algorithm.getResult() ;
	    long computingTime = algorithmRunner.getComputingTime() ;
	    // - print info
	    System.out.println("Total execution time: " + computingTime + "ms");
	    
	    //System.out.println("PARETO FRONT SOLUTIONS:");
	    System.out.println("Pareto solutions of allocation: "+a.name);
	    for (IntegerSolution solution_i : populationSolution) {
	    	System.out.println( solution_i.toString() );
	    }
	    // - save // this method do not work as solutions return feasible and unfeasible solutions
	    //printFinalSolutionSet(populationSolution) ;
	    
		
		
		
		System.out.println("GA Done");
		
		
		
		
		/*
		new SolutionListOutput(solutionList)
	    .setVarFileOutputContext(new DefaultFileOutputContext("VAR_SET.csv", ","))
	    .setFunFileOutputContext(new DefaultFileOutputContext("PARETO_FRONT.csv", ","))
	    .print();
	    */
		
		//.setVarFileOutputContext(new DefaultFileOutputContext(a.name_alloc + "VAR_SET.csv", ","))
	    //.setFunFileOutputContext(new DefaultFileOutputContext(a.name_alloc + "PARETO_FRONT.csv", ","))
		    
	}
	

}



