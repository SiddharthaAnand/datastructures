package arrays;
import java.util.Scanner;
import java.util.Arrays;


class Pivot {
	public static int findPivot(int[] input, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			printValue("mid ", mid);
			if (input[mid] > input[mid+1]) {
				printValue("Inside if ", mid);
				return mid;
			}
			else if (input[mid] < input[mid+1] && input[mid] < input[low]) {
				return findPivot(input, low, mid);
			}
			else if (input[mid] < input[mid+1] && input[mid] > input[low]) {
				return findPivot(input, mid, high);
			}
		}
		return -1;
	}

	public static void printArray(String text, int[] array) {

		System.out.print(text + " ");
		for (int idx = 0; idx < array.length; idx++) {
			System.out.println(array[idx] + " ");
		}
		System.out.println();
	}

	public static void printString(String text) {
		System.out.println(text);
	}

	public static void sortArray(int[] array) {
		Arrays.sort(array);
	}

	public static void printValue(String text, int value) {
		System.out.println(text + " : " + value);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		printString("Enter the length of array: ");
		int len = sc.nextInt();
		int idx = 0;
		int[] array = new int[len];
		while (len > 0) {
			len -= 1;
			array[idx++] = sc.nextInt();
		}
		//sortArray(array);
		printValue("Pivot in array", findPivot(array, 0, array.length - 1));
	}
}