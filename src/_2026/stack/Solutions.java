package _2026.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solutions {
    public boolean isValid(String s) {
        // s: input string containing '(', ')', '{', '}', '[' and ']' only
        // Return true if the string is valid, otherwise return false
        if (s == null || s.isEmpty()) return true;
        Stack<Character> st  = new Stack<>();

        for (int i = 0;  i < s.length() ; i++) {
            char ch = s.charAt(i);
            if (isOpenBracket(ch)) {
                st.push(ch);
            }else {
                if (st.isEmpty()) return false;
                char top = st.peek();
                if (ch == ')' && top != '(') {
                    return false;
                } else if (ch == '}' && top != '{') {
                    return false;
                } else if (ch == ']' && top != '[') {
                    return false;
                }


                st.pop();
            }
        }

        return st.isEmpty();
    }

    public boolean isOpenBracket(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    public boolean isCloseBracket(char ch) {
        return ch == ')' || ch == '}' || ch == ']';
    }

    public int maxDepth(String s) {
        // s: a valid parentheses string
        // Example: "(1+(2*3)+((8)/4))+1"
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Stack<Character> st = new Stack<>();
        int maxDepth = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isOpenBracket(ch)) {
                count++;
                st.push(ch);
            } else if (ch == ')') {
                maxDepth = Math.max(maxDepth,  count);
                count--;
                st.pop();
            }
        }
        return maxDepth;
    }

    public String simplifyParentheses(String s) {
        // s: a string of valid parentheses
        // Returns a string with outermost parentheses removed from each primitive component.
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (count > 0) sb.append(ch);
                count++;
            }else {
                count--;
                if (count > 0) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }

    public int[] asteroidCollision(int[] asteroids) {
         if (asteroids.length == 1) {
             return asteroids;
         }

         Stack<Integer> nasa = new Stack<>();

         for (int num : asteroids) {
             boolean destroyed = false;
             while (!nasa.isEmpty() && nasa.peek() > 0 && num < 0) {
                 // case:1
                 if (nasa.peek() < -num) {
                     nasa.pop();
                     continue;
                 }

                 // case:2

                 if (nasa.peek() == -num) {
                     nasa.pop();
                 }

                 destroyed = true;
                 break;
             }

             if (!destroyed) nasa.push(num);
         }
        int[] result = new int[nasa.size()];
        for (int i = nasa.size() - 1; i >= 0; i--) {
            result[i] = nasa.pop();
        }
        return result;
    }

    public int[] calculateFinalPrices(int[] prices) {
        int n = prices.length;
        int[] result = prices.clone();

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && prices[st.peek()] >= prices[i]) {

                int index = st.pop();
                result[index] = prices[index] - prices[i];
            }

            st.push(i);
        }

        return result;
    }

    public int sumOfMinimumsInSubarrays(int[] arr) {
       long res = 0;
        long  mod = 1000000007;
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int mid = st.pop();
                int left = st.isEmpty() ? mid + 1 : mid - st.peek();
                int right = i- mid;
                res += (long)arr[i] * left * right;
                res %= mod;
            }
            st.push(i);
        }
        return  (int) res;
    }

    public ArrayList<Integer> nextGreater(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> mono = new Stack<>();

        int n = arr.length - 1;

        for (int i = n; i >= 0; i--) {
            while (!mono.isEmpty() && mono.peek() <= arr[i]) {
                mono.pop();
            }

            int greaterEle = mono.isEmpty() ? -1 : mono.peek();
            res.addFirst(greaterEle);
            mono.push(arr[i]);
        }

        return res;
    }

    public int findShortestSortingSegment(int[] nums) {
         int [] sorted = nums.clone();
        Arrays.sort(sorted);

        int left = -1;
        int right = -1;


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sorted[i]) {
                if (left == -1) left = i;
                right = i;
            }
        }

        if (left == -1) return 0;

        return right - left + 1;
    }

    public int countTypableWords(String text, String brokenLetters) {
        // text: string containing space-separated words
        // brokenLetters: string of distinct broken letters
        // Returns the number of typable words
        boolean[] broken = new boolean[26];

        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }

        int count = 0;
        boolean valid = true;

        for (int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);

            if (c == ' ') {
                if (valid) count++;
                valid = true;
            }
            else if (broken[c - 'a']) {
                valid = false;
            }
        }

        if (valid) count++;

        return count;
    }

    public int[] secondGreater(int[] nums) {
        // nums: an array of non-negative integers
        // Return an array where the ith element is the second greater integer of nums[i]
        int n = nums.length;
        int []  res = new int[n];

        for (int i = 0; i <n ;i++) {
            int c = 0;
            boolean isNext = false;
            int max = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j] && c < 2) {
                    max = nums[j];
                    c++;
                }

                if (c ==  2) {
                    isNext = true;
                    break;
                }
            }
            if (isNext) {
                res[i] = max;
            }else {
                res[i] = -1;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Solutions s = new Solutions();
        System.out.println(Arrays.toString(s.secondGreater(new int[] {3,3})));
    }
}
