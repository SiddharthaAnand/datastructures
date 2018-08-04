// Code to check contents of array are equal.
import java.util.Scanner;
import java.util.Arrays;

class ArrayEquality {
	static boolean checkEquality(int arr1[], int arr2[]) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		// assuming both arrays are ofsame length
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inputSize = sc.nextInt();
		int[] arr1 = new int[inputSize];
		int[] arr2 = new int[inputSize];

		// Assuming both arrays are of same length
		// take input
		System.out.println("Enter values for the first array: ");
		for (int i = 0; i < inputSize; i++)
			arr1[i] = sc.nextInt();

		System.out.println("Enter values for the second array: ");
		for (int i = 0; i < inputSize; i++)
			arr2[i] = sc.nextInt();
		
		if(checkEquality(arr1, arr2)) {
			System.out.println("Both the arrays are equal");
		}
		else
			System.out.println("Both the arrays are not equal");
	}
}