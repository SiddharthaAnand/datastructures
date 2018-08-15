import java.util.Scanner;
import java.util.HashMap;


class Node {
	int data;
	Node next;
	Node(int data) {
		this.data = data;
		next = null;
	}
}

class IntersectionLinkedList {
	static Node findIntersection(Node head1, Node head2) {
		HashMap<Node, Integer> hm = new HashMap<Node, Integer>();
		while (head1 != null) {
			hm.put(head1, 1);
			head1 = head1.next;
		}

		while (head2 != null) {
			if (hm.containsKey(head2))
				return head2;
			head2 = head2.next;
		}
		return null;
	}
	
	public static void intersectNodeTestCase() {
		// 1. The linkedlists intersect
		// 2. They dont
		// 3. Single node intersection
		// 4. Single node no interesection
		// 5. null values one or both
		
		// first-already done in main function
		// 
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		// 2nd test case; 1st testcase
		Node head2 = new Node(6);
		head2.next = new Node(7);
		//head2.next.next = head1.next.next;
		head2.next.next = new Node(8);

		// 3rd test case
		Node head3 = new Node(11);
		Node head4 = head3;
		//5th test case
		Node head5 = null;
		Node head6 = null;
		
		Node intersectNode = findIntersection(head5, head6);
		if (intersectNode != null)
			System.out.println("They intersect at " + intersectNode.data);
		else
			System.out.println("They dont interesect at all");
	}
}
