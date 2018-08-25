package stacks;
import stacks.Stack;
import java.util.Scanner;

public class StackHelper {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cap = sc.nextInt();
		Stack st = new Stack(cap);
		while (true) {
			System.out.println("Enter 1/2/3 to push/pop/print the stack");
			int val = sc.nextInt();
			switch(val) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				default:
					break;
			}
	}
}