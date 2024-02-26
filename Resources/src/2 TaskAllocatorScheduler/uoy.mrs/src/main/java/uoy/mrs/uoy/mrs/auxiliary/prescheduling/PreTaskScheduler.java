package uoy.mrs.uoy.mrs.auxiliary.prescheduling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.types.ProblemSpecification;
import uoy.mrs.uoy.mrs.types.impl.Allocation;
import uoy.mrs.uoy.mrs.types.impl.AtomicTaskInstance;
import uoy.mrs.uoy.mrs.types.impl.CompoundTaskInstance;

/*
 * Pre-scheduler stage
 * @author Gricel Vazquez
 */
public class PreTaskScheduler {
	
	/**Transfer constraints from compound tasks to atomic tasks.
	 * Compute doneBefore(ati ) and justDone(ati) for all atomic tasks.*/
	public static void tranferConstraints(ProblemSpecification p) {
		//1) get tasks above atomic tasks
		getTasksAbove(p);
		//2) print
		if(Constants.verbose) {printTasksAbove(p);}
		//3) transfer constraints
		tranferCTconstr(p);
		//4) print
		if(Constants.verbose) {printGetTranferedConstraints(p);}
	}
	
	
	
	private static void printTasksAbove(ProblemSpecification p) {
		// --for each task
		Iterator<String> at = p.getTasks().getatIDs().iterator();
		while (at.hasNext()) {
			//run: printCompoundTasksAboveTask
			p.getTasks().atList.get(at.next()).printCompoundTasksAboveTask();
		}
		
	}

	/**Compute CTs tasks above ATs*/
	private static void getTasksAbove(ProblemSpecification p) {
		// --for each task
		Iterator<String> at = p.getTasks().getatIDs().iterator();
		while (at.hasNext()) {
			//run: getCompoundTasksAboveTask
			p.getTasks().atList.get(at.next()).getCompoundTasksAboveTask(p);
		}
	}
	
