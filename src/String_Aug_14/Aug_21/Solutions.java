package String_Aug_14.Aug_21;

public class Solutions {
    public static void main(String[] args) {
        System.out.println(myAtoi("   -042"));
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
}
