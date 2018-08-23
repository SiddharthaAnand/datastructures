//https://www.geeksforgeeks.org/?p=18754
// Implement 2 stacks using an array.

package stacks;
import stacks.TwoStack;
import java.util.Scanner;

public class TwoStackClassHelper {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TwoStack ts = new TwoStack(10);
		int stack;
		while (true) {
			System.out.println("Enter 1/2 for Push/Pop");
			int val = sc.nextInt();
			switch(val) {
				case 1:
					System.out.println("Enter the value to push: ");
					int inp = sc.nextInt();
					System.out.println("Enter the stack to push: ");
					stack = sc.nextInt();
					switch(stack) {
						case 1:
							ts.pushFirstStack(inp);
							break;

						case 2:
							ts.pushSecondStack(inp);
						default:
							break;
					}
					break;
				case 2:
					System.out.println("Enter the stack to pop from: ");
					stack = sc.nextInt();
					switch(stack) {
						case 1:
							System.out.println(ts.popFirstStack());
							break;

						case 2:
							System.out.println(ts.popSecondStack());
						default:
							break;
					}
					break;
				default:
					break;
			}
		}
	}
}