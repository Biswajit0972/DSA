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

    public static double fractionalKnapsack2(int[] val, int[] wt, int capacity) {
        Integer [] indexs = new Integer[val.length];
        //! insert index in indexs array
        for (int i = 0; i < val.length; i++) {
            indexs[i] = i;
        }
        System.out.println(Arrays.toString(indexs));
        //! sort index array by ration of items
        //! use sort method with double compare
        Arrays.sort(indexs,  (a,b) ->Double.compare((double) val[b] /wt[b], (double) val[a] /wt[a]));

        double total = 0;
        System.out.println(Arrays.toString(indexs));
        // TODO:  Iterate over the indexs array, because we are sorting the index values not the actual array. if  i took any index from  index it will  represent other two array wt and val
        for (int i = 0; i < indexs.length; i++) {
            if (wt[indexs[i]] <= capacity) {
                total += val[indexs[i]];
                capacity -= wt[indexs[i]];
            }else {
                double fracPrice = val[indexs[i]] * ((double) capacity / wt[indexs[i]]);
                total += fracPrice;
                break;
            }
        }

        return Math.round(total * 1e6) /1e6;
    }

    /*
    * Minimum number of Coins
    * */
    public static int findMin(int n) {
        int [] coins = new int[]{10,5,2,1};
        int coinCount = 0;
        int i = 0;
        while  (n > 0) {
            if (n >= coins[i]) {
                n -= coins[i];
                coinCount++;
            }else {
                i++;
            }
        }

        return coinCount;
    }

    public static int findMin2(int n, int[] coins, int i, int count) {
        if (n == 0 || i == coins.length) {
            return count;
        }

        if (coins[i] <= n) {
            return findMin2(n - coins[i], coins, i, count + 1);
        }else {
            return findMin2(n, coins, i+1, count);
        }
    }
    public static void main(String[] args) {
        System.out.println(findMin2(1005, new int [] {10,5,2,1}, 0, 0));
    }
}
