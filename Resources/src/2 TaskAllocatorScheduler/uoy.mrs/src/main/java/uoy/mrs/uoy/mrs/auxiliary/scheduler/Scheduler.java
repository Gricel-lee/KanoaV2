package uoy.mrs.uoy.mrs.auxiliary.scheduler;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.netlib.util.doubleW;
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
import uoy.mrs.uoy.mrs.auxiliary.scheduler.modelA.MDPModelB;
import uoy.mrs.uoy.mrs.auxiliary.scheduler.modelA.MDPModelC;
import uoy.mrs.uoy.mrs.error.KanoaErrorHandler;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;
import uoy.mrs.uoy.mrs.types.impl.Allocation;
import uoy.mrs.uoy.mrs.types.impl.Permutation;
import uoy.mrs.uoy.mrs.types.impl.Robot;

public class Scheduler extends AbstractAlgorithmRunner{
	

	public static void run(ProblemSpecification p) {
		System.out.println(""+ p.getParameters().getNumObjectives()+" objectives:"+p.getParameters().getListObjectiveStrings());
		
		// -- new databases
		startDatabases();
		
	    // -- run
		for (Allocation a: p.getAllocations()) {
			System.out.println("\n-Running scheduler for allocation: "+a.getNum());
			System.out.println("-robot clusters: "+a.getGroupsOfRobot());
			runner(a,p);
		}
	}
	
	
	
