// Check if the tree is height-balanced

class Node {
	int data;
	Node left, right;
	Node(int data) {
		this.data = data;
		this.left = this.right = null;

	}
}

class HeighBalancedTree {
	static int max(int a,int b) {
		return a > b ? a : b;
	}

	// get the height of the binary tree
	// return the maximum of height of both
	// the left and right sub-trees
	public static int getHeight(Node head) {
		// no head or a single Node
		if (head == null || (head.left == null && head.right == null))	return 0;
		return max(1+getHeight(head.left), 1+getHeight(head.right));
	}

	public static void checkGetHeight() {
		Node head = new Node(5);
		head.left = new Node(4);
		head.right = new Node(6);
		head.left.left = new Node(4);
		head.left.right = new Node(8);
		head.left.right.left = new Node(8);
		head.left.right.left.left = new Node(8);
		int height = getHeight(head);
		if (height == 4) {
			System.out.println("-----Test Case Passed-----");
			System.out.println("Height of tree:	" + height);
		}
	}
	
	public static boolean checkForHeightBalanced(Node head) {

		if (head == null)
			return true;
		if (head.left == null && head.right == null)
			return true;
		if (Math.abs(getHeight(head.left) - getHeight(head.right)) <= 1 && checkForHeightBalanced(head.left) && checkForHeightBalanced(head.right)) {
			return true;
		}
		else {
			System.out.println("Position where the tree is unbalanced: " + head.data);
			return false;
		}
	}
	
	public static void main(String[] args) {
		//checkGetHeight();
		Node head = new Node(5);
		head.left = new Node(4);
		head.right = new Node(6);
		head.left.left = new Node(4);
		head.right.left = new Node(4);
		head.left.right = new Node(8);
		head.left.right.left = new Node(8);
		head.left.right.left.left = new Node(8);
		
		if (checkForHeightBalanced(head)) {
			System.out.println(" The tree is height-balanced");
		}
		else {
			System.out.println("The tree is not height-balanced");
		}

	}
}