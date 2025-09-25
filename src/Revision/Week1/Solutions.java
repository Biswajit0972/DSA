package Revision.Week1;

import java.util.HashMap;

public class Solutions {

    // ! Revision of Week 1
    //? Question 1: Longest SubArray Sum EqualTo k
    //* Brute Force
    /*
    public static int longestSubarray(int[] arr, int k) {
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
                int sum = 0;
            for (int j = i ; j < arr.length ; j++) {
                sum += arr[j];

                if (sum == k) {
                    maxLength =  Math.max(maxLength, j - i +1);
                }
            }
        }

        return maxLength;
    }
    */

    // ! Question 1: Longest SubArray Sum EqualTo k - Optimized

    public static int longestSubarray(int[] arr, int k) {
        int maxLength = 0;
        HashMap<Integer, Integer> hash =  new HashMap<>();
        int preSum  = 0;

        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];

            if (preSum == k) {
                maxLength =  Math.max(maxLength, i + 1);
            }else if (hash.containsKey(preSum - k)) {
                maxLength = Math.max(maxLength, i - hash.get(preSum - k));
            }

           if (!hash.containsKey(preSum)) {
               hash.put(preSum, i);
           }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] testingArr = {-5, 8, -14, 2, 4, 12};
        System.out.println(longestSubarray(testingArr, -5));
    }
}
