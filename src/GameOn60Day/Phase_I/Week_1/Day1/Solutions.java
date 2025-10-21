package GameOn60Day.Phase_I.Week_1.Day1;

import java.util.ArrayList;
import java.util.List;

public class Solutions {
    /**
     * Generates Pascal's Triangle with the specified number of rows.
     * 
     * @param numRows the number of rows to generate in Pascal's Triangle
     * @return a list of lists representing Pascal's Triangle, where each inner list contains the integers for that row
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j==0 || j == i) {
                    curr.add(1);
                }else {
                    curr.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }
            res.add(curr);
        }

        return res;
    }
    public static List<Integer> majorityElement(int[] nums) {
    List<Integer> res = new ArrayList<>();
    if (nums.length == 0) return res;

    int candidate1 = 0, candidate2 = 1;
    int count1 = 0, count2 = 0;
    
    // First pass: Find potential candidates
    for (int num : nums) {
        if (num == candidate1) {
            count1++;
        } else if (num == candidate2) {
            count2++;
        } else if (count1 == 0) {
            candidate1 = num;
            count1 = 1;
        } else if (count2 == 0) {
            candidate2 = num;
            count2 = 1;
        } else {
            count1--;
            count2--;
        }
    }
    
    // Second pass: Verify candidates
    count1 = 0;
    count2 = 0;
    for (int num : nums) {
        if (num == candidate1) count1++;
        else if (num == candidate2) count2++;
    }
    
    int threshold = nums.length / 3;
    if (count1 > threshold) res.add(candidate1);
    if (count2 > threshold) res.add(candidate2);
    
    return res;
}
    
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,1,1,3,3,2,2,2}));
    }
}
