/* URL: https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 * Compare two files and find the longest common subsequence in them.
 * diff works by following this.
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

		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				}
				else if (a.charAt(i-1) == b.charAt(j-1)) {
					lcs[i][j] = lcs[i-1][j-1] + 1;
				}
				else {
					lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		lengthLCS = lcs[a.length()][b.length()];
		return lengthLCS;

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
			a = a.append(sc.nextLine());
		}
		sc = new Scanner(fTwo);
		while (sc.hasNextLine()) {
			b = b.append(sc.nextLine());
		}
		// Send them as strings since they are immutable and thread-safe
		// All immutable objects are thread-safe

		//System.out.println("a: " + a);
		System.out.println("Length of the longest common subsequence: " +
							findLCS(a, b));

	}	
}