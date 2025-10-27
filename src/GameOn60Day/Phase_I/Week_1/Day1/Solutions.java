package GameOn60Day.Phase_I.Week_1.Day1;

import java.util.*;

public class Solutions {
    /**
     * Generates Pascal's Triangle with the specified number of rows.
     *
     * @param numRows the number of rows to generate in Pascal's Triangle
     * @return a list of lists representing Pascal's Triangle, where each inner list contains the integers for that row
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curr.add(1);
                } else {
                    curr.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(curr);
        }

        return res;
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;

        int candidate1 = 0, candidate2 = 1;
        int count1 = 0, count2 = 0;

        // First pass: Find potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Second pass: Verify candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        int threshold = nums.length / 3;
        if (count1 > threshold) res.add(candidate1);
        if (count2 > threshold) res.add(candidate2);

        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
//        HashSet<List<Integer>> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                for (int k = j+1; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        List<Integer> curr = new ArrayList<>();
//                        curr.add(nums[i]);
//                        curr.add(nums[j]);
//                        curr.add(nums[k]);
//                        Collections.sort(curr);
//                        set.add(curr);
//                        break;
//                    }
//                }
//            }
//        }
//
//        res.addAll(set);
//        return res;
        int i = 0;
        int left = i + 1;
        int right = nums.length - 1;
        Arrays.sort(nums);

        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum == 0) {
                List<Integer> curr = new ArrayList<>(3);
                curr.add(nums[i]);
                curr.add(nums[left]);
                curr.add(nums[right]);
                res.add(curr);
                i++;
                left++;
                right--;
            } else if (sum > 0) {
                right--;
            } else {
                i++;
                left++;
            }
        }
        return res;
    }

    /**
     * Finds all unique quadruplets in the array that sum up to the target value.
     * Uses a two-pointer technique with nested loops to find combinations of four numbers.
     *
     * <p>Algorithm:
     * <ul>
     *   <li>Sorts the array first for efficient duplicate handling</li>
     *   <li>Uses two outer loops to fix first two numbers (i and j)</li>
     *   <li>Uses two pointers (left and right) to find remaining two numbers</li>
     *   <li>Skips duplicates to ensure unique quadruplets</li>
     * </ul>
     *
     * <p>Time Complexity: O(n³) where n is the length of the array
     * <br>Space Complexity: O(1) excluding the result list
     *
     * @param nums   the input array of integers
     * @param target the target sum to find
     * @return a list of all unique quadruplets [nums[i], nums[j], nums[k], nums[l]]
     * such that nums[i] + nums[j] + nums[k] + nums[l] == target
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int left = j + 1, right = n - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < n - 1 && nums[left] == nums[left + 1]) left++;
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
                while (j < n - 1 && nums[j] == nums[j + 1]) j++;
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    static int maxLength(int arr[]) {
        int maxL = 0;
//        for (int i  =0; i < arr.length; i++) {
//            int sum = arr[i];
//            for (int j = i + 1; j < arr.length; j++) {
//                sum += arr[j];
//                if (sum == 0) {
//                    maxL = Math.max(maxL, j - i +1);
//                }
//            }
//        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxL = Math.max(maxL, i + 1);
                continue;
            }

            if (map.containsKey(sum)) {
                maxL = Math.max(maxL, i - map.get(sum) + 1);
            }
            map.put(sum, i);
        }
        return maxL;
    }

    public static long subarrayXor(int arr[], int k) {
        /*
         * Brute force
         * */
        long res = 0;
        HashMap<Integer, Integer> prefixXor = new HashMap<>();
        int prefix = 0;
        for (int i = 0; i < arr.length; i++) {
            prefix ^= arr[i];

            if (prefix == k) res++;

            res += prefixXor.getOrDefault(prefix, 0);

            prefixXor.put(prefix, prefixXor.getOrDefault(prefix, 0) + 1);
        }

        return res;
    }

    public static int singleNonDuplicate(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int  num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        for  (int num : map.keySet()) {
//            if (map.get(num) == 1) return num;
//        }
//        return -1;
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    public int findPeakElement(int[] nums) {
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
        }

        return -1;
    }

    public static int findDuplicate(int[] nums) {
        int xorAll = 0;
        for (int i = 0; i < nums.length; i++) xorAll ^= nums[i];   // XOR all array elements
        for (int i = 1; i < nums.length; i++) xorAll ^= i;         // XOR with range 1..n-1
        return xorAll;
    }

    public static int inversionCount(int arr[]) {
        // Code Here
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] nums, int left, int right) {
        //! Base condition
            if (left >= right) return 0;
        // * Kaam
        int count = 0;
        int mid = left + (right - left) / 2;
        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid + 1, right);
        count += merge(nums,  left, mid, right);
        return count;
    }

    public static int merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        for (int i = 0; i < n1; i++) leftArr[i] = nums[left + i];
        for (int i = 0; i < n2; i++) rightArr[i] = nums[mid + 1 + i];

        int k = left;
        int i =0, j = 0;
        int inversionCount = 0;
        while (i < n1 && j < n2) {
            //!  if I found inversion then update the smaller pointer because another inversion could be possible
            if (leftArr[i] < rightArr[j]) {
                nums[k++] = leftArr[i++];
            }else {
                nums[k++] = rightArr[j++];
                inversionCount += (n1 - i);
            }
        }

        while (i < n1) {
            nums[k++] = leftArr[i++];
        }
        while (j < n2) {
            nums[k++] = rightArr[j++];
        }
        return inversionCount;
    }

    public static void main(String[] args) {
        System.out.println(inversionCount(new int[]{2, 4, 1, 3, 5}));
    }
}
