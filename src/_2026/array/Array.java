package _2026.array;

public class Array {
    //? 01-missing-number

    public static int findMissingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return  1;
        }

        int n = nums.length+1;

        int exceptedSum = (n*(n+1)) /2;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        return exceptedSum - sum;
    }
}
