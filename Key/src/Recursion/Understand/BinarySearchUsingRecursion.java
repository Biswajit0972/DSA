package Recursion.Understand;

public class BinarySearchUsingRecursion {
    public  static int search (int [] arr, int st, int ed, int key) {
       if (st > ed) {
           return -1;
       }

       int mid = st + (ed - st) / 2;

       if ( arr[mid] == key) {
           return mid;
       }

       if ( arr[mid] > key) {
           return search(arr, st, mid-1, key);
       }

       return search(arr, mid+1, ed, key);
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        int x = search(arr, 0, arr.length-1, 6);
        System.out.println(x);
    }
}
