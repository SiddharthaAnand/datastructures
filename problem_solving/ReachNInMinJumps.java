/* Question: https://www.geeksforgeeks.org/minimum-steps-to-reach-a-destination/
 * At every ith turn, you can jump exactly i steps to the right or to the left.
 * You have to reach a certain place (n), with the least number of jumps.
 */

class ReachNInMinJumps {
	
	private static long minStepsToReachN(int source, int valueAddedTillNow, int destination) {
		if (source == destination) {
			return valueAddedTillNow;
		}
		if (Math.abs(source) > destination) {
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
		System.out.println((minStepsToReachN(0, 0, Math.abs(-1)) == 1) ? "Testcase passed" : "Testcase failed");
	}
}