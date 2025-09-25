package Revision.Week1;

public class Solutions {

    // ! Revision of Week 1
    //? Question 1: Longest SubArray Sum EqualTo k
    //* Brute Force

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

    public static void main(String[] args) {
        int [] testingArr = {-5, 8, -14, 2, 4, 12};
        System.out.println(longestSubarray(testingArr, -5));
    }
}
