package uoy.mrs.uoy.mrs.auxiliary.scheduler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAII;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIBuilder;
import org.uma.jmetal.example.AlgorithmRunner;
import org.uma.jmetal.operator.crossover.CrossoverOperator;
import org.uma.jmetal.operator.crossover.impl.IntegerSBXCrossover;
import org.uma.jmetal.operator.mutation.MutationOperator;
import org.uma.jmetal.operator.mutation.impl.IntegerPolynomialMutation;
import org.uma.jmetal.operator.selection.SelectionOperator;
import org.uma.jmetal.operator.selection.impl.BinaryTournamentSelection;
import org.uma.jmetal.operator.selection.impl.RandomSelection;
import org.uma.jmetal.solution.integersolution.IntegerSolution;
import org.uma.jmetal.util.AbstractAlgorithmRunner;
import org.uma.jmetal.util.JMetalLogger;
import org.uma.jmetal.util.evaluator.impl.SequentialSolutionListEvaluator;

import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.auxiliary.scheduler.modelA.MDPModelA;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;
import uoy.mrs.uoy.mrs.types.impl.Allocation;
import uoy.mrs.uoy.mrs.types.impl.Robot;

public class Scheduler extends AbstractAlgorithmRunner{
	

	public static void run(ProblemSpecification p) {
		System.out.println(""+ p.getParameters().getNumObjectives()+" objectives:"+p.getParameters().getListObjectiveStrings());
	    
		// -- run
		for (Allocation a: p.getAllocations()) {
			System.out.println("\n-Running scheduler for allocation: "+a.getNum());
			System.out.println("-robot clusters: "+a.getGroupsOfRobot());
			runner(a,p);
		}
	}
	
	// --for tests
	public static void runTest(ProblemSpecification p) {
		// Test creating models A, B and C for a specific allocation & permutation
		
		//1 get info
		Allocation a1 = p.getAllocations().get(0);
		// permutation as String: JMetal output as a string: (1,1,1,1,443438)
		String geneString = getMadeUpPermuation_forTest(a1,p);
		//permutation as hashmap<robotID,numOfPermutation>
		HashMap<String,Integer> robots2PermNum = getrobots2PermuationNumberArray(a1,p,geneString);
		
		
		//2 create string permutation for testing, in JMetal encoded 
		
		System.out.println("alloc:" + a1.getNum());
		System.out.println("rob:" +a1.getRobotsList());
		System.out.println("test perm"+geneString);
		MDPModelA.createModelA(robots2PermNum,p,a1);
	}
	
	private static HashMap<String, Integer> getrobots2PermuationNumberArray(Allocation a1, ProblemSpecification p,String geneString) {
		HashMap<String, Integer> robots2PermNum = new HashMap<String, Integer>();
		
		//e.g. geneString= "(2,2,479001600)" -> "2,2,479001600"
		geneString=Utility.removeFirstChars(geneString,1);
		geneString=Utility.removeLastChar(geneString);
		//split
		String[] l = geneString.split(",");
		for (int i = 0; i < l.length; i++) {
			int gene = Utility.string2int(l[i]);
			String robotID = a1.getRobotsList().get(i);
			robots2PermNum.put(robotID , gene);
		}
		return robots2PermNum;
	}

	private static String getMadeUpPermuation_forTest(Allocation a1,ProblemSpecification p) {
		String s = "(";
		for (int i = 0; i < a1.getRobotsList().size(); i++) {
			String rID = a1.getRobotsList().get(i);
			Robot r = p.getRobotsModel().getRob(rID);
			int r_max_permut = a1.getNumTaskPermutations(rID);
			s+=r_max_permut+",";
		}
		s = Utility.removeLastChars(s, 1)+")";
		return s;
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



