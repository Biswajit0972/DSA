package SEP.work4.MON;

import java.util.Arrays;

public class Solutions {
    public static int[] getConcatenation(int[] nums) {
        int [] ans = new int[2* nums.length];

        int p = 0;

        for (p = 0; p < nums.length; p++) {
            ans[p] = nums[p];
        }

        for (int i = 0; i < nums.length; i++) {
            ans[p++] = nums[i];
        }

        return ans;
    }

    public static int[] shuffle(int[] nums, int n) {
        int [] ans = new int [nums.length];
        int x = 0;
        int y = 1;
        int z = n;

        for (int i = 0; i < n; i++) {
            ans[x] = nums[i];
            ans[y] = nums[z];

            x +=2;
            y +=2;
            z++;
        }

        return ans;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0;
        int one = 0;

        for (int num: nums) {
            if (num == 1) {
                one++;
            }else {
                maxConsecutive = Math.max(maxConsecutive, one);
                one = 0;
            }
        }

        maxConsecutive = Math.max(maxConsecutive, one);

        return maxConsecutive;
    }
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
    }
}
