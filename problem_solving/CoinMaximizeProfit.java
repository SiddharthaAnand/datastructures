//URL : https://www.spoj.com/problems/COINS/

import java.util.Scanner;

public class CoinMaximizeProfit {
	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static int maximizeProfit(int n) {
		if (n == 0 || n == 1 || n == 2 || n == 3 || n == 4)
			return n;
		//int[] prof = new int[n+1];
		//prof[0] = 0;
		//int val = 1;
		//while (val <= n) {
			//prof[val] = max(prof[val/2] + prof[val/3] + prof[val/4], val);
			//val++;
		//}
		return max(maximizeProfit(n/2)+maximizeProfit(n/3)+maximizeProfit(n/4), n);
		//return prof[n];
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(maximizeProfit(n));
	}
}