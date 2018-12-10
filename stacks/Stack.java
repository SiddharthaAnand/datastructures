// Implement a simple stack using an array
// SIngle pointer enough to manipulate the stack.

package stacks;

public class Stack {
	int top = -1;
	int capacity;
	int size = 0;
	int[] input;

	Stack(int cap) {
		capacity = cap;
		input = new int[capacity];
	}

	public void print() {
		System.out.println();
		if (size == 0) {
			System.out.println("No values in the stack to print!");
		}
		for (int idx = 0; idx < size; idx++) {
			System.out.print(input[idx] + " ");
		}
		System.out.println();
	}
	
	public void pop() {
        if(isEmptyStack())
        {
            System.out.println("Stack underflow condition");
        }
        else
        {
            int val = Integer.MAX_VALUE;
       		val = input[top];
			input[top] = 0;
			top--;
			size -= 1;
        }
    }

	public void push(int value) {
        if(isFullStack())
        {
            System.out.println("Stack overflow condition");
        }
        else
        {
            top++;
            input[top] = value;
            size += 1;
        }
    }

	public int peek() {
		int val = Integer.MAX_VALUE;
		if (top != -1 && top != capacity) {
			val = input[top];
		}
		else {
			System.out.println("Stack overflow/underflow condition");
		}
		return val;
	}
	
	public boolean isEmptyStack() {
		if (top == -1)
		return true;
		else
		return false;
     }
     
     public boolean isFullStack() {
		if (size == capacity)
		return true;
		else
		return false;
	 }

	public int size() {
		return size;
	}
}
