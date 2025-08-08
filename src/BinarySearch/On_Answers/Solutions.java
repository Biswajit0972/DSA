package BinarySearch.On_Answers;

public class Solutions {

    /*
    * Binary search on Answer is an algorithm, where we're finding answer based on particular conditions. Basically, Questions gives search space in which we take mid and searching best answer.
    * */
    public static void main(String[] args) {
       int [] nums = {21212,10101,12121};
//       int m = 3;
//       int k = 1;
//        System.out.println(minDays(nums, m, k));

        System.out.println(smallestDivisor(nums, 1000000));
    }
    /*
    * 1482. Minimum Number of Days to Make m Bouquets
    * */
    public static int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int ans  = -1;

        for (int num : bloomDay) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
//        while (min <= max) {
//            int mid = min + (max -  min) / 2;
//            int canFullFill = 0;
//            int bloomFlower = 0;
//
//            for (int num : bloomDay) {
//                if (num <= mid ) {
//                    bloomFlower++;
//                }else {
//                    canFullFill += flowerHelper(bloomFlower, k);
//                    bloomFlower = 0;
//                }
//            }
//            canFullFill += flowerHelper(bloomFlower, k);
//            if (canFullFill >= m) {
//                ans = mid;
//                max  = mid - 1;
//            }else {
//                min = mid + 1;
//            }
//        }
        for (int i = min; i <= max; i++)  {
            /*
            * flower bloom ith day when bloom day less than or equal to ith day.
            * can fulfil requirement to
            * track flower bloom using bloom count.
            *
            * */
            int canFullFill = 0;
            int bloomFlower = 0;

            for (int num : bloomDay) {
                if (num <= i ) {
                    bloomFlower++;
                }else {
                    canFullFill += flowerHelper(bloomFlower, k);
                    bloomFlower = 0;
                }
            }

            canFullFill += flowerHelper(bloomFlower, k);

            if (canFullFill >= m) {
                return  i;
            }
        }
        return -1;
    }

    private static int flowerHelper (int bloomFlower, int k) {
        int res = 0;

        while (bloomFlower  >= k) {
            res++;
            bloomFlower -= k;
        }

        return res;
    }

    private static int thresholdHelper (int [] nums, int divisior) {
        int res = 0;
        for (int num : nums) {
            res += (int) Math.ceil((double) num / divisior);
        }
        return res;
    }

    /*
    * 1283. Find the Smallest Divisor Given a Threshold
    * */
    public static int smallestDivisor(int[] nums, int threshold) {
        int  low = 1;
        int high = Integer.MIN_VALUE;
        int ans = -1;

        for (int num : nums) {

            high = Math.max(high, num);
        }
// ! Approach 1: start with Low  and end with high,  generate all the possible divisors and check if threshold is satisfied.

//        for (int i = low; i <= high; i++) {
//            if (thresholdHelper(nums, i) <= threshold) {
//                return i;
//            }
//        }
        // ? TC = O(n) + O(high * n) = O(high * n )
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (thresholdHelper(nums, mid) <= threshold) {
                ans = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        // ? TC = O(n) + O(log(high - low ) * n) = O(log(high) * n )

        return ans;
    }


}
