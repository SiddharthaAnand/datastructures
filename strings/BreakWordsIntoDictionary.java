// Question: https://www.geeksforgeeks.org/word-break-problem-using-backtracking/
/* This problem has been solved using the backtracking approach. This removes
 * extra branches/calls and avoids them which are unnecessary.
 */
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

class BreakWordsIntoDictionary {
	
	public static void printList(String input, ArrayList<String> list) {
		Iterator<String> it = list.iterator();
		System.out.println("Possible for " + input);
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

	/* Split the words by taking a pointer and keeping it at a certain position and check if
	 * the word formed from this to the idx is present or not in dictionary. 
	 * If present, then put the split pointer to the next value of idx and continue to 
	 * search for the next word from that position.
	 */
	public static void splitWords(String input, HashMap<String, Boolean> dictionary, ArrayList<String> list, int splitPos) {
		if (input == null || input.length() == 0) {

		}
		if (splitPos == input.length()) {
			printList(input, list);
		}
		else {
			for (int idx = splitPos; idx < input.length(); idx++) {
				if (dictionary.containsKey(input.substring(splitPos, idx+1))) {
					list.add(input.substring(splitPos, idx+1));
					splitWords(input, dictionary, list, idx+1);
					list.remove(list.size()-1);
				}
			}
		}

	}

	public static void main(String[] args) {
		HashMap<String, Boolean> dict = new HashMap<String, Boolean>();
		dict.put("i", true);
		dict.put("love", true);
		dict.put("samsung", true);
		dict.put("sam", true);
		dict.put("sung", true);
		dict.put("am", true);
		int splitPos = 0;
		String input = "iamlovesamsung";
		ArrayList<String> list = new ArrayList<String>();
		splitWords(input, dict, list, splitPos);
	}
}