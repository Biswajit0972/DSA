package stack_Queue_10sep.Expression;

import java.util.Stack;

public class Solutions {
    public static void main(String[] args) {
        String exp = "h^m^q^(7-4)";
        System.out.println(infixToPostfix(exp));
    }

    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for  (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isOperand(ch)) {
                sb.append(ch);
            }else if (ch == '(') {
                st.push(ch);
            }else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop();
            }else if (ch == '^') {
                st.push(ch);
            }
            else {
                while (!st.isEmpty() && relativePriority(ch) <= relativePriority(st.peek())) {
                    sb.append(st.pop());
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString();
    }

    public static String postToInfix(String exp) {
        if (exp == null || exp.isEmpty()) {
            return exp;
        }

        Stack<String> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (isOperand(ch)) {
                st.push(String.valueOf(ch));
            }else {
                String right = st.pop();
                String left = st.pop();
                String op = String.valueOf(ch);
                st.push("("+ left + op + right + ")");
            }
        }
        return st.pop();
    }


    public static int relativePriority (char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        }else if (ch == '*' || ch == '/') {
            return 2;
        }else if (ch == '^') {
            return 3;
        }else {
            return -1;
        }
    }

    public static boolean  isOperand (char ch) {
        return ch >= '0' && ch <= '9' || ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z';
    }
}
