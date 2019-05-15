/* Implement the Producer-Consumer Problem.
 * Simulate that there are 2 processes, Producer and Consumer.
 * They are sharing a resource named Queue(queue/shared buffer) whose 
 * maximum size is parameterized.
 * There should not be a deadlock condition.
 * wait() and notify() used to wait when the queue/buffer is full, or 
 * notify other threads that one thread just added something in
 * the shared list called shared queue/buffer.
 */

import java.util.LinkedList;

class ProducerConsumer {
	LinkedList<Integer> queue;
	int maxSize;
	int count;
	public ProducerConsumer(LinkedList<Integer> queue, int maxSize) {
		this.queue = queue;
		this.maxSize = maxSize;
		count = 0;

	}

	public void produce() throws InterruptedException {
		while (true) {
			
			synchronized(this) {
				if (queue.size() == maxSize) {
					System.out.println("Produced reached maximum limit - wait() called");
					wait();
				}
				else {
					count += 1;
					queue.add(count);
					System.out.println("Producer produces " + count + " value. ");
					notify();
					Thread.sleep(1000);
				}
			}
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			synchronized(this) {
				if (queue.size() == 0) {
					wait();
					System.out.println("Consumer consumes everything - wait() called now");
				}
				else {
					System.out.println("Consumer removes " + queue.remove() + " from queue. ");
					notify();
					Thread.sleep(1000);
				}
			}
		}
	}
}

class ProducerConsumerController {
	public static void main(String[] args) {

		ProducerConsumer obj = new ProducerConsumer(new LinkedList<Integer>(), 10);

		// Shining example of an Anonymous Class being created here. I had a question
		// regarding how is this possible that an object of an interface(Runnable) is
		// being created? On googling, 
		//found the answer here: https://stackoverflow.com/questions/16880494/how-can-we-create-object-of-interface-in-java
		// You can check that an anonymous class with the name ProducerConsumerController$1.class
		// is getting created which is an anonymous class.
		// Also refer https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					obj.produce();
				}
				catch (Exception e) {

				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					obj.consume();
				}
				catch (Exception e) {

				}
			}
		});

		t1.start();
		t2.start();
		t1.run();
		t2.run();
	}
}