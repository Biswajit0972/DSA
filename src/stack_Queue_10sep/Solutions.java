package stack_Queue_10sep;

import java.util.*;

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

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n; i >= 0 ; i--) {

            int num = nums[i % n];

            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i % n] = -1;
            }else{
                ans[i %n] = stack.peek();
            }
            stack.push(i);
        }

       return ans;
    }

    public static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));
        Deque<Integer> stack = new ArrayDeque<>(); // faster than Stack

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                ans.set(i, stack.peek());
            }
            stack.push(arr[i]);
        }

        return ans;
    }

    public static int[] count_NGE(int arr[], int indices[]) {
        int [] ans = new int[indices.length];

        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            int count = 0;
            for (int j = index + 1; j < arr.length; j++) {
                if (arr[j] > arr[index]) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    public static int trap(int[] height) {
        int n = height.length;
        int [] leftMax = new int[n];
        int [] rightMax = new int[n];

        leftMax[0] = height[0];

        for (int i = 1; i < n; i++) { // O(n)
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {// O(n)
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int trapWater =0;
        for (int i = 0; i < n; i++) {// O(n)
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > height[i]) {
                trapWater += min - height[i];
            }else {
                trapWater +=  height[i] - min;
            }
        }

        //? Total TC  = O(n) + O(n) + O(n) = O(3n) = O(n)
        //? Total SC = O(n) + O(n) = O(2n) = O(n)
        return trapWater;
    }

    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for  (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                sum += min;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
      int [] nums = {3,1,2,4};
        System.out.println(sumSubarrayMins(nums));

}}
