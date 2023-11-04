package uoy.mrs.uoy.mrs.auxiliary.jmetal;

import java.util.List;
import java.util.stream.Collectors;

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
import org.uma.jmetal.util.ConstraintHandling;
import org.uma.jmetal.util.evaluator.impl.SequentialSolutionListEvaluator;

import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.types.Allocation;
public class PlanScheduler extends AbstractAlgorithmRunner{
	
	static List<Allocation> allocations;
	
	// 1) set allocations
	public static void setAllocations(List<Allocation> a) {
		allocations  =a;
	}
	
	// 2) run for all allocations
	public static void run() {
		Utility.createEmptyFile(Constants.allsolutionsMDPFiles);// create output file
    	runner();
	}
	
	// 3) GA runner
	@SuppressWarnings("rawtypes")
	public static void runner() {
		
		// a) set MRS problem									// based on https://jmetal.readthedocs.io/en/latest/experimentation.html
		PlanProblem problem = new PlanProblem();
		
		// crossover
		double crossoverProbability = 0.95;
		double crossoverDistributionIndex = 5.0;
		CrossoverOperator<IntegerSolution> crossover = new IntegerSBXCrossover(crossoverProbability, crossoverDistributionIndex); //CrossoverOperator<DoubleSolution> crossover = new SBXCrossover(crossoverProbability, crossoverDistributionIndex);
		// mutation
		double mutationProbability = 0.9;//1.0 / problem.getNumberOfVariables();
		double mutationDistributionIndex = 5;//10.0;
		MutationOperator<IntegerSolution> mutation = new IntegerPolynomialMutation(mutationProbability, mutationDistributionIndex);  //MutationOperator<DoubleSolution> mutation = new PolynomialMutation(mutationProbability, mutationDistributionIndex);
		
		
		
		int populationSize = Integer.parseInt(Constants.num_population);
		
		if (populationSize==1) {
			System.out.println("Only one solution found. Check MDP files.");
			System.exit(0);
		}
		else if ( (populationSize & 1) != 0 ) { populationSize--; } //if 2, then take the two, if more than 3, divide by 2 and round up. Note: population size MUST be even in JMetal.
		
		
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
											new SequentialSolutionListEvaluator<PlanProblem>() // evaluator
											);
		
		
		// c) ------ run GA algorithm	-------					// instead of algorithm.run(); to get more info
		AlgorithmRunner algorithmRunner = new AlgorithmRunner.Executor(algorithm).execute() ;
		
		// d) read and save solutions
		//List<IntegerSolution> populationSolution = algorithm.getResult() ;
		//List<IntegerSolution> populationSolution = algorithm.getResult().stream().filter(
		//        ConstraintHandling::isFeasible).collect(Collectors.toList());
		List<IntegerSolution> populationSolution =  (List<IntegerSolution>)(Object) algorithm.getResult().stream().filter(ConstraintHandling::isFeasible).collect(Collectors.toList()); 
		
		// - print info and save 
		Utility.WriteToFile(Constants.optimisedSolutionsData, "prob,idle,travel,feasible,allocation,clusters,permutation");
	    
		
		
		for (IntegerSolution solution_i : populationSolution) {
	    	
	    	
	    	// 1) get gene from solution
			Integer gene = solution_i.variables().get(0);
			System.out.println("\n- Gene:" + gene );
			// 2) print solution
			System.out.println( solution_i.toString() );
			
			// 3) save
			Utility.WriteToFile(Constants.optimisedSolutionsData,solution_i.toString());
		}
		System.out.println("GA Done");	    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 3) GA runner
		@SuppressWarnings("rawtypes")
		public static void runnerTest() {
			
			// a) set MRS problem									// based on https://jmetal.readthedocs.io/en/latest/experimentation.html
			PlanProblem problem = new PlanProblem();
			
			// crossover
			double crossoverProbability = 0.95;
			double crossoverDistributionIndex = 5.0;
			CrossoverOperator<IntegerSolution> crossover = new IntegerSBXCrossover(crossoverProbability, crossoverDistributionIndex); //CrossoverOperator<DoubleSolution> crossover = new SBXCrossover(crossoverProbability, crossoverDistributionIndex);
			// mutation
			double mutationProbability = 0.9;//1.0 / problem.getNumberOfVariables();
			double mutationDistributionIndex = 5;//10.0;
			MutationOperator<IntegerSolution> mutation = new IntegerPolynomialMutation(mutationProbability, mutationDistributionIndex);  //MutationOperator<DoubleSolution> mutation = new PolynomialMutation(mutationProbability, mutationDistributionIndex);
			
			
			
			int populationSize = Integer.parseInt(Constants.num_population);
			
			if (populationSize==1) {
				System.out.println("Only one solution found. Check MDP files.");
				System.exit(0);
			}
			else if ( (populationSize & 1) != 0 ) { populationSize--; } //if 2, then take the two, if more than 3, divide by 2 and round up. Note: population size MUST be even in JMetal.
			
			
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
												new SequentialSolutionListEvaluator<PlanProblem>() // evaluator
												);
			
			
			// c) ------ run GA algorithm	-------					// instead of algorithm.run(); to get more info
			AlgorithmRunner algorithmRunner = new AlgorithmRunner.Executor(algorithm).execute() ;
			
			// d) read and save solutions
			//List<IntegerSolution> populationSolution = algorithm.getResult() ;
			//List<IntegerSolution> populationSolution = algorithm.getResult().stream().filter(
			//        ConstraintHandling::isFeasible).collect(Collectors.toList());
			List<IntegerSolution> populationSolution =  (List<IntegerSolution>)(Object) algorithm.getResult().stream().filter(ConstraintHandling::isFeasible).collect(Collectors.toList()); 
			
			// - print info and save 
			Utility.WriteToFile(Constants.optimisedSolutionsData, "prob,idle,travel,feasible,allocation,clusters,permutation");
		    
			
			
			for (IntegerSolution solution_i : populationSolution) {
		    	
		    	
		    	// 1) get gene from solution
				Integer gene = solution_i.variables().get(0);
				System.out.println("\n- Gene:" + gene );
				// 2) print solution
				System.out.println( solution_i.toString() );
				
				// 3) save
				Utility.WriteToFile(Constants.optimisedSolutionsData,solution_i.toString());
			}
			System.out.println("GA Done");	    
		}
	
	public static void main( String[] args )  throws Exception{
		System.out.println("Hi");
		runnerTest();
	}

}



