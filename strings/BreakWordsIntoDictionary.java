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