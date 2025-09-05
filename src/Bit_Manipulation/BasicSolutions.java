package Bit_Manipulation;

public class BasicSolutions {
    public static void main(String[] args) {
        System.out.println(intToBinary(13));
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
}
