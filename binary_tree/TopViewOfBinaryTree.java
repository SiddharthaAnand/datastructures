import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Node {
	int data;
	Node left;
	Node right;
	Node (int d) {
		data = d;
		left = null;
		right = null;
	}
}

class TopViewOfBinaryTree {
	public static void topViewHelper(Node root, TreeMap<Integer, ArrayList<Integer>> map, int level) {
		if (root == null)
			return;
		else {
			if (map.containsKey(level)) {
				ArrayList<Integer> list = map.get(level);
				list.add(root.data);
				map.put(level, list);
			}
			else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(root.data);
				map.put(level, list);
			}
			topViewHelper(root.left, map, level-1);
			topViewHelper(root.right, map, level+1);
		}

	}
	public static void topView(Node root) {
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		topViewHelper(root, map, 0);
		for (Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()) {
			System.out.println(entry.getValue().toString());
		}

	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.left.right = new Node(6);
		topView(root);
	}
}