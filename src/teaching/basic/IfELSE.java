package teaching.basic;

import java.util.Scanner;

public class IfELSE {
    public static void main(String[] args) {
        // Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n % 2 == 0) {
            System.out.println("Prime");
        }else {
            System.out.println("Not Prime");
        }
    }
}
