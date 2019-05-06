import java.util.Scanner;

class ForwardBinarySearch {
	
	public static int binarySearch(int[] input, int left, int right) {
		if (left >= 0 && right >= 0 && input.length != 0) {
			while (left <= right) {
				int mid = right - (left + right) / 2;
				if (input[mid] < 0 && mid-1 >= 0 && input[mid-1] >= 0) {
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
		while (jumper < input.length) {
			if (input[jumper] > 0) {
				jumper = jumper << 2;
			}
			else {
				return binarySearch(input, jumper >> 2, jumper);
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