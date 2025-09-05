package Bit_Manipulation;

public class BasicSolutions {
    public static void main(String[] args) {
        System.out.println(binaryToInt(intToBinary(13)));

    }

    public static String intToBinary(int num) {
        StringBuilder sb = new StringBuilder();

        if (num == 0) {
            return "0";
        }
        if (num == 1) {
            return "1";
        }

        while (num > 0) {
            sb.insert(0, num % 2);
            num /= 2;
        }
        return sb.toString();
    }

    public static int binaryToInt(String s) {
        int res = 0;
        int power = 1;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                res += power;
            }
            power *= 2;
        }

        return res;
    }
}
