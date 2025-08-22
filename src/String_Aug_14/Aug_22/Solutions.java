package String_Aug_14.Aug_22;

import java.util.HashMap;

public class Solutions {
    public static void main(String[] args) {
        System.out.println(beautySum("aabcb"));
    }

    public static int beautySum(String s) {
        int n = s.length();
        int sum  = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>(26);
            map.put(s.charAt(i), 1);
            for (int j = i + 1; j < n; j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if (map.size() <= 1) {
                    continue;
                }
                sum += beautyHelper(map);
            }
        }

        return sum;
    }

    public static int beautyHelper (HashMap<Character, Integer> map) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int val : map.values()) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        return max - min;
    }
}
