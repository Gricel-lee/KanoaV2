package jmetaltest;

import java.io.IOException;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
//import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.examples.AlgorithmRunner;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAII;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIBuilder;
import org.uma.jmetal.operator.crossover.CrossoverOperator;
import org.uma.jmetal.operator.crossover.impl.SBXCrossover;
import org.uma.jmetal.operator.mutation.MutationOperator;
import org.uma.jmetal.operator.mutation.impl.PolynomialMutation;
import org.uma.jmetal.operator.selection.SelectionOperator;
import org.uma.jmetal.operator.selection.impl.BinaryTournamentSelection;
import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.problem.ProblemFactory;
//import org.uma.jmetal.qualityindicator.QualityIndicatorUtils;
//import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.solution.doublesolution.DoubleSolution;
import org.uma.jmetal.util.AbstractAlgorithmRunner;
import org.uma.jmetal.util.JMetalLogger;
//import org.uma.jmetal.util.SolutionListUtils;
//import org.uma.jmetal.util.VectorUtils;
//import org.uma.jmetal.util.comparator.RankingAndCrowdingDistanceComparator;
import org.uma.jmetal.util.errorchecking.JMetalException;

//import org.uma.jmetal.problem.multiobjective.Kursawe;

/**
 * Class to configure and run the NSGA-II algorithm to solve problem ZDT1
 *
 * @author Antonio J. Nebro <antonio@lcc.uma.es>
 */
public class run extends AbstractAlgorithmRunner {
	
	public static ArrayList<ArrayList<String>> initRobAllocList(){
		ArrayList<ArrayList<String>> groupsOfRob = new ArrayList<>();
		List<String> g1 = new ArrayList<>(Arrays.asList("r1","r2"));
		List<String> g2 = new ArrayList<>(Arrays.asList("r4"));
		groupsOfRob.add((ArrayList<String>) g1);
		groupsOfRob.add((ArrayList<String>) g2);		
		return groupsOfRob;
	}
	public static HashMap<String, ArrayList<String>> initRobotTasks(){
		HashMap<String, ArrayList<String>> robotToAtomicTasksIds = new HashMap<String, ArrayList<String>>();
		
		ArrayList<String> t1 = new ArrayList<>(Arrays.asList("at1_1","at1_12"));
		ArrayList<String> t2 = new ArrayList<>(Arrays.asList("at2_1","at2_2"));
		ArrayList<String> t3 = new ArrayList<>(Arrays.asList("at3_1","at3_2"));
		robotToAtomicTasksIds.put("r1", t1);
		robotToAtomicTasksIds.put("r2", t2);
		robotToAtomicTasksIds.put("r3", t3);		
		return robotToAtomicTasksIds;
	}
	
	/*
	 *
	 */
	public static void main(String[] args) throws JMetalException, IOException {
		ArrayList<ArrayList<String>> groupsOfRobot = initRobAllocList();
		System.out.println(groupsOfRobot);
		HashMap<String, ArrayList<String>> robotToAtomicTasksIds = initRobotTasks();
		System.out.println(robotToAtomicTasksIds);

		String problemName = "jmetaltest.Problem2Objectives";
		Problem<DoubleSolution> problem = ProblemFactory.<DoubleSolution>loadProblem(problemName);
	
	
	double crossoverProbability = 0.9;
	double crossoverDistributionIndex = 20.0;
	CrossoverOperator<DoubleSolution> crossover = new SBXCrossover(crossoverProbability,
	    crossoverDistributionIndex);

	double mutationProbability = 1.0 / problem.numberOfVariables();
	double mutationDistributionIndex = 20.0;
	MutationOperator<DoubleSolution> mutation = new PolynomialMutation(mutationProbability,
	    mutationDistributionIndex);

	SelectionOperator<List<DoubleSolution>, DoubleSolution> selection = new BinaryTournamentSelection<DoubleSolution>();
	
	int populationSize = 100;
	NSGAII<DoubleSolution> algorithm =
	    new NSGAIIBuilder<>(problem, crossover, mutation, populationSize)
	        .setSelectionOperator(selection)
	        .setMaxEvaluations(25000)
	        .build();

    AlgorithmRunner algorithmRunner = new AlgorithmRunner.Executor(algorithm).execute();

    List<DoubleSolution> population = algorithm.result();
    long computingTime = algorithmRunner.getComputingTime();

    JMetalLogger.logger.info("Total execution time: " + computingTime + "ms");

    printFinalSolutionSet(population);
//    QualityIndicatorUtils.printQualityIndicators(
//        SolutionListUtils.getMatrixWithObjectiveValues(population),
//        VectorUtils.readVectors(referenceParetoFront, ","));
  }
}
