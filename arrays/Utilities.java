/**
 * Method overloading in action.
 */
package utilities;

public class Utilities {
	public static void print(String text, String delimeter, int[] array) {
		System.out.print(text + delimeter + " ");

		for (int idx = 0; idx < array.length; idx++) {
			System.out.print(array[idx] + " ");
		}
		System.out.println();
	}

	public static void print(String text, String delimeter, int value) {
		System.out.println(text + delimeter + " " + value);
	}

	public static void print(String text, String delimeter) {
		System.out.println(text + delimeter);
	}
}