package problem_solving;

import java.util.Scanner;

class MatrixRotation {
	
	private static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void rotateBy90(int[][] matrix) {
		int length = matrix.length;
		// Transpose and then swap the columns
		for (int i = 0; i < length; i++) {
			for (int j = i+1; j < length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length/2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][length - j - 1];
				matrix[i][length - j - 1] = temp;
			}
		}
		print(matrix);
	}

	private static void rotateMatrix(int rotateAngle, int[][] matrix) {
		if (rotateAngle != 90 && rotateAngle != 180 && rotateAngle != 270) {
			System.out.println("Rotation angle should be one of [90, 180, 270]");
			return;
		}
		else if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
			System.out.println("matrix is either null or empty or not a square matrix");
			return;
		}
		else if(rotateAngle == 90) {
			rotateBy90(matrix);
		}
		else if (rotateAngle == 180) {
		//	rotateBy180(matrix);
		}
		else if (rotateAngle == 270) {
		//	rotateby270(matrix);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int[][] matrix = new int[row][row];
		int col = row;
		int len = col;
		int i = 0, j = 0;
		while (row > 0) {
			row -= 1;
			col = len;
			while (col > 0) {
				col -= 1;
				matrix[i][j] = sc.nextInt();
				j++;
			}
			i++;
			j = 0;
		}
		int rotateAngle = sc.nextInt();
		rotateMatrix(rotateAngle, matrix);
	}
}