/* MRS -- Gricel Vazquez
 * 2023
 * 
 * Main class. Run multi-robot system (MRS) task allocation and scheduling.
*/

package uoy.mrs.uoy.mrs;

import uoy.mrs.uoy.mrs.alloy.RunAlloy;
import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.Timer;
import uoy.mrs.uoy.mrs.auxiliary.prescheduling.PreTaskScheduler;
import uoy.mrs.uoy.mrs.auxiliary.scheduler.Scheduler;
import uoy.mrs.uoy.mrs.error.KanoaErrorHandler;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;
import uoy.mrs.uoy.mrs.types.impl.Optimal;

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
		//TestDummyRefactor-IdleNotFeasible
		
		String fileTest = "TestDummyRefactor-IdleNotFeasible/config.properties"; //"TestCase3-var4/config.properties"); //Constants.setProperties("TestAlloyPreallocatedTasks/HospitalPreallocatedTasks1/config.properties");
		fileTest = "TestDummyRefactor/config.properties"; //"TestCase3-var4/config.properties"); //Constants.setProperties("TestAlloyPreallocatedTasks/HospitalPreallocatedTasks1/config.properties");
		System.out.println(fileTest);
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
    	readSchedules();  //HERE + check models - check previous Kanoa 
    	
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
    	//if no allocations found
    	if (!problemSpec.isThereAllocationsFound()) {KanoaErrorHandler.NoAllocationsFound();}	
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
		System.out.println("\n\n---- Running Scheduler, GA optimisation");
		// timer
		long startTime = System.nanoTime();
		
		// a) -- if testing -- 
		//Scheduler.runTest(problemSpec); //- test one of the models
		
		
		// a) get Pareto set of solutions for each allocation
		Scheduler.run(problemSpec); //- run GA
		
		// 3) get single Pareto set
		Optimal.getParetoOptimal(problemSpec);
		
		
		System.exit(0);
    	
		
	}
}

