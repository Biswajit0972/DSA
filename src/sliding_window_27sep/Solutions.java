package sliding_window_27sep;

import java.util.Arrays;
import java.util.HashMap;

public class Solutions {
    /*
    * Sliding window started 27sep 2025
    */

    //! Question 1: Longest Substring Without Repeating Characters
    // TODO: Brute force
    // ? TC:
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,  Integer> store = new HashMap<>();
        int maxUniqueLength = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (store.containsKey(s.charAt(j)) && store.get(s.charAt(j)) >= 1) {
                    maxUniqueLength = Math.max(maxUniqueLength, (j-1) - i +1);
                    store.put(s.charAt(j), store.get(s.charAt(j)) -1);
                    break;
                }
                store.put(s.charAt(j), store.getOrDefault(s.charAt(j), 0) + 1);
            }
        }

        return maxUniqueLength;
    }

    // ! Optimal approach
    public static int lengthOfLongestSubstringOptimal(String s) {
        int n = s.length();
        int maxUniqueLength = 0;
        HashMap<Character, Integer> store = new HashMap<>();
        int left = 0;

        for (int i = 0; i < n; i++) {
            char currCharacter = s.charAt(i);
            if (store.containsKey(currCharacter)) {
                if (left <= store.get(currCharacter)) {
                    left = store.get(currCharacter) + 1;
                }
            }
            maxUniqueLength = Math.max(maxUniqueLength, i - left + 1);
            store.put(currCharacter, i);
        }

        return maxUniqueLength;
    }
    // ! Question 1: (Easy) Contains Duplicate II

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
      HashMap<Integer, Integer> store = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
          if (store.containsKey(nums[i])) {
              if (Math.abs(i - store.get(nums[i])) <= k) {
                  return true;
              }
          }
          store.put(nums[i], i);
      }
      return false;
    }
    // ! Question 2 : (Easy) findLHS
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = 1;
        int length = 0;

        while (right < nums.length) {
            int diff = nums[right] - nums[left];

            if (diff == 1) {
                length =  Math.max(length, right - left + 1);
            }else if (diff <= 1) {
                right++;
            }else {
                left++;
            }
        }

        return length;
    }
    // ! Question 3 : (Easy) findLHS
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = 0.0;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        maxAvg = sum / k;

        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];

            maxAvg = Math.max(maxAvg, (sum/ k));
        }

        return maxAvg;
    }

    //! Question 1: Medium
    public int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int zeroCount = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zeroCount++;
                }

                if (zeroCount > k) {
                    break;
                }

                maxLength = Math.max(maxLength, j - i +1);
            }
        }

        return maxLength;
    }

    public int longestOnesOptimal(int[] nums, int k) {
        int maxLength = 0;
        int zeroCount = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, i - left +1);
        }

        return maxLength;
    }

//    public int totalFruit(int[] fruits) {
//        int totalFruitCount = 0;
//        int left = 0;
//        HashMap<Integer, Integer> store = new HashMap<>();
//
//        for (int i = 0; i < fruits.length; i++) {
//            while (store.size() > 2) {
//                store.put(fruits[left], store.get(fruits[left]) - 1);
//                left++;
//                if (store.get(fruits[left]) == 0) {
//                    store.remove(fruits[left]);
//                }
//            }
//            totalFruitCount = Math.max(totalFruitCount, i - left + 1);
//            store.put(fruits[i], store.getOrDefault(fruits[i], 0) + 1);
//        }
//
//        return totalFruitCount;
//    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int count =0;
        int sum = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum > goal && left < i) {
                sum -= nums[left];
                left++;
            }

            count += i - left +1;
        }

        return count;
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int goodSubarrays = 0;

        for (int i = 0; i < nums.length; i++) {
            int count =0;
            for (int j = i; j < nums.length; j++) {
                if (!isEven(nums[j])) {
                    count++;
                }

                if (count == k) {
                    goodSubarrays++;
                }

                if (count > k) {
                    break;
                }
            }
        }

        return goodSubarrays;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static int numberOfSubarraysOptimal(int[] nums, int k) {
        int count = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!isEven(nums[i])) {
                count++;
            }

            while (count > k) {
                if (!isEven(nums[left])) {
                    count--;
                }
                left++;
            }

            count += i - left +1;

        }

        return count;
    }

    public static void main(String[] args) {
       int [] test  = {2,4,6};
        System.out.println(numSubarraysWithSum(test, 1) - numSubarraysWithSum(test, 0));
    }
}
