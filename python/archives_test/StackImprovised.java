/* Problem: Implement a stack (using util.Stack) which returns minimum element in O(1) time.
 *          Other functions must remain as it is.
 */
import java.util.Stack;
import java.util.Scanner;

class StackImprovised {

	public static int getMin(Stack<Integer> minStack) {
		if (!minStack.isEmpty()) {
			return minStack.peek();
		}
		return -99999;
	}

	public static void push(Stack<Integer> stack, Stack<Integer> minStack, int value) {
		if (stack.isEmpty()) {
			stack.push(value);
			minStack.push(value);
		}
		else {
			stack.push(value);
			if (minStack.peek() > value) {
				minStack.push(value);
			}
			else {
				minStack.push(minStack.peek());
			}
		}
	}

	public static int pop(Stack<Integer> stack, Stack<Integer> minStack) {
		if (stack.isEmpty()) {
			return -99999;
		}
		else {
			minStack.pop();
			return stack.pop();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> minStack = new Stack<>();

		System.out.println();
		System.out.println();
		while(true) {
			System.out.println("1. To Push, Enter                : 1 X");
			System.out.println("2. To Pop, Enter                 : 2");
			System.out.println("3. To Peek, Enter                : 3");
			System.out.println("4. To get current minimum, Enter : 4");
			System.out.println("5. To exit, Enter                : 5");
			String input = sc.nextLine();
			char method = input.charAt(0);

			switch(method) {
				case '1':
					int val = Character.getNumericValue(input.charAt(2));
					push(stack, minStack, val);
					break;
				case '2':
					System.out.println("Element at the top: " + pop(stack, minStack));
					break;
				case '3':
					System.out.println("Element at the top: " + stack.peek());
					break;
				case '4':
					System.out.println("Current minimum: " + getMin(minStack));
					break;
				case '5':
					System.exit(0);
					break;
				default:
					System.out.println("Please enter a valid value");
					break;
			}
		}
	}
}