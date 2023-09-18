/* MRS -- Gricel Vazquez
 * 2022
 * 
 * Main class. Run multi-robot system (MRS) task allocation and scheduling.
*/


package uoy.mrs.uoy.mrs;

import uoy.mrs.uoy.mrs.alloy.RunAlloy;
import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.PreTaskScheduler;
import uoy.mrs.uoy.mrs.auxiliary.Timer;
import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;

public class Kanoa {
	
	ProblemSpecification problemSpec = new ProblemSpecification();
	
	public Kanoa()	{}
	
	
	
	public static void main( String[] args )  throws Exception{
		/**Create Kanoa instance**/
		Kanoa kanoaMRS = new Kanoa(); 	
		
		/**Set config.properties**/
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
		System.out.println(Constants.dslFile);		
	}
	
	
	
	
	/*Run*/
	public void run() throws Exception {
		//------- Load DSL info
		problemSpec.initialise(Constants.infoDSLFile, Constants.genMissionTree);
		//------- Timer
		Timer.startTimer();// start Timer;
		//------- Allocator 
    	runAllocator();
    	//------- Pre-scheduler
    	runPreTaskScheduler();
    	//------ Scheduler
    	//runScheduler();
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
    	problemSpec.getAllocationsInfo();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
   	}
	
	/*Run Transitive closure*/
	private void runPreTaskScheduler() {
		System.out.println("\n---- Pre-scheduler, getting clusters");
			
		// -- Clusters output file
		PreTaskScheduler.getRobotsGroupsForAllocations(problemSpec);
		
		
		System.out.println(Constants.outputDir+"/try/");
		Utility.checkPath(Constants.transClosureOutputDir);
		
		
		
		
	}	
    
}

