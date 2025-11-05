package SEP.work1.Wed;

import java.util.Arrays;

public class Solutions {
    /*
     * 455. Assign Cookies (GREEDY)
     * */
    public static int findContentChildren(int[] g, int[] s) {
        //! count for satisfied children
        int satisfied = 0;
        //! sort children and cookies  by ace order to satisfy max  children
        Arrays.sort(g);
        Arrays.sort(s);

        //! loop for children
        int i = 0;
        int j = 0;

        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                satisfied++;
                i++;
            }
            j++;
        }
        return satisfied;
    }

    static class Item {
        int val;
        int wt;
        double ratio;

        public Item(int val, int wt) {
            this.val = val;
            this.wt = wt;
            this.ratio = (double) val / wt;
        }
    }

    public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        Item[] items = new Item[val.length];

        for (int i = 0; i < val.length; i++) {
            items[i] = new Item(val[i], wt[i]);
        }

        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double total = 0;

        for (int i = 0; i < items.length; i++) {

            if (items[i].wt <= capacity) {
                total += items[i].val;
                capacity -= items[i].wt;
            } else {

                double fracPrice = items[i].val * ((double) capacity / items[i].wt);
                total += fracPrice;
                break;
            }
        }

        return total;
    }


    public static void main(String[] args) {
        System.out.println(fractionalKnapsack(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50));
    }
}
