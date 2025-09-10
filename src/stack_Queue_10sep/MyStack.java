package stack_Queue_10sep;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
    List<Integer> list;
    MyStack () {
        list =  new ArrayList<>();
    }

    public void push(int x) {
        if (x == -1) {
            return;
        }
        list.addFirst(x);
    }

    public int pop() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.removeFirst();
    }

    public void print() {
        while (!list.isEmpty()) {
            System.out.println(list.removeFirst());
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print();
    }
}
