package sliding_window_27sep;

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

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringOptimal("pwwkew"));
    }
}
