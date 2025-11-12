package SEP.work2.Wed;

import java.util.Stack;

public class Solutions {
    static class Index {
        public int index = 0;
    }

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

    public static TreeNode constructTree(int[] nums, Index o) {
        if (o.index >= nums.length || nums[o.index] == -1) {
            o.index++;
            return null;
        }

        TreeNode newNode = new TreeNode(nums[o.index]);
        o.index++;

        newNode.left = constructTree(nums, o);
        newNode.right = constructTree(nums, o);

        return newNode;
    }

    //! Iteration pre-order

    public static void  ItPreOrder (TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            System.out.println(curr.val);
            if (curr.right != null) st.push(curr.right);
            if (curr.left != null) st.push(curr.left);
        }
    }

    public static void ItPostSingleStack (TreeNode roo)

    public static void main(String[] args) {
        TreeNode root = constructTree(new int[] {1,2,3,-1,-1,4,-1,-1,-1}, new Index());
        ItPreOrder(root);
    }
}
