
import java.util.Scanner;

class RemoveDuplicates {
	public static void remDup(char[] inp) {
		if (inp == null) return;
		if (inp.length < 2) return;

		int j = 1;
		for (int i = 1; i < inp.length; i++) {
			int k = 0;
			for (k = 0; k < j; k++) {
				if (inp[k] == inp[i]) break;
			}
			// If there is no match - characters in new inp is different.
			if (k == j) {
				inp[j] = inp[i];
				j++;
			}
		}
		// if all characters are unique, j value will reach the end
		for (int i = 0; i < j; i++) {
			System.out.print(inp[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		// Convert String to CharacterArray
		char[] inp = input.toCharArray();
		remDup(inp);
		
	}
}

