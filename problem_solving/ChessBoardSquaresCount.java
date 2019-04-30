// Count the number of different sized squares in a chess-board.

import java.util.*;
import java.lang.*;
import java.io.*;

class ChessBoardSquaresCount {
    private static int squaresCount(int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += (n-i) * (n-i);
        }
        return result;
    }
    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
		    t -= 1;
		    int n = sc.nextInt();
		    System.out.println(squaresCount(n));
		}
	}
}