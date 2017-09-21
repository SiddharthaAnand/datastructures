import java.util.Scanner;

/* Question: Generate all the subsets of a set. 
 * Input: 3
 *        1 2 3
 * Output: All subsets of the given set.
 * The first line of the input denotes the size of the set. The second line denotes the elements of the set.
 * There are two methods doing the same generation - one recursive and the other based on bit position of the sets.
 * Question from Cracking the coding interview
 */
class SubsetGeneration {
	public static void generate(int[] subset) {
		int length = subset.length;
		
		int count = 0;
		int numberOfSubsets = 1 << length;
		while (count < numberOfSubsets) {
			int bit = 1;
			System.out.print("{");
			for (int i = 0; i < length; i++) {
				if ((bit & count) > 0) {
					System.out.print(subset[i] +",");
				}
				bit = bit << 1;
			}
			count++;
			System.out.println("}");
		}
	}

	// Utility method to print the set elements.
	public static void printArray (int temp[]) {
		System.out.print("[ ");
		for (int i = 0; i < temp.length; i++) {
			// Assumed that the set cannot contain zeroes - 0s
			if (temp[i] != 0) {
				System.out.print(temp[i] + "," );
			}
		}
		System.out.println(" ]");
	}

	public static void recursiveGenerate(int[] subset, int temp[], int k) {
		// Base Case: When the length of the temp has reached the end
		if (k == subset.length) {
			// Print the temp array
			printArray(temp);
			return;
		}

		// Either the element is present in the set.
		temp[k] = subset[k];
		recursiveGenerate(subset, temp, k + 1);
		// Or the element is not present in the set - 0 denotes absence.
		temp[k] = 0;
		recursiveGenerate(subset, temp, k + 1);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] subset = new int[size];

		for (int i = 0; i < size; i++) {
			subset[i] = sc.nextInt();
		}
		
		// Choose as to which method to be called.
		System.out.println(" Which method do you want to use: ?");
		System.out.println(" 1. Bit-position generation  ");
		System.out.println(" 2. Recursive generation  ");
		int input = sc.nextInt();
		if (input == 1) 
			generate(subset);
		else if (input == 2) {
			int temp[] = new int[size];
			recursiveGenerate(subset, temp, 0);
		}
		else {
			System.exit(0);
		}
	}
}