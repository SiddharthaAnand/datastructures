import java.util.Scanner;

public class HeapSort {
    private void sort(int[] arr) {
        int size = arr.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, size, i);
        }

        for (int i=size-1; i>=0; i--) {
            arr[i] = arr[0] + arr[i] - (arr[0] = arr[i]);
            heapify(arr, i, 0);
        }
    }

    private void heapify(int arr[], int heapSize, int i) {
        int largest = i;
        int leftChildIdx  = 2*i + 1;
        int rightChildIdx  = 2*i + 2;

        if (leftChildIdx  < heapSize && arr[leftChildIdx ] > arr[largest]) {
            largest = leftChildIdx;
        }

        if (rightChildIdx  < heapSize && arr[rightChildIdx ] > arr[largest]) {
            largest = rightChildIdx;
        }

        if (largest != i) {
            arr[largest] = arr[i] + arr[largest] - (arr[i] = arr[largest]);
            heapify(arr, heapSize, largest);
        }
    }

    private void printArray(int[] arr) {
        for(int i: arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the array elements: ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println();
        HeapSort ob = new HeapSort();
        ob.sort(arr);
        ob.printArray(arr);
        sc.close();
    }
}
