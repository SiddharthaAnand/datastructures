// URL: https://www.geeksforgeeks.org/rearrange-a-given-linked-list-in-place/

package linked_list;

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
	}
}

public class ReArrangerClass {
	
	// 1. Divide the linked list in two halves
	// 2. Reverse the second half
	// 3. Merge the nodes alternatively to make the final linked list.
	public static void rearrange(Node head) {
		Node middle = findMiddle(head);
		print(middle);
		Node anotherList = reverse(middle.next);
		print(anotherList);
		middle.next = null;
		
		// merge the two lists alternatively
		Node tmp1 = head.next;
		Node tmp2 = anotherList.next;
		while (anotherList.next != null && head.next != null) {
			head.next = anotherList;
			anotherList.next = tmp1;
			head = tmp1;
			tmp1 = tmp1.next;
			anotherList = tmp2;
			tmp2 = tmp2.next;
		}
		if (anotherList.next != null) {
			head.next = anotherList;
			//head = head.next;
			//anotherList = anotherList.next;
		}
		if (head.next != null) {
			tmp1 = head.next;
			head.next = anotherList;			
			anotherList.next = tmp1;
		}
	}

	// Find the middle of the linked list using hare-tortoise method
	public static Node findMiddle(Node head) {
		Node tortoise = head;
		Node hare = head;

		while (hare != null && hare.next != null) {
			tortoise = tortoise.next;
			hare = hare.next.next;
		}
		return tortoise;
	}

	public static void print(Node head) {
		System.out.println();
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	// Reverse a linked list and return the pointer to the head
	public static Node reverse(Node head) {
		Node prev = null;
		Node curr = head;
		Node nex = head.next;

		while (curr != null && curr.next != null) {
			curr.next = prev;
			prev = curr;
			curr = nex;
			nex = nex.next;
		}
		curr.next = prev;
		head = curr;
		return head;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);

		print(head);
		rearrange(head);
		print(head);

	}
}