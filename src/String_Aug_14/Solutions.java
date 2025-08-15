package String_Aug_14;

import java.util.Stack;


public class Solutions {
    public static void main(String[] args) {
        String originalString ="  hello world  ";
        System.out.println(largestOddNumber("4206"));
    }

    /**
     * Removes the outermost parentheses from every primitive segment of the input.
     *
     * Logic:
     * - Track current nesting using a depth counter.
     * - On encountering '(', if current depth > 0, append it (it is not outermost); then increase depth.
     * - On encountering ')', first decrease depth; if new depth > 0, append it (it is not outermost).
     * - This way, the very first '(' that opens a primitive and the matching ')' that closes it are skipped.
     *
     * Example:
     * "(()())(())" -> primitive splits: "(()())", "(())"
     * After removing outermost for each -> "()()()", "()"
     * Final result -> "()()()()"
     *
     * Time Complexity: O(n) — single pass over the string.
     * Space Complexity: O(n) — for the output builder (excluding input).
     */
    public static String removeOuterParentheses(String s) {
       StringBuilder sb = new StringBuilder();
       int depth = 0;
       for (int i = 0; i < s.length(); i++) {
           if(s.charAt(i) == '('){
               if (depth > 0) {
                   sb.append(s.charAt(i));
               }
               depth++;
           }else if(s.charAt(i) == ')'){
               depth--;
               if (depth > 0) {
                   sb.append(s.charAt(i));
               }
           }

       }

       return sb.toString();
    }

    public static String reverseWords(String s) {
        String trimmedString = s.trim();
        String cleanedString = trimmedString.replaceAll("\\s+", " ");
        StringBuilder sb = new StringBuilder();

        String [] words = cleanedString.split(" ");

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }

        // ?  TC: O(n) + O(n) + O(n) = O(n)
        // ?  SC: O(n)
        return sb.toString();
    }

    public static String largestOddNumber(String num) {
        int n = num.length();

        for  (int i = n - 1; i >= 0; i--) {
            if (Helpers.isOddString(num.charAt(i))) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }



}
