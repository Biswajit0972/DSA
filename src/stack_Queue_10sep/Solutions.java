package stack_Queue_10sep;

import java.util.Arrays;
import java.util.Stack;

public class Solutions {
    public static  boolean isValid(String s) {
        Stack<Character>  stack = new Stack<>();
        for  (int i = 0; i < s.length(); i++) {
            char  ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (ch == ')' && top != '(') {
                    return false;
                }
                if (ch == '}' && top != '{') {
                    return false;
                }
                if (ch == ']' && top != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int [] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            int num = nums1[i];
            for  (int  j = 0 ; j < m; j++) {
                if (nums2[j] == num) {
                    for (int k = j + 1; k < m; k++) {
                        if (nums2[k] > num) {
                            ans[i] = nums2[k];
                            break;
                        }
                    }
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
