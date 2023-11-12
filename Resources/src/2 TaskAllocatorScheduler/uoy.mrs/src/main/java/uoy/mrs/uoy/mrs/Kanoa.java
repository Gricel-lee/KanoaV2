/* MRS -- Gricel Vazquez
 * 2023
 * 
 * Main class. Run multi-robot system (MRS) task allocation and scheduling.
*/

package uoy.mrs.uoy.mrs;

import uoy.mrs.uoy.mrs.alloy.RunAlloy;
import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.scheduler.Scheduler;
import uoy.mrs.uoy.mrs.auxiliary.Timer;
import uoy.mrs.uoy.mrs.auxiliary.prescheduling.PreTaskScheduler;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;

public class Kanoa {
	
	ProblemSpecification problemSpec = new ProblemSpecification();
	
	public Kanoa()	{}
	
	public static void main( String[] args )  throws Exception{
		/**Create Kanoa instance**/
		Kanoa kanoaMRS = new Kanoa(); 	
		
		/**Set config.properties**/
		//TestDummyRefactorORDERED
		//TestDummyRefactorCONSEC
		//TestDummyRefactor4ORD_CON
		String fileTest = "TestDummyRefactor/config.properties"; //"TestCase3-var4/config.properties"); //Constants.setProperties("TestAlloyPreallocatedTasks/HospitalPreallocatedTasks1/config.properties");
		kanoaMRS.setPropertiesFile(args,fileTest);
		
		/**Run**/ 
    	kanoaMRS.run();
    }
	
	
	
	/*Config.properties file*/
	public void setPropertiesFile(String[] args,String fileString) throws Exception {
		System.out.println("\n---- Reading config.prop file");
		if (args.length > 0)
			Constants.setProperties(args[0]);
		else 
			Constants.setProperties(fileString);	
	}
	
	
	
	
	/*Run*/
	public void run() throws Exception {
		//------- Load DSL info
		problemSpec.initialise(Constants.infoDSLFile, Constants.genMissionTree);
		//------- Timer
		Timer.startTimer();// start Timer; 
		//------- Allocator    //Pre-allocation done in Xtend
    	runAllocator();
    	//------- Pre-scheduler
    	runPreTaskScheduler();
    	//------ Scheduler
    	runScheduler();
    	//-------Read Data
    	//readSchedules();
    	
    	//------ Get Plans Info
    	//PlotFactory.plotParetoFront(3);
    	
    	System.out.println("Time: "+Timer.getTimeSoFar()+"ms");
    }
	
	
	
	
	
	
	
	/**
	 * Run Alloy
	 */
	public void runAllocator(){
    	System.out.println("\n---- Running Task Allocator");
    	Constants.setalloyFilesOutput(RunAlloy.runAlloy(Constants.genAlloyModel,Constants.num_instances));
    	problemSpec.getAllocations();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
   	}
	
	/*Run Transitive closure*/
	private void runPreTaskScheduler() {
		System.out.println("\n---- Pre-scheduler, transfering constraints to atomic tasks");
		// a) Transfer compound task constraints to atomic tasks
		PreTaskScheduler.tranferConstraints(problemSpec); 
		
		System.out.println("\n---- Pre-scheduler, getting clusters");
		// b) Clusters output file
		PreTaskScheduler.getRobotsGroupsForAllocations(problemSpec);
	}
	
	
	
	
	/**
	 * Run Multi-objective Optimisation
	 * Internally, runs PRISM for MDPs modelling a permutation of tasks
	 * @throws Exception
	 */
	public void runScheduler() throws Exception {
		System.out.println("\n\n---- Running Scheduler");
				
		// get feasible permutation of tasks
		//Scheduler.getPermutations();
		// get MDP files
		//Scheduler.getMDPs();
		
		// a) get Pareto solutions
		Scheduler.runTest(problemSpec);
		
		//Scheduler.run(problemSpec);
//		
//		System.out.println(Constants.num_population);
//		
//		System.err.println("DONE --");
//		
//		System.exit(0);
//		
//		
//		// @depricated
//    	// a) get pareto for each allocations
//    	AllocationScheduler.setAllocations(Constants.allocationsList);
//    	AllocationScheduler.run();
//    	
//		// 3) run pareto among all allocations
//    	if (Constants.allocationSchedules.size()==0)
//    		System.err.println("NO solutions found");
//    	else
//    		PlanScheduler.run();
		
	}
}

