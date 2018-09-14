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
	private static int checkSumTree(Node root) {
		if (root == null)	return true;
		if (root.left == null && root.right == null)	return root.value;
		int lValue = checkSumTree(root.left);
		int rValue = checkSumTree(root.right);

		if (lValue + rValue == root.value)
			return root.value;
		return -1;
	}

	public static void main(String[] args) {

	}
}