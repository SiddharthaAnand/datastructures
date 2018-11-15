import java.util.Scanner;

// Java program for implementation of Insertion Sort 


class InsertionSort 
{ 
    /*Function to sort array using insertion sort*/
    void sort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=1; i<n; ++i) 
        { 
            int key = arr[i]; 
            int j = i-1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j>=0 && arr[j] > key) 
            { 
                arr[j+1] = arr[j]; 
                j = j-1; 
            } 
            arr[j+1] = key; 
        } 
    } 
  
    /* A utility function to print array of size n*/
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        System.out.println("Sorted array is: ");
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " ");   
        System.out.println(); 
    } 
  
    // Driver method 
    public static void main(String args[]) 
    {         
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
        InsertionSort ob = new InsertionSort();         
        ob.sort(arr);           
        printArray(arr); 
        sc.close();
    } 
} 

// Enter the number of elements: 
// 10
// Enter the array elements: 
// 10
// 3
// 2
// 9
// 1
// 6
// 4
// 8
// 7
// 5

// Sorted array is: 
// 1 2 3 4 5 6 7 8 9 10 