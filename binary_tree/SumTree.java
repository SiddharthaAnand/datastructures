package binary_tree;

class Node {
	int value;
	Node left;
	Node right;

	Node(int v) {
		value = v;
		left = null;
		right = null;
	}
}

public class SumTree {
	private static int sum(Node root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.value;
		return sum(root.left) + sum(root.right) + root.value;
	}

	private static boolean checkSumTree(Node root) {
		// If the root is null, then it is a sum tree.
		if (root == null)	return true;
		// if it is a leaf node, then it is sum-tree.
		if (root.left == null && root.right == null)	return true;

		int lValue = sum(root.left);
		int rValue = sum(root.right);

		if (lValue + rValue == root.value && checkSumTree(root.left) && checkSumTree(root.right))
			return true;
		return false;
	}

	public static void main(String[] args) {
		Node root = new Node(26);
		root.left = new Node(10);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(6);
		root.right.right = new Node(3);
		//root.left.left.right = new Node(7);
		System.out.println();
		System.out.println(checkSumTree(root));
		System.out.println();
	}
}