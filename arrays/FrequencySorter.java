// URL: https://www.geeksforgeeks.org/sort-elements-by-frequency-set-5-using-java-map/

package arrays;

import java.util.*;

/* Use a Sorter which implements a Comparator and compares the values of a user-defined class.
 */
class Sorter implements Comparator<Integer> {

	HashMap<Integer, Integer> hm;
	Sorter(HashMap<Integer, Integer> map) {
		this.hm = map;
	}

	@Override
	public int compare(Integer x, Integer y) {
		int freqComp = hm.get(x) - hm.get(y);
		int valueComp = x - y;

		if (freqComp == 0)
			return valueComp;
		else
			return freqComp;
	}
}

public class FrequencySorter {
	
	static HashMap<Integer, Integer> storeFreq(int[] arr) {
		HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (hMap.containsKey(arr[i])) {
				hMap.put(arr[i], hMap.get(arr[i]) + 1);
			}
			else {
				hMap.put(arr[i], 1);
			}
		}
		return hMap;
	}

	static void sortByFrequency(int[] arr, List<Integer> output) {
		if (arr == null || arr.length == 0)
			return;

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm = storeFreq(arr);
		Sorter s = new Sorter(hm);
		Collections.sort(output, s);

	}

	static void print(List<Integer> output) {
		for (int i : output) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] arr = new int[length];
		List<Integer> output = new ArrayList<Integer>();

		for (int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
			output.add(arr[i]);
		}

		sortByFrequency(arr, output);
		print (output);
	}
}