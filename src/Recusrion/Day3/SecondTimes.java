package Recusrion.Day3;

public class SecondTimes {
    public static int SecondOccurrence (int [] arr, int target) {
        // i want to use a helper function
        return helperFunction(arr, target, 0, 0);
    }

    static int helperFunction (int [] arr, int target, int count, int index) {
        // base case when target not found or element not present on the array.
        if (index == arr.length - 1) {
            return -1;
        }

        if (arr[index] == target) {
            count++;
//            return element when it's appear twice.
            if (count == 2) {
                return index;
            }
        }
       // check further element available or not
        return helperFunction(arr, target, count, index + 1);
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,5,7,8,5,7,9,10};
        System.out.println(SecondOccurrence(arr, 5)); // ans should be 6
    }
}
