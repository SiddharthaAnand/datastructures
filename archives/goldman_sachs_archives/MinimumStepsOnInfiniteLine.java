import java.util.Scanner;

class MinimumStepsOnInfiniteLine {
	static int count = 0;
	static int findMinSteps(int source, int destination, int currJumpSize) {
		if (Math.abs(source) == Math.abs(destination))
			return currJumpSize;
		if (Math.abs(source) > Math.abs(destination))
			return Integer.MAX_VALUE;
	
		// go left by currJumpSize
		int right = findMinSteps(source + currJumpSize + 1, destination, currJumpSize + 1);
		//go right by currJumpSize
		int left = findMinSteps(source - currJumpSize - 1, destination, currJumpSize + 1);

		return right > left ? left:right;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------Enter the value to start from : ");
		int source = sc.nextInt();
		System.out.println("-------Enter the value to reach : ");
		int destination = sc.nextInt();
		System.out.println("Minimum jumps required are :" + 
							findMinSteps(Math.abs(source), Math.abs(destination), 0));
	}
}