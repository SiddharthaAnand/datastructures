/* URL: https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
 */

package dynamic_programming;
import java.util.Scanner;


public class RodCuttingProblem {

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	/* Method recursively finds out better ways of cutting the rod
	 * for maximizing the cost. There are overlapping sub-problems
	 * which need not be computed again.
	 */
	private static int maximizeRodCutting(int rodSize, int[] prices) {
		int maxVal = Integer.MIN_VALUE;
		if (rodSize == 0 || rodSize == 1) {
			return prices[rodSize];
		}
		
		else {
			for (int i = 1; i <= rodSize; i++) {
				maxVal = max(maximizeRodCutting(rodSize-i, prices) + 
							prices[i],
							maxVal);
			}
		}
		return maxVal;
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the cost array: ");
		int size = sc.nextInt();

		int[] cost = new int[size+1];
		System.out.println("Enter the cost");
		for (int i = 1; i <= size; i++) {
			cost[i] = sc.nextInt();
		}

		System.out.println("Enter the size of the rod: ");
		int rod = sc.nextInt();
		System.out.println("maximum cost: " + maximizeRodCutting(rod, cost));

	}
}