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



    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
