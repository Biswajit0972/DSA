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

    public static void main(String[] args) {
        System.out.println(2/3);
    }
}
