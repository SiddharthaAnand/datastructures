package heaps;

import java.util.Scanner;

class HeapStore {
	int size;
	int[] heap;
	HeapStore(int size) {
		heap = new int[size];
		this.size = size;
	}

	void heapify(int rootIdx) {

		int lChild = 2 * rootIdx + 1;
		int rChild = 2 * rootIdx + 2;
		int smallestIdx = rootIdx;

		if (lChild < size && heap[lChild] < heap[rootIdx])
			smallestIdx = lChild;
		if (rChild < size && heap[rChild] < heap[smallestIdx])
			smallestIdx = rChild;

		if (rootIdx != smallestIdx) {
			int swp = heap[rootIdx];
			heap[rootIdx] = heap[smallestIdx];
			heap[smallestIdx] = swp;
			heapify(smallestIdx);
		}
	}

	void buildHeap() {
		for (int i = size/2-1; i >= 0; i--) {
			heapify(i);
		}
	}

	void printHeap() {
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}
}


public class FindKLargest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		HeapStore hp = new HeapStore(k);
		int lengthOfStream = 0;
		while (true) {
			int stream = sc.nextInt();
			if (lengthOfStream < k) {
				hp.heap[lengthOfStream] = stream;
			}
			else if (lengthOfStream == (k-1)) {
				hp.buildHeap();
			}
			else if (stream > hp.heap[0]) {
				hp.heap[0] = stream;
				hp.heapify(0);
				hp.printHeap();
			}
			lengthOfStream++;
		}
	}
}