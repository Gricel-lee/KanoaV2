package uoy.mrs.uoy.mrs.auxiliary.scheduler.models;

import java.util.HashMap;

import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.types.impl.Permutation;

public class MDPModelC {
	
	/**Return the sum of the travelling cost of all robots in a given allocation and permutation.*/
	public static int createModelC(HashMap<String, Permutation> r_permutationTasks) {
		
		System.out.print("\nModelC (travel)- ");
		
		int travelCost = 0;
		for(Permutation r_perm : r_permutationTasks.values()) {
			travelCost += r_perm.TTravel;
		}
		
		// ==print--
		if(Constants.verbose) 
			System.out.print("Total cost: "+ travelCost );
		
		return travelCost;
	}
	
}
