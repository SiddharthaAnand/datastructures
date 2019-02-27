package linkedlist;
import java.util.*;

class Node {
	int data;
	Node next;
}

class AddNumbersInLinkedListClass {
	Node head;
	Node tail;
	public AddNumbersInLinkedListClass(int d) {
		head = new Node();
		head.data = d;
		head.next = null;
	}

	public Node createNode(int data) {
		Node somethingNew = null;
		try {
			somethingNew = new Node();
			somethingNew.data = data;
			somethingNew.next = null;
			return somethingNew;
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("Unable to create a new node :(");
		}
		return somethingNew;
	}

	public void addDigit(int digit) {
		Node temp = head;
		while (temp != null && temp.next != null) {
			temp = temp.next;
		}
		if (temp != null) {
			temp.next = createNode(digit);
		}
	}

	/* Method to add the number to the linked list representation of number.
	 * Need to consider all test cases:
	 * 1. No carry.
	 * 2. Carry without need for creation of new node.
	 * 3. Carry with need for creation of new node.
	 */
	public void finalSum(int number) {
		if (head != null) {
			// 2. If Carry condition is true
			if  ((number + head.data) > 9) {
				Node temp = head;
				int carry = number;
				// Go till the last node and check if there is need for creation of new node.
				while (temp.next != null && (carry + temp.data) > 9) {
					int val = temp.data;
					temp.data = (carry + temp.data) % 10;
					carry = (number + val) / 10;
					temp = temp.next;
				}
				// If last node reached, then check do we need to create a new node (if there is a non-zero carry)
				if (temp.next == null) {
					if ((carry + temp.data) > 9) {
						// Create a new node and then update the current value.
						temp.next = createNode((carry + temp.data) / 10);
						temp.data = (carry + temp.data) % 10;
					}
				}
				// If carry not required, then simply update the value.
				else {
					temp.data = carry + temp.data;
				}
			}
			else {
				head.data = number + head.data;
			}
		}
		else {

		}

	}

	public void print() {
		Node temp = head;
		System.out.println();
		while (temp != null) {
			System.out.println(temp.data+ " ");
			temp = temp.next;
		}
		System.out.println();
	}
}


public class AdditionLinkedListController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfDigits = sc.nextInt();
		AddNumbersInLinkedListClass number = null;
		while (numberOfDigits > 0) {
			numberOfDigits -= 1;
			int digit = sc.nextInt();
			if (number == null) {
				number = new AddNumbersInLinkedListClass(digit);
			}
			else {
				number.addDigit(digit);
			}
		}
		System.out.println("Enter the number in reverse order to be added: ");
		int no = sc.nextInt();
		number.finalSum(no);
		number.print();
	}
}