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
import uoy.mrs.uoy.mrs.auxiliary.jmetal.AllocationScheduler;
import uoy.mrs.uoy.mrs.auxiliary.jmetal.PlanScheduler;
import uoy.mrs.uoy.mrs.auxiliary.scheduler.Scheduler;
import uoy.mrs.uoy.mrs.types.Allocation;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RunApp {
	
	
	public RunApp()	{}
	
	
	
	public static void main( String[] args )  throws Exception{
		
		// create instance
		RunApp mrs = new RunApp(); 	
		// set config.properties
		//mrs.setPropertiesFile(args);
		Constants.setProperties("TestCase3-var4/config.properties");
		
		//run
    	mrs.runMRS();}
	
	
	/*Run All*/
	public void runMRS() throws Exception {
		//------- Timer
		Timer.startTimer();// start Timer;
		//------- Allocator 
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
	
	
	
	public void setPropertiesFile(String[] args) throws Exception {
		System.out.println("\n---- Reading config.prop file");
		if (args.length > 0)
			Constants.setProperties(args[0]);
		else 
			Constants.setProperties("config.properties");
		System.out.println(Constants.dslFile);
	}
	
	
	
	/**
	 * Run Alloy
	 * @throws Exception
	 */
	public void runAllocator() throws Exception {
    	System.out.println("\n---- Running Task Allocator");
    	Constants.setalloyFilesOutput(RunAlloy.runAlloy(Constants.genAlloyModel,Constants.num_instances) );
	}
	
	/*Run Transitive closure*/
	private void runPreTaskScheduler() {
		System.out.println("\n---- Pre-scheduler, getting clusters");
		PreTaskScheduler.transClosure_Python();
		allocationInstances();
	}
	
	
	/**Alloy instances*/
	private void allocationInstances() {
    	System.out.println("\n\n---- Allocation Instances");
		
		// unique allocations in Allocations.csv
		CSVFormat  csvInFormat = CSVFormat.RFC4180.withDelimiter("|".charAt(0)) ; //modify delimiter
		
		try (Reader reader = Files.newBufferedReader(Paths.get(Constants.allocationsCSVFile));
			 CSVParser csvParser = new CSVParser(reader, csvInFormat); ) {
			// each line is an allocation:
            for (CSVRecord csvRecord : csvParser) {
            	// instantiate allocation
            	Allocation a = new Allocation();
            	a.file =  csvRecord.get(0);
            	a.name =  csvRecord.get(1);
            	a.num_robots =  csvRecord.get(2);
            	a.clustersStr=  csvRecord.get(3);
            	a.getRobotList(csvRecord.get(4));
            	// print info
            	a.print();
            	// add allocation instance
            	Constants.allocationsList.add(a); 
            	}
            }
		catch (IOException e) {
			e.printStackTrace();
			System.exit(0);}
	}
	
	/**
	 * Run Multi-objective Optimisation
	 * Internally, runs PRISM for MDPs modelling a permutation of tasks
	 * @throws Exception
	 */
	public void runScheduler() throws Exception {
		System.out.println("\n\n---- Running Scheduler");
		
		// get feasible permutation of tasks
		Scheduler.getPermutations();
		// get MDP files
		Scheduler.getMDPs();
		
		// a) get pareto solutions
		PlanScheduler.run();
		
		System.out.println(Constants.num_population);
		
		System.err.println("DONE --");
		
		System.exit(0);
		
		
		// @depricated
    	// a) get pareto for each allocations
    	AllocationScheduler.setAllocations(Constants.allocationsList);
    	AllocationScheduler.run();
    	
		// 3) run pareto among all allocations
    	if (Constants.allocationSchedules.size()==0)
    		System.err.println("NO solutions found");
    	else
    		PlanScheduler.run();
		
	}
	
	
	public void readSchedules() throws Exception {
		System.out.println("Read Schedules");
	}
	
	
    
}

