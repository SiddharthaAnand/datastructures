/* URL: https://practice.geeksforgeeks.org/problems/pythagorean-triplet/0
 * Solution Approach: Make the array sorted. Square the values and store it in the same array.
 * Apply meet-in-the-middle approach to check and find a pythagorean triplet.
 */

package arrays;

import java.util.*;
public class MeetInTheMiddle {

	/* The condition to satisfy is a*a + b*b = c*c,
	 * Fix the element for c and then apply the algorithm.
	 * Continue this for all the elements.
	 */
	static void doMeetInMiddleAlgorithm(int[] input) {
		if (input == null || input.length == 0)
			return;

		for (int k = input.length-1; k > 0; k--) {
			int c = input[k];
			int i = 0, j = k-1;

			while (i < j) {
				if ((input[i] + input[j]) == c) {
					System.out.println("Found a pythagorean triplet at positions " + i + " " + j + " " + k);
					return;
				}
				else if (input[i] + input[j] < c) {
					i++;
				}
				else {
					j--;
				}
			}

		}
		System.out.println("No pythagorean-triplets found :(");
	}

	// No need to return the values since the values are changed in the original array.
	static void squareElements(int[] input) {
		if (input == null || input.length == 0) {
			return;
		}

		for (int i = 0; i < input.length; i++) {
			input[i] = input[i] * input[i];
		}
	}

	public static void main(String[] args) {
		int[] input = {1, 2, 3, 3, 5, 6};
		Arrays.sort(input);
		squareElements(input);
		doMeetInMiddleAlgorithm(input);
	}
}