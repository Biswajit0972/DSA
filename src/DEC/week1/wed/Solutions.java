package DEC.week1.wed;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st  = new Stack<>();
        int n = tokens.length;

        for (int i = 0; i < n;i++) {
            if (isOperator(tokens[i])) {
                int pop1 = st.pop();
                int pop2 = st.pop();
                int eval = applyOperator(pop2, pop1, tokens[i]);
                st.push(eval);
            }else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }

        return st.pop();
    }

    private boolean isOperator(String st) {
        if (st == null) return false;
        return st.equals("+") || st.equals("-") || st.equals("/") || st.equals("*");
    }


    public int applyOperator(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }

    public static void main(String[] args) {

    }
}