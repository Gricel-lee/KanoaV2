package uoy.mrs.uoy.mrs.auxiliary;

// Program for transitive closure
// using Floyd Warshall Algorithm


class TransitiveClosure{
	
	/** Transitive closure of graph using Floyd-Warshall algorithm.
	 * @return transitiveClosure[][] = matrix with transitive closure
	 */
	void transitiveClosure(int graph[][]) {
		int[][] adjacencyMatrix = {
	            {1, 0, 1, 0},
	            {0, 1, 0, 1},
	            {0, 0, 1, 0},
	            {0, 0, 0, 1}
	        };
	     
	    int[][] transitiveClosure = findTransitiveClosure(adjacencyMatrix);
	    
	    // Print the transitive closure matrix
        printMatrix(transitiveClosure);
	}
	
	public static void printMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); // Move to the next row
        }
	}
	
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


	
}