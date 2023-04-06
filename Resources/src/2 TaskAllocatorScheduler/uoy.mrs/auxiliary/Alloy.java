package uoy.mrs.uoy.mrs.auxiliary;


import java.util.ArrayList;

import edu.mit.csail.sdg.alloy4.Err;
import uoy.mrs.uoy.mrs.alloy.RunAlloy;

public class Alloy {

	/**List of Alloy instances found**/
	private static ArrayList<String> alloy_instances_found;
	
	/**Run Alloy**/
    public static int runAlloy(String model, String dslFile, String num_instances) {
		try {
			// -f specify the file in the next arg value
			// -n specify the number of instances in the next arg value
			// all the rest are considered commands (in Alloy, name of "run" commands)
			String[] alloyFile = new String[] {"-f" , model , "-n" , num_instances , "TaskAllocation"};
			alloy_instances_found = RunAlloy.main(alloyFile);
			return (alloy_instances_found.size());
			
		} catch (Err e) {
			// TODO Catch block
			e.printStackTrace();
		}
		return 0;
	}
    
    
	public static String numAlloyInstancesToGet(String dslFile) {
		String num = Utility.ReadDSLnumber("number of allocations","100",dslFile);
		return num;
	}
	
	public static String numPopulation(String dslFile) {
		String num = Utility.ReadDSLnumber("evochecker population","100",dslFile);
		return num;
	}
	
	public static String numEvaluations(String dslFile) {
		String num = Utility.ReadDSLnumber("evochecker evaluations","1000",dslFile);
		return num;
	}
}