	/*
	 * Create new databases to save: 1) optimal, 2) feasible (optimal and suboptimal) and 3) unfeasible solutions
	 */
	public static void startDatabases() {
		Utility.checkPath(Constants.solutionsDatabasesDir);//check if folder exists
		Utility.createEmptyFile(Constants.db1_optimisedSolutions);
		Utility.createEmptyFile(Constants.db2_feasibleSolutions);
		Utility.createEmptyFile(Constants.db3_infeaibleSolutions);
		// -- Header database 1 = Pareto-optimal solutions per allocation 
		String header1 = "allocationNum,,robots,,permutation,,robotClusters,,idle,,rateSucc,,travelCost\n";
		Utility.WriteToFile(header1 ,Constants.db1_optimisedSolutions);
		// --Header database 2 = Feasible solutions (optimal and sub-optimal)
		String header2 = "allocationNum,,robots,,permutation,,robotClusters,,idle,,rateSucc,,travelCost\n";
		Utility.WriteToFile(header2 ,Constants.db2_feasibleSolutions);
		// --Header database 3 = infeasible solutions
		String header3 = "allocationNum,,robots,,permutation,,robotClusters,,idle,,rateSucc,,travelCost,,violatedReq\n";
		Utility.WriteToFile(header3 ,Constants.db3_infeaibleSolutions);
		
	}
	
	
	// --for tests
	public static ArrayList<Integer> runTest(ProblemSpecification p) {
		
		
		//---------------------------------------
		//Create new variables
		// -- new databases
		System.out.println("HI");
		startDatabases();
		// -- new array for optimisation objectives names to values
		HashMap<String, Integer> objectiveValuesHashmap = new HashMap<String, Integer>(); // initialise array (this could be size 1 to 3 depending on number of optimisation objectives declared in DSL)
		// -- check for feasibility (i.e., all travelling paths exists, no constraint (tasks, time, min. success rate) is violated)
		Boolean feasible = true;
		
		//---------------------------------------
		// 1 get info - create allocation (Test creating alloc./permutation)
		int allocNum = 0;
		Allocation a1 = p.getAllocations().get(allocNum); //get first allocation
		//1.1 get JMetal permutation. String type, e.g.: "(1,1,1,1,443438)" where each number is the robot's task permutation
		String geneString = getMadeUpPermuation_forTest(a1,p); // create string permutation for testing, in JMetal encoded
		//1.2 array robot ID to permutation */		
		HashMap<String, Integer> robots2PermNum = getrobots2PermuationNumberArray(a1,p,geneString);
		HashMap<String, Permutation> r_permutationTasks = getPerm(p,a1,robots2PermNum);
		//1.3 list of objectives declared in DSL
		ArrayList<String> objectiveList = p.getParameters().getListObjectiveStrings();
				
		
		//1.3 ==print==
		if(Constants.verbose) {
			System.out.println("allocation num:" + a1.getNum());
			//same as:  System.out.println("robots:" +a1.getRobotsList());
			System.out.println("a) 'robots' to permutation Number"+robots2PermNum.keySet()); //e.g.: robots2PermNum[r2, r3, r4, r5, r1]
			//same as: System.out.println("permutation"+geneString);
			System.out.println("b) robots to 'permutation Number'"+robots2PermNum.values()); //e.g.: robots2PermNum[1, 1, 2, 2, 3628800]
		}
		
		//---------------------------------------
		//2 check if all paths are feasible
		Boolean pathsTransitable = true;
		for(Permutation perm:r_permutationTasks.values()) {
			//2.1 not feasible : save in database 3 and return
			if(!perm.isFeasible_AllPathsExist) {
				KanoaErrorHandler.NoPathExistsToCompleteRunTestPermutation(robots2PermNum,perm,allocNum);
				//String header3 = "allocationNum,,robots,,permutation,,robotClusters,,idle,,rateSucc,,travelCost,,violatedReq\n";
				String s = allocNum+",,"
						+ robots2PermNum.keySet()+",,"
						+ robots2PermNum.values() +",,"
						+ a1.getGroupsOfRobot().toString() +",,"
						+ "NA" +",,"
						+ "NA" +",,"
						+ "NA" +",,"
						+ "somePathsDontExist" + "\n";
				Utility.WriteToFile(s, Constants.db3_infeaibleSolutions); //database 3
				feasible=false; //<----- infeasible
				return createInViolationList(p);
			}}
		
		//---------------------------------------
		//3 check if task permutation is feasible due to idle and task constraints (model A must not return infinite=2147483647)
		File file = MDPModelA.createModelA(r_permutationTasks,p,a1,geneString);
		int idle = getIdle(file, "R{\"idle\"}min=?[F done]");
		//3.1 not feasible : save in database 3 and return
		if(idle==2147483647) { //Infinite = 2147483647
			System.out.println("MODEL A. Plan not feasible."+idle);
			//String header3 = "allocationNum,,robots,,permutation,,robotClusters,,idle,,probSucc,,travelCost,,violatedReq\n";
			String s = allocNum+",,"
					+ robots2PermNum.keySet()+",,"
					+ robots2PermNum.values() +",,"
					+ a1.getGroupsOfRobot().toString() +",,"
					+ "NA" +",,"
					+ "NA" +",,"
					+ "NA" +",,"
					+ "idlingTimeLimitOrTaskConstraintsOrTimeLimit" + "\n";
			Utility.WriteToFile(s, Constants.db3_infeaibleSolutions); //database 3
			feasible=false; //<----- infeasible
			return createInViolationList(p);
		}
		
		//---------------------------------------
		//4) get optimisation values array (this could be 1, 2 or 3 depending on objectives declared in DSL)
		for (int i = 0; i <objectiveList.size() ; i++) {
			if(Constants.verbose) {System.out.println("Getting value of optimisation objective: "+ objectiveList.get(i));}
			// 4.1 idle
			if(objectiveList.get(i)=="minIdle") { //already computed, & feasible is this part of the code is reached
				objectiveValuesHashmap.put(objectiveList.get(i), idle);}
			// 4.2 probability of success
			else if(objectiveList.get(i)=="maxSucc") {
				double prob = MDPModelB.createModelB(r_permutationTasks,p,a1, geneString); //computed prob. of succ.
				objectiveValuesHashmap.put(objectiveList.get(i), (int) (prob*100) );}
			// 4.3 travelling cost
			else if(objectiveList.get(i)=="minTravel") {
				int travelCost = MDPModelC.createModelC(r_permutationTasks);
				objectiveValuesHashmap.put(objectiveList.get(i), travelCost);}
			// ERROR
			else {KanoaErrorHandler.ErrorObjectiveNotRecognised(objectiveList.get(i));}
		}
		// print
		if(Constants.verbose){System.out.println(objectiveValuesHashmap.toString());}
		
		
		//---------------------------------------
		//5) check violations of requirement (only rate of success missing to be checked)
		//5.1 success rate constraint - if constraint declared in DSL then !=0
		if(p.getParameters().ratesucc!="0") { 
			//5.1.2 check if prob. NOT computed as part of the optimisation objectives (otherwise calculate it as needed for this requirement)
			double succRate = 0;
			if(!objectiveValuesHashmap.keySet().contains("maxSucc"))
				succRate = MDPModelB.createModelB(r_permutationTasks,p,a1,geneString)*100;
			else
				succRate = objectiveValuesHashmap.get("maxSucc");
			//5.1.3 check if requirement does not hold (succ.rate has to be greater that N in the DSL)
			if( succRate <= Utility.string2double( p.getParameters().ratesucc )) {
				System.out.println("Plan not feasible. Success rate expected >"+p.getParameters().ratesucc+" but computed: "+succRate);
				//String header3 = "allocationNum,,robots,,permutation,,robotClusters,,idle,,rateSucc,,travelCost,,violatedReq\n";
				String s = allocNum+",,"
						+ robots2PermNum.keySet()+",,"
						+ robots2PermNum.values() +",,"
						+ a1.getGroupsOfRobot().toString() +",,"
						// ******* CHECK HERE: SOME may not have all 3 !! - only 1, or 2 
						+ objectiveValuesHashmap.get("minIdle") +",,"
						+ objectiveValuesHashmap.get("maxSucc") +",,"
						+ objectiveValuesHashmap.get("minTravel") +",,"
						+ "rateSuccessViolated" + "\n";
				Utility.WriteToFile(s, Constants.db3_infeaibleSolutions); //database 3
				feasible=false; //<----- infeasible
				return createInViolationList(p);
			}
		}
		
		//---------------------------------------
		//5) if nothing is violated, save in feasible solutions and return values
		//5.1 save
		System.out.println("Plan is feasible!");
		//String header2 = "allocationNum,,robots,,permutation,,robotClusters,,idle,,rateSucc,,travelCost\n";
		String s = allocNum+",,"
				+ robots2PermNum.keySet()+",,"
				+ robots2PermNum.values() +",,"
				+ a1.getGroupsOfRobot().toString() +",,"
				// ******* CHECK HERE: SOME may not have all 3 !! - only 1, or 2
				+ objectiveValuesHashmap.get("minIdle") +",,"
				+ objectiveValuesHashmap.get("maxSucc") +",,"
				+ objectiveValuesHashmap.get("minTravel") + "\n";
				
		Utility.WriteToFile(s, Constants.db2_feasibleSolutions); //database 2 --all feasible (including sub-optimal solutions)
		feasible=true; //<----- feasible
		
		//5.2 return
		return createFeasibleValuesList(objectiveValuesHashmap, p);
	}
	
	
	private static ArrayList<Integer> createFeasibleValuesList(HashMap<String, Integer> objectiveValuesHashmap, ProblemSpecification p) {
		ArrayList<Integer> optimisationValues = new ArrayList<Integer>();
		for(int i=0; i<p.getParameters().getListObjectiveStrings().size();i++) {
			Integer val = objectiveValuesHashmap.get(p.getParameters().getListObjectiveStrings().get(i));
			optimisationValues.add(val); //values of idle, succRate and travelCost
		}
		return optimisationValues;
	}