	//only for testing purposes
	public static void printGetTranferedConstraints(ProblemSpecification p) {
		Collection<AtomicTaskInstance> ats = p.getTasks().atList.values();
		for (Iterator<AtomicTaskInstance> iterator = ats.iterator(); iterator.hasNext();) {
			AtomicTaskInstance at = (AtomicTaskInstance) iterator.next();
			System.out.println(at.getID() +"just done: "+at.getjustDone_con());
			System.out.println(at.getID() +"done before: "+at.getdoneBefore_ord());
		}
		
	}
		
	
	/**Transfer constraints from compound tasks to atomic tasks.
	 * Compute doneBefore(ati ) and justDone(ati) for all atomic tasks.*/
	public static void tranferCTconstr(ProblemSpecification p) {
		// --for each task
		Iterator<String> ats = p.getTasks().getatIDs().iterator();
		while (ats.hasNext()) {
			// get at info
			String id = ats.next();
			AtomicTaskInstance atI = p.getTasks().atList.get(id);
			// get tasks above (needed to transfer CT constraints to AT)
			ArrayList<CompoundTaskInstance> listCTsAbove = atI.getCompoundTasksAboveTask(p);
			
			//System.out.println("\ntransfering CTs constaints to "+id);
			
			tranfer(id, listCTsAbove, p);
			
		}
	}
	
	
	/**Transfer constraints from compound tasks to atomic tasks.
	 * Compute doneBefore(ati) and justDone(ati) for all atomic tasks.*/
	public static void tranfer(String atID,ArrayList<CompoundTaskInstance> listCTsAbove, ProblemSpecification p) {
		while (listCTsAbove!=null){
			
			///System.out.println("in "+atID);
			
			CompoundTaskInstance ct0 = listCTsAbove.get(0);  //at .get(0) is higher node
			
			if(listCTsAbove.size()==1) {listCTsAbove=null;} else {listCTsAbove.remove(ct0);} //remove from list to check
			
			
			// a) if -consecutive- constraints found in higher nodes (tasks above)
			if (ct0.isconsecutive()) {
				
						
				///System.out.println(ct0.getID() + " is consecutive");
				ArrayList<String> listAT = ct0.getAtomicTasksReachable(p);
				
				///System.out.println("reachable ats="+listAT);
				
				int atIndex = listAT.indexOf(atID);
				
				///System.out.println("index="+atIndex);
				
				if (atIndex!=0) {
					String last = listAT.get(atIndex-1);
					///System.out.println("last="+last);
					//-- add task to be done JUST before atID //---- add constraint to atomic task
					p.getTasks().atList.get(atID).setJustDone( last );
					return; //break; END
				}
			}
			
			// b) if -ordered- constraints found in higher nodes (tasks above)
			if (ct0.isordered()) {
				System.out.println(ct0.getID() + " is ordered");
				if(ct0.isatomicTaskInSubtasks(atID)) {
					
					///System.out.println(ct0.getID() + " has atomic");
					
					ArrayList<String> arrayListsubtasks = new ArrayList<>(Arrays.asList(ct0.getorderedChildren()));
					int atIndex = arrayListsubtasks.indexOf(atID);
					
					//System.out.println("index of at in ct: "+atIndex);
					
					if (atIndex!=0) {
						
						String[] taskToBeDoneBefore = ct0.getfirstNsubtasks(atIndex-1);
						for (int i = 0; i < taskToBeDoneBefore.length; i++) {
							
							String itaskBefore = taskToBeDoneBefore[i];
							
							if ( p.isCompound(itaskBefore)) {
								ArrayList<String> reachableAT = p.getTasks().ctList.get(itaskBefore).getAtomicTasksReachable(p);
								//---- add list of atomic tasks to constraint over atomic task atID
								p.getTasks().atList.get(atID).setDoneBefore(reachableAT);
							}
							if(p.isAtomic(itaskBefore)) {
								//---- add atomic task to constraint over atomic task atID
								p.getTasks().atList.get(atID).setDoneBefore(itaskBefore);
							}
						}
					}
				}
				else { //(at not in ct0.subtasks)
					//get next compound task index
					CompoundTaskInstance ct1 = listCTsAbove.get(0);
					
					String ct1ID = ct1.getID();
					String[] ct0children = ct0.getorderedChildren();
					
					///System.out.println("Next="+ct1ID);
					
					//get next compound task index - where is subCT in ct0.getorderedChildren()
					ArrayList<String> arrayListsubtasks = new ArrayList<>(Arrays.asList(ct0.getorderedChildren()));
					
					///System.out.println(arrayListsubtasks);
					
					int ct1Index = arrayListsubtasks.indexOf(ct1ID);
					
					///System.out.println("index here: "+ct1Index);
					
					if (ct1Index!=0) {
						for (int i = 0; i == ct1Index-1; i++) {
							
							String ct0subtask = ct0children[i];
							if(p.isAtomic(ct0subtask)) {
								//-- add task to be DONE before atID
								p.getTasks().atList.get(atID).setDoneBefore(ct0subtask);
							}
							if(p.isCompound(ct0subtask)) {
								ArrayList<String> reachableAT = p.getTasks().ctList.get(ct0subtask).getAtomicTasksReachable(p);
								//---- add constraint to atomic task
								p.getTasks().atList.get(atID).setDoneBefore(reachableAT);
							}}}}}}
	}
	
	
		
	
	/**Grouping robots*/
	public static void getRobotsGroupsForAllocations(ProblemSpecification p) {

		//save
		Utility.checkPath(Constants.solutionsDatabasesDir);
		Utility.createEmptyFile(Constants.allocClustersCSVFile);
		Utility.WriteToFile(Constants.allocClustersCSVFile , "alloc,,clusters,,tasksAlloc,,file");
		
		//------------------
		// ----- Stage (a) - do bread first to get constrained tasks
		ArrayList<String> firstencountered_constrainedTasks = BreadthFirst.breadthFirstTree(p);
		System.out.println("b) Grouping robots");
		
		// for each allocation
		for(Allocation a : p.getAllocations()) {
			//------------------
			// ----- Stage (b) - get robots for each cluster of atomic tasks sharing a constraint
			ArrayList<ArrayList<String>> robotListOfLists = new ArrayList<ArrayList<String>>();
			
			for(String t : firstencountered_constrainedTasks) {
				//if atomic task
				if(p.isAtomic(t)) {
					ArrayList<String> rList =  a.whichRobots(t);
					//System.out.println("AT:");
					//System.out.println("  "+ t + " done by: " + rList.toString());
					robotListOfLists.add(rList);
				}
				
				//if compound task 
				else {
					//**set of robots assigned to compound task (i.e., to reachable atomic tasks of compound task)
					Set<String> set = new HashSet<>();
					//System.out.println("CT:" + t + " has reachable atomic tasks : " );
					//**getting robots for each atomic subtask that compound task can reach
					ArrayList<String> atomicTasks = p.getTasks().ctList.get(t).getAtomicTasksReachable(p);
					for(String at:atomicTasks) {
						//**list of robot
						ArrayList<String> rList =  a.whichRobots(at);
						//System.out.println("  "+ at + "done by:" + rList.toString());
						set.addAll(rList);
					}
					//**add list of robots to list
					ArrayList<String> list = new ArrayList<>(set);
					robotListOfLists.add(list);
				}
			}
			
			
			//------------------
			// ----- Stage (c) - transitive closure over lists of robots
			ArrayList<String> robotsInAlloc = a.getRobotsList();
			//**create adjacency matrix
			int size = a.getRobotsList().size();
						
			int[][] adjacencyMatrix = TransitiveClosure.createAdjacencyMatrix(size,robotListOfLists,robotsInAlloc);
			

			//**get transitive closure
			int[][] tcMatrix = TransitiveClosure.findTransitiveClosure(adjacencyMatrix);
			
			//**get grouped robots : get rows that are not repeated, each group is a row of this matrix
			int[][] uniqueMatrix = removeDuplicateRows(tcMatrix);
			
			//System.out.println();
			//TransitiveClosure.printMatrix(uniqueMatrix);
			
			ArrayList<ArrayList<String>> groupsOfRobot = new ArrayList<ArrayList<String>>();
			
			for(int iRow=0; iRow<=uniqueMatrix.length-1; iRow+=1  ) {
				
				ArrayList<String> groupR = new ArrayList<String>();
				
				int[] row= uniqueMatrix[iRow];
				int countR = 0; //count the column, i.e., the robot
				for(int val:row) {
					
					if(val==1) {groupR.add(robotsInAlloc.get(countR));} //add robot to group
					countR+=1; //counter
				}
				groupsOfRobot.add(groupR); //add group to list
			}
			
			//by task dependency - print groups of robots
			if(Constants.verbose) {System.out.println("-- Alloc "+a.getNum() + ":\nrobots grouped by constraint tasks:" + robotListOfLists.toString() );}
			
			//by transitive closure - print groups of robots
			if(Constants.verbose) {System.out.println("robot groups by transitive closure"+groupsOfRobot.toString());}
			
			//print adjacency matrix
			if(Constants.verbose) {System.out.println("row/col:"+robotsInAlloc.toString() + "\nadjacency matrix"); TransitiveClosure.printMatrix(adjacencyMatrix);}
			
			//print transitive matrix
			if(Constants.verbose) {System.out.println("transitive matrix"); TransitiveClosure.printMatrix(tcMatrix);}
			
			a.setGroupsOfRobot(groupsOfRobot);
			
			//save -> "alloc,clusters,tasksAlloc, file"
			Utility.WriteToFile(Constants.allocClustersCSVFile , a.getNum() + ",," 
					+  groupsOfRobot.toString() + ",," 
					+ a.robotToAtomicTasksIds.toString() + ",,"
					+ a.getFile());
			
			
		}
	}
	
	
	
