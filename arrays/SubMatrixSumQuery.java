/* Given a matrix find the sum of sub-matrices denoted by 
 * index positions given as input. You need to do it quickly
 * without calculating it at run time.
 */

package arrays;
import utilities.Utilities;

public class SubMatrixSumQuery {

	public static void initializeMatrix(int[][] cumulativeMatrix) {

	}
	
	// no need to return the matrix array since it manipulates the matrix in-place 
	// and by reference.
	public static void findCumulativeSumOfMatrix(int[][] cumulativeMatrix, int rowLen, int colLen) {
		int[][] buffer = new int[rowLen][colLen];
		for (int idx = 0; idx < rowLen; i++) {
			for (int _idx = 0; _idx < colLen; _idx++) {

			}
		}
	}

	public static void findSumOfSubMatrix(int[][] cumulativeMatrix, int rowL, int colL, int rowR, int colR) {
		return (cumulativeMatrix[rowR][colR] - cumulativeMatrix[rowL][colL]);
	}

	public static void main(String[] args) {
		// Assuming to be a square matrix
		Utilities.print("Enter the matrix size", ":");
		int len = Utilities.takeInputIntegerValue();
		int[][] matrix = new int[len][len];
		Utilities.print("Enter the matrix values", "");
		for (int idx = 0; idx < len; idx++) {
			for (int _idx = 0; _idx < len; _idx++) {
				matrix[idx][_idx] = sc.nextInput();
			}
		}
	}
}