/* Question: Find a loop in a given linked list.
 */

class Node {
	Node next;
	int data;
	Node (int d) {
		data = d;
		next = null;
	}
}

public class LoopFinder {
	/* Test Cases
	 * 1->2->1
	 * 1->1
	 * null
	 * 1->2->3->4->2
	 * 1->2->3->null
	 * 1->2->3->4->1
	 * 1->null
	 * 1->2->null
	 */
	public static boolean loopFinder(Node head) {
		//Application of tortoise and hare algorithm
		if(head == null || head.next == null) {
			return false;
		}
		Node tortoise = head;
		Node hare = tortoise.next;
		
		while (tortoise != hare && hare != null && hare.next != null) {
			tortoise = tortoise.next;
			hare = hare.next.next;
		}

		if (tortoise == hare && hare != null) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = head.next;
		System.out.println(loopFinder(head));

	}
}