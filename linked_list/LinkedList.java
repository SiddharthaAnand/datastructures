/* URL: 
 */

package linked_list;

import java.util.Scanner;

class Node {
	Node next;
	int data;

	Node (int d) {
		data = d;
	}
}

class LinkedList {

	public static void nodeDeleteHelper(Node node) {
		if (node == null)
			return;

	}
	public static void replaceAlternateNodesLinkedListInPlace(Node head) {
		
		// If there are 2 nodes then no need to do anything
		if (head == null || head.next == null || head.next.next == null) {

		}
		// 1. Go till the end for every node and replace and remove the last node (simple solution - O(n^2) time)
		else {
			Node runner = head;
			while (runner != null) {
				Node temp = runner;
				Node prev = temp;
				while (temp.next != null) {
					prev = temp;
					temp = temp.next;
				}
				Node holder = runner.next;
				runner.next = temp;
				temp.next = temp.next != null ? holder : temp.next;
				prev.next = prev.next.next != null ? null: prev.next;
				runner = runner.next != null ? runner.next.next: runner.next;
				print(head);
			}
		}
	}

	public static void print(Node head) {
		System.out.println();
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		print(head);
		replaceAlternateNodesLinkedListInPlace(head);
		print(head);
	}
}