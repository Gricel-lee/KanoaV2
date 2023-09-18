package uoy.mrs.uoy.mrs.auxiliary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import uoy.mrs.uoy.mrs.types.ProblemSpecification;
import uoy.mrs.uoy.mrs.types.impl.Allocation;
import uoy.mrs.uoy.mrs.types.impl.CompoundTaskInstance;
import uoy.mrs.uoy.mrs.types.impl.MissionTaskInstance;

public class PreTaskScheduler {
	
	private static void setToOne(String r1, String r2, ArrayList<String> atIDsList) {
		//atIDsList.getIndex();
		
	}
	
	/**
	 * Create square matrix initialised with zeros.
	 * @param size
	 * @return matix int[][]
	 */
	public static int[][] createMatrix(int size) {
		int[][] matrix = new int[size][size];
        // Initialize the matrix elements to zero
        for (int i = 0; i < size; i++) { for (int j = 0; j < size; j++) { matrix[i][j] = 0; } }
        return matrix;
	}
	
	
	//private static void setAdjacencyMatrix(rList);
	
	
	public static void getRobotsGroupsForAllocations(ProblemSpecification p) {
		//------------------
		// ----- Stage (a) - do bread first to get constrained tasks
		ArrayList<String> firstencountered_constrainedTasks = BreadthFirst.breadthFirstTree(p);
		
		
		for(Allocation a : p.getAllocationsInfo()) {
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
			if(Constants.verbose) {System.out.println("Alloc : "+a.getNum() + ", clusters of robots assigned constraint tasks:" + robotListOfLists.toString() );}
			
			
			
			//------------------
			// ----- Stage (c) - transitive closure over lists of robots
			ArrayList<String> robotsInAlloc = Utility.setToList(a.getRobots());
			//**create adjacency matrix
			int size = a.getRobots().size();
						
			int[][] adjacencyMatrix = createAdjacencyMatrix(size,robotListOfLists,robotsInAlloc);
			

			//**get transitive closure
			int[][] tcMatrix = TransitiveClosure.findTransitiveClosure(adjacencyMatrix);
			
			//print transitive matrix
			if(Constants.verbose) { System.out.println(); TransitiveClosure.printMatrix(tcMatrix);}
			
			//**get grouped robots : get rows that are not repeated, each group is a row of this matrix
			int[][] uniqueMatrix = Utility.removeDuplicateRows(tcMatrix);
			
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
			
			
			if(Constants.verbose) { System.out.println(); System.out.println(groupsOfRobot.toString());}
			
			a.setGroupsOfRobot(groupsOfRobot);
		}
	}
	
	
		
	private static int[][] createAdjacencyMatrix(int size ,
			ArrayList<ArrayList<String>>robotListOfLists,
			ArrayList<String> robotsInAlloc){


		int[][] adjacencyMatrix = createMatrix(size);
		//**for every two robots - add one in 
		for(ArrayList<String> robots: robotListOfLists) {
			
			for(String r1: robots) {
				for(String r2:robots) {

					int row = robotsInAlloc.indexOf(r1);
					int column = robotsInAlloc.indexOf(r2);
					adjacencyMatrix[row][column]=1;
				}
			}
			
		}
		
		//print adjacency matrix
		if(Constants.verbose) {System.out.println(robotsInAlloc.toString()); TransitiveClosure.printMatrix(adjacencyMatrix);}
		
		return adjacencyMatrix;
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
	public static void onlyFortestTransitiveMatrix() {
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
		
		int[][] adjacencyMatrix= createAdjacencyMatrix(size,robotListOfLists,robotsInAlloc);
		
		//**get transitive closure
		int[][] tcMatrix = TransitiveClosure.findTransitiveClosure(adjacencyMatrix);
		
		//print transitive matrix
		if(Constants.verbose) {System.out.println(); TransitiveClosure.printMatrix(tcMatrix);}
	}
		
}