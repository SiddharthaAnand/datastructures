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

	// Compare the priority of the new node with the other nodes
	// and return the node after which we can insert the new node.
	private NodeQueue getPositionToInsertNodeQueue(NodeQueue q) {

	}

	// Create a new Node
	private NodeQueue createNode(int val, int priority) {
		return new NodeQueue(val, priority);
	}

	// 1. insert the node in the correct position according to priority
	// takes O(n) time in worst-case
	private void enQueue(int val, int priority) {

	}

	// Dequeue 
	// must take O(1) time
	private int deQueue() {

	}

	// Simply iterate through the queue since it is 
	// already in prioritised order.
	private void print() {
		if (size != 0) {
			NodeQueue n = front;
			System.out.println();
			while (n != null) {
				System.out.print(n.value + " ");
			}
			System.out.println();
		}
		else {
			System.out.println("Queue is empty!");
		}
	}

	public static void main(String[] args) {

	}
}