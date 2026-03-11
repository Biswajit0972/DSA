package _2026.sliding_window.D02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solutions {
    /**
     * Determines the length of the longest contiguous segment of 1's.
     * @param arr binary array containing only 0's and 1's
     * @return length of the longest run of 1's
     */
    public int longestRunOfOnes(int[] arr) {
       int maxLength = 0;
       int onesCount = 0;

       for (int num : arr)  {
           if (num == 1) {
               onesCount++;
           }else {
               maxLength = Math.max(maxLength, onesCount);
               onesCount = 0;
           }
       }

       maxLength = Math.max(maxLength, onesCount);
        return maxLength;
    }

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> res = new ArrayList<>();

        String target = concatenateArray(words);
        int window = target.length();

        int[] targetFreq = buildFreq(target);

        for (int i = 0; i <= s.length() - window; i++) {

            String sub = s.substring(i, i + window);

            if (Arrays.equals(targetFreq, buildFreq(sub))) {
                res.add(i);
            }
        }

        return res;
    }

    public String concatenateArray(String[] words) {

        StringBuilder sb = new StringBuilder();

        for (String w : words) {
            sb.append(w);
        }

        return sb.toString();
    }

    public int[] buildFreq(String s) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        return freq;
    }

    public int totalFruit(int[] fruits) {
        // `fruits`: an array where each element indicates the type of fruit on that tree
        // Return the maximum number of fruits that can be picked
        HashMap<Integer, Integer> bucket = new HashMap<>();
        int st  = 0;
        int ed = 0;
        int count = 0;

        while ( ed < fruits.length) {
            bucket.put(fruits[ed], bucket.getOrDefault(fruits[ed], 0) +1);
            while (bucket.size() > 2) {
                int removedFruit = fruits[st];
                bucket.put(removedFruit, bucket.get(removedFruit) - 1);
                if ( bucket.get(removedFruit) == 0){
                    bucket.remove(removedFruit);
                    st++;
                }
            }
            count = ed - st + 1;

            ed++;
        }
        return count; // Return placeholder, change as per logic
    }

    public boolean checkForStringPermutation(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return  false;

        int [] bucket = new int[26];

        for (int i = 0; i < n; i++) {
            bucket[s1.charAt(i) - 'a']++;
            bucket[s2.charAt(i) - 'a']--;
        }
        if (isZero(bucket)) return true;

        for (int i = n; i < m; i++) {
            bucket[s2.charAt(i) - 'a']++;
            bucket[s2.charAt(i-n) - 'a']--;
            if (isZero(bucket)) return true;
        }

        return false;

    }

    public boolean isZero(int [] nums) {
        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solutions s =  new Solutions();
        for (Integer num : s.findSubstring("barfoofoobarthefoobarman", new String[]  {"bar","foo","the"})) {
            System.out.println(num);
        }

    }
}
