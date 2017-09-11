import java.util.Scanner;
/* Given a matrix of size rows X cols, rotate the matrix by 90 degrees.
 * Input: Size of the matrix - rows and cols
 * Output: Rotated matrix by 90degrees clockwise directions
 */

class MatrixRotation {
	public static void rotateNow(int i, int j, int rows, int cols, int matrix[][], int levels) {
		if (i < 0 || j < 0 || rows < 0 || cols < 0 || matrix == null || levels < 0) return;

		int d = j;
		// Need some change here
		for (int k = i; k < rows; k++) {
			int x = matrix[i+j][cols];
			matrix[i+j][cols] = matrix[i][j];
			int y = matrix[rows][cols-j];
			matrix[rows][cols-j] = x;
			int z = matrix[rows-j][i];
			matrix[rows-j][i] = y;
			matrix[i][j] = z;
			++j;
		}
		System.out.println("===========Rotated Matrix - by 90 degrees========");
		for (int l = 0; l <= rows; l++) {
			for (int k = 0; k <= cols; k++) {
				System.out.print(matrix[l][k] + " ");
			}
			System.out.println();
		}

		
		if (levels <= (rows/2)) {
			++levels;
			System.out.println("Inside");
			rotateNow(i+1, i+1, rows-1, cols-1, matrix, levels);
		}
		System.out.println("===========Rotated Matrix - by 90 degrees========");
		for (int l = 0; l <= rows; l++) {
			for (int k = 0; k <= cols; k++) {
				System.out.print(matrix[l][k] + " ");
			}
			System.out.println();
		}
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		int matrix[][] = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		int levels = 1;
		rotateNow(0, 0, rows-1, cols-1, matrix, levels);
	}
}