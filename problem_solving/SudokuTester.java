import sudoku.Sudoku;
import java.util.Scanner;
import java.io.FileNotFoundException;

class SudokuTester {
	

	public static void print(int[][] matrix) {
		System.out.println("---------------------");
		System.out.println("---------------------");

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("---------------------");
		System.out.println("---------------------");
	}
	public static void main(String[] args) throws FileNotFoundException {
		Sudoku sudo = new Sudoku("sudoku_file");
		// check fileToMatrix method
		int[][] sudoMatrix = sudo.fileToMatrix(sudo.fileName);
		print(sudoMatrix);

	}


}