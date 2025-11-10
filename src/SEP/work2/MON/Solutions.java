package SEP.work2.MON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null) return intervals;
        if (intervals == null || intervals.length == 0) {
            return new int[][] { { newInterval[0], newInterval[1] } };
        }

        List<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;

        // 1) Add intervals that end before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // 2) Merge all overlapping intervals with newInterval
        int mergedStart = newInterval[0];
        int mergedEnd = newInterval[1];

        while (i < n && intervals[i][0] <= mergedEnd) {
            mergedStart = Math.min(mergedStart, intervals[i][0]);
            mergedEnd   = Math.max(mergedEnd, intervals[i][1]);
            i++;
        }
        res.add(new int[] { mergedStart, mergedEnd });

        // 3) Add the remaining intervals
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        jobSequencing(new int[]{4, 1, 1, 1}, new int[]{20, 10, 40, 30});
    }
}
