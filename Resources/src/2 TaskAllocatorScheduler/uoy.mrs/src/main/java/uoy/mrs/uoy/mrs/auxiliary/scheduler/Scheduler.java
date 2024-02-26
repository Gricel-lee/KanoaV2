package uoy.mrs.uoy.mrs.auxiliary.scheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import org.netlib.util.doubleW;
//import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAII;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIBuilder;
import org.uma.jmetal.example.AlgorithmRunner;
import org.uma.jmetal.operator.crossover.CrossoverOperator;
import org.uma.jmetal.operator.crossover.impl.IntegerSBXCrossover;
import org.uma.jmetal.operator.mutation.MutationOperator;
import org.uma.jmetal.operator.mutation.impl.IntegerPolynomialMutation;
import org.uma.jmetal.operator.selection.SelectionOperator;
import org.uma.jmetal.operator.selection.impl.BinaryTournamentSelection;
//import org.uma.jmetal.operator.selection.impl.RandomSelection;
import org.uma.jmetal.solution.integersolution.IntegerSolution;
import org.uma.jmetal.util.AbstractAlgorithmRunner;
//import org.uma.jmetal.util.JMetalLogger;
//import org.uma.jmetal.util.evaluator.impl.SequentialSolutionListEvaluator;

import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.auxiliary.scheduler.models.MDPModelA;
import uoy.mrs.uoy.mrs.auxiliary.scheduler.models.MDPModelB;
import uoy.mrs.uoy.mrs.auxiliary.scheduler.models.MDPModelC;
import uoy.mrs.uoy.mrs.error.KanoaErrorHandler;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;
import uoy.mrs.uoy.mrs.types.impl.Allocation;
import uoy.mrs.uoy.mrs.types.impl.Permutation;
import uoy.mrs.uoy.mrs.types.impl.Robot;
import uoy.mrs.uoy.mrs.types.impl.ScheduleGA;

public class Scheduler extends AbstractAlgorithmRunner{
	
	private static int countSol_id = 0;
	
	
	public static void run(ProblemSpecification p) {
		System.out.println(""+ p.getParameters().getNumObjectives()+" objectives:"+p.getParameters().getListObjectiveStrings());
		
		// -- new databases
		startDatabases();
		
	    // -- run
		for (Allocation a: p.getAllocations()) {
			System.out.println("\n-Task schedules for Allocation "+a.getNum() +" with " + a.getGroupsOfRobot().size() +" clusters." );
			runGA(a,p);
		}
	}
	
	
	
	/*
	 * Create new databases to save: 1) optimal, 2) feasible (optimal and suboptimal) and 3) unfeasible solutions
	 */
	public static void startDatabases() {
		Utility.createEmptyFile(Constants.db1_optimisedSolutions);
		Utility.createEmptyFile(Constants.db2_feasibleSolutions);
		Utility.createEmptyFile(Constants.db3_infeaibleSolutions);
		Utility.createEmptyFile(Constants.db4_paretoSolutions); //used after GA

		Utility.WriteToFile(Constants.db1_optimisedSolutions , "alloc,,robots,,permut,,attr,,time   (maxSucc value=prob. of failing times 100)");
		Utility.WriteToFile(Constants.db2_feasibleSolutions , "alloc,,robots,,permut,,attr  (maxSucc value=prob. of failing times 100)");
		Utility.WriteToFile(Constants.db3_infeaibleSolutions , "alloc,,robots,,perm,,reason");
		Utility.WriteToFile(Constants.db4_paretoSolutions , "alloc,,robots,,perm,,attr  (maxSucc value=prob. of failing times 100)"); //used after GA
	}
	
	
	/**Return true if feasible to travel between locations*/
	public static Boolean checkPaths(HashMap<String, Permutation> r_permutationTasks, HashMap<String, Integer> r_permNum, Allocation a1) {
		for(Permutation perm:r_permutationTasks.values()) {
			// not feasible - save in database 3 and return false
			if(!perm.isFeasible_AllPathsExist) {
				//KanoaErrorHandler.NoPathExistsToCompleteRunTestPermutation(r_permNum,perm,a1);
				return false;
			}
		}
		return true;
	}
	
	private static void saveViolationDatabase(HashMap<String, Integer> r_permNum, String allocNum, String violationType) {
		//String header3 = "alloc,,robots,,perm,,reason\n";
		String s = allocNum+",,"
				+ r_permNum.keySet()+",,"
				+ r_permNum.values() +",,"
				+ violationType ;
		Utility.WriteToFile(Constants.db3_infeaibleSolutions, s); //database 3
	}
	
