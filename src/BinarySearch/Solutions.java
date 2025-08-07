package BinarySearch;

import java.util.Arrays;

public class Solutions {

    public static void main(String[] args) {
        int [] nums = {3,6,7,11};

        for (int num : nums) {
            System.out.println( (int) Math.ceil((double) num / 3));
        }
    }

    public static int getStartingPoint(int[] nums, int target) {
        int st = 0;
        int ed = nums.length - 1;

        int stIndex = -1;

        while (st <= ed) {
            int  mid = st + (ed - st) / 2;

            if (nums[mid] >= target) {
                stIndex = mid;
                ed = mid - 1;
            }else {
                st = mid + 1;
            }
        }
        if (stIndex == -1 || nums[stIndex] != target) {
            return -1;
        }
        return stIndex;
    }

    public static int getEndingPoint(int [] nums, int target) {
        int st = 0;
        int ed = nums.length - 1;
        int stIndex = -1;

        while (st <= ed) {
            int mid = st + (ed - st) / 2;

            if (nums[mid] <= target) {
                stIndex = mid;
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        if (stIndex == -1 || nums[stIndex] != target) {
            return -1;
        }
        return stIndex;
    }

    // ! 4 Aug and day 14

    public static int nthRoot (int n,  int m)  {
        /**
         *  Brute force
        for (int i = 1; i <= m; i++) {
             if ((int)Math.pow(i,  n) == m) {
                 return i;
             }else if ((int) Math.pow(i,n) > m)  {
                 break;
             }
        }
        return -1;
         */

        int st = 1;
        int ed = m;

        while (st <= ed) {
            int mid = st + (ed - st) / 2;

            int com = (int) Math.pow(mid, n);

            if (com == m) {
                return mid;
            } else if (com  >  m) {
                ed = mid - 1;
            }else {
                st = mid + 1;
            }
        }
         return -1;

        //? TC O(logn)
    }

    // ! 5 th aug i am only did dsa on leet code.
    
}
