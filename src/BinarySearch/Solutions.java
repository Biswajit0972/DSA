package BinarySearch;

public class Solutions {

    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        System.out.println(getStartingPoint(nums, 11));
        System.out.println(getEndingPoint(nums, 11));
    }

    public static int getStartingPoint(int[] nums, int target) {
        int st = 0;
        int ed = nums.length - 1;

        int stIndex = -1;

        while (st <= ed) {
            int  mid = st + (ed - st) / 2;

            if (nums[mid] >= target) {
                stIndex = mid;
                ed = mid - 1;
            }else {
                st = mid + 1;
            }
        }
        if (stIndex == -1 || nums[stIndex] != target) {
            return -1;
        }
        return stIndex;
    }

    public static int getEndingPoint(int [] nums, int target) {
        int st = 0;
        int ed = nums.length - 1;
        int stIndex = -1;

        while (st <= ed) {
            int mid = st + (ed - st) / 2;

            if (nums[mid] <= target) {
                stIndex = mid;
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        if (stIndex == -1 || nums[stIndex] != target) {
            return -1;
        }
        return stIndex;
    }
}
