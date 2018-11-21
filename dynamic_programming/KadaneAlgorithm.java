package dynamic_programming;
import java.util.Scanner;

public class KadaneAlgorithm {

	/* The logic behind this algorithm is that we should keep 
	 * continuing storing the sum of the array elements until
	 * the sum becomes negative. Once it is negative, then 
	 * it cannot be part of a bigger sum. 
	 * If the runnning sum is positive, then keep adding the 
	 * current element so that it gets added in a part of the 
	 * bigger sum.
	 */
	private static int getMaximumSumFromSubarray(int[] input) {
		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++) {
			currSum += input[i];
			if (currSum > maxSum)
				maxSum = currSum;
			else if (currSum < 0)
				currSum = 0;
		}
		return maxSum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] input = new int[length];
		int i = 0;

		while (length > 0) {
			length -= 1;
			input[i++] = sc.nextInt();
		}

		System.out.println("Maximum sum out of all sub-arrays: " + getMaximumSumFromSubarray(input));
	}
}