// Count the number of different sized squares in a chess-board.

import java.util.*;
import java.lang.*;
import java.io.*;

class ChessBoardSquaresCount {

	private static long nC2(long n) {
		return (n * (n-1)) / 2;
	}

	// Take two horizontal lines and two vertical lines 
	// for the creation of rectangle.
	// n+1 - because there are n+1 lines needed to create n sized rectangles.
	// Includes the squares as well since a square is also a rectangle.
	private static long rectanglesCount(long n) {
		return nC2(n+1) * nC2(n+1);
	}

    private static long squaresCount(long n) {
        long result = 0;
        for (long i = 0; i < n; i++) {
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
		    long n = sc.nextLong();
		    System.out.println(squaresCount(n));
		    System.out.println(rectanglesCount(n));
		}
	}
}