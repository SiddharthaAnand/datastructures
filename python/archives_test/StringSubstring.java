// Check whether a string X is a substring of string y without using
// the in-built function.

import java.util.Scanner;

class StringSubString {
	static boolean substring(String x, String y) {
		int i = 0, j = 0;

		while (i < y.length()) {
			// Need this condition here because of a presence of multiple 
			// occurences of x in y.
			if (j == x.length()) {
				return true;
			}
			else if (x.charAt(j) == y.charAt(i)) {
				++i;
				++j;
			}
			else {
				j = 0;
				++i;
			}
		}
		// Need this here because of x presence in the end of y
		if (j == x.length()) {
				return true;
			}
		return false;
	}

	static void testsubstring() {
		System.out.println("-------------------------------------------------------------");
		System.out.println("// Check if first string is substring of second or not");
		System.out.println("substring(abcde, abcd): " + substring("abcde", "abcd"));
		System.out.println("substring(bcd, abcd): " + substring("bcd", "abcd"));
		System.out.println("substring(bc, abde): " + substring("bc", "abde"));
		System.out.println("substring(bcd, bcd): " + substring("bcd", "bcd"));
		System.out.println("substring(bcd, bcdef): " + substring("bcd", "bcdef"));
		System.out.println("substring(bcd, aaabcdeeff): " + substring("bcd", "aaabcdeeff"));
		System.out.println("-------------------------------------------------------------");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// String x = sc.next();
		// String y = sc.next();
		testsubstring();
	}
}