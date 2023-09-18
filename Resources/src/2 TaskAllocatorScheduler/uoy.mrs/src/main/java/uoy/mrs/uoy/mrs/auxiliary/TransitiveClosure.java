package uoy.mrs.uoy.mrs.auxiliary;

// Program for transitive closure
// using Floyd Warshall Algorithm
import java.util.*;
import java.lang.*;
import java.io.*;

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
        for (int i = 0; i < transitiveClosure.length; i++) {
            for (int j = 0; j < transitiveClosure[i].length; j++) {
                System.out.print(transitiveClosure[i][j] + " ");
            }
            System.out.println();
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
	
//	
//	
//	
//		/* Initialize the solution matrix same as input graph
//		matrix. Or we can say the initial values of shortest
//		distances are based on shortest paths considering
//		no intermediate vertex. */
//		for (i = 0; i < V; i++)
//			for (j = 0; j < V; j++)
//				reach[i][j] = graph[i][j];
//
//		/* Add all vertices one by one to the set of intermediate
//		vertices.
//		---> Before start of a iteration, we have reachability
//			values for all pairs of vertices such that the
//			reachability values consider only the vertices in
//			set {0, 1, 2, .. k-1} as intermediate vertices.
//		----> After the end of a iteration, vertex no. k is
//				added to the set of intermediate vertices and the
//				set becomes {0, 1, 2, .. k} */
//		for (k = 0; k < V; k++)
//		{
//			// Pick all vertices as source one by one
//			for (i = 0; i < V; i++)
//			{
//				// Pick all vertices as destination for the
//				// above picked source
//				for (j = 0; j < V; j++)
//				{
//					// If vertex k is on a path from i to j,
//					// then make sure that the value of reach[i][j] is 1
//					reach[i][j] = (reach[i][j]!=0) ||
//							((reach[i][k]!=0) && (reach[k][j]!=0))?1:0;
//				}
//			}
//		}
//
//		// Print the shortest distance matrix
//		printSolution(reach);
//	}
//
//	/* A utility function to print solution */
//	void printSolution(int reach[][])
//	{
//		System.out.println("Following matrix is transitive closure"+
//						" of the given graph");
//		for (int i = 0; i < V; i++)
//		{
//			for (int j = 0; j < V; j++) {
//				if ( i == j)
//				System.out.print("1 ");
//				else
//				System.out.print(reach[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}
//
//	// Driver Code
//	public static void main (String[] args)
//	{
//		/* Let us create the following weighted graph
//		10
//		(0)------->(3)
//		|		 /|\
//	5 |		 |
//		|		 | 1
//		\|/	 |
//		(1)------->(2)
//		3		 */
//
//		/* Let us create the following weighted graph
//
//			10
//		(0)------->(3)
//		|		 /|\
//		5 |		 |
//		|		 | 1
//		\|/		 |
//		(1)------->(2)
//			3		 */
//		int graph[][] = new int[][]{ {1, 1, 0, 1},
//									{0, 1, 1, 0},
//									{0, 0, 1, 1},
//									{0, 0, 0, 1}
//									};
//
//		// Print the solution
//		GraphClosure g = new GraphClosure();
//		g.transitiveClosure(graph);
//	}
//}
//// This code is contributed by Aakash Hasija
//