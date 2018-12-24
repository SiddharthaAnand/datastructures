package binary_tree;

/* Data structure to store a data and left and right pointers too
 * which will be mapped as previous and next pointers as in a DLL.
 */
class Node {
	int data;
	Node left;
	Node right;

	Node (int d) {
		data = d;
		left = right = null;
	}
}

/* Keep a pointer to the last visited node after the recursive call,
 * And then re-assign the pointers.
 */


public class BinaryTreeToDLL {

	static Node head = null;
	static Node prev = null;

	/* iterate over the nodes as a linked and see if it prints all the nodes
	 * or not.
	 */
	public static void dListChecker() {
		System.out.println();
		// Referring to the static head pointer
		Node tmp = head;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.right;
		}
		System.out.println();
	}

	public static void converter(Node root) {
		
		if (root == null)
			return;

		converter(root.left);
		// Reached the leftmost node
		if (head == null) {
			head = root;
		}
		else {
			root.left = prev;
			prev.right = root;
		}
		// Change the prev pointer to point to the current node
		prev = root;
		converter(root.right);
	}

	static void inOrder(Node root) {

		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);

	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		// Traverse like a binary tree
		inOrder(root);
		converter(root);
		// Traverse like a double linked list
		dListChecker();
	}
}