	private static void saveFeasibleDatabase(HashMap<String, Integer> r_permNum, String allocNum, HashMap<String, Double> objectiveVal) {
		//String header3 = "alloc,,robots,,permut,,attr";
		
		String s = allocNum+",,"
				+ r_permNum.keySet()+",,"
				+ r_permNum.values() +",,"
				+ objectiveVal ;
		Utility.WriteToFile(Constants.db2_feasibleSolutions, s); //database 3
	}
	
	private static void saveGAOptimalDatabase(String anum, ArrayList<String> rob, Object perm, HashMap<String, Double> attr,
			Object time) {
		//String header3 = "alloc,,robots,,permut,,attr,,attrVal,,time";
		String s = anum+",,"
				+ rob+",,"
				+ perm +",,"
				+ attr +",,"
				+ time;
		Utility.WriteToFile(Constants.db1_optimisedSolutions, s); //database 1
	}
	
	
	
	
	// --for tests
	public static void runTest(ProblemSpecification p) {
		//---------------------------------------
		// -- New databases
		startDatabases();
		
		//------Input: (allocation, permutation)
		// 1 get info - create allocation (Test creating alloc./permutation)
		int allocNum = 0;
		Allocation a1 = p.getAllocations().get(allocNum); //get first allocation
		//1.1 get JMetal permutation. String type, e.g.: "(1,1,1,1,443438)" where each number is the robot's task permutation
		String geneString = getMadeUpPermuation_forTest(a1,p); // create string permutation for testing, in JMetal encoded
		
		System.out.println("allocation num:" + a1.getNum());
		
		getAttrib(p,a1,geneString);
	}
	
	
	/** Get attributes for one combination (alloc,perm)
	 * @param geneString */
	public static double[] getAttrib(ProblemSpecification p, Allocation a1, String geneString) {
		
		String allocNum = a1.getNum();
		
		// -- 1 Optimisation objectives
		HashMap<String, Double> objectiveValuesHashmap = new HashMap<String, Double>(); //initialise array {} (this could be size 1 to 3 depending on number of optimisation objectives declared in DSL)
		
		// -- check feasibility (i.e., all travelling paths exists, no constraint (tasks, time, min. success rate) is violated)
		Boolean feasible = true;
		
		//---------------------------------------
		//1.2 Permutation info */		
		HashMap<String, Integer> r_permNum = getrobots2PermutationNum(a1,p,geneString);
		HashMap<String, Permutation> r_permutationTasks = getPerm(p,a1,r_permNum);
		
		//==print==
		if(Constants.verbose) {
			System.out.println("permutation: "+r_permNum.values()+", robots: "+r_permNum.keySet()); //e.g.: robots2PermNum[1, 1, 2, 2, 3628800]
		}
		
		//1.3 Optimisation objectives declared in DSL
		ArrayList<String> objectiveList = p.getParameters().getListObjectiveStrings();
				
		//---------------------------------------
		//2 check if all paths are feasible 
		feasible = checkPaths(r_permutationTasks,  r_permNum, a1); //must be declared in DSL or in config.prop ALLOW_PATH_DISTANCE_EUCLIDIAN = true
		if(!feasible) {
			saveViolationDatabase(r_permNum, a1.getNum(), "pathsDontExist");
			return createInViolationList(p);
		}
		
		//---------------------------------------
		//3 check if task permutation is feasible due to idle and task constraints (model A must not return infinite=2147483647)
		double idle = (double) MDPModelA.checkModelA(r_permutationTasks,p,a1,geneString,r_permNum);
		if (idle==2147483647) {feasible=false;} //infinity
		if(!feasible) {
			saveViolationDatabase(r_permNum, a1.getNum(), "noPlanSynthesised");//due to time limit, task constraint or idling limit
			return createInViolationList(p);
		}
		
		//---------------------------------------
		//4) get attrib/optimisation values array (this could be 1, 2 or 3 depending on objectives declared in DSL)
		for (int i = 0; i <objectiveList.size() ; i++) {
			//if(Constants.verbose) {System.out.println("Getting value of optimisation objective: "+ objectiveList.get(i));}
			// 4.1 idle
			if(objectiveList.get(i)=="minIdle") { //already computed, & feasible is this part is reached
				objectiveValuesHashmap.put(objectiveList.get(i), idle);}
			// 4.2 probability of success
			else if(objectiveList.get(i)=="maxSucc") {
				double prob = MDPModelB.createModelB(r_permutationTasks,p,a1, geneString); //computed prob. of succ.
				objectiveValuesHashmap.put(objectiveList.get(i), (prob*100) );}
			// 4.3 travelling cost
			else if(objectiveList.get(i)=="minTravel") {
				double travelCost = MDPModelC.createModelC(r_permutationTasks);
				objectiveValuesHashmap.put(objectiveList.get(i), travelCost);}
			// ERROR
			else {KanoaErrorHandler.ErrorObjectiveNotRecognised(objectiveList.get(i));}
		}
		// print
		if(Constants.verbose){System.out.println("\n"+objectiveValuesHashmap.toString());}
		
		
		//---------------------------------------
		//5) check violation prob. success - if constraint declared in DSL then !=0
		double succRate = 0;
		if(p.getParameters().ratesucc!="0" && !objectiveList.contains("maxSucc")) //if prob. NOT computed yet
			succRate = MDPModelB.createModelB(r_permutationTasks,p,a1,geneString)*100;
		else{succRate = objectiveValuesHashmap.get("maxSucc");}
		//5.2 check if requirement holds (succ.rate has to be greater that N in the DSL)
		if(succRate <= Utility.string2double( p.getParameters().ratesucc )) {
			saveViolationDatabase(r_permNum, a1.getNum(), "probSuccessViolated");//due to time limit, task constraint or idling limit
			return createInViolationList(p);}
		
		//---------------------------------------
		//6) feasible solution
		System.out.println("Plan is feasible!");
		
		//save
		saveFeasibleDatabase(r_permNum, a1.getNum(), objectiveValuesHashmap);
		
		return createFeasibleValuesList(objectiveValuesHashmap, p);
	}
	
	
	private static double[] createFeasibleValuesList(HashMap<String, Double> objectiveValuesHashmap, ProblemSpecification p) {
		
		ArrayList<Double> optimisationValues = new ArrayList<Double>();
		for(int i=0; i<p.getParameters().getListObjectiveStrings().size();i++) {
			Double val = objectiveValuesHashmap.get(p.getParameters().getListObjectiveStrings().get(i));
			optimisationValues.add(val); //values of idle, succRate and travelCost
		}
		return Utility.arrayDouble2doubleList( optimisationValues);
	}



