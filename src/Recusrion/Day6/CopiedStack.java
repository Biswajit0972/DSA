package Recusrion.Day6;

import java.util.Stack;

public class CopiedStack {

    static Stack<Integer> copy (Stack<Integer> input, Stack<Integer> dummy) {
//    TODO: Base if the input stack is empty and dummy is empty
        if (input.isEmpty() && dummy.isEmpty()) {
            return input;
        }

        // Todo: Copy them into the input stack for desending order
        if (input.isEmpty()) {
           while (!dummy.isEmpty()) {
               input.push(dummy.pop());
           }

           return input;
        }

        // Todo: mein copy and poping the element;

        int popElement = input.pop();

        insertElement(dummy, popElement);

        return copy(input, dummy);
    }

    static void insertElement (Stack<Integer> dummy, int popElement) {
        if (dummy.isEmpty() || popElement <= dummy.peek()) {
            dummy.push(popElement);
            return;
        }

        // TODO: if dummy top element is smaller then popElement. pop the top element
        int dummyPopElement = dummy.pop();
        insertElement(dummy, popElement);
        dummy.push(dummyPopElement);
    }
    static void printStack (Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        System.out.println(st.pop());

        printStack(st);
    }
    public static void main(String[] args) {
        Stack<Integer> st  = new Stack<>();
        Stack<Integer> d  = new Stack<>();
        st.push(41);
        st.push(3);
        st.push(32);
        st.push(2);
        st.push(11);
        copy(st, d);
    }
}
