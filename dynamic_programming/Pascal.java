// Nth line of Pascal's Triangle

import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

class Pascal {
	private static List<Integer> nthPascal(int n) {
		if (n <= 0)
			return null;
		List<Integer> result = new LinkedList<Integer>();
		if (n == 1) {
			result.add(1);
			return result;
		}
		int[][] pascalTriangle = new int[n+1][n+1];
		for (int rowIdx = 0; rowIdx < n; rowIdx++) {
			for (int colIdx = 0; colIdx <= rowIdx; colIdx++) {
				if (colIdx == 0 || colIdx == rowIdx) {
					pascalTriangle[rowIdx][colIdx] = 1;
					if (rowIdx == n-1)
						result.add(1);
				}
				else if (rowIdx == n-1) {
					result.add(pascalTriangle[rowIdx-1][colIdx] + pascalTriangle[rowIdx-1][colIdx-1]);
				}
				else {
					pascalTriangle[rowIdx][colIdx] = pascalTriangle[rowIdx-1][colIdx] + pascalTriangle[rowIdx-1][colIdx-1];
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the nth line to find out for pascal's triangle: ");
		int n = sc.nextInt();

		List<Integer> result = nthPascal(n);
		System.out.println();
		Iterator <Integer> it = result.iterator();
		
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		

	}
}