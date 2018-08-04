/* Input: abc
 * Output: abc, acb, bac, bca, cba, cab
 * Given a string as input, print all the permutations of that string.
 * Method: Recursive backtracking method used here.
 * Question from Cracking the coding interview
 */
import java.util.Scanner;

class PermutationsString {
	public static void recursePermute(char[] input, int k) {
		// Base Case and boundary Case 
		if (input == null || input.length == 0) return;
		if (input.length == 1) {
			System.out.println(input);
			return;
		}
		// When it is time to print.
		if (k == input.length) {
			System.out.println(input);
			return;
		}
		for (int i = k; i < input.length; i++) {
			// Swap
			char c = input[i];
			input[i] = input[k];
			input[k] = c;
			recursePermute(input, k + 1);
			c = input[i];
			input[i] = input[k];
			input[k] = c;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// sc.next() - takes only a single word or till first space as input
		// sc.nextLine() - take one whole line as input.
		String input = sc.next();
		char[] inp = input.toCharArray();
		recursePermute(inp, 0);
	}
}