package GameOn60Day.Phase_I.Week_2.Day3;

import java.util.ArrayList;
import java.util.List;

public class Solutions {

    static  class Recursion {
        public  boolean isPalindrome(String str) {
            int n = str.length();

            if (n == 0) {
                return false;
            }

            if ( n == 1) {
                return true;
            }

            int mid = n / 2;

            for (int i = 0; i < mid; i++) {
                char left = str.charAt(i);
                char right = str.charAt(n - i -1);
                if (left != right) {
                    return false;
                }
            }

            return true;
        }

        public void printSubsequences (String str) {
            StringBuilder sb = new StringBuilder(str.length());
            printSubHelper(str, sb);
        }

        private void printSubHelper (String str, StringBuilder sb) {
            if (str.isEmpty()) {
               if (isPalindrome(  sb.toString())) {
                   System.out.print(sb + " ");
               }
                return;
            }

            // * Take or not Take

            sb.append(str.charAt(0));
            printSubHelper(str.substring(1), sb); // Taking
            sb.deleteCharAt(sb.length() - 1);
            printSubHelper(str.substring(1), sb); // Not taking
        }

    }
    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        recursion.printSubsequences("aab");
    }
}
