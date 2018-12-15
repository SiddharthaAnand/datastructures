// URL : https://www.geeksforgeeks.org/queue-using-stacks/
package problem_solving;

import java.util.Scanner;
import java.util.Stack;

class QueueUsingStack {

	private static void enqueue(Stack<Integer> queueUsingStack, int data) {
		queueUsingStack.push(data);
	}

	// Recursively, pop elements from the stack, pop out the last element,
	// and push the elements back again.
	// O(1) - Enqueue () operation
	// O(stack_size) - Dequeue () operation
	private static void dequeue(Stack<Integer> queueUsingStack, String top) {
		int topElement = queueUsingStack.pop();
		if (queueUsingStack.isEmpty()) {
			top = Integer.toString(topElement);
			System.out.print(top);
		}
		else {
			dequeue(queueUsingStack, top);
			enqueue(queueUsingStack, topElement);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> queueUsingStack = new Stack<Integer>();

		while (true) {
			System.out.println("Enter 1/2 for enqueue/dequeue in Queue: ");
			int input = sc.nextInt();

			switch(input) {
				case 1:
					System.out.println("Enter the value to be enqueued: ");
					int data = sc.nextInt();
					enqueue(queueUsingStack, data);
					break;
				case 2:
					if (!queueUsingStack.isEmpty()) {
						String top = "";
						dequeue(queueUsingStack, top);
						System.out.println("Dequeued!");
						break;
					}
					else {
						System.out.println("Stack is Empty!!");
						break;
					}
				case 3:
					break;
				default:
					break;
			}

		}
	}
}