package recursion_1sep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solutions {
    public static void main(String[] args) {
        int [] nums = {2,3,5};
        System.out.println(combinationSum(nums, 8));
    }

    public static int binaryExpoentiation  (int x, int y) {
        if (y == 0) {
            return 1;
        }

        if (y < 0) {
            return 1 / binaryExpoentiation(x, -y);
        }

        if (x % 2  == 1) {
            return x * binaryExpoentiation(x, y - 1);
        }else {
            return binaryExpoentiation(x, y / 2);
        }
    }
    int M = (int) 1e9 + 7;

    public int countGoodNumbers(long n) {
        long evenPosition = (n + 1) / 2; // digits at even indices → choices = 5
        long oddPosition = n / 2;        // digits at odd indices → choices = 4

        long result = (pow(5, evenPosition) * pow(4, oddPosition)) % M;
        return (int) result;
    }


    public long pow(long base, long power) {
        if (power == 0) return 1;
        long half = pow(base, power / 2);
        long res = (half * half) % M;
        if (power % 2 == 1) {
            res = (res * base) % M;
        }
        return res;
    }

    public Stack<Integer> sort(Stack<Integer> s) {
       if (s.isEmpty()) return s;

       int top = s.pop();
       sort(s);
       sort(s, top);
       return s;
    }

    public void sort(Stack<Integer> s, int k) {
        // base case

        if (s.isEmpty() || s.peek() < k) {
            s.push(k);
            return;
        };

        int top = s.pop();
        sort(s, k);
        s.push(top);
    }

    public  void reverse(Stack<Integer> St) {
        // code here
        if (St.isEmpty()) {
            return;
        }

        int top = St.pop();
        reverse(St);
        reverse(St, top);
    }

    public void reverse (Stack<Integer> s,  int k) {
        Stack<Integer> temp = new Stack<>();
        if (s.isEmpty() ) {
            return;
        }

        while (!s.isEmpty()) {
            temp.push(s.pop());
        }
        s.push(k);
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
    }

    public static int myAtoi(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        s = s.trim();

        if (s.isEmpty()) {
            return  0;
        }

        if (s.charAt(0) == '-') {
            return (int) -myAtoiHelper(0, s.substring(1), true);
        }else if (s.charAt(0) == '+') {
            return (int) myAtoiHelper(0, s.substring(1), false);
        }else {
            return (int) myAtoiHelper(0, s, false);
        }
    }

    public static long myAtoiHelper(long res, String s, boolean isNegative) {
        if (s.isEmpty() || !isInteger(s.charAt(0))) {
            return res;
        }

        res = res * 10 + s.charAt(0) - '0';

        if (isNegative && -res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (!isNegative && res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return myAtoiHelper(res, s.substring(1), isNegative);
    }

    public static boolean isInteger(char s) {
        return s >= '0' && s <= '9';
    }

    public static List<String> generateBinaryStrings(int n) {
        StringBuilder sb = new StringBuilder();
         List<String> res = new ArrayList<>();
         generateBinaryStrings(res, sb, n, false);
         return res;
    }

    public static void generateBinaryStrings(List<String> res, StringBuilder sb, int n, boolean isPrevOne) {
        if (sb.length() == n) {
            res.add(sb.toString());
            return;
        }

        sb.append(0);
        generateBinaryStrings(res,  sb, n, false);
        sb.deleteCharAt(sb.length() - 1);

        if (!isPrevOne) {
            sb.append(1);
            generateBinaryStrings(res,  sb, n, true);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateParenthesis(n, 0, 0, sb, res);
        return res;
    }

    public void generateParenthesis(int n, int open, int close, StringBuilder sb, List<String> res) {

        if (open == n && close == n) {
            res.add(sb.toString());
            return;
        }

        if (open < n) {
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

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(nums, 0, res, new ArrayList<>());
        return res;
    }

    public static void subsets(int[] nums, int index, List<List<Integer>> res, List<Integer> curr) {
        res.add(new ArrayList<>(curr));

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            subsets(nums, i + 1, res, curr);
            curr.remove(curr.size() - 1);
        }
    }

    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        // code here
       if (arr.length == 0) {
           return false;
       }

       return checkSubsequenceHelper(arr, 0, 0, K);
    }
    public static boolean  checkSubsequenceHelper (int [] arr, int sum, int index, int  k) {
        if (index == arr.length || sum > k) {
            return false;
        }

        if (sum == k) {
            return true;
        }

        sum += arr[index];
        boolean res1 = checkSubsequenceHelper(arr, sum, index + 1, k);
        boolean res2 = checkSubsequenceHelper(arr, sum - arr[index], index + 1, k);
        return res1 || res2;
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, res, new ArrayList<>(), 0);
        return res;
    }

    public static void combinationSumHelper(int [] candidates, int target, int index, List<List<Integer>> res, List<Integer> curr, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (sum > target) {
            return;
        }

        if (index == candidates.length) {
            return;
        }
        curr.add(candidates[index]);
        combinationSumHelper(candidates, target, index, res, curr, sum + candidates[index]);
        curr.remove(curr.size() - 1);
        combinationSumHelper(candidates, target, index + 1, res, curr, sum);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // must sort for duplicate skipping
        combinationSum2Helper(candidates, target, 0, res, new ArrayList<>(), 0);
        return res;
    }

    public static void combinationSum2Helper(int[] candidates, int target, int index,
                                             List<List<Integer>> res, List<Integer> curr, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break; // pruning

            if (i > index && candidates[i] == candidates[i - 1]) continue; // skip duplicates

            curr.add(candidates[i]);
            combinationSum2Helper(candidates, target, i + 1, res, curr, sum + candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }

    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        if (arr.length == 0) {
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();
        subsetSumsHelper(arr, 0, 0, res);
        return res;
    }

    public void subsetSumsHelper(int [] arr, int index, int sum, ArrayList<Integer> curr) {
        if (index == arr.length) {
            curr.add(sum);
            return;
        }

        subsetSumsHelper(arr, index + 1, sum + arr[index], curr);
        subsetSumsHelper(arr, index + 1, sum, curr);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithDupHelper(nums, 0, res, new ArrayList<>());
        return res;
    }

    public void subsetsWithDupHelper(int [] nums, int index, List<List<Integer>> res, List<Integer> curr) {
        if (index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i >  index && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            subsetsWithDupHelper(nums, i + 1, res, curr);
            curr.remove(curr.size() - 1);
        }
    }

}
