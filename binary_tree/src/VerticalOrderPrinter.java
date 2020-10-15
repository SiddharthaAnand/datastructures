/* URL: https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
 * Solution: Assign a token to every node, and add them as it recursively goes down
 * the tree.
 * TreeMap used here since it helps maintain the keys in sorted order. That is what we need here
 * to print the values from left to right vertically.
 */

package binary_tree;

import java.util.TreeMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* Node structure to hold the data and the pointers */
class Node {
	int data;
	Node left;
	Node right;

	Node (int d) {
		data = d;
		left = right = null;
	}
}

public class VerticalOrderPrinter {
	
	// Need this when we need the elements to be stored in a sorted order.
	private static TreeMap<Integer, LinkedList<Integer>> tm = new TreeMap<Integer, LinkedList<Integer>>();

	// Method overloading example here
	static void printVerticalOrder(Node root, int dist) {
		if (root == null)
			return;

		if (tm.get(dist) == null) {
			LinkedList<Integer> l = new LinkedList<Integer>();
			l.add(root.data);
			tm.put(dist, l);
		}
		else {
			LinkedList<Integer> l = tm.get(dist);
			l.add(root.data);
		}
		printVerticalOrder(root.left, dist-1);
		printVerticalOrder(root.right, dist+1);


	}

	/* Typically, this is how a treemap needs to be traversed.
	 */
	static void printMap() {
		System.out.println();
		for (Map.Entry<Integer, LinkedList<Integer>> entry : tm.entrySet()) {
			int key = entry.getKey();
			LinkedList<Integer> l = entry.getValue();
			Iterator it = l.iterator();
			System.out.print("Key: " + key + " : ");
			while (it.hasNext()) {
				System.out.print(it.next() + " ");
			}
			System.out.println();
		}
		
	}

	/* Helper method to do a vertical order print.
	 */
	static void printVerticalOrder(Node root) {
		int dist = 0;
		printVerticalOrder(root, dist);
	}

	/* Print the tree nodes in inorder.
	 */
	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

	public static void main(String[] args) {
		// Hard-coded values as input
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		root.right.right.left = new Node(10);
		root.right.right.right = new Node(9);
		root.right.right.left.right = new Node(11);
		root.right.right.left.right.right = new Node(12);
		
		System.out.println();
		printInorder(root);
		System.out.println();
		printVerticalOrder(root);
		printMap();

	}
}