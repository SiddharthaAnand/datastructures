package arrays;
import utilities.RandomInput;

public class Stub {
	private int[] input;
	public static void printArray(String text, int[] input) {
		System.out.print(text + ": ");
		for (int idx = 0; idx < input.length; idx++) {
			System.out.print(input[idx] + " ");
		}
		System.out.println();
	}

	public static void generateArray() {
		input = RandomInput.getRandomArray(10, 0, 10);
	}
}