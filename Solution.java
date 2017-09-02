/*
 * Check if the characters are unique or not. 
 * Assumption: Only Ascii-alphabets lower case present in input.
 * Space decreases if used in this way, bits store the presence of a character.
 */
import java.util.*;

class Solution {
	public static boolean uniqueCharacters(String input) {
		int charset = 0;
		for (int i = 0; i < input.length(); i++) {
			int setBit = charset & (1 << (input.charAt(i) - 'a'));
			if (setBit > 0) return false;
			charset |= (1 << (input.charAt(i) - 'a'));
			System.out.println(charset);
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		boolean unique = uniqueCharacters(input);
		System.out.println(unique);
	}
}