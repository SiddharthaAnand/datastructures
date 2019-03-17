/* Question: Find the length of longest substring which does not have any repeated characters.
 */

import java.util.Map;
import java.util.HashMap;

class LengthOfLongestSubstring {
	/* Sliding Window where the window has only unique characters in every iteration. 
	 * Every character visit is done only once.
	 * Time Complexity: O(n)
	 * Space complexity: O(n)
	 */
	public static int lengthOfLongestSubstringContainingUniqueCharacters(StringBuilder input) {
		int ans = 0;
		if (input == null || input.length() == 0) {
			return ans;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0, j = 0; i < input.length() && j < input.length();) {
			if (map.containsKey(input.charAt(j))) {
				i = Math.max(map.get(input.charAt(j))+1, i);
			}
			map.put(input.charAt(j), j);
			ans = Math.max(ans, j - i + 1);
			j++;
		}
		return ans;
	}
	public static void main(String[] args) {
		StringBuilder input = new StringBuilder("abcdabcd");
		System.out.println(lengthOfLongestSubstringContainingUniqueCharacters(input));
		input = new StringBuilder("aabbccdd");
		System.out.println(lengthOfLongestSubstringContainingUniqueCharacters(input));
		input = new StringBuilder("aaaa");
		System.out.println(lengthOfLongestSubstringContainingUniqueCharacters(input));
		input = new StringBuilder("");
		System.out.println(lengthOfLongestSubstringContainingUniqueCharacters(input));
		input = new StringBuilder("aabcd");
		System.out.println(lengthOfLongestSubstringContainingUniqueCharacters(input));
	}	
}