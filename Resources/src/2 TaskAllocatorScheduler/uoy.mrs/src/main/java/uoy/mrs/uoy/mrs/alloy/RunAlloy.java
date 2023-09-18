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
			
			alloyFilesOutput = Alloy.main(alloyFiles);
			
		} catch (Err e) {
			e.printStackTrace();
		}
		return alloyFilesOutput;
	}
    
    
}
