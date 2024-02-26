package uoy.mrs.uoy.mrs.types.impl;

import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.auxiliary.scheduler.Scheduler;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Optimal{
	
	/**Get single Pareto set of solutions
	 * @return */
	public static ArrayList<ScheduleGA> getParetoOptimal(ProblemSpecification p) {
		System.out.println("---- Get single Pareto-optimal solution");
		
		//list for GA output:
		ArrayList<ScheduleGA> schedulesGAList = p.getSchedulesGA();
		//new list		
		ArrayList<ScheduleGA> paretoList = new ArrayList<>();
		
		//Pareto-optimal solutions from the schedulesGAList
		// Iterate over each ScheduleGA object
        for (ScheduleGA schedule : schedulesGAList) {
            boolean isPareto = true;

            // Compare with other ScheduleGA objects
            for (ScheduleGA otherSchedule : schedulesGAList) {
                if (schedule != otherSchedule && isDominating(otherSchedule.getAttr(), schedule.getAttr())) {
                    isPareto = false;
                    break;}}

            if (isPareto) {paretoList.add(schedule);}
        }
        //save
		for(ScheduleGA sch: paretoList) {
        	saveAllOptimal(sch.getAllocNum(), sch.getRob(), sch.getPerm(), sch.getAttr(), sch.getTime() ); //in database
        }
        
        p.setOptimalSchedules(paretoList); //in problem spec
        return paretoList;
	}
	
	
	private static void saveAllOptimal(String anum, ArrayList<String> rob, Object perm, HashMap<String, Double> attr,
			Object time) {
		//String header3 = "alloc,,robots,,permut,,attr,,attrVal,,time";
		String s = anum+",,"
				+ rob+",,"
				+ perm +",,"
				+ attr +",,"
				+ time;
		Utility.WriteToFile(Constants.db4_paretoSolutions, s); //database 1
	}
	
	
	// Helper method to check if one set of attributes dominates another
    private static boolean isDominating(Map<String, Double> attr1, Map<String, Double> attr2) {
        boolean allEqualOrBetter = true;
        boolean oneBetter = false;

        for (Map.Entry<String, Double> entry : attr1.entrySet()) {
            String key = entry.getKey();
            Double value1 = entry.getValue();
            Double value2 = attr2.get(key);

            if (value2 == null || value1 > value2) {
                oneBetter = true;
            } else if (!value1.equals(value2)) {
                allEqualOrBetter = false;
                break;
            }
        }
        return allEqualOrBetter && oneBetter;
    }
}