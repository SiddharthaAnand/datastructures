import java.util.Scanner;
import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;

class ValidParenthesisClass {

	private static void print(Queue<Character> result) {
		System.out.println();
		Iterator<Character> it = result.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}

	public static void printValidParenthesis(int openP, int closeP, String result) {
		if (openP == 0 && closeP == 0) {
			System.out.println(result);
			return;
		}
		if (openP > closeP)
			return;
		if (openP > 0) {
			printValidParenthesis(openP-1, closeP, result + "(");
		}
		if (closeP > 0) {
			printValidParenthesis(openP, closeP-1, result + ")");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] parenthesis = new int[2];
		parenthesis[0] = n;
		parenthesis[1] = n;
		String result = "";
		printValidParenthesis(n, n, result);
	}
}