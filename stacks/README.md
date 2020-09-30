# Stacks
## Introduction
Stack is a linear data structure which follows a particular order in which the operations are performed. 
The order may be LIFO(Last In First Out) or FILO(First In Last Out). A stack can be implemented using array and using linked list.

The list of problems which can come under a broad heading of problem solving are inserted here. 

# List of Problems

### Implementation of Stack
  
  The class uses arrays to implement a stack. The class contains basic operations performed on the stack:
  - print (prints the contents of the stack)
  - pop (removes the topmost element from the stack)
  - push (inserts an element into the stack)
  - peek (returns the topmost element from the stack but doesn't remove it)
  - isEmptyStack (returns true if the stack is empty)
  - isFullStack (returns true if the stack is full)
  - size (returns the size of the stack)
  
 Go to file: [Stack.java](Stack.java) | Associated Helper class : [StackHelper.java](StackHelper.java)

### Infix to Postfix Converter
  
  Infix expression:The expression of the form a op b. When an operator is in-between every pair of operands.
  Postfix expression:The expression of the form a b op. When an operator is followed for every pair of operands.
  
  The function converts a given infix expression to a postfix expression using stacks.
  
  Go to file: [InfixToPostfixConvertor.java](InfixToPostfixConvertor.java)
  
### Queue Implementation using Stack
  
  The task is to implement a queue (FIFO) using instances of stack (LIFO) data structure and operations on them.
  This can be done using two stacks.
  
  Go to file: [QueueImplentationStack.java](QueueImplentationStack.java)
  
### Special Stack

  The task is to design a special stack using the Stack class and which takes the same time complexity for it's operations. 
  Also, there must include an extra method to find minimum value in the stack in O(1) time.
  
  Go to file: [SpecialStack.java](SpecialStack.java) | Associated Helper class : [SpecialStackImplementer.java](SpecialStackImplementer.java)

### Two Stack

  Implement 2 stacks using an array, i.e., both stacks should use the same array for storing elements. Following functions must be supported by twoStacks:
  - push1(int x) –> pushes x to first stack
  - push2(int x) –> pushes x to second stack

  - pop1() –> pops an element from first stack and return the popped element
  - pop2() –> pops an element from second stack and return the popped element
  
  Go to file: [TwoStack.java](TwoStack.java) | Associated Helper class : [TwoStackClassHelper.java](TwoStackClassHelper.java)

  
  
