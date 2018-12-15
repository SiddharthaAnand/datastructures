// Problem: Check if the two given binary trees are mirror trees or not.
// If they are mirrors, then the current root data will be equal and their
// left child will be equal to the right child of the other tree and the 
// right child will be equal to the left child.
package binary_tree;

class Node {
	Node left;
	Node right;
	int data;
	Node (int d) {
		data = d;
	}
}

class BinaryTree {
	Node root;
	
	BinaryTree(int d) {
		root = new Node(d);
	}

	public boolean isMirrorHelper(Node rootOne, Node rootTwo) {
		if (rootOne == null && rootTwo == null)
			return true;
		if (rootOne.data == rootTwo.data && isMirrorHelper(rootOne.left, rootTwo.right) && isMirrorHelper(rootOne.right, rootTwo.left)) {
			return true;
		}
		return false;
	}


	public boolean isMirror(BinaryTree anotherTree) {
		return isMirrorHelper(this.root, anotherTree.root);
	}

}
public class MirrorChecker {
	public static void main(String[] args) {

	BinaryTree btOne = new BinaryTree(1);
	BinaryTree btTwo = new BinaryTree(1);
	btOne.root.left = new Node(2);
	btOne.root.right = new Node(4);

	btTwo.root.left = new Node(3);
	btTwo.root.right = new Node(2);

	System.out.println("Is mirror: " + btOne.isMirror(btTwo));

	}
}