/* Question: https://www.geeksforgeeks.org/minimum-steps-to-reach-a-destination/
 * At every ith turn, you can jump exactly i steps to the right or to the left.
 * You have to reach a certain place (n), with the least number of jumps.
 */

class ReachNInMinJumps {
	
	private static long minStepsToReachN(int source, int valueAddedTillNow, int destination) {
		if (source == destination) {
			return valueAddedTillNow;
		}
		// Taking the absolute value here since reaching k and -k are symmetric. So considering only 
		// positive values. Reaching k and -k, the number of jumps would be the same.
		// Also, Can we reach every number ?
		// We can. Since, going from i to i+1, we can take k jumps to the left and k+1 to the right
		// and increment the step by one. So, all values are reachable.
		if (Math.abs(source) > Math.abs(destination)) {
			return Integer.MAX_VALUE;
		}
		long leftJumpCount = minStepsToReachN(source - (valueAddedTillNow + 1), valueAddedTillNow + 1, destination);
		long rightJumpCount = minStepsToReachN(source + (valueAddedTillNow + 1), valueAddedTillNow + 1, destination);

		return leftJumpCount < rightJumpCount ? leftJumpCount : rightJumpCount;
	}
	
	public static void main(String[] args) {
		System.out.print("(minStepsToReachN(0, 0, 2) == 3) - ");
		System.out.println((minStepsToReachN(0, 0, 2) == 3) ? "Testcase passed" : "Testcase failed");
		System.out.print("(minStepsToReachN(0, 0, 1) == 1) - ");
		System.out.println((minStepsToReachN(0, 0, 1) == 1) ? "Testcase passed" : "Testcase failed");
		System.out.print("(minStepsToReachN(0, 0, -1) == 2) - ");
		System.out.println((minStepsToReachN(0, 0, -2) == 3) ? "Testcase passed" : "Testcase failed");
		/* Can run this code by running the following command:
		 * java -ea ReachNInMinJumps
		 * -ea means enabled assertions
		 * assert (minStepsToReachN(0, 0, 2) == 3);
		 */
	}
}