	/** Return array with the size of optimisation objectives 
	 * populated with 'infinite', i.e., infeasible  
	 * **/
	private static ArrayList<Integer> createInViolationList(ProblemSpecification p){
		ArrayList<Integer> optimisationValues = new ArrayList<Integer>();
		for(int i=0; i<p.getParameters().getListObjectiveStrings().size();i++) 
			optimisationValues.add( Utility.infiniteInt ); //set to infinite as the optimisation problem in JMetal is a minimisation problem.
		return optimisationValues;
	}
		
	
	
	
	
//	private static void runModelA(ProblemSpecification p) {
//		// Test creating models A, B and C for a specific allocation & permutation
//		//--------------------------------------- 
//		//1 get info - create allocation
//		int allocNum = 0;
//		Allocation a1 = p.getAllocations().get(allocNum); //get first allocation
//		//2 get JMetal permutation. String type, e.g.: "(1,1,1,1,443438)" where each number is the robot's task permutation
//		String geneString = getMadeUpPermuation_forTest(a1,p); // create string permutation for testing, in JMetal encoded
//		HashMap<String, Integer> robots2PermNum = getrobots2PermuationNumberArray(a1,p,geneString);
//		
//		// ==print==
//		if(Constants.verbose) {
//			System.out.println("allocation num:" + a1.getNum());
//			//same as:  System.out.println("robots:" +a1.getRobotsList());
//			System.out.println("a) 'robots' to permutation Number"+robots2PermNum.keySet()); //e.g.: robots2PermNum[r2, r3, r4, r5, r1]
//			//same as: System.out.println("permutation"+geneString);
//			System.out.println("b) robots to 'permutation Number'"+robots2PermNum.values()); //e.g.: robots2PermNum[1, 1, 2, 2, 3628800]
//		}
//		
//		//3 array robot ID to permutation */		
//		HashMap<String, Permutation> r_permutationTasks = getPerm(p,a1,robots2PermNum);
//		
//		// -check if permutation feasible due to feasible to travel paths between locations
//		Boolean pathsTransitable = true;
//		for(Permutation perm:r_permutationTasks.values())
//			if(!perm.isFeasible_AllPathsExist) {
//				KanoaErrorHandler.NoPathExistsToCompleteRunTestPermutation(robots2PermNum,perm,allocNum);
//				pathsTransitable =false;
//			}
//		
//		
//		// ==print--
//		if(Constants.verbose) 
//			for(Permutation perm:r_permutationTasks.values()) {perm.print();}
//		
//		// 2) run specialised models
//		//--------------------------------------- 
//		// Model A - idling
//		File file = MDPModelA.createModelA(r_permutationTasks,p,a1);
//		int idle = getIdle(file, "R{\"idle\"}min=?[F done]");
//		
//		if(idle!=2147483647) //Infinite = 2147483647
//			System.out.println("MODEL A. Idle: "+idle);
//		else
//			System.out.println("MODEL A. Plan not feasible."+idle);
//		//=========================================================
//		
//		
//		//--------------------------------------- 
//		// Model B - prob. of success
//		double prob = MDPModelB.createModelB(r_permutationTasks,p,a1);
//		//--------------------------------------- 
//		// Model C - travel cost
//		int travelCost = MDPModelC.createModelC(r_permutationTasks);
//		
//		
//		// 3) check feasibility: , 1=not feaible 
//		int feasible = 100; //100= feasible permutation of tasks
//		if(!pathsTransitable)
//			feasible = 1;   //1  = not feasible due to (a) idling time exceeded OR (b) tasks constraints  
//		if(idle!=2147483647)
//			feasible = 2;   //2  = 
//		if(prob <= Utility.string2double( p.getParameters().ratesucc)) 
//			feasible = 3;
//		
//		
//		
//		
//		
//				
//		
//		
//		String header = "allocationNum,,permutation,,robotClusters,,idle,,probSucc,,travelCost\n";
//		Utility.WriteToFile(Constants.optimisedSolutionsData,s);
//		
//		//allocationNum,,permutation,,robotClusters,,idle,,probSucc,,travelCost 
//		String s = allocNum + ",," 
//				   + geneString + ",,"
//				   + a1.getGroupsOfRobot().toString() + ",," 
//				   + idle + ",," +  prob + ",," + travelCost + "time"
//				   + "\n";
//		Utility.WriteToFile(Constants.optimisedSolutionsData,s);
//		
//		
//		String path = "";
//		saveInfo(idle,prob,travelCost,path);
//		
//	}
	
