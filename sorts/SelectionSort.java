import java.util.Scanner;

public class SelectionSort {
    private void sort(int[] arr) {
        for(int i = 0; i< arr.length - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            arr[i] = arr[i] + arr[minIndex] - (arr[minIndex] = arr[i]);
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
        SelectionSort ob = new SelectionSort();
        ob.sort(arr);
        ob.printArray(arr);
        sc.close();
    }
}
