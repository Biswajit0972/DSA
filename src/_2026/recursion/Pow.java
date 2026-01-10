package _2026.recursion;

public class Pow {
    public static double pow(double base, int exponent) {
        // Base
        if (exponent < 0) {
            return 1/ pow(base, -exponent);
        }

        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        double half = pow(base, exponent / 2);

        if (exponent % 2 == 0) {
            return half * half;
        }else {
            return base * half * half;
        }
    }
    public static void main(String[] args) {
        System.out.println(pow(5,-2));
    }
}