	/**Remove repeated rows - Each row represents a group of robots, repeated rows not needed.*/
	private static int[][] removeDuplicateRows(int[][] matrix) {
        List<int[]> uniqueRows = new ArrayList<>();
        HashSet<String> rowStrings = new HashSet<>();

        for (int[] row : matrix) {
            // Convert the row to a string to check for duplicates
            String rowString = Utility.arrayIntToString(row);

            // If the rowString is not already in the set, add it to uniqueRows and rowStrings
            if (!rowStrings.contains(rowString)) {
                uniqueRows.add(row);
                rowStrings.add(rowString);
            }
        }
        // Convert the list of unique rows back to a 2D array
        int[][] uniqueMatrix = new int[uniqueRows.size()][matrix[0].length];
        for (int i = 0; i < uniqueRows.size(); i++) {
            uniqueMatrix[i] = uniqueRows.get(i);
        }
        return uniqueMatrix;
    }	

	
	
	
	
	
	

	/**
	 * Use only for testing transitive matrix
	 * Testing:
	 * [[r4, r5], [r5, r6], [r6, r7]] clusters of robots assigned to tasks that share constraints
	 * [r4, r7, r5, r6]
	 * @usage PreTaskScheduler.testTransitiveMatrix();
	 * @print1 lists of robots sharing constraint
	 * @print2 robots (in order representing rows and columns)
	 * @print3 adjacency matrix
	 * @print4 transitive closure matrix
	 */
	public static void onlyForTestTransitiveMatrix() {
		System.out.println("Testing transitive closure");
		//create fake list of lists of robots
		ArrayList<ArrayList<String>> robotListOfLists =  new ArrayList<ArrayList<String>>();

		ArrayList<String> linkedList1 = new ArrayList<>();
		// Add elements to the end of the list
        linkedList1.add("r4");
        linkedList1.add("r5");
		robotListOfLists.add(linkedList1);
		
		ArrayList<String> linkedList2 = new ArrayList<>();
		// Add elements to the end of the list
        linkedList2.add("r5");
        linkedList2.add("r6");
		robotListOfLists.add(linkedList2);
		
		ArrayList<String> linkedList3 = new ArrayList<>();
		// Add elements to the end of the list
        linkedList3.add("r6");
        linkedList3.add("r7");
		robotListOfLists.add(linkedList3);
		
		ArrayList<String> robotsInAlloc = new ArrayList<String>();
		robotsInAlloc.add("r4");robotsInAlloc.add("r7"); robotsInAlloc.add("r5"); robotsInAlloc.add("r6");
		
		int size=robotsInAlloc.size();
		
		if(Constants.verbose) {System.out.println(robotListOfLists.toString());}
		
		int[][] adjacencyMatrix= TransitiveClosure.createAdjacencyMatrix(size,robotListOfLists,robotsInAlloc);
		
		//**get transitive closure
		int[][] tcMatrix = TransitiveClosure.findTransitiveClosure(adjacencyMatrix);
		
		//print transitive matrix
		if(Constants.verbose) {System.out.println(); TransitiveClosure.printMatrix(tcMatrix);}
	}
		
}