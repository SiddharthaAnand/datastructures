/* URL: https://www.geeksforgeeks.org/queue-set-2-linked-list-implementation/
 *
 */

package queue;

class QueueNode {
	int value;
	QueueNode next;
	QueueNode(int val) {
		value = val;
		next = null;
	}
}

public class QueueLinkedList {
	QueueNode rear;
	QueueNode front;
	int size = 0;

	QueueLinkedList() {
		rear = null;
		front = null;
	}

	public void print(QueueLinkedList q) {
		System.out.println();
		if (q != null) {
			while (q != null) {
				System.out.print(q.val + " ");
				q = q.next;
			}
		}
		else {
			System.out.println("Queue is empty!");
		}
		System.out.println();
	}

	public QueueNode createNode(int val) {
		return new QueueNode(val);
	}

	/* Create a new queue node and add the value.
	 * Point the rear to this node.
	 * No nede to check overflow since this is linked list.
	 */
	public void enQueue(int val) {
		QueueNode q = createNode(val);
		rear = q;
		size++;
	}

	/* Dequeue from the front.
	 * Jump to the next node.
	 * Here need to check the condition of underflow.
	 */
	public int deQueue() {
		int val = Integer.MIN_VALUE;
		if (size != 0) {

			val = front.value;
			QueueNode q = front;
			q = null;
			front = front.next;
			size--;
		}
		else {
			System.out.println("Queue underflow condition");
		}
		return val;
	}

}