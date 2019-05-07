/* Question: Find the first x value where the y value is negative in a 
 * strictly monotonically decreasing function. 
 * Assumption: Atleast one positive value present.
 * Given: value of n(sizeof the array) not known in advance.
 * Solution: O(log k + log n) complexity
 */
import java.util.Scanner;

class ForwardBinarySearch {
	
	public static int binarySearch(int[] input, int left, int right) {
		if (left >= 0 && right >= 0 && input.length != 0) {
			while (left <= right) {
				int mid = (left + right) / 2;
				if (input[mid] < 0 && (mid-1) >= 0 && input[mid-1] >= 0) {
					return mid;
				}
				else if (input[mid] > 0) {
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

	public static int leastXValue(int[] input) {
		if (input.length == 1 && input[0] < 0) {
			return 0;
		}

		int jumper = 1;
		while (jumper <= input.length) {
			if (input[jumper-1] > 0) {
				jumper = jumper << 1;
				if (jumper > input.length) {
					jumper = input.length;
				}
			}
			else {
				return binarySearch(input, jumper >> 1, jumper);
			}
		}
		return -1;
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		System.out.println(leastXValue(input));
	}
}