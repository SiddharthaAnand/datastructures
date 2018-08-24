package stacks;
// URL: https://www.geeksforgeeks.org/implement-stack-using-queue/
// Implementing a queue using an integer array of size given as input.

public class Queue {
	int front = -1;
	int rear = 0;
	int size;
	int[] queue;


	Queue(int size) {
		this.size = size;
		queue = new int[size];
	}

	private void enQueue(int value) {
		if ((rear+1) % size != front) {
			queue[rear] = value;
			rear++;
		}
		else {
			System.out.println("Queue overflow condition!");
		}
	}

	private void deQueue() {
		int val = Integer.MAX_VALUE;
		if ((front % size) != rear) {
			front++;
			val = queue[front];
			queue[front] = 0;
		}
		else {
			System.out.println("Queue underflow condition");
		}
		return val;
	}

}