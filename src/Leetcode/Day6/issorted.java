package Leetcode.Day6;

import java.util.HashMap;

public class issorted {
    public static boolean IsSorted (int [] arr) {
        HashMap<Integer, Integer> container = new HashMap<>();
        for (int i : arr) {
            container.put(i, countSetBit(i));
        }



        System.out.println(container);
        return false;
    }

    public static int countSetBit (int n) {
        if (n == 0) {
            return 0;
        }

        int count = 0;

        while (n > 0) {
            int bit = n & 1;
           if (bit == 1) {
               count++;
           }
            n = n >> 1;
        }

        return count;
    }
    public static void main(String[] args) {
        int [] arr = {8,4,2,30,15};
        System.out.println(Integer.bitCount(30));
    }
}
