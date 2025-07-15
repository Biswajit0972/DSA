package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class Merge {
    public static void divide (int [] arr, int st, int ed) {

        if (st >=ed) {
            return;
        }

        int mid = (st + ed) / 2;
        // ! kaam
        // ? Process left one first
        divide(arr,  st, mid);
        // ? Process right one
        divide(arr,  mid+1, ed);

        marge(arr, st, mid, ed);
    }

    public static void marge (int [] arr, int st, int mid,  int ed) {
        // ! logic needs an extra array
        ArrayList<Integer> res = new ArrayList<>();

        // find out the half of the array
        // left side
        int low = st;
        int high = mid + 1;

        while (low <= mid && high <=ed) {
            if (arr[low] < arr[high]) {
                res.add(arr[low++]);
            }else {
                res.add(arr[high++]);
            }
        }

        while (low <= mid)  {
            res.add(arr[low++]);
        }

        while (high <= ed)  {
            res.add(arr[high++]);
        }
        // ? if write arr[i] = res[i] then, It arranges the wrong order in the array, suppose we have 2,8,5,3 and subarray 5,3 change the 5 with arr[0] = res[0], then sorted part will also affect.
        for (int i = 0; i < res.size(); i++) {
            arr[st + i] = res.get(i);
        }


    }

    public static void main(String[] args) {
        int [] arr = {2,8,5,3,9,4,1,7};
        divide(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
