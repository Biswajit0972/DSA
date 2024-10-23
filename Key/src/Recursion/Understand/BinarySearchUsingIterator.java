package Recursion.Understand;

public class BinarySearchUsingIterator {
    public  static  int search (int [] arr, int key) {
        int n = arr.length;
        int st = 0;
        int ed = n -1;
        while (st <=ed ) {
            int mid = ed - (st + ed) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] > key) {
                ed = mid - 1;
            }else {
                st = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        System.out.println(search(arr, 4));
    }
}
