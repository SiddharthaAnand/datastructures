/* URL: https://practice.geeksforgeeks.org/problems/fractional-knapsack/0/?ref=self
 *
 */

package name;
import java.util.Scanner;

public class FractionalKnapsack {
	
	private static int fractionalKnapsackMaximumProfit(int[] values, int[] weights) {
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		while (input > 0) {
			input -= 1;
			int N = sc.nextInt();
			int W = sc.nextInt();
			int n = N;
			int values[] = new int[N];
			int weights[] = new int[N];
			int idx = 0;
			while (2*n > 0) {
				n -= 1;
				values[idx] = sc.nextInt();
				weights[idx] = sc.nextInt();
				idx++;

			}

			System.out.println(fractionalKnapsackMaximumProfit(values, weights));
		}
	}
}