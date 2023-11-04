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
 * @input atoms
 *
 */
public class PermutationGenerator {
    public static List<String> nthPermutation(List<String> atoms, int index, int size) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int itemIndex = index % atoms.size();
            index = index / atoms.size();
            result.add(atoms.get(itemIndex));
            atoms.remove(itemIndex);
        }
        return result;
    }
    
    //Test 
    public static void main(String[] args) {
        List<String> atoms = new ArrayList<>();
        for (Integer i = 0; i<=100;i++) {
        	atoms.add(i.toString());
        	System.out.println(atoms);
        }
        int index = 1; // Change the index value here
        int size = atoms.size();  // Change the size value here
        List<String> permutation = nthPermutation(atoms, index, size);
        System.out.println("Permutation for index " + index + ": " + permutation);
    }
}
