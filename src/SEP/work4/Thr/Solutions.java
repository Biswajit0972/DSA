package SEP.work4.Thr;

import java.util.Arrays;

public class Solutions {
    public static int[] findErrorNums(int[] nums) {
        int findDuplicate = 0, sum = 0;

        for (int num: nums) {
            findDuplicate ^= num;
            sum += num;
        }
        System.out.println(findDuplicate);
        int n = nums.length;
        int exceptedSum = n * (n+1)/2;

        for (int i = 1; i < n; i++) {
            findDuplicate ^= i;
        }
        System.out.println(findDuplicate);
        return new int[] {};
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;

        int [] res = new int[n];

        for (int i = 0; i < n;i++) {
            int count = 0;
            for (int j = i +1; j < n; j++) {
                if (nums[i] > nums[j]) count++;
            }

            if (i > 0) {
                for (int j = i-1; j >= 0; j--) {
                    if (nums[i] > nums[j]) count++;
                }
            }

            res[i] = count;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[] {8,1,2,2,3})));
    }
}
