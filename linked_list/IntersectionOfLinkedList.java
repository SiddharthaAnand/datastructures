/* The Intersection Point of Linked Lists
*/

import java.util.HashMap;
class Node {
	int data;
	Node next;
	Node(int d) {
		data = d;
		next = null;
	}
}

class IntersectionOfLinkedList {
	public static int getIntersection(Node one, Node two) {
		HashMap<Node, Boolean> map = new HashMap<Node, Boolean>();
		while (one != null) {
			map.put(one, true);
			one = one.next;
		}
		while (two != null) {
			if (map.containsKey(two)) {
				return two.data;
			}
			two = two.next;
		}
		return -1;
	}

	public static void main(String[] args) {
		Node listOne = new Node(1);
		listOne.next = new Node(2);
		listOne.next.next = new Node(3);
		Node listTwo = new Node(4);
		listTwo.next = listOne.next;

		System.out.println("Intersection point of linked list: " +getIntersection(listOne, listTwo));
	}
}