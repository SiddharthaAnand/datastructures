/* URL: https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0/?ref=self
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class MaximumSumSubsequence {
    static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        return max;
    }
    
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
           t -= 1;
           int n = sc.nextInt();
           int[] arr = new int[n];
           int[] sub = new int[n];
           for (int i = 0; i < n; i++) {
               arr[i] = sc.nextInt();
               sub[i] = arr[i];
           }
           sub[0] = arr[0];
           for (int i = 1; i < n; i++) {
               int max = sub[i];
               for (int j = i-1; j >= 0; j--) {
                   if (arr[i] > arr[j] && (arr[i] + sub[j]) > max) {
                       max = arr[i] + sub[j];
                   }
               }
               sub[i] = max;
           }
           System.out.println(maxOf(sub));
    }
  }
}