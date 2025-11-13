package SEP.work2.Thu;

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
       if (p == null && q == null) {
           return true;
       }

       if (p == null || q == null) {
           return false;
       }

       boolean left = isSameTree(p.left, q.left);
       boolean right = isSameTree(p.right,  q.right);
       if (left && right && p.val == q.val) return true;

       return false;
    }


    public static void main(String[] args) {

    }
}
