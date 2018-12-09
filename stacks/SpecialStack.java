// URL: https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
// Design a special stack using the Stack class and which takes the same time complexity for 
// it's operations. Also, include an extra method to find minimum value in O(1) time.

package stacks;

import java.util.Scanner;
import java.util.Stack;

class SpecialStack {
	
	public static int getMin(Stack<Integer> minStack) {
		int v = Integer.MIN_VALUE;
		if (!minStack.isEmpty()) {
			v = minStack.peek();			
		}
		return v;
	}

	public static void push(Stack<Integer> stack, Stack<Integer> minStack, int data) {
		stack.push(data);
		if (minStack.isEmpty()) {
			minStack.push(data);
		}
		else {
			int top = minStack.peek();
			if (top > data) {
				minStack.push(data);
			}
			else {
				minStack.push(minStack.peek());
			}
		}
	}

	public static int pop(Stack<Integer> stack, Stack<Integer> minStack) {
		int data = Integer.MIN_VALUE;
		if (stack.isEmpty()) {
			return data;
		}
		else {
			data = stack.pop();
			int top = minStack.pop();
		}
		return data;
	}

	public static void main(String[] args) {
		// This is the stack which will store the inserted elements.
		Stack<Integer> stack = new Stack<Integer>();
		// This stack will store the current minimum value for every element entered in the stack.
		Stack<Integer> minStack = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("Enter 1/2/3 for push/pop/findMin in the stack: ");
			int ch = sc.nextInt();

			switch(ch) {
				case 1:
					System.out.println("Enter the data to be pushed in the stack: ");
					int data = sc.nextInt();
					push(stack, minStack, data);
					break;
				case 2:
					data = pop(stack, minStack);
					if (data == Integer.MIN_VALUE) {
						System.out.println("Stack is empty now!! Underflow...");
					}
					else {
						System.out.println("Popped: " + data);
					}
					break;
				case 3:
					System.out.println("Current min: " + getMin(minStack));
					break;
				default:
					break;
			}
		}

	}	
}