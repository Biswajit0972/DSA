package SEP.work3.Thu;

import java.util.ArrayList;
import java.util.TreeMap;

public class Solutions {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        // top view /tracker - val
        TreeMap<Integer, Integer> bucket = new TreeMap<>();
        topViewHelper(bucket, root, 0);

        res.addAll(bucket.values());

        return res;
    }

    private void topViewHelper ( TreeMap<Integer, Integer> bucket , Node root,int tracking) {
        if (root == null) {
            return;
        }

        topViewHelper(bucket, root, tracking  - 1);
        topViewHelper(bucket, root, tracking  + 1);

        if (!bucket.containsKey(tracking)) {
            bucket.put(tracking, root.data);
        }

        bucket.put(tracking, root.data);
    }
}
