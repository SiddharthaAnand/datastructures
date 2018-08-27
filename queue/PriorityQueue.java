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
	QueueNode front;
	QueueNode rear;

	private QueueNode getPositionQueueNode(QueueNode q, int priority) {

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