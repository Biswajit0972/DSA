package Recusrion.Day6;

import java.util.Stack;

public class SortStack {

    static void printStack (Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        System.out.println(st.pop());

        printStack(st);
    }
    public static void main(String[] args) {
        Stack<Integer> st  = new Stack<>();
        st.push(41);
        st.push(3);
        st.push(32);
        st.push(2);
        st.push(11);

        printStack(st);
    }
}
