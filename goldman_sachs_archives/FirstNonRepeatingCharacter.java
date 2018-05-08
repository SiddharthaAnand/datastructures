import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

// Used in the modified method below,
// stores the index of the first time 
// a character is encountered and the 
// total count of the character in the string.

class Attribute {
	int index, count;

	Attribute(int index) {
		this.index = index;
		this.count = 1;
	}

	int getIndex() {
		return index;
	}

	int getCount() {
		return count;
	}

	void increment() {
		this.count++;
	}
}

class FirstNonRepeatingCharacter {
	// traverse the input string only once 
	// in case the string is too long, by storing
	// the position of the character too along with
	// the count in the hashmap.
	public static char modifiedFirstNonRepeatingChar(String input) {
		if (input == null || input.length() == 0)	return '0';

		HashMap<Character, Attribute> hm = new HashMap<Character, Attribute>();

		for (int idx = 0; idx < input.length(); idx++) {
			if (hm.containsKey(input.charAt(idx))) {
				hm.get(input.charAt(idx)).increment();
			}
			else {
				hm.put(input.charAt(idx), new Attribute(idx));
			}
		}

		// now, iterate over the hashmap instead of the string again
		// using Sets for this
		int lowestIdx = Integer.MAX_VALUE;
		for (Map.Entry<Character, Attribute> entry: hm.entrySet()) {
			if (entry.getValue().getCount() == 1 && entry.getValue().getIndex() < lowestIdx) {
				lowestIdx = entry.getValue().getIndex();
			}
		}
		//check if there are any non-repeating characters or not
		if (lowestIdx == Integer.MAX_VALUE)	return '1';
		else return input.charAt(lowestIdx);
	}

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
		System.out.println("Enter the input string: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		System.out.println("Enter the method to be used: ");
		System.out.println("1. getFirstNonRepeatingChar()- Uses 2 passes over the input");
		System.out.println("2. modifiedFirstNonRepeatingChar()- Uses 1 pass over the input");
		String choice = sc.next();
		char firstChar;
		switch (choice) {
			case "1":
				firstChar = getFirstNonRepeatingChar(input);
				if (firstChar != '0' && firstChar != '1')
					System.out.println("First non-repeating character: " + new Character(firstChar).toString());
				else if (firstChar == '0')
					System.out.println("Input string is either empty or null");
				else
					System.out.println("Input string has no non-repeating character");
				break;
			case "2":
				firstChar = modifiedFirstNonRepeatingChar(input);
				if (firstChar != '0' && firstChar != '1')
					System.out.println("First non-repeating character: " + new Character(firstChar).toString());
				else if (firstChar == '0')
					System.out.println("Input string is either empty or null");
				else
					System.out.println("Input string has no non-repeating character");
				break;
			default:
				System.out.println("Invalid choice entered.");
	}
		}
		
}