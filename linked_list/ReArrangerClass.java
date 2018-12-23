// URL: https://www.geeksforgeeks.org/rearrange-a-given-linked-list-in-place/

package linked_list;

class Node {
	int data;
	Node next;
}

public class ReArrangerClass {
	
	public static void rearrange(Node head) {

	}

	public static void print(Node head) {
		System.out.println();
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void reverse(Node head) {

	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);

	}
}