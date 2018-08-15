import java.util.Scanner;
import java.util.HashMap;
// to use instead of an iterator over a hashmap
import java.util.Map;
// Stores the character position and the frequency, O(N) only once over the input.
class CountChar {
	int count;
	int position;
	CountChar(int pos) {
		this.count = 1;
		this.position = pos;
	}
	void incrementCount() {
		this.count++;
	}
	int getCount() {
		return count;
	}

	int getPos() {
		return position;
	}
}

class FirstUniqueCharacter {
	public static void findFirstUniqueChar(String input) {
		HashMap<Character, CountChar> hm = new HashMap<Character, CountChar>(26);
		for (int i = 0; i < input.length(); i++) {
			if (hm.containsKey(input.charAt(i)))	hm.get(input.charAt(i)).incrementCount();
			else {

				hm.put(input.charAt(i), new CountChar(i));
			}
		}
		// Iterate of HashMap
		int position = input.length();

		for (Map.Entry h: hm.entrySet()) {
			CountChar c = (CountChar)h.getValue();
			int pos = c.getPos();
			int count = c.getCount();
			if (count == 1 && pos < position) {
				position = pos;
			}
			
		}
		System.out.println("First Unique Character in String " + input + ": " + input.charAt(position));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		findFirstUniqueChar(input);
	}
}

