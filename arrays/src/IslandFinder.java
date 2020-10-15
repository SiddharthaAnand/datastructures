// URL: 
package arrays;

import java.util.Scanner;

class IslandFinder {
	
	private static int count = 0;

	private static void countIsland(int[][] matrix, int row, int col) {
		if (matrix == null || matrix.length == 0 || row < 0 || col < 0)
			return;


	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] matrix = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		countIsland(matrix, row, col);
		System.out.println("Number of islands: " + count);
	}
}

