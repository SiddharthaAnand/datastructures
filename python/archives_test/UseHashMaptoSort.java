// Find the key with the highest frequency and lexicographically smallest.
// Using HashMap to do it.

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
class UseHashMaptoSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		while (input > 0) {
			input -= 1;
			String inp = sc.next();
			if (hm.containsKey(inp)) {
				hm.put(inp, hm.get(inp) + 1);
			}
			else {
				hm.put(inp, 1);
			}
		}

		// for-each
		String winner = "";
		int freq = 0; 
		for (Map.Entry h: hm.entrySet()) {
			if ((Integer)h.getValue() > freq) {
				winner = (String)h.getKey();
				freq = (Integer)h.getValue();
			}
			else if ((h.getValue() == freq) && winner.compareTo((String)h.getKey()) > 0) {
				winner = (String)h.getKey();
			}
		}
		System.out.println("Key with the highest frequency and lexicographically smallest: ");
		System.out.println(winner);
	}
}