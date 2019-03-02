package problem_solving;
import java.util.Scanner;

public class CountPerfectSquares {
	// Returns the count inclusive of X and Y.
	public static int perfectSquareCount(int X, int Y) {
		// No negative numbers allowed.
		if (X < 0 || Y < 0) {
			System.out.println("Negative ranges not allowed");
			return -1;
		}

		double rootX = Math.ceil(Math.sqrt(X));
		double rootY = Math.floor(Math.sqrt(Y));
		int d = (int)(rootY - rootX);
		return (d + 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();

		int result = perfectSquareCount(X, Y);
		if (result != -1) {
			System.out.println("Count of perfect squares between " + X + " and " + Y + " is " + result);
		}
	}
}
