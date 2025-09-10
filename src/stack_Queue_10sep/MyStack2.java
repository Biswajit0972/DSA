package stack_Queue_10sep;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack2 {
    Deque<Integer> deque;
    public MyStack2() {
        deque = new ArrayDeque<>();
    }

    public void push(int x) {
        if  (x == -1) {
            return;
        }

        deque.push(x);
    }

    public int pop() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.removeLast();
    }

    public int top() {
       if (deque.isEmpty()) {
            return -1;
       }
       return deque.peekLast();
    }

    public boolean empty() {
      return deque.isEmpty();
    }

}
