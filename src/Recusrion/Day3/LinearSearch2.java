package Recusrion.Day3;

import java.util.ArrayList;

public class LinearSearch2 {

    static ArrayList<Integer> res = new ArrayList<>();

    static ArrayList<Integer> multipleIndex (int [] arr, int target, int index) {
        if (index == arr.length - 1) {
            return res;
        }

        if (arr[index] == target) {
            res.add(index);
        }

        return multipleIndex(arr, target, index + 1);
    }

    public static void main(String[] args) {
        int [] arr = {1,2,2,2,45,65,733,46,2,234,56,2};
        System.out.println(multipleIndex(arr, 2, 0)); // [1, 2, 3, 8]

    }
}
