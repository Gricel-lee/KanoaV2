package uoy.mrs.uoy.mrs.auxiliary.scheduler;

import java.util.List;
import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAII;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIBuilder;
import org.uma.jmetal.example.AlgorithmRunner;
import org.uma.jmetal.operator.crossover.CrossoverOperator;
import org.uma.jmetal.operator.crossover.impl.IntegerSBXCrossover;
import org.uma.jmetal.operator.crossover.impl.SBXCrossover;
import org.uma.jmetal.operator.mutation.MutationOperator;
import org.uma.jmetal.operator.mutation.impl.IntegerPolynomialMutation;
import org.uma.jmetal.operator.mutation.impl.PolynomialMutation;
import org.uma.jmetal.operator.selection.SelectionOperator;
import org.uma.jmetal.operator.selection.impl.BinaryTournamentSelection;
import org.uma.jmetal.operator.selection.impl.RandomSelection;
import org.uma.jmetal.solution.doublesolution.DoubleSolution;
import org.uma.jmetal.solution.integersolution.IntegerSolution;
import org.uma.jmetal.util.AbstractAlgorithmRunner;
import org.uma.jmetal.util.JMetalLogger;
import org.uma.jmetal.util.evaluator.impl.SequentialSolutionListEvaluator;

import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;
import uoy.mrs.uoy.mrs.types.impl.Allocation;

public class Scheduler extends AbstractAlgorithmRunner{
	

	public static void run(ProblemSpecification p) {
		System.out.println(""+ p.getParameters().getNumObjectives()+" objectives:"+p.getParameters().getListObjectiveStrings());
	    
		for (Allocation a: p.getAllocationsInfo()) {
			System.out.println("\n-Running scheduler for allocation: "+a.getNum());
			System.out.println("-robot clusters: "+a.getGroupsOfRobot());
			runner(a,p);
		}
	}
	
	// 3) GA runner
	public static void runner(Allocation a, ProblemSpecification p) {
		// a) MRS problem									// based on https://jmetal.readthedocs.io/en/latest/experimentation.html
		AllocationProblem problem = new AllocationProblem(a,p);
		
		// print
		//System.out.println("Scheduler name:" + problem.getName());
		//System.out.println("Num of Objectives:"+problem.getNumberOfObjectives());
		//System.out.println("Num Constraints:" + problem.getNumberOfConstraints());
		//System.out.println("Num of Variables (robots):"+problem.getNumberOfVariables());
		
		// crossover
		double crossoverProbability = 0.95;
		// - example: double crossoverProbability = 0.9;
		
		double crossoverDistributionIndex = 5.0;
		//-example: double crossoverDistributionIndex = 20.0;
		
		CrossoverOperator<IntegerSolution> crossover = new IntegerSBXCrossover(crossoverProbability, crossoverDistributionIndex); //CrossoverOperator<DoubleSolution> crossover = new SBXCrossover(crossoverProbability, crossoverDistributionIndex);
		//-example: CrossoverOperator<DoubleSolution> crossover = new SBXCrossover(crossoverProbability, crossoverDistributionIndex);
		
		
		// mutation
		//- PlanScheduler
		double mutationProbability = 0.9;
		//- AllocationScheduler and example: double mutationProbability = 1.0 / problem.getNumberOfVariables();
		
		double mutationDistributionIndex = 10.0;
		//- example: 20, plan schedule =5
		
		MutationOperator<IntegerSolution> mutation = new IntegerPolynomialMutation(mutationProbability, mutationDistributionIndex);  //MutationOperator<DoubleSolution> mutation = new PolynomialMutation(mutationProbability, mutationDistributionIndex);
		// -example: MutationOperator<DoubleSolution> mutation = new PolynomialMutation(mutationProbability,mutationDistributionIndex);
		
		
		//new PolynomialMutation(1.0/problem.getNumberOfVariables() , 20 )
		//Termination termination = new TerminationByEvaluations(75000);
		//Ranking<DoubleSolution> ranking = new MergeNonDominatedSortRanking<>();
		
		//HERE:----CHANGE it to be proportional to the number of possible permutations
		int populationSize = 10; //HAS to be even num.
		
		// b) set NSGAII algorithm
		@SuppressWarnings("unchecked")   // solutions are DOUBLE, genes are INTEGERS
		Algorithm<List<IntegerSolution>> algorithm22 = new NSGAII( // following example of builder from: org.uma.jmetal.algorithm.multiobjective.nsgaii
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
		
		SelectionOperator<List<IntegerSolution>, IntegerSolution> selection = new BinaryTournamentSelection<IntegerSolution>();
		
		
		
		NSGAII<IntegerSolution> algorithm =
		    new NSGAIIBuilder<>(problem, crossover, mutation, populationSize)
		        .setSelectionOperator(selection)
		        .setMaxEvaluations(600)//25000)
		        .build();
		
		
		
		// c) ------ run GA algorithm	-------					// instead of algorithm.run(); to get more info
		System.out.println("HERE: running?");
		AlgorithmRunner algorithmRunner = new AlgorithmRunner.Executor(algorithm).execute() ;
		
		// d) read and save solutions
		List<IntegerSolution> populationSolution = algorithm.getResult() ;
	    long computingTime = algorithmRunner.getComputingTime() ;
	    JMetalLogger.logger.info("Total execution time: " + computingTime + "ms");

	    printFinalSolutionSet(populationSolution);
	    
	    // - print info
	    System.out.println("Total execution time: " + computingTime + "ms");
	    
	    //System.out.println("PARETO FRONT SOLUTIONS:");
	    System.out.println("Pareto solutions of allocation: "+a.getNum());
	    for (IntegerSolution solution_i : populationSolution) {
	    	System.out.println( solution_i.toString() );
	    }
	    // - save // this method do not work as solutions return feasible and unfeasible solutions
	    //printFinalSolutionSet(populationSolution) ;
	    
		System.out.println("GA Done");			
	}
	
	
	
}



