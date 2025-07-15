package Pattern;

public class Rectangle {
    public static void printPattern (int n) {
        // ! consider i is row and j is column. j is reponsible for printing stars.
        // ! i = 0, we need to print one *, j runs equals to i j <= i, j runs one times and so one.
        // ? example i = 0, j -> *
        // ? i = 1, j -> 0, 1 -> * *
        // ? i = 2,  j -> 0,1,2->* * *

        // TODO: Outer loop runs row wise 0  to n - 1
        for (int i = 0; i < n; i++) {
        // !  space
            for (int j = n - i -  1; j >= 0; j--) {
                System.out.print(" ");
            }
//            ! starts

            for (int k = 0; k < (2 * i + 1); k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
    public static void printPattern2 (int n) {

        for (int i = n - 1; i >= 0; i--) {
//      ! space
            for (int k = 0; k < n - 1 - i; k++) {
                System.out.print(" ");
            }
//            ! stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {
        printPattern2(5);
    }
}
