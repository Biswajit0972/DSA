package SEP.work3.MON;

import java.util.*;

public class Solutions {
    static class TreeNode {
        int val;
       TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans =  new ArrayList<>();

        if (root == null) {
            return ans;
        }

        TreeMap<Integer, List<Integer>> bucket = new TreeMap<>();
        helperOfVerticalOrder(bucket, root, 0);

        for (Map.Entry<Integer, List<Integer>> entry : bucket.entrySet()) {
            List <Integer> temp = entry.getValue();

            if (temp.size() > 2) {
                temp.sort((a, b) -> a - b);
            }

           ans.add(temp);
        }
        return ans;
    }

    public void helperOfVerticalOrder (TreeMap<Integer, List<Integer>> bucket, TreeNode root, int col) {
        if (root == null) {
            return;
        }

        bucket.computeIfAbsent(col, k -> new ArrayList<>()).add(root.val);
        // left
        helperOfVerticalOrder(bucket, root.left, col - 1);
        // right
        helperOfVerticalOrder(bucket, root.right, col + 1);
    }

    public List<List<Integer>> optimalVerticalTraversal(TreeNode root) {

    }

    public static void main(String[] args) {

    }
}
