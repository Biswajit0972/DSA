package stack_Queue_10sep;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if (x == -1) {
            return;
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        print();
    }

    public int pop() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.pop();
    }

    public int peek() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.peek();

    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void print() {
        while (!stack1.isEmpty()) {
            System.out.println(stack1.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);

    }

    // push O(n)
    // other O(1)
}
