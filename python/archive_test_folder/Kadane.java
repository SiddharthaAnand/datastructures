import java.util.*;
import java.lang.*;
import java.io.*;

class Kadane {
    public static int findKadane(int arr[]) {
        int sumSoFar = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sumSoFar += arr[i];
            if (sumSoFar > max)
                max = sumSoFar;
            if (sumSoFar < 0)
                sumSoFar = 0;
        }
        return max;
    }
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    while (T != 0) {
	        T--;
	        int size = sc.nextInt();
	        int arr[] = new int[size];
	        
	        for (int i = 0; i < size; i++)
	            arr[i] = sc.nextInt();
	            
	        System.out.println(findKadane(arr));
	    }
	}
}