import java.util.Scanner;
import java.util.HashMap;

class FirstNonRepeatingCharacter {
	public static char getFirstNonRepeatingChar(String input) {
		if (input == null || input.length() == 0)	return '0';

		// Can store the frequencies of all alphabets
		// in a HashMap and then iterate over the 
		// string once again. As soon as we get the 
		// first character whose frequency is one,
		// return that character.

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		for (int idx = 0; idx < input.length(); idx++) {
			if (hm.containsKey(input.charAt(idx))) {
				hm.put(input.charAt(idx), hm.get(input.charAt(idx)) + 1);
			}
			else {
				hm.put(input.charAt(idx), 1);
			}
		}

		for (int idx = 0; idx < input.length(); idx++) {
			if (hm.get(input.charAt(idx)) == 1)
				return input.charAt(idx);
		}
		return '1';
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char firstChar = getFirstNonRepeatingChar(input);
		if (firstChar != '0' && firstChar != '1')
			System.out.println("First non-repeating character: " + new Character(firstChar).toString());
		else if (firstChar == '0')
			System.out.println("Input string is either empty or null");
		else
			System.out.println("Input string has no non-repeating character");
	}
}