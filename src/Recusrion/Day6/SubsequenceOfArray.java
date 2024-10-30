package Recusrion.Day6;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceOfArray {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> dummy =  new ArrayList<>();
        Helper (result,  nums, 0, dummy);
        return result;
    }

    static void Helper ( List<List<Integer>> res, int [] nums, int index, List<Integer> dummy) {

        // Base case
        if (index == nums.length) {
            res.add(new ArrayList<>(dummy));
            return;
        }

        int num = nums[index];
        dummy.add(num);

        Helper(res, nums, index + 1, dummy);

        dummy.removeLast();
        Helper(res, nums, index+1, dummy);
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3};
        List<List<Integer>> result = new ArrayList<>(subsets(arr));

        for (List<Integer> ls : result) {
            System.out.println(ls);
        }

    }
}
