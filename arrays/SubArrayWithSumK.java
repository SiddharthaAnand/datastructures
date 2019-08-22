/* Question: Find the subarray which has the sum equal to a given value K.
 * URL:
 * Given: K >= 0 and arr[i] >= 0 for all i.
 */

import java.util.Scanner;

class SubArrayWithSumK {
	public static void findSubArrayWithSumK(int[] arr,
											int K) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int start = 0, currSum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			currSum += arr[i];
			while (currSum > K && start < i) {
				currSum -= arr[start];
				start++;
			}
			if (currSum == K) {
				System.out.println("start: " + start + " end: " + i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int i = 0;
		while (i < n) {
			arr[i] = sc.nextInt();
			i++;
		}
		System.out.println("Enter the sum to be found: ");
		int K = sc.nextInt();
		findSubArrayWithSumK(arr, K);
	}
}