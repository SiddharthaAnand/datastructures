import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

/* Given a input string, check if it contains balanced paranthesis or not.
 * Example:
 * {{}} - returns 1
 * }aaa{}} - returns -1
 * {} - returns 1
 */
class BalancedParantheses {

	public static int checkBalanced(String input) {
		// Deque is an interface - double ended queue
		// can be used as a stack or a queue
		// all methods defined for ArrayDeque
		// ArrayDeque - implementation of Deque interface inside util
		Deque<Character> deq = new ArrayDeque<Character>();

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '{')
				deq.addFirst(input.charAt(i));
			else if (!deq.isEmpty() && deq.peekFirst() == '{' && input.charAt(i) == '}')
				deq.removeFirst();
			else if (deq.isEmpty() && input.charAt(i) == '}')
				return -1;
		}

		if (deq.isEmpty())
			return 1;
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(checkBalanced(input));
	}
}