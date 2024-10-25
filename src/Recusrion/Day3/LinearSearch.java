package Recusrion.Day3;

public class LinearSearch {
    public static boolean linearSearch (int [] arr, int target) {
        return Helper (arr, target, 0);
    }

    static boolean Helper (int [] arr, int target, int index) {
        if (index == arr.length - 1 && arr[index] != target)  {
            return false;
        }

        return arr[index] == target || Helper(arr, target, index + 1);
    }
    public static void main(String[] args) {
        int [] arr = {25, 45, 2, 1, 78, 34, 56};
        System.out.println(linearSearch(arr, 100));
    }
}
