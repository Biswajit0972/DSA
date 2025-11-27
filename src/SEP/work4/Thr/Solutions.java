package SEP.work4.Thr;

public class Solutions {
    public static int[] findErrorNums(int[] nums) {
        int findDuplicate = 0, sum = 0;

        for (int num: nums) {
            findDuplicate ^= num;
            sum += num;
        }
        System.out.println(findDuplicate);
        int n = nums.length;
        int exceptedSum = n * (n+1)/2;

        for (int i = 1; i < n; i++) {
            findDuplicate ^= i;
        }
        System.out.println(findDuplicate);
        return new int[] {};
    }

    public static void main(String[] args) {
        System.out.println(findErrorNums(new int[] {1,2,2,4}));
    }
}
