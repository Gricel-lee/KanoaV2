package uoy.mrs.uoy.mrs.auxiliary.scheduler.models;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;
import uoy.mrs.uoy.mrs.types.impl.Allocation;
import uoy.mrs.uoy.mrs.types.impl.Permutation;

public class MDPModelB {
	
	//-- Note about paths:
	// Paths are read from the DSL. However, if "Constants.euclidian_path_distances" is declared as string:"true",
	// the paths between all locations not added explicitly are added with Euclidian distances and success rate =100
	/**Join prob. for all groups - create model B for each group*/
	public static double createModelB(HashMap<String, Permutation> r_permutationTasks, ProblemSpecification p, Allocation a, String geneString) {
		//--Starting Model B
		double totalProb = 1;
		
		System.out.print("\nModelB (prob)- ");
		
		//for each group, get prob
		for (int i=0 ; i< a.getGroupsOfRobot().size(); i++) {
			
			String mdpFilePath = createModelB_groupi(r_permutationTasks,p,a,geneString,i);
			
			//check not feasible 
			if(mdpFilePath=="missingPath") {
				if(Constants.verbose) {System.out.print("g"+i + ":missing path");}
				return 99; //code for missing path in DSL
			}
			
			//check not feasible
			File file = new File(mdpFilePath);
			String property = "1-Pmin=?[F done]";
			double prob = MDPModelA.RunPrism(file,property); //<-- return the travelling time (computed using PRISM PMC)
			if (prob>1) { //if not feasible
				if(Constants.verbose) {System.out.print("g"+i + ":PRISM returns "+prob);}
				return 999; //code for failed PMC for DTMC
			}
			
			//Note: probability threshold requirement checked in Scheduler.getAttrib
			
			//feasible
			else {
				if(Constants.verbose) {System.out.print("g"+i + ":"+prob+", ");}
			}
			
			
			//if feasible
			totalProb = totalProb * prob;
		}
		System.out.print("Total prob fail:"+ totalProb);
		return totalProb;
	}
	
	
	/**Probability of success DTMC file*/
	public static String createModelB_groupi(HashMap<String, Permutation> r_permutationTasks, ProblemSpecification p, Allocation a, String geneString, int group_i) {
		
		// a) get info
		// -list robot IDs in allocation
		ArrayList<String> group_robID = a.getGroupsOfRobot().get(group_i);			//ArrayList<String> robIDset = a.getRobotsList(); //if one DTMC for all robots
		
		//paths info -- returnrs a path object with the 
		
		//=========================================================
		//BUILD PRISM MODEL:
		
		//Prism model:
		StringBuilder model = new StringBuilder();
		model.append("dtmc\n\n");
		
		// - prob. of travelling
		for(String rID:group_robID) {
			Permutation r_permutation = r_permutationTasks.get(rID);
			//tasks
			String t1ID= r_permutation.tasksInPerm.get(0);
			//location
			String robotLocation = r_permutation.robot.getLoc().getID(); //initial location of the robot
			String t1IDLocation = p.getATLocation(t1ID).getID();		 //location of task 1
			//--Get probability of travelling
			double probTravel = p.getWorldModel().getProbabilityPathTravel(robotLocation , t1IDLocation, p);
			// =================================---
			// if prob. -1, path does not exist -> permutation not allowed 
			if (probTravel==-1) {return "missingPath";} //(Model A should have detected it already and return-no model synthesised)
			// =================================---
			model.append("const double p_travel_"+rID+t1ID+"="+probTravel +" ;// from location: "+robotLocation +" (robot initial loc) to location: "+ t1IDLocation+" ("+t1ID+")"+"\n");
			
			for (int i = 0; i < r_permutation.tasksInPerm.size()-1; i++) {
				//tasks
				t1ID= r_permutation.tasksInPerm.get(i);
				String t2ID= r_permutation.tasksInPerm.get(i+1);
				//locations of tasks
				t1IDLocation = p.getATLocation(t1ID).getID();		 //location of task 1
				String t2IDLocation = p.getATLocation(t2ID).getID();		 //location of task 1
				//--Get probability of travelling
				probTravel = p.getWorldModel().getProbabilityPathTravel(t1IDLocation , t2IDLocation, p);
				// =================================---
				// if prob. -1, path does not exist -> permutation not allowed 
				if (probTravel==-1) {return "missingPath";} //(Model A should have detected it already and return-no model synthesised)
				// =================================---
				model.append("const double p_travel_"+rID+t2ID+"="+probTravel +" ;// from location: "+t1IDLocation +" ("+t1ID+") to location: "+ t2IDLocation+"("+t2ID+")"+"\n");
			}
		}
		
		
		// - prob. of succeeding with tasks
		
		for(String rID:group_robID) {
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
		// -- Compute range of variables for each module
		// (computed before declaring states, e.g. "r1:[0..10];"
		// to implicitly calculate the num. of states used by each robot)
		HashMap<String, Integer> r_numStates = new HashMap<String,Integer>(); //robotID to total num of states used
		
		for (int i = 0; i < group_robID.size(); i++) {
			String r = group_robID.get(i);
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
		// -- Compute state where robot fails to travel or complete a task
		HashMap<String, ArrayList<Integer>> r_failStates = new HashMap<String, ArrayList<Integer>>();
				
		String s = "";
		
		// -- 
		for (int i = 0; i < group_robID.size(); i++) { //for each robot
			String rID = group_robID.get(i);
			Permutation r_perm = r_permutationTasks.get(rID);
			int nState = 0; //this tracks the value of the state variable robot i, e.g. "r1:[0..10];"
			int succState = 0;
			s+=("module "+rID+"\n");
			// -- state variables
			s+=(" "+ rID +":[0.."+ r_numStates.get(rID) +"];\n");
			
			for (int j = 0; j < r_perm.tasksInPerm.size(); j++) {//for each task
				String t2ID=r_perm.tasksInPerm.get(j); //t2 is the task to be completed when transition taken
				//---------------------------------------
				// ------ transitions (travel)
				//label & guard travel
				s+=" //travel to "+t2ID+"\n";
				s+=(" ["+rID+"travel_"+t2ID+"] "+rID+"="+nState+"->" );
				//---------------------------------------
				//update 
				
				//------ //*****---MISSING
				//--**** Missing
				// --- I AM HERE
				// ALSO - FOR MODEL A!! -> change travelling costs
				
				String t_prob = "p_travel_"+rID+t2ID;
				
				s+=(t_prob+":("+rID+"'="+(nState+2)+") + 1-"+t_prob+":("+rID+"'="+(nState+1)+");\n");
				
						//("+r+"time+"+r+t2+"Time+travel"+r+t2+"<=TT)");
				nState += 2; //transition to state where succeeded to travel (nState+1= fail, nState+2=succeded)
				//---------------------------------------
				// ------ transitions (next task)
				
				Integer retry = p.getTasks().atList.get(t2ID).getRetry();
				double p_t2 =  r_perm.robot.getCapability(t2ID,p).getprobSucc();
				succState = nState + retry + 2 ; //current state + n retries + 1 fail + 1 success  -  state where succeeded to do task
				// - retry
				if (retry.equals(0))
					s+=(" //try "+t2ID+", no retry allowed\n");
				else
					s+=(" //try "+t2ID+", retry allowed "+retry+" times\n");
				for (int k = 0; k < retry+1; k++) {
					s+=(" []"+rID+"="+nState+" -> "+p_t2+":("+rID+"'="+succState+") + 1-"+p_t2+":("+rID+"'="+(nState+1)+");\n"); //"succeeds" or "fails and retries" transitions
					nState+=1;
				}
				s = Utility.removeLastChars(s, 1);
				s+=(" //fail task at "+rID+"="+nState+"\n");
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
			String rID = group_robID.get(i);
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
		String mdpFileName = "modelB_"+allocNum+"_"+ geneString +"_"+group_i +".dtmc";
		String mdpFilePath = outputFolder+mdpFileName;
		
		// ==print--
		//if(Constants.verbose) 
			//System.out.println("DTMC: "+ outputFolder+mdpFilePath );
		
		//-Save to file
		MDPModelA.createMDPFile(outputFolder,mdpFileName,model);

		//=========================================================
		//=========================================================
		//Run prism:
		return mdpFilePath;
		
	}
	
		
	
}
