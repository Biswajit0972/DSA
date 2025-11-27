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
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        TreeMap<Integer, List<Integer>> bucket = new TreeMap<>();
        helperOfVerticalOrder(bucket, root, 0);

        for (Map.Entry<Integer, List<Integer>> entry : bucket.entrySet()) {
            List<Integer> temp = entry.getValue();

            if (temp.size() > 2) {
                temp.sort((a, b) -> a - b);
            }

            ans.add(temp);
        }
        return ans;
    }

    public void helperOfVerticalOrder(TreeMap<Integer, List<Integer>> bucket, TreeNode root, int col) {
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
        List<int[]> nodes = new ArrayList<>();
        Queue<Object[]> q = new LinkedList<>();

        q.add(new Object[]{root, 0, 0}); // node, row, col

        // BFS to collect (col, row, val)
        while (!q.isEmpty()) {
            Object[] curr = q.poll();
            TreeNode currRoot = (TreeNode) curr[0];
            int row = (int) curr[1];
            int col = (int) curr[2];

            nodes.add(new int[]{col, row, currRoot.val});

            if (currRoot.left != null)
                q.offer(new Object[]{currRoot.left, row + 1, col - 1});
            if (currRoot.right != null)
                q.offer(new Object[]{currRoot.right, row + 1, col + 1});
        }

        // sort by col, then row, then val
        nodes.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];   // col
            if (a[1] != b[1]) return a[1] - b[1];   // row
            return a[2] - b[2];                     // value
        });

        List<List<Integer>> ans = new ArrayList<>();
        int pastCol = Integer.MIN_VALUE;

        for (int[] n : nodes) {
            int col = n[0];
            int val = n[2];

            if (col != pastCol) {
                ans.add(new ArrayList<>());
                pastCol = col;
            }
            ans.get(ans.size() - 1).add(val);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
