// Class which creates a heap.
// Keep a max-heap.
package heaps;

class HeapNode {
	int value;
	int priority = -1;
	boolean pQueue = false;
	HeapNode left;
	HeapNode right;

	HeapNode(int v, int p) {
		priority = p;
		value = v;
		pQueue = true;
	}

	HeapNode(int v) {
		value = v;
	}
}

class Heap {
	
	int[] heap;
	int size;
	
	Heap(int[] input) {
		size = input.length;
		heap = input;
	}

	public int getMax() {

	}

	public void heapify() {

	}

	public void createHeap() {

	}
}