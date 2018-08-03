import java.util.Scanner;
import java.util.Arrays;

class BinarySearch {
	// Assuming that the input[] is sorted.
	// [4 5 1 2 3] [3 4 5 1 2] [2 3 4 5 1] [1 2 3 4 5]
	public static int findPivotInRotatedArray(int[] input, int lowPos, int highPos) {
		int pivotPosition = -1;
		while (lowPos < highPos) {
			int mid = (lowPos + highPos) / 2;
			if (mid+1 <= highPos && input[mid] > input[mid+1]) {
				pivotPosition = mid;
				return pivotPosition;
			}
			else if (mid < highPos && input[mid] < input[lowPos]) {
				highPos = mid;
			}
			else {
				lowPos = mid;
			}
		}
		return pivotPosition;
	}

	public static int[] rotateArray(int[] input, int d) {
		int[] temp = new int[d];
		for (int i = 0; i < d; i++) {
			temp[i] = input[i];
		}
		int val = 0;
		for (int i = d; i < input.length; i++) {
			input[val++] = input[i];
		}
		for (int i = 0; i < d; i++) {
			input[val++] = temp[i];
		}
		return input;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int input[] = new int[size];
		int arrSize = 0;
		while (size > 0) {
			size -= 1;
			int temp = sc.nextInt();
			input[arrSize++] = temp;
		}
		Arrays.sort(input);
		print(input);
		rotateArray(input, 4);
		print(input);
		int pivotPosition = findPivotInRotatedArray(input, 0, input.length-1);
		printValue(pivotPosition);

	}

	public static void printValue(int value) {
		System.out.println("Pivot position: " + value);
	}

	public static void print(final int[] arr) {
		System.out.print("Length (" + arr.length + ") :[ ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("]");
	}
}