package uoy.mrs.uoy.mrs.auxiliary.prescheduling;

import java.util.ArrayList;

// Transitive closure using Warshall Algorithm


public class TransitiveClosure{
	
	
	/** Transitive closure of graph using Warshall algorithm.
	 * @return transitiveClosure[][] = matrix with transitive closure
	 */
	public static int[][] findTransitiveClosure(int[][] adjacencyMatrix) {
        int n = adjacencyMatrix.length;
        int[][] transitiveClosure = new int[n][n];
        
        // Initialize the transitive closure matrix with the adjacency matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transitiveClosure[i][j] = adjacencyMatrix[i][j];
            }
        }
        
        // Use the Floyd-Warshall algorithm to compute transitive closure
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    transitiveClosure[i][j] = (transitiveClosure[i][j] == 1) || ((transitiveClosure[i][k] == 1) && (transitiveClosure[k][j] == 1)) ? 1 : 0;
                }
            }
        }
        return transitiveClosure;
    }
	
	
	
	/*
	 * Create the adjacency matrix of a list of lists of robots.
	 * e.g. For a list of groped robots by constrained tasks: [[r4, r5], [r4, r5], [r1], [r1], [r2, r1], [r2, r1]]
	 * The adjacency matrix with rows and columns representing robots
	 * [r2, r4, r5, r1], is:
	 * 1 0 0 1 
	 * 0 1 1 0 
	 * 0 1 1 0 
	 * 1 0 0 1 
	 * it means, there is a relation between r1-r2 (hence r2-r1), and r4-r5 (and r5-r4), plus 1s in the diagonal.
	 */
	public static int[][] createAdjacencyMatrix(int size ,
			ArrayList<ArrayList<String>>robotListOfLists,
			ArrayList<String> robotsInAlloc){

		int[][] adjacencyMatrix = createNullMatrix(size);
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
		return adjacencyMatrix;
	}
	
	
	
	/**
	 * Create square matrix initialised with zeros.
	 * @param size
	 * @return matix int[][]
	 */
	public static int[][] createNullMatrix(int size) {
		int[][] matrix = new int[size][size];
        // Initialize the matrix elements to zero
        for (int i = 0; i < size; i++) { for (int j = 0; j < size; j++) { matrix[i][j] = 0; } }
        return matrix;
	}
	
	
	/** Print matrix */
	public static void printMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); // Move to the next row
        }
	}
	
	

	/** Test transitive closure */
	static void testTransitiveClosure() {
		
		int[][] adjacencyMatrix0 = {
	            {1, 0, 0, 0},
	            {0, 1, 0, 1},
	            {0, 0, 1, 1},
	            {0, 1, 1, 1}
	        };
		System.out.println("\n");
		printMatrix(adjacencyMatrix0);
		
	    int[][] transitiveClosure0 = findTransitiveClosure(adjacencyMatrix0);
	    
	    // Print the transitive closure matrix
	    System.out.println("\n");
        printMatrix(transitiveClosure0);
        
        
        
		int[][] adjacencyMatrix = {
	            {1, 0, 1, 0},
	            {0, 1, 0, 1},
	            {0, 0, 1, 0},
	            {0, 0, 0, 1}
	        };
		System.out.println("\n");
		printMatrix(adjacencyMatrix0);
		
	    int[][] transitiveClosure = findTransitiveClosure(adjacencyMatrix);
	    
	    // Print the transitive closure matrix
	    System.out.println("\n");
        printMatrix(transitiveClosure);
	}
	
	//Test
	public static void main( String[] args )  throws Exception{
		testTransitiveClosure();
	}
	
}