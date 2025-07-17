package Array.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    //    !-- Leet-Code 26. Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] nums) {
        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }

    // ? TC: O(n)
    // ? SC: O(1)

    // ! --------- Leet-Code: 189 Rotate Array by k step problem.

    public static void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }

        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }

    // ? TC: O(n) + O(k) + O(n - k) = O(n)
    //? SC: O(1)

    public static void reverseArray(int[] nums, int st, int ed) {

        while (st <= ed) {
            int temp = nums[st];
            nums[st] = nums[ed];
            nums[ed] = temp;
            st++;
            ed--;
        }
    }

    // !--- 283. Move Zeroes

    // * Approach 1
//    public void moveZeroes(int[] nums) {
//        int zeros = 0;
//
//        for (int i : nums) {
//            if (i == 0) {
//                zeros++;
//            }
//        }
//
//        int i = 0;
//
//        for (int j : nums) {
//            if (j != 0) {
//                nums[i++] = j;
//            }
//        }
//
//        for (int k = 0; k < zeros; k++) {
//            nums[k + i] = 0;
//        }
//    }
    //? TC: O(n)
    // ? SC:O(1)

    // * Approach 2 (Better code)

    public static void moveZeroes(int[] nums) {
        int i = 0;

        for (int j =  0; j< nums.length; j++)  {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }
    }

    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        HashSet<Integer> hash = new HashSet<>();  //O(n)

        for (int i : a) { // O(a)
            hash.add(i);
        }

        for (int j : b) {
            hash.add(j); // O(b)
        }

        // ? TC:  O(a) + O(b) = O(a +  b)

        // ? SC:  O(n) + O(a + b)

        return new ArrayList<>(hash);
    }

    public static int missingNumber(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int i = 0;

        while (i < nums.length) {

            sum -= i;
            System.out.println(i);
            i++;
        }


        return sum != 0 ? i : nums.length;
    }

    public static void main(String[] args) {
        //  !      int  [] arr = {0,0,1,1,1,2,2,3,3,4}; remove duplicates test case

        //  !  int[] arr = {99,-1,-100,3};  Rotate Array by k step problem. test case
          int[] arr = {0,1,3};
          missingNumber(arr);
    }
}
