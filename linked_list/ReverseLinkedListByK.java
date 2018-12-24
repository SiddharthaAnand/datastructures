/* URL: https://www.geeksforgeeks.org/reverse-linked-list-groups-given-size-set-2/
 * Question: Reverse the linked list in batches of k(given as input).
 * Solution Approach: Since the linked list remains as it is, we can simply
 * replace the elements and leave the nodes as it is.
 */

package linked_list;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Node {
	int data;
	Node next;

	Node (int d) {
		data = d;
	}
}


public class ReverseLinkedListByK {
	
	/* Assuming that the linked list size is divisible by k.
	 */
	public static void reverseByValue(Node head, Queue<Integer> q, int k) {
		if (head == null || k < 1)
			return;
		if (q.size() == k-1) {
			q.add(head.data);
			head.data = q.remove();
			return;
		}
		else {
			q.add(head.data);
			reverseByValue(head.next, q, k);
			head.data = q.remove();
		}
	}

	public static void reverseLListByK(Node head, int k) {

	}

	public static void print(Node head) {
		System.out.println();
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(4);
		head.next.next.next = new Node(5);
		head.next.next.next.next = new Node(6);
		head.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next = new Node(8);
		head.next.next.next.next.next.next.next = new Node(9);
		head.next.next.next.next.next.next.next.next = new Node(10);

		print(head);
		Queue<Integer> q = new LinkedList<Integer>();
		reverseByValue(head, q, 3);
		print(head);

	}
}