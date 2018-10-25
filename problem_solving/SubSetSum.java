import java.util.Scanner;

public class SubSetSum {
	private static boolean subsetSum(int currSum, int sum, int[] a, int pos) {
		if (currSum == sum) {
			System.out.println("Possible");
			return true;
		}
		for(int i = pos; i < a.length; i++) {
			if (a[i] + currSum > sum) {
				continue;
			}
			return subsetSum(a[i] + currSum, sum, a, i+1);
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 0;
		int[] a = new int[n];
		while (i < n) {
			a[i++] = sc.nextInt();
		}
		int sum = sc.nextInt();
		System.out.println(subsetSum(0, sum, a, 0));
		//System.out.println("Sum possible: ");
	}
}