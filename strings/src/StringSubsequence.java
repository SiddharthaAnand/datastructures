import java.util.Scanner;

class StringSubsequence {
	public static boolean possibleToCreateFirstString(String first, String second) {
		
		if (first == null || first.length() == 0) {
			return true;
		}
		int fIdx = 0;
		for (int idx = 0; fIdx < first.length() && idx < second.length(); idx++) {
			if (first.charAt(fIdx) == second.charAt(idx)) {
				fIdx++;
			}
		}

		if (fIdx == first.length())
			return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String first = sc.next();
		String second = sc.next();

		System.out.println(first + " can be formed by removing characters from " + second + " is " + possibleToCreateFirstString(first, second));
	}
}