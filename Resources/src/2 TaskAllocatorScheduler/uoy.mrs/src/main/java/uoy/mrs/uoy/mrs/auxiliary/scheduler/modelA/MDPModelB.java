package uoy.mrs.uoy.mrs.auxiliary.scheduler.modelA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import parser.ast.ModulesFile;
import parser.ast.PropertiesFile;
import prism.Prism;
import prism.PrismDevNullLog;
import prism.PrismException;
import prism.PrismLog;
import prism.Result;
import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;
import uoy.mrs.uoy.mrs.types.impl.Allocation;
import uoy.mrs.uoy.mrs.types.impl.AtomicTaskInstance;
import uoy.mrs.uoy.mrs.types.impl.Permutation;
import uoy.mrs.uoy.mrs.types.impl.Robot;

public class MDPModelB {
	
	
	public static double createModelB(HashMap<String, Permutation> r_permutationTasks, ProblemSpecification p, Allocation a) {
		//probability of success - return the minimum probability of completion without failure
		// prob > 0 
		double prob = -1;
		
		// a) get info
		// -list robot IDs in allocation
		ArrayList<String> robIDset = a.getRobotsList();
				
		
		//=========================================================
		//BUILD PRISM MODEL:
		
		//Prism model:
		StringBuilder model = new StringBuilder();
		model.append("dtmc\n\n");
		
		// - prob. of travelling
//		const double p1=0.99;
//		const double p2=p1;
//		const double p3=p1;
//		const double p4=p1;
		for(String rID:robIDset) {
			Permutation r_permutation = r_permutationTasks.get(rID);
			
			String t1ID= r_permutation.tasksInPerm.get(0);
			int time = r_permutation.getTravelTime(rID, t1ID);
			
			//--**** Missing
			int p_travel = -1000;
			
			model.append("const int p_travel_"+rID+t1ID+"="+p_travel +" ;//l0-"+t1ID+", time:"+time+"\n");
			for (int i = 0; i < r_permutation.tasksInPerm.size()-1; i++) {
				t1ID= r_permutation.tasksInPerm.get(i);
				String t2ID= r_permutation.tasksInPerm.get(i+1);
				time = r_permutation.getTravelTime(t1ID, t2ID);
				model.append("const int travel"+rID+t2ID+"="+time +" ;//"+t1ID+"-"+t2ID+"\n");
			}
		}
		
		
		
		// - prob. of succeeding with tasks
		for(String rID:robIDset) {
			Permutation r_permutation = r_permutationTasks.get(rID);
			for (int i = 0; i < r_permutation.tasksInPerm.size(); i++) {
				String t1ID = r_permutation.tasksInPerm.get(i);
				double p_t1 = r_permutation.robot.getCapability(t1ID,p).getprobSucc();
				model.append("const double p_"+rID+t1ID+"="+p_t1 +" ;\n");
			}
			
		}
		

		
		//---------------------------------------
//		//Not needed in the model, just for explainability
		//---------------------------------------
//		label "fail" = (r1=1|r1=5|r1=7|r1=9);// & (r2=...;
//		label "r1try_t1" = r1=2 & r1=3 & r1=4;
//		label "r1try_t2" = r1=8 & r1=3 & r1=4;

		//---------------------------------------
		// -- modules
		// (computed before declaring states, e.g. "r1:[0..10];"
		// to implicitly calculate the num. of states used by each robot)
		
		HashMap<String, Integer> r_numStates = new HashMap<String,Integer>(); //robotID to total num of states used
		
		for (int i = 0; i < robIDset.size(); i++) {
			String r = robIDset.get(i);
			Permutation r_perm = r_permutationTasks.get(r);
			int succState = 0; //count total num of states needed - success state
			
			
			for (int j = 0; j < r_perm.tasksInPerm.size(); j++) {//for each task
				String t2=r_perm.tasksInPerm.get(j); //t2 is the task to be completed when transition taken
				//travel
				succState += 2; //2 states to travel to a task: successTravel and failTravel
				//retry
				Integer retry = p.getTasks().atList.get(t2).getRetry();
				succState += retry+2; //n retries + 1 fail + 1 success
			}
			 //save final value of robot's state variable
			r_numStates.put(r, succState);
			succState = 0;
		}
		
		
		
		HashMap<String, ArrayList<Integer>> r_failStates = new HashMap<String, ArrayList<Integer>>();
				
		String s = "";
		
		for (int i = 0; i < robIDset.size(); i++) { //for each robot
			String r = robIDset.get(i);
			Permutation r_perm = r_permutationTasks.get(r);
			int nState = 0; //this tracks the value of the state variable robot i, e.g. "r1:[0..10];"
			int succState = 0;
			s+=("module "+r+"\n");
			// -- state variables
			s+=(" "+ r +":[0.."+ r_numStates.get(r) +"];\n");
			
			for (int j = 0; j < r_perm.tasksInPerm.size(); j++) {//for each task
				String t2=r_perm.tasksInPerm.get(j); //t2 is the task to be completed when transition taken
				//---------------------------------------
				// ------ transitions (travel)
				//label & guard travel
				s+=" //travel to "+t2+"\n";
				s+=(" ["+r+"travel_"+t2+"] "+r+"="+nState+"->" );
				//---------------------------------------
				//update 
				
				//------ //*****---MISSING
				int t_prob = 1;
				
				s+=(t_prob+":("+r+"'="+(nState+2)+") + 1-"+t_prob+":("+r+"'="+(nState+1)+");\n");
				
						//("+r+"time+"+r+t2+"Time+travel"+r+t2+"<=TT)");
				nState += 2; //transition to state where succeeded to travel (nState+1= fail, nState+2=succeded)
				//---------------------------------------
				// ------ transitions (next task)
				
				Integer retry = p.getTasks().atList.get(t2).getRetry();
				double p_t2 =  r_perm.robot.getCapability(t2,p).getprobSucc();
				succState = nState + retry + 2 ; //current state + n retries + 1 fail + 1 success  -  state where succeeded to do task
				// - retry
				if (retry.equals(0))
					s+=(" //try "+t2+", no retry allowed\n");
				else
					s+=(" //try "+t2+", retry allowed "+retry+" times\n");
				for (int k = 0; k < retry+1; k++) {
					s+=(" []"+r+"="+nState+" -> "+p_t2+":("+r+"'="+succState+") + 1-"+p_t2+":("+r+"'="+(nState+1)+");\n"); //"succeeds" or "fails and retries" transitions
					nState+=1;
				}
				s = Utility.removeLastChars(s, 1);
				s+=(" //fail task at "+r+"="+nState+"\n");
				nState+=1; //success
			}
//			 //save final value of robot's state variable
//			r_numStates.put(r, succState);
			s+=("endmodule\n\n");
		}
		
		//---------------------------------------
		// -- formula done
		model.append("\nformula done=(");
		for (int i = 0; i < r_numStates.size(); i++) {
			String rID = robIDset.get(i);
			model.append(rID+"="+ r_numStates.get(rID) +"&");
		}
		model.deleteCharAt(model.length() - 1);
		model.append(");\n\n");
		
		//---------------------------------------
		// -- modules (add to final string)
		model.append(s);
		
		
		
		
		
		
		
		
//		module Robot_r1
//		 r1:[0..10];
//		 //travel to t1
//		 [r1travel_t1]r1=0 -> p1:(r1'=2) + 1-p1:(r1'=1);
//		 //try t1, retry allowed 3 times
//		 []r1=2 -> p2:(r1'=6) + 1-p2:(r1'=3);
//		 []r1=3 -> p2:(r1'=6) + 1-p2:(r1'=4);
//		 []r1=4 -> p2:(r1'=6) + 1-p2:(r1'=5);
//		 //travel to t2
//		 [r1travel_t2]r1=6 -> p3:(r1'=8) + 1-p3:(r1'=7);
//		 //try t2, no retry allowed
//		 []r1=8 -> p4:(r1'=10) + 1-p4:(r1'=9);
//		endmodule
//
//
//		module Robot_r2
//		 r2:[0..4];
//		 
//
//		endmodule
		
		
		
		
		//=========================================================
		//=========================================================
		//Save model
		//-File info
		//b) allocation num
		String allocNum = a.getNum();
		String outputFolder = Constants.prismFilesDir;
		String mdpFileName = "modelB_"+"All"+allocNum+"_Perm"+0 +".mdp";
		String mdpFilePath = outputFolder+mdpFileName;
		
		System.out.println("MDP: "+ outputFolder+mdpFilePath );
		
		//-Save to file
		MDPModelA.createMDPFile(outputFolder,mdpFileName,model);

		//=========================================================
		//=========================================================
		//Run prism:
		File file = new File(mdpFilePath);
		String property = "Pmin=?[F done]";
		prob = MDPModelA.RunPrism(file,property); //<-- return the travelling time (computed using PRISM PMC)
		
		return prob;
	}
	
		
	
}
