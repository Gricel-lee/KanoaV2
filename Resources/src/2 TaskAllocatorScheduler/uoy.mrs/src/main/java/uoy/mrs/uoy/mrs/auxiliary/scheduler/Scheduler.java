package uoy.mrs.uoy.mrs.auxiliary.scheduler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAII;
import org.uma.jmetal.example.AlgorithmRunner;
import org.uma.jmetal.operator.crossover.CrossoverOperator;
import org.uma.jmetal.operator.crossover.impl.IntegerSBXCrossover;
import org.uma.jmetal.operator.mutation.MutationOperator;
import org.uma.jmetal.operator.mutation.impl.IntegerPolynomialMutation;
import org.uma.jmetal.operator.selection.impl.RandomSelection;
import org.uma.jmetal.solution.integersolution.IntegerSolution;
import org.uma.jmetal.util.AbstractAlgorithmRunner;
import org.uma.jmetal.util.JMetalLogger;
import org.uma.jmetal.util.evaluator.impl.MultiThreadedSolutionListEvaluator;
import org.uma.jmetal.util.evaluator.impl.SequentialSolutionListEvaluator;

import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.Timer;
import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.types.Allocation;
public class Scheduler extends AbstractAlgorithmRunner{
	
	static List<Allocation> allocations;
	
	
	
	public static void getPermutations() {
		
		
		// call python script
		ProcessBuilder procBuilder = new ProcessBuilder(
				Constants.pythonDir, // python version to run
				Constants.python_script_tasks, // python file: PYTHONSCRIPT/startTasks.py
				Constants.permutationsFile,
				Constants.genMissionTree,
				Constants.allAllocations,
				"Permutations_and_MDPCreate" //to execute MDP part in Python
				);
		
	
	
		// 2.1) create process
		Process process = null;    		//procBuilder.redirectErrorStream(true); // if errors need to be merged (https://docs.oracle.com/javase/7/docs/api/java/lang/ProcessBuilder.html#redirectErrorStream%28boolean%29)
		
		// 2.2) start python process and print memory
		try {
			process = procBuilder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 2.3) read output and check if feasible given each robot's order of tasks
		try {
			Utility.readPython(process);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // feasibility 1, true is possible
		// 2.4) end process
		process.destroy();
	}
	
	
	
	public static void getMDPs() {
		
		// call python script
		ProcessBuilder procBuilder = new ProcessBuilder(
				Constants.pythonDir, // python version to run
				Constants.python_script, // python file: start.py
    			Constants.alloyoutputDir,
    			Constants.genMissionTree,
    			Constants.dslFile,
    			Constants.transClosureOutputDir, 
    			Constants.time_available,
    			Constants.verbose,
    			Constants.genWM,
    			Constants.outputDir,
				// NEW INPUTS (compared to prescheduler)
				"MDPCreate", 							//to execute MDP part in Python
				Constants.permutationsFile, // BEFORE: allocation.file,
				Constants.prismFilesDir,
				Constants.allAllocations// BEFORE: allocation.getRobotsStr(),
				// BEFORE: genesVal
				);
		
		
		// 2.1) create process
		Process process = null;    		//procBuilder.redirectErrorStream(true); // if errors need to be merged (https://docs.oracle.com/javase/7/docs/api/java/lang/ProcessBuilder.html#redirectErrorStream%28boolean%29)
		
		// 2.2) start python process and print memory
		try {
			process = procBuilder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 2.3) read output and check if feasible given each robot's order of tasks
		try {
			Utility.readPython(process);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // feasibility 1, true is possible
		// 2.4) end process
		process.destroy();
	}
	
	
	
}



