package SEP.sunday.phase1.pattern;

import java.util.ArrayList;
import java.util.List;

public class Solutions {
    public static void subSequence(String s, StringBuilder sb) {
        if (s.isEmpty())  {
            System.out.println(sb.toString());
            return;
        }

        sb.append(s.charAt(0));
        subSequence(s.substring(1), sb);
        sb.deleteCharAt(sb.length() - 1);
        subSequence(s.substring(1), sb);
    }

    public static void bin2(int n, StringBuilder sb, ArrayList<String> ans) {

        //! base case
        if (sb.length() == n) {
            ans.add(sb.toString());
            return;
        }

        // ! recursive case
        sb.append('0');
        bin2(n, sb,   ans);
        sb.deleteCharAt(sb.length()-1);
        sb.append('1');
        bin2(n, sb, ans);
        sb.deleteCharAt(sb.length()-1);
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateParenthesis(n, 0, 0, sb, res);
        return res;
    }

    public static void generateParenthesis(int n, int open, int close, StringBuilder sb, List<String> res) {
        if (open == n && close == n) {
            res.add(sb.toString());
            return;
        }

        if (open  <  n) {
            sb.append('(');
            generateParenthesis(n, open + 1, close, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            generateParenthesis(n, open, close + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void printAllSubsequencesOfExpectedSum(int [] nums, int expectedSum, int index, StringBuilder sb, int  sum) {
        if (index == nums.length) {
            if (expectedSum == sum) {
                System.out.println(sb.toString());
            }
            return;
        }

        sum+= nums[index];
        sb.append(nums[index]);
        printAllSubsequencesOfExpectedSum(nums,  expectedSum, index+1, sb, sum);
        sum -= nums[index];
        sb.deleteCharAt(sb.length()-1);
        printAllSubsequencesOfExpectedSum(nums,  expectedSum, index+1, sb, sum);
    }
    public static void main(String[] args) {
        printAllSubsequencesOfExpectedSum(new  int[] {1,2,1}, 2, 0, new StringBuilder(), 0);
    }
}