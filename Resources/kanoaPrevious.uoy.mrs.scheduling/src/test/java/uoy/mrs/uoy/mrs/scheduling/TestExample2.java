package uoy.mrs.uoy.mrs.scheduling;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//import org.junit.Ignore;


import uoy.mrs.uoy.mrs.RunApp;

/** Test Example 2:
 * 	
 * Two robots: 2 pick and place, 0 cleaner 
 * 
 * Mission:
 * 	move room3
 * 	move room5
 * 
 * Constraints:
 * 	time available: 51
 * 	system: get 100 number of allocations
 *  
 *  SOLUTIONS for allocations: 
 *  1 solution: the two robots have to move
 *  objects in locations room3 and room5, as 
 *  the task requires two robots. 
 *   
 * */

public class TestExample2 
{
	@Before
    public void beforeEachTest() throws Exception {
		
        System.out.println("EXAMPLE 2 - Starting");
    }
	
	@Test //@Ignore
	public void testAlloyInstancesFound(){
		/*-
		 * TEST -- Example 2 
		 */
		try {
			// 1) Check DSL input 
			RunApp mrs = new RunApp();
			/*mrs.setResourcesDir("tests/Example2MoveObject");
			mrs.setConstants();
		      
			assertEquals(RunApp.time_available, "51");
			
			assertEquals(mrs.num_instances,"100");
			
			assertEquals(RunApp.num_population,"5");
			
			assertEquals(RunApp.num_evaluations,"8");
			
			mrs.runAllocator();
			
			// 2) Check Alloy outputs
			assertEquals(mrs.num_instances_found,2);
			
			// 3) Prescheduler
			mrs.runPreTaskScheduler();

			// 4) Task schedules
	    	mrs.getSchedules();
			*/
			/*
						r1 and r2 (as it requires both robots to move an object)				
			Allocations	1	2
			at1_0		x	x
			at1_1		x	x
			*/
		}
		catch (Exception e) {
            e.printStackTrace(System.err);
            System.out.println("Error in Testing Example 2");
        }
		
	}
	
	
	@After
    public void afterEachTest() {
        System.out.println("Test Completed");
    }
	
}


