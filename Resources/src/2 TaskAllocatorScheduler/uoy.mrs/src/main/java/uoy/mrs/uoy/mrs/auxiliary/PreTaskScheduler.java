package uoy.mrs.uoy.mrs.auxiliary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import uoy.mrs.uoy.mrs.types.ProblemSpecification;
import uoy.mrs.uoy.mrs.types.impl.Allocation;
import uoy.mrs.uoy.mrs.types.impl.CompoundTaskInstance;
import uoy.mrs.uoy.mrs.types.impl.MissionTaskInstance;

public class PreTaskScheduler {
	
	private static void setToOne(String r1, String r2, ArrayList<String> atIDsList) {
		atIDsList.getIndex();
		
	}
	
	public void createMatrix(ProblemSpecification p) {
		ArrayList<String> atIDsList = p.getTasks().getatIDs();
		
		
		for(String atID: p.getTasks().atList.keySet()) {
			
		}
	}
	
	public static void transClosure(ProblemSpecification p) {
		// Stage (a) - do bread first to get constrained tasks
		ArrayList<String> firstencountered_constrainedTasks = BreadthFirst.breadthFirstTree(p);
		
		// Stage (b) - get robots for each transition
		
		
		
		for(Allocation a: p.getAllocationsInfo()) {
			
			String num = a.getNum();
			Set<String> robSet = a.getRobots();
			System.out.println( num + " has robots "+robSet.toString());
			
			for(String task: firstencountered_constrainedTasks) {
				if(p.isAtomic(task)) {
					String r= a.whichRobot(task);
					System.out.println( r + " do "+task);
					setToOne(r,r);
				}
				else {
					CompoundTaskInstance ct= p.getTasks().ctList.get(task);
					String[] children= ct.getorderedChildren();
					for(String ti: children) {
						
						String ri= a.whichRobot(ti);
						System.out.println( ri + " do "+ti);
						
						for(String tj: children) {
							String rj= a.whichRobot(ti);
							System.out.println( rj +" do "+tj);
							setToOne(ri, rj);
							setToOne(rj, ri);
						}
					}
				}
			}
			
			
			
			
			
			
		}
		
		
		//TransitiveClosure.transitiveClosure();
		
		
		
		// get clusters of constrained tasks
		Collection<MissionTaskInstance> mIDs= p.getTasks().mtList.values();
		
		for(MissionTaskInstance mID: mIDs) {
			System.out.println(mID.getID() + "<------Starting at mission task");
			
			String child = mID.getorderedChildren()[0];
			System.out.println(child);
			
			
			//if atomic
			if( p.getTasks().atList.keySet().contains(child) ) {
				System.out.println("atomic:" + child);
			}
			//if compound
			if( p.getTasks().ctList.keySet().contains(child) ) {
				System.out.println("compound:" + child);
			}
			
		}
		
	}
	
	
	
	/**
	 * Get transitive closure and Probabilistic models for each cluster of robots
	 * Python code called from: "resources/pythonScripts/start.py"
	 */
	public static void transClosure_Python() {
		try {			
			//System.out.println("Time available to complete plan: "+RunApp.time_available);
			
			// 1) set process variables
    		ProcessBuilder procBuilder = new ProcessBuilder(
    				Constants.pythonDir, // python version to run
    				System.getProperty("user.dir")+"/pythonScripts/start2.py",
    				//Constants.python_script, // python file: start.py
        			Constants.alloyoutputDir,
        			Constants.genMissionTree,
        			Constants.dslFile,
        			Constants.transClosureOutputDir,
        			// --ProblemSpecification.getParameters().getTime(), 
        			"true",//Constants.verbose,
        			Constants.genWM,//world model
        			Constants.outputDir);
    		
    		// 2) create process
    		Process process = null;    		//procBuilder.redirectErrorStream(true); // if errors need to be merged (https://docs.oracle.com/javase/7/docs/api/java/lang/ProcessBuilder.html#redirectErrorStream%28boolean%29)
    		
    		// 3) start python process and print memory
    		//System.out.println("(Memory: " + Runtime.getRuntime().freeMemory()+")");
    		process = procBuilder.start();
    		
    		//System.out.println("(Memory: " + Runtime.getRuntime().freeMemory()+")"); //*** if program suddenly stops, may be saturated memory: https://stackoverflow.com/questions/16907898/java-process-stops-in-the-middle-of-the-process
    		//System.out.println("Checking...");
    		
    		// 4) read output
    		Utility.readPython(process);
    		//System.out.println("---------Transitive Closure and MDP files completed.");
    		
    		// 5) end process
    		process.destroy();
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.exit(0);
		}
		
	}
		
}