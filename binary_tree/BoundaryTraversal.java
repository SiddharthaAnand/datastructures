/* URL: https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1/?ref=self
 * Solution: We can print first nodes of every new level vertically and the leaf nodes.
 */

package binary_tree;

import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node (int d) {
		data = d;
		left = right = null;
	}
}

public class BoundaryTraversal {

	  TreeMap<Integer, Node> tmap = new TreeMap<Integer, Node>();

	/* This logic will add the nodes in a vertical manner.
	 */
	static void boundary(Node root, int dist) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			System.out.print(root.data + " ");
			return;
		}
		if (!tmap.containsKey(dist)) {
			System.out.print(root.data + " ");
			tmap.put(dist, root);
			boundary(root.left, dist-1);
			boundary(root.right, dist+1);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.right.right = new Node(25);

	}
}