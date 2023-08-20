/* MRS -- Gricel Vazquez
 * 2022
*/
package uoy.mrs.uoy.mrs.alloy;


import java.util.ArrayList;

import edu.mit.csail.sdg.alloy4.Err;

public class RunAlloy {

	/**List of Alloy instances found**/
	private static ArrayList<String> alloyFilesOutput;
	
	
	
	/**Run Alloy**/
    public static ArrayList<String> runAlloy(String model, String num_instances) {
		try {
			// -f specify the file in the next arg value
			// -n specify the number of instances in the next arg value
			// all the rest are considered commands (in Alloy, name of "run" commands)
			String[] alloyFiles = new String[] {"-f" , model , "-n" , num_instances , "TaskAllocation"};
			
			//System.out.println("1");
			alloyFilesOutput = Alloy.main(alloyFiles);
			//System.out.println("2");
			
	    	
	    	System.out.println("- allocations returned: " + alloyFilesOutput.size());
	    	
			if (true){ // print .xml files found
				for (String i : alloyFilesOutput) {
					System.out.println(i);
				}
			}
			
			
		} catch (Err e) {
			// TODO Catch block
			e.printStackTrace();
		}
		return alloyFilesOutput;
	}
    
    
}
