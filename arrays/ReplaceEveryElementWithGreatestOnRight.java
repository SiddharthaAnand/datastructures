package arrays;
import utilities.RandomInput;

public class ReplaceEveryElementWithGreatestOnRight {
	// Possible in single pass of the array
	private static void replace(int[] array) {
		int largest = array[array.length - 1];
		for (int idx = array.length-2; idx >= 0; idx--) {
			int temp = array[idx];
			array[idx] = largest;
			if (temp > largest) {
				largest = temp;
			}
		}
		// The rightmost element will always have the value -1
		array[array.length-1] = -1;
	}

	public static void printArray(int[] array) {
		System.out.println();
		for (int idx = 0; idx < array.length; idx++) {
			System.out.print(array[idx] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// generate random numbers in range [-10, 10)
		int[] input = RandomInput.generateArray(10, 0, 100);
		printArray(input);
		replace(input);
		printArray(input);
	}
}