	/** Return array with the size of optimisation objectives 
	 * populated with 'infinite', i.e., infeasible  
	 * **/
	private static double[] createInViolationList(ProblemSpecification p){
		ArrayList<Integer> optimisationValues = new ArrayList<Integer>();
		for(int i=0; i<p.getParameters().getListObjectiveStrings().size();i++) 
			optimisationValues.add( Utility.infiniteInt ); //set to infinite as the optimisation problem in JMetal is a minimisation problem.
		return Utility.arrayInt2doubleList( optimisationValues );
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
			
			r_permutationTasks.put(rID, perm);
		}
		return r_permutationTasks;
	}
	
	/** <allocation,permutation> as a HashMap <robotID,numOfPermutation>*/
	private static HashMap<String, Integer> getrobots2PermutationNum(Allocation a1, ProblemSpecification p,String geneString) {
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
	public static void runGA(Allocation a, ProblemSpecification p) {
		//----- SET UP
		// a) problem setup    // based on https://jmetal.readthedocs.io/en/latest/experimentation.html
		AllocationProblem problem = new AllocationProblem(a,p);
		// crossover
		double crossoverProbability = 0.95; // - example: double crossoverProbability = 0.9;
		double crossoverDistributionIndex = 5.0; //-example: double crossoverDistributionIndex = 20.0;
		CrossoverOperator<IntegerSolution> crossover = new IntegerSBXCrossover(crossoverProbability, crossoverDistributionIndex); //CrossoverOperator<DoubleSolution> crossover = new SBXCrossover(crossoverProbability, crossoverDistributionIndex);  //-example: CrossoverOperator<DoubleSolution> crossover = new SBXCrossover(crossoverProbability, crossoverDistributionIndex);
		// mutation
		double mutationProbability = 0.9; //- AllocationScheduler and example: double mutationProbability = 1.0 / problem.getNumberOfVariables();
		double mutationDistributionIndex = 10.0; //- example: 20, plan schedule =5
		MutationOperator<IntegerSolution> mutation = new IntegerPolynomialMutation(mutationProbability, mutationDistributionIndex);  //MutationOperator<DoubleSolution> mutation = new PolynomialMutation(mutationProbability, mutationDistributionIndex); // -example: MutationOperator<DoubleSolution> mutation = new PolynomialMutation(mutationProbability,mutationDistributionIndex);
		//selector
		SelectionOperator<List<IntegerSolution>, IntegerSolution> selection = new BinaryTournamentSelection<IntegerSolution>();
		
		//new PolynomialMutation(1.0/problem.getNumberOfVariables() , 20 )
		//Termination termination = new TerminationByEvaluations(75000);
		//Ranking<DoubleSolution> ranking = new MergeNonDominatedSortRanking<>();
		
		//Future work----make it proportional to the number of possible permutations
		int populationSize = Utility.checkEven("GA population", Utility.string2int(Constants.num_population)); //HAS to be even num.
		
		// b) set NSGAII algorithm
		NSGAII<IntegerSolution> algorithm = new NSGAIIBuilder<>(problem, crossover, mutation, populationSize)
		        .setSelectionOperator(selection)
		        .setMaxEvaluations(Utility.string2int(Constants.num_evaluations))//25000)
		        .build();
		
		
//		@SuppressWarnings("unchecked")   // solutions are DOUBLE, genes are INTEGERS
//		Algorithm<List<IntegerSolution>> algorithm22 = new NSGAII( // following example of builder from: org.uma.jmetal.algorithm.multiobjective.nsgaii
//											problem,
//											Integer.parseInt(Constants.num_evaluations),//maxEvaluations
//											populationSize, //populationSize
//											populationSize, //matingPoolSize
//											populationSize, //offspringSize
//											crossover, //crossoverOperator
//											mutation, //mutationOperator  - second parameter: distribution index: he distribution index η in the SBX operator controls the distance between two offsprings and two parents. If the value of η is large, the probability that the generated offsprings are closer to the two parents is greater; if the value of η is relatively small, the probability that the generated offsprings are farther away from the two parents is greater. 
//											new RandomSelection(), //selectionOperator     - I selected randomed based on results table from: https://www.researchgate.net/publication/2372815_Comparison_of_Selection_Methods_for_Evolutionary_Optimization
//											//new MultiThreadedSolutionListEvaluator<AllocationProblem>(1) //not working
//											new SequentialSolutionListEvaluator<AllocationProblem>() // evaluator
//											);
		
		
		
		//-------- RUN GA
		// c) run GA algorithm				// instead of algorithm.run(); to get more info
		AlgorithmRunner algorithmRunner = new AlgorithmRunner.Executor(algorithm).execute() ; //if accessing info at runtime
		
		//--------- READ RESULTS
		// d) Pareto optimal solutions
		//save
		List<IntegerSolution> populationSolution = algorithm.getResult() ;
		for (IntegerSolution solution : populationSolution) {
	        //get solution info
            ArrayList<String> rob = a.getRobotsList();
            String perm = (String) solution.attributes().get("perm");
            String time = Long.toString(Long.parseLong(solution.attributes().get("time").toString()));
            HashMap<String, Double> attr =  optimalVal2Map(p,solution);
            // save in database
            saveGAOptimalDatabase(a.getNum(), rob, perm, attr,  time); // in database
            // save in problem spec.
            countSol_id+=1;
            ScheduleGA sol = new ScheduleGA(countSol_id,rob,a.getNum(),perm,attr,time); //in problem spec.
    		p.addScheduleGA(sol);
        }	
		
	    //print JMetal info
	    printFinalSolutionSet(populationSolution);
	    
	    // print time
	    long computingTime = algorithmRunner.getComputingTime() ;
	    System.out.println("Total execution time: " + computingTime + "ms");
	    //JMetalLogger.logger.info("Total execution time: " + computingTime + "ms");
	    
		System.out.println("GA loop done");	
	}
	
	
	/**Reading GA Pareto-optimal front and map to attributes names*/
	private static HashMap<String, Double> optimalVal2Map(ProblemSpecification p, IntegerSolution solution) {
		HashMap<String, Double> attr = new HashMap<String, Double>();
		double[] attr_val = solution.objectives(); //values from GA
		for(int i=0; i<attr_val.length ; i++) {
			String name = p.getParameters().getListObjectiveStrings().get(i); //name of objective
			attr.put(name,attr_val[i]);
		}
		return attr;
	}



	
	
	
	
}



