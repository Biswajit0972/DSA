package _2026.Learning;

import java.util.TreeSet;

class Pair  {
    int val;
    int freq;

    public Pair (int val,  int freq) {
        this.val  = val;
        this.freq = freq;
    }
}
// TreeSet maintains elements in sorted order using the comparator
// provided in the constructor. Internally it uses a Red-Black Tree.
// Every insertion compares elements with the comparator to find
// the correct position in the balanced tree. Time complexity: O(log n).

public class Sorting {
    public static void main(String[] args) {
        TreeSet<Pair> tree = new TreeSet<>((a,b) -> {
            if (a.freq != b.freq) {
                return b.freq - a.freq;
            }
            return b.val - a.val;
        });

        tree.add(new Pair(2, 2));
        tree.add(new Pair(3, 2));
        tree.add(new Pair(4, 1));
        tree.add(new Pair(5, 1));

        for (Pair p : tree) {
            System.out.println(p.val + " -> " + p.freq);
        }
    }
}
