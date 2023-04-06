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

/** Test Example 1:
 * 	
 * Two robots: 1 pick and place, 1 cleaner 
 * 
 * Mission:
 * 	clean room3
 * 	clean room5
 * 
 * Constraints:
 * 	time available: 40
 * 	get 100 number of allocations
 *  all robots deployed
 *  
 *  
 *  
 *  SOLUTIONS for allocations: 
 *  As all robots must be deployed, only one way of doing this:
 *   r1 do everything but r5 helps notifying in room 3
 *   r1 do everything but r5 helps notifying in room 5
 *   r1 do everything but r5 helps notifying in room 3 and 5
 *   
 * */
public class TestExample1 
{
	
	@Before
    public void beforeEachTest() throws Exception {
		
        System.out.println("EXAMPLE 1 - Starting");
    }
	
	@Test //@Ignore
	public void testAlloyInstancesFound(){
		/*-
		 * TEST -- Example 1 
		 */
		try {
			// 1) Check DSL input 
			RunApp mrs = new RunApp();
			/*mrs.setResourcesDir("tests/Example1");
			mrs.setConstants();
		      
			assertEquals(RunApp.time_available, "40");
			
			assertEquals(mrs.num_instances,"100");
			
			assertEquals(RunApp.num_population,"5");
			
			assertEquals(RunApp.num_evaluations,"8");
			
			mrs.runAllocator();
			
			// 2) Check Alloy outputs
			assertEquals(mrs.num_instances_found,6);
			
			// 3) Prescheduler
			mrs.runPreTaskScheduler();
			
			// 4) Task schedules
	    	mrs.getSchedules();*/
			
			/*
								r1					
			Allocations	1	2	3	4	5	6
			at4_0					x	x	
			at2_1		x	x	x	x	x	x
			at3_2		x	x	x	x	x	x
			at4_3			x			x
			at2_4		x	x	x	x	x	x
			at3_5		x	x	x	x	x	x
			*/
		}
		catch (Exception e) {
            e.printStackTrace(System.err);
            System.out.println("Error in Testing Example 1");
        }
		
	}
	
	@After
    public void afterEachTest() {
        System.out.println("Test Completed");
    }
	
}


