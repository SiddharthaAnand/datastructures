/* URL: https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0/?ref=self
 */

package strings;

import java.util.*;

class Permute {

	/* This method does not necessarily return strings 
	 * in alphabetical order.
	 */
	static void permuteString(char[] input, int i) {
		if (i == input.length) {
			System.out.println(input);
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

	public static void main(String[] args) {
		
		String input = "abc";
		char[] inp = input.toCharArray();
		permuteString(inp, 0);
	}
}