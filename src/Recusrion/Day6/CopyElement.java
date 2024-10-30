package Recusrion.Day6;

import java.util.Stack;

public class CopyElement {
    public static void copy (Stack<Integer> s) {
        Stack<Integer> dumy = new Stack<>();
        helper(s, dumy);
    }
    public static void helper (Stack<Integer> s, Stack<Integer> dummy) {

        if ( dummy.isEmpty()) {
            return;
        }

        if (s.isEmpty()) {
            while (!dummy.isEmpty()) {
                s.push(dummy.pop());
            }
        }

        dummy.push(s.pop());

        helper(s, dummy);
    }
    static void printStack (Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        System.out.println(st.pop());

        printStack(st);
    }
    public static void main(String[] args) {
        Stack<Integer> st =  new Stack<>();
        st.push(1);
        st.push(3);
        st.push(2);
        st.push(4);
        copy(
                st
        );

        printStack(st);
    }
}
