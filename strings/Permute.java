/* URL: https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0/?ref=self
 */

package strings;

import java.util.*;

class Permute {

	// Store the permuted strings to sort them and print.
	static ArrayList<String> store = new ArrayList<String>();

	/* This method does not necessarily return strings 
	 * in alphabetical order.
	 */
	static void permuteString(char[] input, int i) {
		if (i == input.length) {
			store.add(new String(input));
			//System.out.println(input);
		}

		else {
			for (int k = i; k < input.length; k++) {
				swap(input, i, k);
				permuteString(input, i+1);
				swap(input, i, k);
			}
		}
	}

	/* Utility to swap the characters since Strings
	 * are immutable.
	 */
	static void swap(char[] input, int x, int y) {
		char t = input[x];
		input[x] = input[y];
		input[y] = t;
	}

	/* This permutation does not consider duplicate 
	 * character reduction for generating permutations.
	 * All the characters are taken to be unique.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		char[] inp = input.toCharArray();
		permuteString(inp, 0);

		// Sorting the strings here so as to print them in order.
		Collections.sort(store);
		System.out.println("-------All Permutations-------");
		System.out.println("------------------------------");
		Iterator<String> it = store.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("------------------------------");
		System.out.println("------------------------------");
	}
}