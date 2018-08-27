// Priority Queue: https://www.geeksforgeeks.org/priority-queue-using-linked-list/
// Add a new node with the priority
// Compare with the current priority of the node and 
// insert if it is less than the current priority.
// Low value of priority means low priority of the node.
	
package queue;

class NodeQueue {
	int value;
	int priority;
	NodeQueue next;

	NodeQueue(int v, int p) {
		value = v;
		priority = p;
		next = null;
	}
}

public class PriorityQueue {
	int size = -1;
	NodeQueue front;
	NodeQueue rear;

	private NodeQueue getPositionToInsertNodeQueue(NodeQueue q, int priority) {

	}

	private NodeQueue createNode(int val) {
		return new NodeQueue(val);
	}

	private void enQueue(int val, int priority) {

	}

	private int deQueue() {

	}

	private void print() {

	}

	public static void main(String[] args) {

	}
}