/* Problem: Given a number, print all the valid paranthesis of given number;
 * Input: 3
 * Output: ((()))
 *         (()())
 *         ()(())
 *         (())()
 * From: Cracking the coding interview
 */
import java.util.Scanner;

class MakeBalancedPranthesis {
	public static void makeBalancedParam(int k, char[] balancedParamString, int left, int right) {
		// Base Case
		if (balancedParamString == null) return;
		// OR
		if (left == 0 && right == 0) {
			System.out.println(balancedParamString);
			return;
		}
		else {
			if (left > 0) {
				balancedParamString[k] = '(';
				makeBalancedParam(k+1, balancedParamString, left-1, right);
			}
			if (right > left) {
				balancedParamString[k] = ')';
				makeBalancedParam(k+1, balancedParamString, left, right-1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		char balancedParamString[] = new char[number<<2];
		int left = number;
		int right = number;
		makeBalancedParam(0, balancedParamString, left, right);
	}
}