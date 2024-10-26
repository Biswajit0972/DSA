package Recusrion.Day3;

public class Exponential {
   public static int exponential (int x, int n) {
        // base case
       if (n == 0) {
           return 1;
       }
       int ans  = x * exponential(x, n - 1);
       return ans;
    }
    public static void main(String[] args) {
        System.out.println(exponential(2, 10));
    }
}
