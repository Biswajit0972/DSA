package _2026.sliding_window.D01;

import java.util.*;

class Pair {
    int val;
    int freq;

    Pair(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }
}

public class KthSubarraySum {

    public int[] kLengthSubarrayXSum(int[] nums, int k, int x) {

        Map<Integer, Integer> bucket = new HashMap<>();

        TreeSet<Pair> tree = new TreeSet<>((a, b) -> {
            if (a.freq != b.freq) return b.freq - a.freq;
            if (a.val != b.val) return b.val - a.val;
            return 1;
        });

        int n = nums.length;
        int[] res = new int[n - k + 1];

        // build first window
        for (int i = 0; i < k; i++) {
            bucket.put(nums[i], bucket.getOrDefault(nums[i], 0) + 1);
        }

        buildTree(tree, bucket);

        res[0] = getXSum(tree, x);

        int r = 1;

        for (int i = k; i < n; i++) {

            int remove = nums[i - k];
            int add = nums[i];

            // remove element
            bucket.put(remove, bucket.get(remove) - 1);
            if (bucket.get(remove) == 0) {
                bucket.remove(remove);
            }

            // add element
            bucket.put(add, bucket.getOrDefault(add, 0) + 1);

            tree.clear();
            buildTree(tree, bucket);

            res[r++] = getXSum(tree, x);
        }

        return res;
    }

    private void buildTree(TreeSet<Pair> tree, Map<Integer, Integer> bucket) {
        for (Map.Entry<Integer, Integer> entry : bucket.entrySet()) {
            tree.add(new Pair(entry.getKey(), entry.getValue()));
        }
    }

    private int getXSum(TreeSet<Pair> tree, int x) {

        int sum = 0;
        int count = 0;

        for (Pair p : tree) {
            sum += p.val * p.freq;
            count++;
            if (count == x) break;
        }

        return sum;
    }

    public static void main(String[] args) {

        KthSubarraySum obj = new KthSubarraySum();

        int[] nums = {2,2,3,3,4,5,3,4};
        int k = 6;
        int x = 2;

        int[] res = obj.kLengthSubarrayXSum(nums, k, x);

        System.out.println(Arrays.toString(res));
    }
}