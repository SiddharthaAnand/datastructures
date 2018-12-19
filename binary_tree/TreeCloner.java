// URL: 

package binary_tree;

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

public class TreeCloner {
	public static Node clone(Node tree) {
		if (tree == null) {
			return tree;
		}
		Node newNode = new Node(tree.data);
		newNode.left = clone(tree.left);
		newNode.right = clone(tree.right);
		return newNode;
	}

	public static void inOrder(Node tree) {
		if (tree == null) {
			return;
		}
		inOrder(tree.left);
		System.out.print(tree.data + " ");
		inOrder(tree.right);

	}

	public static void main(String[] args) {
		Node tree = new Node(1);
		tree.left = new Node(2);
		tree.right = new Node(3);
		tree.left.right = new Node(4);
		tree.left.left = new Node(5);
		Node cloneTree = clone(tree);
		inOrder(cloneTree);
		System.out.println();

	}	
}