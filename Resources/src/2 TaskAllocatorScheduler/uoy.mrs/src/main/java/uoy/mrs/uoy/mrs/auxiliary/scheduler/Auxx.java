package uoy.mrs.uoy.mrs.auxiliary.scheduler;


import java.util.ArrayList;
import java.util.Random;
import org.uma.jmetal.solution.integersolution.IntegerSolution;
import prism.Prism;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;
import uoy.mrs.uoy.mrs.types.impl.Allocation;

/**
 * These methods are needed in creating the MDP models 
 * @author Gricel Vazquez
 *
 */
public class Auxx {
	
	
	public static String createModelA(String genesVal, Allocation allocation, ProblemSpecification p) {
		String filePath = "";
		
		return filePath;
	}
	
	
	/**Positive +1 means NOT feasible*/
	public static Boolean getFeasibility() {
		Boolean feasibility = null;
		double prismResult = 0;//HERE: getPrismFeasibility(fpm,PRISM, modulesFile);		// check value from Prism is 0 or 1
		// - not feasible
		if (prismResult==0 | prismResult==0.0) {
			System.out.println("Not feasible permutation (2)");
			feasibility = false; // 0 means not feasible
		}
		// - feasible
		else if (prismResult==1 | prismResult==1.0) {
			feasibility = true;
		}
		else {System.out.println("ERROR");}//HERE: add error
		return feasibility;
	}
	
	
	
	public static double[] evalChromosomeMDP(IntegerSolution solution, String genesVal, Allocation allocation, Prism PRISM, ProblemSpecification p) {
		// timer
		long startTime = System.nanoTime();
		
		// initiate other variables
		double probSucc = 1;  //probabilities of multiple groups of robots are multiplied
		double idle = 0;      //idling time of  multiple groups of robots are added
		double travel = 0;    //travel cost of multiple groups of robots are added
		double feasibility = 100; //**feasibility of the whole allocation, negative means it is feasible
		
		ArrayList<Double> res = new ArrayList<Double>();
		
		/************************************************************/
		//***** Get (objective) values of evaluated Chromosome *****//
		// for each robot's cluster
		for(int i=0; i < allocation.getGroupsOfRobot().size(); i++ ) {
			

			//System.out.println("clusters:"+a.getGroupsOfRobot());
			
			
			//-- 1) Create MDP (model A) and check if robots permutations ok
			//- 1.1 - create MDP
			String s = createModelA(genesVal,allocation,p);
			//??-> File[] files =Utility.getFilesFromChromosome(Constants.prismFilesDir, genesVal);
			
			//- 1.2 - check feasibility (by checking Prism formula 'minIdle')
			Boolean feasible = getFeasibility();
			
			
			if(!feasible) {
				for (int j = 0; j < solution.objectives().length; j++) {
				    //res.add(Double.POSITIVE_INFINITY);//-100.0);
					Random random = new Random();
					//double randomDouble = random.nextDouble();
				       
					double[] items = {1.2,2,3,4,5,6,7,8,Double.POSITIVE_INFINITY};
					// Generate a random index within the range of the list size
			        int randomIndex = random.nextInt(items.length);

			        // Retrieve the randomly selected item
			        double randomDouble = items[randomIndex];
			        
					//res.add(randomDouble);
			        Double g = (double) solution.variables().get(j+1);
			        res.add(g);
					
				}
				//add feasibility - positive=NOT feasible
				res.add(Double.POSITIVE_INFINITY);  //last in res is value of feasibility
				
				double[] arr = res.stream().mapToDouble(Double::doubleValue).toArray(); //array to []
				return arr;
			}
			
			//- 1.3 - get adversary - robot plans 
			
			
			//-- 2) Get minimum idle time  - if 'minIdle', compute minimum idle time using model A
			if(p.getParameters().getObjective_minIdle()) {
				//compute idling 
				
				//add value
				res.add(0.1);
			}
			//-- 3) Get minimum travelling cost -  if 'minTravel'
			if(p.getParameters().getObjective_minTravel()) {
				//compute travel 
				
				//add value
				res.add((double) 111);
			}
			//-- 4) Get maximum probability of success - if 'maxSucc'
			if(p.getParameters().getObjective_maxSucc()) {
				//compute probability of success 
				
				//add value
				res.add(0.99);
			}
			//last in res is value of feasibility
			res.add(-1.0);
			
		}
		/************************************************************/
		
		//Error
		if(res==null) {System.out.println("Error. No objective values computed.");}
		
		System.out.println("values:"+res.toString());
		
		
		boolean feasible = true;
		idle = 3;
		
		double[] arr = res.stream().mapToDouble(Double::doubleValue).toArray(); //via method reference
		return arr;
	}
	

}
