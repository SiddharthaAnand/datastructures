/* URL: https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 * Compare two files and find the longest common subsequence in them.
 * diff works by following this.
 * https://www.geeksforgeeks.org/printing-longest-common-subsequence/
 */

package dynamic_programming;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class LongestCommonSubsequence {
	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static int findLCS(final StringBuffer a, final StringBuffer b) {
		int lengthLCS = -1;
		int[][] lcs = new int[a.length()+1][b.length()+1];
		StringBuffer result = new StringBuffer();
		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				}
				else if (a.charAt(i-1) == b.charAt(j-1)) {
					lcs[i][j] = lcs[i-1][j-1] + 1;
					//result.append(a.charAt(i-1));

				}
				else {
					lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		lengthLCS = lcs[a.length()][b.length()];
		//System.out.println("Common subsequence: " + result);
		printCommonSubsequece(a, lcs);
		return lengthLCS;

	}

	/* Print the longest common subsequence 
	 */
	public static void printCommonSubsequece(final StringBuffer a, int[][] lcs) {
		String result = "";
		int i = lcs.length-1, j = lcs[0].length-1;
		while (i != 0 && j != 0) {
			if (lcs[i][j] == lcs[i-1][j-1] + 1) {
				result = a.charAt(i-1) + result;
				i--;
				j--;
			}
			else if (lcs[i-1][j] != lcs[i][j-1] && lcs[i][j] == lcs[i][j-1]) {
				j--;
			}
			else {
				i--;
			}
		}
		System.out.println("Result made from lcs array: " + result);
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		String fileOne = sc.next();
		String fileTwo = sc.next();
		File fOne = new File(fileOne);
		File fTwo = new File(fileTwo);

		// Read the file contents into Strings
		StringBuffer a = new StringBuffer();
		StringBuffer b = new StringBuffer();
		sc = new Scanner(fOne);
		while (sc.hasNextLine()) {
			a.append(sc.nextLine());
		}
		System.out.println(a);
		sc = new Scanner(fTwo);
		while (sc.hasNextLine()) {
			b.append(sc.nextLine());
		}
		// Send them as strings since they are immutable and thread-safe
		// All immutable objects are thread-safe

		//System.out.println("a: " + a);
		System.out.println("Length of the longest common subsequence: " +
							findLCS(a, b));

	}	
}