	private static void saveInfo(int idle, double prob, int travelCost, String path) {
		
		
	}

	/**Run prism: idle and adversary
	 * idle - return the minimum idle time
	 * if > 0 -> permutation of tasks is possible
	 * if < 0 -> permutation of tasks is NOT possible
	 * @param file = modelA
	 * @param property = "R{\"idle\"}min=?[F done]";
	 * @return
	 */ 
	private static int getIdle(File file, String property) {
		int idle = -1;
		idle =  (int) MDPModelA.RunPrism(file,property);  //<-- return the idle time (computed using PRISM PMC)
		return idle;
	}
	
	
	
	/*Array permutation of tasks*/
	private static HashMap<String, Permutation> getPerm(ProblemSpecification p, Allocation a,
			HashMap<String, Integer> robots2PermNum) {
		
		HashMap<String, Permutation> r_permutationTasks = new HashMap<>();
		// robots
		ArrayList<String> robIDset = a.getRobotsList();
		// 
		for (int i = 0; i < robIDset.size(); i++) {
			String rID = robIDset.get(i);
			Integer numPerm = robots2PermNum.get(rID);
			
			//System.out.println("robots2PermNum"+robots2PermNum.keySet()); //e.g. robots2PermNum[r2, r3, r4, r5, r1]
			//System.out.println("robots2PermNum"+robots2PermNum.values()); //     robots2PermNum[1, 1, 2, 2, 3628800]
			
			// permutation per robot
			Permutation perm = new Permutation(rID, p, a, numPerm);
			
			// Print
			//if(Constants.verbose) {perm.print();}

			r_permutationTasks.put(rID, perm);
		}
		return r_permutationTasks;
	}
	
	/** <allocation,permutation> as a HashMap <robotID,numOfPermutation>*/
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
	    // - save // this method do not work as solutions return feasible and infeasible solutions
	    //printFinalSolutionSet(populationSolution) ;
	    
		System.out.println("GA Done");			
	}
	
	
	
}



