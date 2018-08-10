/* Generate random numbers and do a quick sort analysis
 * over them.
 */
package sorts;
import java.util.Scanner;
import java.util.Random;
import sorts.QuickSort;

public class Analysis {
	
	public static void startSort(int[] array) {
		QuickSort.doQuickSort(array);
	}

	// Generates a random number between [0, arraySize)
	public static int generateRandomNumber(int arraySize) {
		Random rm = new Random();
		int random = rm.nextInt(arraySize);
		return random;
	}

	// Returns time in milliseconds since Jan, 1970
	// Used here to get the relative difference between
	// executions
	public static long getCurrentTime() {
		return System.currentTimeMillis();
	}

	public static void generateRandomArray(int[] array, int arraySize) {
		for (int idx = 0; idx < arraySize; idx++) {
			array[idx] = generateRandomNumber(arraySize);
		}
	}

	public static void writeToFile(int arraySize, long time) {

	}

	public static void printArray(int[] array) {
		System.out.println();
		for (int idx = 0; idx < array.length; idx++) {
			System.out.print(array[idx] + " ");
		}
		System.out.println();
	}

	public static void analysisMachine(int arraySize, int maxLimit) {
		int[] array = new int[arraySize];
		while (maxLimit > 0) {
			generateRandomArray(array, arraySize);
			//printArray(array);
			long startTimeInSeconds = getCurrentTime();
			startSort(array);
			long endTimeInSeconds = getCurrentTime();
			//printArray(array);
			writeToFile(arraySize, endTimeInSeconds - startTimeInSeconds);
			System.out.println("Time taken: " + (endTimeInSeconds - startTimeInSeconds));
			maxLimit -= 1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the randomly generated array:");
		int len = sc.nextInt();
		System.out.println("Enter the number of times it should generate a random array for an average analysis:");
		int maxLimit = sc.nextInt();
		analysisMachine(len, maxLimit);
	}
}