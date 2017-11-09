import java.util.LinkedList;

class ProdConsImpl {
  // Shared buffer between producer and consumer.
  LinkedList<Integer> l = new LinkedList<Integer>();
  int capacity = 2;
  public void produce()throws InterruptedException {
    int value = 0;
    while (true) {
      synchronized(this) {
        // producer waits till the buffer is full.
        while(l.size() == capacity)
          wait();
        // add a value in buffer.
        System.out.println("Produce: " + value);
        l.add(value++);
        // notify the other thread that it can consume.
        notify();
        //Thread.sleep(1000);
      }
    }
  }

  public void consume()throws InterruptedException {
    while(true) {
        synchronized(this) {
        // consumer waits till the buffer is empty.
        while(l.size() == 0)
          wait();
        int val = l.removeFirst();
        System.out.println("Consume: " + val);
        notify();
        //Thread.sleep(1000);
      }
    }
  }
}

class ProducerConsumer {
  public static void main(String[] args)throws InterruptedException {
    ProdConsImpl pc = new ProdConsImpl();
    Thread t1 = new Thread(new Runnable(){
        public void run() {
          try {
            pc.produce();
          }
          catch(InterruptedException e) {

          }

        }
      });
    Thread t2 = new Thread(new Runnable(){
        public void run() {
          try {
            pc.consume();
          }
          catch(InterruptedException e) {

          }

        }
      });
    t1.start();
    t2.start();

    t1.join();
    t2.join();
  }
}
