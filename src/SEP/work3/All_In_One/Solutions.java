package SEP.work3.All_In_One;

import java.util.Arrays;

public class Solutions {

    static class Index {
        int index = 0;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode createTree(int[] nums, Index o) {
        if (o.index >= nums.length || nums[o.index] == -1) {
            o.index++;
            return null;
        }

        TreeNode newNode = new TreeNode(nums[o.index]);
        o.index++;

        newNode.left = createTree(nums, o);
        newNode.right = createTree(nums, o);

        return newNode;
    }

    //!  pre order traversal

    public void preOrder (TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " -> ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //! post order traversal

    public void postOrder (TreeNode root) {
        
    }

    public static int sumAndMultiply(int n) {
        StringBuilder sb = new StringBuilder();
        long sum = 0;

        while  (n > 0) {
            int lastDigit = n % 10;
            if (lastDigit > 0) sb.insert(0, lastDigit);
            sum += lastDigit;
            n /= 10;
        }
        long num = (sb.length() == 0 ? 0 : Long.parseLong(sb.toString()));

        long MOD = 1_000_000_007L;

        long result = (sum % MOD) * (num % MOD) % MOD;

        return (int) result;
    }

    public static int[] sumAndMultiply(String s, int[][] queries) {
        int [] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            res[i] = sumAndMultiply(s.substring(l,r+1));
        }

        return res;
    }
    public static int sumAndMultiply(String str) {
        StringBuilder sb = new StringBuilder();
        long sum = 0;

        for (char c : str.toCharArray()) {
            int digit = c - '0';
            if (digit > 0) sb.append(digit);
            sum += digit;
        }

        long num = (sb.length() == 0 ? 0 : Long.parseLong(sb.toString()));

        long MOD = 1_000_000_007L;

        long result = (sum % MOD) * (num % MOD) % MOD;

        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumAndMultiply("9876543210", new int[][] {
                        {0,9}
                }))
        );
    }
}
