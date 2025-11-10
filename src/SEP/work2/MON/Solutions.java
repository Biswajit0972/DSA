package SEP.work2.MON;

import java.util.ArrayList;
import java.util.Arrays;

public class Solutions {
    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        //! Sorting
        Integer[] indexes = new Integer[deadline.length];
        for (int i = 0; i < deadline.length; i++) {
            indexes[i] = i;
        }

        Arrays.sort(indexes, (a, b) -> profit[b] - profit[a]);

        int maxEl = 0;

        for (int num : deadline) {
            maxEl = Math.max(num, maxEl);
        }

        int[] tracker = new int[maxEl + 1];
        Arrays.fill(tracker, 0);

        int profit2 = 0;
        int job = 0;

        for (int i = 0; i < deadline.length; i++) {
            int currDeadLine = deadline[indexes[i]];
            for (int j = tracker.length - 1; j >= 0; j--) {
                if (currDeadLine >= j && tracker[j] == 0) {
                    job++;
                    profit2 += profit[indexes[i]];
                    tracker[j] = currDeadLine;
                    break;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(job);
        res.add(profit2);
        return res;
    }

    public static void main(String[] args) {
        jobSequencing(new int[]{4, 1, 1, 1}, new int[]{20, 10, 40, 30});
    }
}
