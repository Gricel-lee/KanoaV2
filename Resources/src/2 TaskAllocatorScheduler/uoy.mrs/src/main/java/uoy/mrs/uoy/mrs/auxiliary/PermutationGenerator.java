/**
 * Retrieve permutation, aka Lehmer code, of a vector.
 * 
 * Thanks to second answer in:
 * https://stackoverflow.com/questions/7918806/finding-n-th-permutation-without-computing-others
 * 
 */

package uoy.mrs.uoy.mrs.auxiliary;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @input data
 *
 */
public class PermutationGenerator {
    
	/**Get the nth permutation of a list of strings*/
	public static List<String> nthPermutation(List<String> data, int permNum) {
        List<String> result = nthPermutation(data, permNum, data.size());
        return result;
    }
	
	/**Get permutation of a list in N (size) spaces*/
	public static List<String> nthPermutation(List<String> originalData, int permNum, int size) {
		
		// Create a copy of the original list -otherwise the original is modified when using .remove
        List<String> data = new ArrayList<>(originalData);
		
		List<String> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int itemIndex = permNum % data.size();
            permNum = permNum / data.size();
            result.add(data.get(itemIndex));
            data.remove(itemIndex);
        }
        return result;
    }
    
    //Test 
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        for (Integer i = 0; i<=100;i++) {
        	data.add(i.toString());
        }
        int permNum = 1; // Change the permNum value here (0 to n)
        int size = data.size();  // Change the size value here (if needed subset, e.g. [1,2,3] possible permutation of size [1,2], or [2,3], or...)
        List<String> permutation = nthPermutation(data, permNum, size);
        //print
        System.out.println(data);
        System.out.println("Permutation number " + permNum + ": " + permutation);
    }
}
