// URL: https://www.geeksforgeeks.org/design-a-stack-with-find-middle-operation/

package stacks;

import java.util.Scanner;

class DoubleLinkedList {
	DoubleLinkedList prev;
	DoubleLinkedList next;
	int data;

	DoubleLinkedList(int d) {
		data = d;
	}
}

class SpecialStackUsingDLL {

	DoubleLinkedList top = null;
	DoubleLinkedList middle = null;
	private int length = 0;

	public DoubleLinkedList create(int data) {
		DoubleLinkedList node = new DoubleLinkedList(data);
		return node;
	}

	public void push(int data) {
		length++;
		if (top == null) {
			top = create(data);
			middle = top;
		}
		else {
			DoubleLinkedList tmp = create(data);
			top.next = tmp;
			tmp.prev = top;
			top = tmp;
			if (length % 2 != 0) {
				middle = middle.next;
			}
		}
	}

	public int pop() {
		int data = Integer.MIN_VALUE;
		if (top == null) {
			return data;
		}
		else {
			DoubleLinkedList tmp = top;
			data = tmp.data;
			top = top.prev;
			if (top != null) {
				top.next = null;
			}
			tmp = null;
			length--;
			if (length % 2 == 0) {
				middle = middle.prev;
			}
		}
		return data;
	}

	public int getMiddleElement() {
		if (middle != null) {
			return middle.data;
		}
		else {
			return Integer.MIN_VALUE;
		}
	}

	public void deleteMiddleElement() {
		if (middle != null) {
			length--;
			if (length == 0) {
				top = null;
			}
			if (length < 3) {
				DoubleLinkedList tmp = middle;
				middle = middle.next;
				if (middle != null)
					middle.prev = null;
				tmp = null;
			}
			else if (length % 2 == 0) {
				DoubleLinkedList tmp = middle;
				middle.prev.next = middle.next;
				middle.next.prev = middle.prev;
				middle = middle.prev;
				tmp = null;
			}
		}
	}

}

public class SpecialStackImplementer {
	public static void main(String[] args) {
		SpecialStackUsingDLL stack = new SpecialStackUsingDLL();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("Enter 1/2/3/4 to push/pop/getMiddleElement/deleteMiddleElement from the stack: ");
			int ch = sc.nextInt();
			switch (ch) {
				case 1:
					System.out.println("Enter the data to push to stack: ");
					int inp = sc.nextInt();
					stack.push(inp);
					break;
				case 2:
					int val = stack.pop();
					if (val != Integer.MIN_VALUE) {
						System.out.println("Popped: " + val);
					}
					else {
						System.out.println("Empty stack!!");
					}
					break;
				case 3:
					int d = stack.getMiddleElement();
					if (d != Integer.MIN_VALUE) {
						System.out.println("middle element of the stack: " + d);
					}
					else {
						System.out.println("No middle element present");
					}
					break;
				case 4:
					stack.deleteMiddleElement();
					System.out.println("Middle element deleted");
					break;
				default:
					break;
			}
		}
	}
}