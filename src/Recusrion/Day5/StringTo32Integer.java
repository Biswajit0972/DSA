package Recusrion.Day5;

public class StringTo32Integer {
    public static  int myAtoi (String s) {
        // reasign s with no leading whitespace
        s = s.trim();

        if (s.isEmpty()) {
            return 0;
        }

        int sign = 1;

        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            sign = (s.charAt(0) == '-')? -1 : 1;
            return helper (0, s.substring(1), sign);
        }

        return helper(0, s, sign);
    }

    static int helper (int res, String s, int sign) {
        if (s.isEmpty() || !Character.isDigit(s.charAt(0))) {
            return res * sign;
        }

        int digit = s.charAt(0) - '0';

        if (res > (Integer.MAX_VALUE - digit) / 10) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (digit < 0) {
            return helper(res, s.substring(1), sign);
        }

        int result = res * 10;
        return helper(result + digit, s.substring(1), sign);
    }
    public static void main(String[] args) {
//
//        System.out.println('4' - '0');
        System.out.println(myAtoi("433-2"));
    }
}
