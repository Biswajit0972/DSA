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

        while (i < g.length &&   j  < s.length) {
            if (g[i] <= s[j]) {
                satisfied++;
                i++;
            }
            j++;
        }
        return satisfied;
    }

    public static void main(String[] args) {

    }
}
