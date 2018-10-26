/* URL: https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 * Compare two files and find the longest common subsequence in them.
 * diff works by following this.
 */

package dynamic_programming;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class LongestCommonSubsequence {
	public static int findLCS(final StringBuffer a, final StringBuffer b) {
		int lengthLCS = -1;
		return lengthLCS;

	}
	public static void main(String[] args) throws FileNotFoundException {
		File fOne = new File("fileOne");
		File fTwo = new File("fileTwo");

		// Read the file contents into Strings
		StringBuffer a = new StringBuffer();
		StringBuffer b = new StringBuffer();
		Scanner sc = new Scanner(fOne);
		while (sc.hasNextLine()) {
			a = a.append(sc.nextLine());
		}
		sc = new Scanner(fTwo);
		while (sc.hasNextLine()) {
			b = b.append(sc.nextLine());
		}
		// Send them as strings since they are immutable and thread-safe
		// All immutable objects are thread-safe

		System.out.println("a: " + a);
		System.out.println("Length of the longest common subsequence: " +
							findLCS(a, b));

	}	
}