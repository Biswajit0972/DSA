package SEP.work1.FRI;

import java.util.Arrays;
import java.util.HashMap;

public class Solutions {
    public static boolean canJump(int[] nums) {
        int furtherCan = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > furtherCan) return false;
            furtherCan = Math.max(furtherCan, i + nums[i]);
            if (furtherCan > nums.length - 1) return true;
        }
        return true;
    }

    public int jump(int[] nums) {
        int count = 0;
        int i = 0;

        while (i < nums.length - 1) {
            if (i + nums[i] >= nums.length - 1) {
                count++;
                break;
            }

            int maxReach = 0;
            int nextReach = i;

            for (int j = nextReach + 1; j < i + nums[i] && j < nums.length; j++) {
                if (maxReach < j + nums[j]) {
                    maxReach = j + nums[j];
                    nextReach = j;
                }
            }

            i = nextReach;
            count++;
        }

        return count;
    }

    public static int minPlatform(int arr[], int dep[]) {
        Integer[] indexes = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indexes[i] = i;
        }

        Arrays.sort(indexes, (a, b) -> Integer.compare(dep[a], dep[b]));
        HashMap<Integer, Integer> platform = new HashMap<>();

        int i = 0, j = 0;
        int platNeeded = 0, maxPlat = 0;

        while (i < indexes.length && j < indexes.length) {
            if (arr[indexes[i]] <= dep[indexes[j]]) {
                platNeeded++;
                i++;
            } else {
                platNeeded--;
                j++;
            }
            maxPlat = Math.max(maxPlat, platNeeded);
        }

        return maxPlat;
    }

    public static void main(String[] args) {
        System.out.println(minPlatform(new int[]{900, 940, 950, 1100, 1500, 1800}, new int[]{910, 1200, 1120, 1130, 1900, 2000}));
    }
}
