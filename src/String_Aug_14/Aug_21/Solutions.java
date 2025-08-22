package String_Aug_14.Aug_21;

public class Solutions {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
    public static int myAtoi(String s) {
        s = s.trim();   // only trim leading/trailing spaces

        if (s.isEmpty()) {
            return 0;
        }

        long num = 0;
        boolean isNegative = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '-' && i == 0) {
                isNegative = true;
                continue;
            }

            if (ch == '+' && i == 0) {
                continue;
            }

            if (!isInteger(ch)) {
                break;
            }

            num = num * 10 + (ch - '0');

            // clamp early because long conversion with int produces inconsistent answers.
            if (!isNegative &&  num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (isNegative && -num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return isNegative ? (int) -num : (int) num;
    }

    public static boolean isInteger(char s) {
        return s >= '0' && s <= '9';
    }

    public static int countSubstring(String s) {
        int n = s.length();
        int res = 0;

        int [] store = new int[3];
        int left = 0;

        for (int right = 0; right < n; right++) {
            store[s.charAt(right) - 'a']++;

            while (store[0] > 0 && store[1] > 0 && store[2] > 0) {
                res += n - right;
                store[s.charAt(left) - 'a']--;
                left++;
            }

        }
        return res;
    }

    // ? TC: O(n)
    // ? SC: O(1) This approach is optimal, gives a mathematical test. when our string is valid means calculate res by removes valid extra elements

    public static boolean isAbcContains(String s) {
        return s.contains("a") && s.contains("b") && s.contains("c");
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int left = 0;
        int right = s.length() - 1;

        while (left  <= right) {
            if (isPalindrome(s.substring(left, right + 1))) {
                return s.substring(left, right + 1);
            }

            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }else if (s.charAt(left) != s.charAt(right)) {
                if (s.charAt(left) == s.charAt(right - 1)) {
                    right--;
                }else {
                    if (s.charAt(left + 1) == s.charAt(right)) {
                        left++;
                    }else {
                        left++;
                        right--;
                    }
                }
            }
        }

        return "";
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
