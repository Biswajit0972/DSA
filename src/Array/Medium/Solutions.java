package Array.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solutions {

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     for (int j = i+1; j <n; j++){
        //         if ((nums[i] + nums[j]) == target) {
        //             return new int [] {i  , j};
        //         }
        //     }
        // }

        // return new int [] {-1,-1};

        HashMap<Integer, Integer> bucket = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];

            if (bucket.containsKey(complement)) {
                return new int[]{i, bucket.get(complement)};
            }

            bucket.put(nums[i], i);
        }
        return new int[]{-1, -1};

    }

    //    !
//    ? Approach 1
    public static void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;

        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else {
                two++;
            }
        }  // O(n)

        int it = 0;

        while (zero > 0) {
            nums[it++] = 0;
            zero--;
        }
        while (one > 0) {
            nums[it++] = 1;
            one--;
        }
        while (two > 0) {
            nums[it++] = 2;
            two--;
        }

        // ? TC : O(n) + O(zero + one + two) = O(n)
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {

            sum += num;

            if (sum >= maxSum) {
                maxSum = sum;
            }

            System.out.println(maxSum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }

    public static void printMaxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int st = 0;
        int ed = 0;
        int n = nums.length;
        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            int sum = nums[i];
//            for (int j = i + 1; j < n; j++) {
//                sum += nums[j];
//
//                if (maxSum < sum) {
//                    maxSum = sum;
//                    st = i;
//                    ed = j;
//                }
//            }
//        }

        for  (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum >= maxSum) {
                maxSum = sum;
                st = ed;
                ed = i;
            }

            System.out.println(maxSum);
            if (sum < 0) {
                sum = 0;
            }
        }

        for (int i = st; i <= ed; i++) {
            System.out.print(nums[i] + " ,");
        }

    }

    // ! Leet Code  premium: Longest consecutive subarray length;

    public static int longestConsecutive(int[] arr) {
        // Approach1: brute
        int longest = 0;


        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int count = 1;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] ==  1) {
                    System.out.println(x);
                }
                if (x + 1 == arr[j]) {
                    x = x+1;
                    count++;

                }
            }

            longest = Math.max(count, longest);
        }

        return longest;
    }

    // ! 2D Arrays
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse top row
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // Traverse right column
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // Traverse bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[] arr = {2, 6, 1, 9, 4, 5, 3};
        System.out.println(longestConsecutive(arr));
    }
}
