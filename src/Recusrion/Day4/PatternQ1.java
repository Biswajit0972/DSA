package Recusrion.Day4;

public class PatternQ1 {
    public static void reversePyramid (int  row, int col) {
        if (row  == 0 || col == 0) {
            return;
        }

        printStar(col);
        System.out.println();

        reversePyramid(row - 1, col-1);
    }

    static void printStar (int col) {
        if (col == 0) {
            return;
        }

        System.out.print("* ");

        printStar(col - 1);
    }
    public static void main(String[] args) {
     reversePyramid(2,2);
    }
}
