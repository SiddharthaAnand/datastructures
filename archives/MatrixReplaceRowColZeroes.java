import java.util.Scanner;

/* Given a matrix, replace all rows and columns with zeroes,
 * where any place contains a zero.
 *
 */
class MatrixReplaceRowColZeroes {
	// See how matrix manipulation is done in Java
	public static void replaceZeroRowAndCol(int[][] matrix) {
		
		// Store position of zero in row and column
		int rows[] = new int[matrix.length];
		int columns[] = new int[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = 1;
					columns[j] = 1;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (rows[i] == 1 || columns[j] == 1)
					matrix[i][j] = 0;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int columns = sc.nextInt();
		int matrix[][] = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j =0; j < columns; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		replaceZeroRowAndCol(matrix);
	}
}