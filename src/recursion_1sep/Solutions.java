package recursion_1sep;

import java.util.Stack;

public class Solutions {
    public static void main(String[] args) {

    }

    public static int binaryExpoentiation  (int x, int y) {
        if (y == 0) {
            return 1;
        }

        if (y < 0) {
            return 1 / binaryExpoentiation(x, -y);
        }

        if (x % 2  == 1) {
            return x * binaryExpoentiation(x, y - 1);
        }else {
            return binaryExpoentiation(x, y / 2);
        }
    }
    int M = (int)1e9 + 7;

    public int countGoodNumbers(long n) {
        long evenPosition = (n + 1) / 2; // digits at even indices → choices = 5
        long oddPosition = n / 2;        // digits at odd indices → choices = 4

        long result = (pow(5, evenPosition) * pow(4, oddPosition)) % M;
        return (int) result;
    }


    public long pow(long base, long power) {
        if (power == 0) return 1;
        long half = pow(base, power / 2);
        long res = (half * half) % M;
        if (power % 2 == 1) {
            res = (res * base) % M;
        }
        return res;
    }

    public Stack<Integer> sort(Stack<Integer> s) {
       if (s.isEmpty()) return s;

       int top = s.pop();
       sort(s);
       sort(s, top);
       return s;
    }

    public void sort(Stack<Integer> s, int k) {
        // base case

        if (s.isEmpty() || s.peek() < k) {
            s.push(k);
            return;
        };

        int top = s.pop();
        sort(s, k);
        s.push(top);
    }

    public  void reverse(Stack<Integer> St) {
        // code here
        if (St.isEmpty()) {
            return;
        }

        int top = St.pop();
        reverse(St);
        reverse(St, top);
    }

    public void reverse (Stack<Integer> s,  int k) {
        Stack<Integer> temp = new Stack<>();
        if (s.isEmpty() ) {
            return;
        }

        while (!s.isEmpty()) {
            temp.push(s.pop());
        }
        s.push(k);
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
    }
}
