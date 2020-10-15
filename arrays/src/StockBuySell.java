
/* Url: https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0/?ref=self
 */

package arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

class StockBuySell {
    static void stocksMax(int[] input) {
        int start = 0, end = 0;
        boolean flag = true;
        for (int i = 0; i < input.length-1; i++) {
            if (input[i] <= input[i+1]) {
                end = i+1;
            }
            else {
                if (end > start) {
                    flag = false;
                    System.out.print("(" + start + " " + end + ") ");
                    start = i+1;
                    end = start;
                }
                else {
                    end += 1;
                    start += 1;
                }
            }
        }
        if (start < end) {
            flag = false;
            System.out.print("(" + start + " " + end + ") ");
        }
        if (flag) {
            System.out.print("No Profit");
        }
    }
    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
		    t -= 1;
		    int n = sc.nextInt();
		    int[] stock = new int[n];
		    for (int i = 0; i < n; i++)
		        stock[i] = sc.nextInt();
		        
		    stocksMax(stock);
		    System.out.println();
		}
	}
}