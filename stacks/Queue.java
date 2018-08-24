package stacks;
// URL: https://www.geeksforgeeks.org/implement-stack-using-queue/
// Implementing a queue using an integer array of size given as input.

public class Queue {
	int front = -1;
	int rear = -1;
	int size;
	int[] queue;


	Queue(int size) {
		this.size = size;
		queue = new int[size];
	}

	private void enQueue(int value) {
		if ((rear+1) != size) {
			front++;
			queue[front] = value;
		}
		else {
			System.out.println("Queue overflow condition!");
		}
	}

	private void deQueue() {
		if (()) {
			
		}
	}

}