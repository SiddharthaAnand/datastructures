import java.util.HashMap;
class Node {
	int data;
	Node next;
	Node (int d) {
		this.data = d;
		this.next = null;
	}
}

class IntersectionPointLL {
	// @return the Node which is the intersection point.
	public static Node getIntersection(Node head_1, Node head_2) {
		//if (head_1 == null || head_2 == null) return;
		Node temp = head_1;
		// Using a hashmap to store the address of the nodes/
		// If the same node is visited again, then that is the
		// intersection point.
		HashMap<Node, Integer> hm = new HashMap<Node, Integer>();
		int count = 0;
		while (head_1 != null) {
			hm.put(head_1, count);
			count++;
			head_1 = head_1.next;
		}

		while(head_2 != null) {
			if (hm.containsKey(head_2)) {
				temp = head_2;
				break;
			}
			head_2 = head_2.next;
		}
		return temp;
	}

	static void print(Node head) {
		while(head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

	public static void main(String[] args) {
		/*
		 * 1  -->  2  -->  3  -->  null = head
		 * 1-->3--^  = head2
		 * The structure above is defined below.
		 */
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		Node head2 = new Node(1);
		head2.next = new Node(3);
		head2.next.next = head.next;
		System.out.println("-----First list-----");
		print(head);
		System.out.println("-----Second list-----");
		print(head2);
		System.out.println("Prints the node data where the intersection starts");
		System.out.println(getIntersection(head, head2).data);
	}
}
