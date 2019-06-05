/* Question: Find the length of longest substring which does not have any repeated characters.
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

class LengthOfLongestSubstring {

	public static int lengthOfLongestSubstringInAlphabeticalOrder(String input) {
		int ans = 0;
		if (input == null && input.length() == 0) {
			return ans;
		}
		if (input.length() == 1) {
			return 1;
		}
		for (int i = 0, j = 1; i < input.length() && j < input.length();) {
			if (input.charAt(j-1) < input.charAt(j)) {
				ans = Math.max(j - i + 1, ans);
				j++;
			}
			else {
				i = j;
				j++;
			}
		}
		return ans;
	}

	/* Sliding Window where the window has only unique characters in every iteration. 
	 * Every character visit is done only once.
	 * Time Complexity: O(n)
	 * Space complexity: O(n)
	 */
	public static int lengthOfLongestSubstringContainingUniqueCharacters(String input) {
		int ans = 0;
		if (input == null || input.length() == 0) {
			return ans;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0, j = 0; i < input.length() && j < input.length();) {
			if (map.containsKey(input.charAt(j))) {
				// Jump after that index since till that index you will be having a duplicate value.
				i = map.get(input.charAt(j))+1;
			}
			map.put(input.charAt(j), j);
			ans = Math.max(ans, j - i + 1);
			j++;
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println("This code prints the following: ");
		System.out.println("1. Returns the longest substring containing unique characters.");
		System.out.println("2. Returns the longest substring containing sorted alphabetically characters.");
		System.out.println("3. Exit.");
		System.out.println("Which one do you want to choose? 1/2/3");
		
		String input = "";
		Scanner sc = new Scanner(System.in);
		String ch = sc.next();
		switch (ch) {
			case "1":
				System.out.println("Enter the string to be given as input: ");
				System.out.println(lengthOfLongestSubstringContainingUniqueCharacters(sc.next()));
				break;
			case "2":
				System.out.println("Enter the string to be given as input: ");
				System.out.println(lengthOfLongestSubstringInAlphabeticalOrder(sc.next()));
				break;
			case "3":
				break;
			default:
				break;
		}
		// StringBuilder input = new StringBuilder("abcdabcd");
		// System.out.println(lengthOfLongestSubstringContainingUniqueCharacters(input));
		// input = new StringBuilder("aabbccdd");
		// System.out.println(lengthOfLongestSubstringContainingUniqueCharacters(input));
		// input = new StringBuilder("aaaa");
		// System.out.println(lengthOfLongestSubstringContainingUniqueCharacters(input));
		// input = new StringBuilder("");
		// System.out.println(lengthOfLongestSubstringContainingUniqueCharacters(input));
		// input = new StringBuilder("aabcd");
		// System.out.println(lengthOfLongestSubstringContainingUniqueCharacters(input));
		// input = new StringBuilder("abcdbcdef");
		// System.out.println(lengthOfLongestSubstringContainingUniqueCharacters(input));
	}	
}