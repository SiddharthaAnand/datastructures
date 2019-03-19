/* Question: https://practice.geeksforgeeks.org/problems/x-total-shapes/0/?ref=self
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class CountTotalXShapes {
    public static void walk(int i, int j, boolean[][] visited, char[][] inp) {
        if (i < 0 || j < 0 || i >= inp.length || j >= inp[0].length) {
            return;
        }
        if (!visited[i][j] && inp[i][j] == 'X') {
            visited[i][j] = true;
            walk(i, j+1, visited, inp);
            walk(i+1, j, visited, inp);
            walk(i, j-1, visited, inp);
            walk(i-1, j, visited, inp);
        }
    }
    
    public static int result(char[][] inp) {
        boolean[][] visited = new boolean[inp.length][inp[0].length];
        int count = 0;
        for (int i = 0; i < inp.length; i++) {
            for (int j = 0; j < inp[0].length; j++) {
                if (!visited[i][j] && inp[i][j] == 'X') {
                    walk(i, j, visited, inp);
                    count++;
                }
            }
        }
        return count;
    }
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0)  {
		    t -= 1;
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    sc.nextLine();
		    String[] input = sc.nextLine().split(" ");
		    char[][] inp = new char[n][m];
		    
		    for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                inp[i][j] = input[i].charAt(j);
	            }
	        }
	        int count = result(inp);
	        System.out.println(count);
		}
	}
}