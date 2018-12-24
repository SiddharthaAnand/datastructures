package problem_solving;

import java.util.Scanner;

class StoreMinMax {
	int min;
	int max;

	StoreMinMax() {}
}

class FindSmallest {

	/* This method decreases the comparisons to 3*(n-1)/2
	 * Pick the elements in pairs and compare with only 
	 * either current maximum or current minimum.
	 */
	public static StoreMinMax findMinMax(int[] arr) {
		StoreMinMax store = new StoreMinMax();
		if (arr != null && arr.length == 1) {
			store.min = store.max = arr[0];
			return store;
		}
		int i = 0;
		// If the length is even, store max and min
		if (arr.length % 2 == 0) {
			if (arr[0] < arr[1]) {
				store.min = arr[0];
				store.max = arr[1];
				i = 2;
			}
			else {
				store.min = arr[1];
				store.max = arr[0];
			}
		}
		else {
			store.min = arr[0];
			store.max = arr[0];
			i = 1;
		}
		while (i < arr.length-1) {
			if (arr[i] < arr[i+1]) {
				if (store.min > arr[i]) {
					store.min = arr[i];
				}
				if (store.max < arr[i+1]) {
					store.max = arr[i+1];
				}
			}
			else {
				if (store.min > arr[i+1]) {
					store.min = arr[i+1];
				}
				if (store.max < arr[i]) {
					store.max = arr[i];
				}
			}
			i += 2;
		}
		return store;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 0;
		int[] arr = new int[n];
		while (i < n) {
			arr[i] = sc.nextInt();
			i += 1;
		}

		StoreMinMax store = findMinMax(arr);
		System.out.println("Minimum value: " + store.min);
		System.out.println("Maximum value: " + store.max);
	}
}