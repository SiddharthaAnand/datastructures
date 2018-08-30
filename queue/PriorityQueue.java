// Priority Queue: https://www.geeksforgeeks.org/priority-queue-using-linked-list/
// Add a new node with the priority
// Compare with the current priority of the node and 
// insert if it is less than the current priority.
// Low value of priority means low priority of the node.
	
package queue;
import java.util.Scanner;

// Define a node for the priority queue
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

// define a data structure for priority queue
public class PriorityQueue {
	int size = -1;
	NodeQueue front;
	NodeQueue rear;

	// Compare the priority of the new node with the other nodes
	// and return the node after which we can insert the new node.
	private NodeQueue getPositionToInsertNodeQueue(NodeQueue q) {
		NodeQueue temp = front;
		NodeQueue posNode = null;
		if (temp == null) {
			
		}
		while (temp.next != null && temp.priority > q.priority) {
			temp = temp.next;
		}

		posNode = temp;
		return posNode;
	}

	// Create a new Node
	private NodeQueue createNode(int val, int priority) {
		return new NodeQueue(val, priority);
	}

	// 1. insert the node in the correct position according to priority
	// takes O(n) time in worst-case
	private void enQueue(int val, int priority) {
		NodeQueue nq = createNode(val, priority);
		NodeQueue nodeAfterWhichToInsert = getPositionToInsertNodeQueue(nq);
		// If the position is the last node, then need to update
		if (rear == nodeAfterWhichToInsert) {
			rear.next = nq;
			rear = nq;
		}
		else {
			nq.next = nodeAfterWhichToInsert.next;
			nodeAfterWhichToInsert.next = nq;
		}
		size++;

	}

	// Dequeue 
	// must take O(1) time
	private int deQueue() {
		return -1;
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
		Scanner sc = new Scanner(System.in);
		PriorityQueue q = new PriorityQueue();
		while (true) {
			System.out.println("Enter 1/2/3 to enqueue/dequeue/print the Priority Queue: ");
			int val = sc.nextInt();
			switch (val) {
				case 1:
					System.out.println("Enter the value: ");
					val = sc.nextInt();
					System.out.println("Enter the priority: ");
					int p = sc.nextInt();
					q.enQueue(val, p);
					break;
				case 2:
					val = q.deQueue();
					if (val != Integer.MIN_VALUE) {
						System.out.println("Dequeued!: " + val);
					}
					break;
				case 3:
					q.print();
					break;
				default: break;
			}
		}
	}
}