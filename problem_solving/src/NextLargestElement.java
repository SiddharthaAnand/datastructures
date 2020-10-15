import java.util.Stack;

class NextLargestElement {
	public static void nextLargest(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		Stack<Integer> st = new Stack<Integer>();
		int[] result = new int[arr.length];

		for (int idx = arr.length-1; idx >= 0; idx--) {
			if (st.isEmpty()) {
				result[idx] = -1;
				st.push(arr[idx]);
			}
			else {
				while (!st.isEmpty() && st.peek() <= arr[idx]) {
					st.pop();
				}
				if (st.isEmpty())
					result[idx] = -1;
				else
					result[idx] = st.peek();
				st.push(arr[idx]);
			}
		}

		for (int idx = 0; idx < result.length; idx++) {
			System.out.println(result[idx] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// int[] input = {1, 2, 3, 4};
		// nextLargest(input);
		int[] input = {4, 3, 2, 1};
		nextLargest(input);
		// int[] input = {5, 3, 1, 2};
		// nextLargest(input);
		// int[] input = {1, 1, 1, 1};
		// nextLargest(input);
		// int[] input = {3, 5, 4, 6};
		// nextLargest(input);
	}
}