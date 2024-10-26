package Recusrion.Day4;

import java.util.Arrays;

public class BubbleSort {
    public static void BubbleSort (int [] arr, int row, int col) {
        if (row < 0) {
            return;
        }

        if (col <= row) {
            if (arr[col] < arr[col - 1]) {
                int temp = arr[col];
                arr[col] = arr[col-1];
                arr[col -  1] = temp;
            }

            BubbleSort(arr, row, col + 1);
        }

        BubbleSort(arr, row - 1, col);
    }
    public static void main(String[] args) {
        int [] arr = {5,6,1,3};
        BubbleSort(arr, arr.length - 1,  1);
        System.out.println(Arrays.toString(arr));
    }
}
