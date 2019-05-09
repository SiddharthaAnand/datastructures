/* Question: Find the longest string with repeating characters.
 * In case of a tie, return the leftmost string.
 * Solution: Return the starting position and the length of the string.
 *
 * Input: "11110011"
 * Output: [0, 4]
 * Input: "abcda"
 * Output: [0, 1]
 * Input: "aabbbbcd"
 * Output: [2, 4]
 */

class LongestUniformString {
	
	/* Complexity of O(n). Continue to increment the right pointer
	 * till you get the characters to be the same as the left pointer.
	 * As soon as there is a mismatch, compare the current length with
	 * the maximum length. If it is true, then replace the values accordingly
	 * else, update the left pointer and right pointers to start a fresh
	 * comparison.
	 */ 
	private static int[] getUniformString(String input) {
		int start = 0;
		int maxLength = -1;
		if (input == null || input.length() == 0) {
			return new int[] {start, maxLength};
		}
		int leftPtr = 0;
		int rightPtr = 0;
		while ((rightPtr + 1) < input.length()) {
			if (input.charAt(rightPtr + 1) == input.charAt(leftPtr)) {
				rightPtr++;
			}
			else {
				if ((rightPtr - leftPtr + 1) > maxLength) {
					start = leftPtr;
					maxLength = rightPtr - leftPtr + 1;
					leftPtr = rightPtr + 1;
					rightPtr++;
				}
				else {
					leftPtr++;
					rightPtr++;
				}
			}
		}
		if ((rightPtr - leftPtr + 1) > maxLength) {
			start = leftPtr;
			maxLength = rightPtr - leftPtr + 1;
			leftPtr = rightPtr + 1;
			rightPtr++;
		}
		return new int[] {start, maxLength};
	}

	public static void main(String[] args) {
		//assert (getUniformString("11110001").equals(new int[]{0, 4}));
		
		int[] res = getUniformString("10");
		System.out.println(res[0] + " " + res[1]);
	}
}