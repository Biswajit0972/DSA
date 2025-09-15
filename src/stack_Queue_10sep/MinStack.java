package stack_Queue_10sep;

import java.util.*;

public class MinStack {
    Stack<Integer> stack;
    Deque<Integer> minStack;
    int  min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) { // ?  O(1)
            stack.push(val);
            minStack.push(val);
            min = val;
            return;
        }

        stack.push(val); //? 0(1)

        if (val <= min) {
            minStack.addFirst(val); // ?  O(1)
            min = val;
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        int popElement = stack.pop();// ?  O(1)
        if (popElement == min) {
            minStack.pop(); // ?  O(1)
            min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();// ?  O(1)
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }

        return minStack.peek();// ?  O(1)
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
//        stack.printList();
    }
}