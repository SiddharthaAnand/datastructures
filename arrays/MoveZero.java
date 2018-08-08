/* Move all the zeroes to the end of the given
 * input array.
 */
package arrays;
import utilities.Utilities;

public class MoveZero {
	public static void moveZeroesToEnd(int[] array) {
		int lastIdx = array.length-1;
		int firstIdx = 0;
		while (firstIdx < lastIdx) {
			if (array[firstIdx] == 0 && array[lastIdx] != 0) {
				int temp = array[firstIdx];
				array[firstIdx] = array[lastIdx];
				array[lastIdx] = temp;
				firstIdx++; lastIdx--;
			}
			else if (array[firstIdx] == 0 && array[lastIdx] == 0) {
				lastIdx--;
			}
			else if (array[firstIdx] != 0) {
				firstIdx++;
			}
		}
	}

	public static void main(String[] args) {
		Utilities.print("Enter the length of array", ":");
		int len = Utilities.takeInputIntegerValue();
		
		int[] array = new int[len];
		int idx = 0;
		Utilities.print("Enter the values of the array", ":");
		while (len > 0) {
			len -= 1;
			array[idx++] = Utilities.takeInputIntegerValue();
		}
		moveZeroesToEnd(array);
		Utilities.print("Array modified", ":", array);

	}
}