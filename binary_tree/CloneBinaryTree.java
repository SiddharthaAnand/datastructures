/* Question: Clone a given binary tree which also has an extra pointer as an attribute 
 * called a random pointer pointing to a random node of the same binary tree.
 * It is not necessary that every random pointer will be not null.
 * URL: https://www.geeksforgeeks.org/clone-binary-tree-random-pointers/
 */

import java.util.HashMap;

/* Defining the tree nodes as a class. */
class Node {
	int data;
	Node left;
	Node right;
	Node random;

	Node (int d) {
		data = d;
		left = null;
		right = null;
		random = null;
	}
}

public class CloneBinaryTree {
	/* Method which recursively clones only the left and right pointer nodes
	 * by creating a new node in every call, and maps the older node to the new
	 * node using a map.
	 */
	public static Node cloneOtherPointers(Node root, HashMap<Node, Node> map) {
		if (root == null) {
			return null;
		}
		Node clonedRoot = new Node(root.data);
		clonedRoot.left = cloneOtherPointers(root.left, map);
		clonedRoot.right = cloneOtherPointers(root.right, map);
		map.put(root, clonedRoot);
		return clonedRoot;
	}

	/* Method which only clones the random pointers using the map stored 
	 * while traversing the tree.
	 */
	public static void cloneRandomPointer(Node root, Node clonedRoot, HashMap<Node, Node> map) {
		if (root == null) {
			return;
		}
		clonedRoot.random = map.get(root.random);
		cloneRandomPointer(root.left, clonedRoot.left, map);
		cloneRandomPointer(root.right, clonedRoot.right, map);
	}

	public static void cloneHelper(Node root, HashMap<Node, Node> map) {
		Node clonedRoot = cloneOtherPointers(root, map);
		cloneRandomPointer(root, clonedRoot, map);
		System.out.println();
		System.out.println("Printing in InOrder way...");
		printInorder(clonedRoot);
		System.out.println("----------------------------");

	}

	public static void clone(Node root) {
		if (root != null) {
			HashMap<Node, Node> map = new HashMap<Node, Node>();
			cloneHelper(root, map);
		}
		else {
			return;
		}
	}
	
	public static void printInorder(Node root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print("\nCurrent Node: " + root.data + " ");
		if (root.random != null)
			System.out.print("Random for the current node: " + root.random.data + " ");
		printInorder(root.right);
	}

	public static void main(String[] args) {
		// Test case 1
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.random = root.left.right;
		root.left.random = root.right.left;
		root.left.left.random = root.right.right;
		clone(root);
	}
}