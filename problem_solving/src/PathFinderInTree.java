/* Find a path from root to a node if a value is present in one of the nodes in the tree.
 */
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node (int d) {
		data = d;
		left = null;
		right = null;
	}
}

class PathFinderInTree {

	static boolean present = false;
	public static void findPathHelper(Stack<Integer> st, Node root, int value) {
		if (root == null)
			return;
		else if (root.data == value) {
			st.push(root.data);
			present = true;
		}
		else {
			st.push(root.data);
			
			findPathHelper(st, root.left, value);
			if (present) {
				return;
			}
			findPathHelper(st, root.right, value);
			if (present) {
				return;
			}

			st.pop();
		}

	}
	public static Stack<Integer> findPath(Node root, int value) {

		Stack<Integer> st = new Stack<Integer>();
		findPathHelper(st, root, value);
		return st;
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		int value = 7;
		Stack<Integer> path = findPath(root, value);

		Iterator<Integer> it = path.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}
}