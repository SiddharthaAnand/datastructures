/* URL: https://www.geeksforgeeks.org/connect-nodes-at-same-level/
 * We need to connect the nodes through a pointer at the same level
 * in a binary tree.
 */

package problem_solving;

class Node {
	int data;
	Node left;
	Node right;
	Node sameLevelRight;

	Node (int d) {
		data = d;
		left = right = sameLevelRight = null;
	}
}


public class ConnectNodeAtSameLevel {
	private static void connectNodes(Node root) {

	}
	
	public static void main(String[] args) {

	}
}