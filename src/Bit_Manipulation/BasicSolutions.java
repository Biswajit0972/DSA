package Bit_Manipulation;

public class BasicSolutions {
    public static void main(String[] args) {
        System.out.println(setIthBit(9, 2));
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

        // ? TC  =  O(n)
        // ? SC =  O(1)
    }

    public static void swapTwoNumber (int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    }

    public static void checkIthBit(int n,  int i) {
        //? right shift operator >>
        if (((n >> i) & 1) != 0) {
            System.out.println("1");
        }else {
            System.out.println("0");
        }
        //? Left shift operator <<
        if ((n & (1 << i)) != 0) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    public static int setIthBit (int n, int i) {
        return n | (1 << i);
    }
}
