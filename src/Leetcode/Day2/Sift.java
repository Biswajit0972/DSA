package Leetcode.Day2;

public class Sift {
    public static boolean rotateString(String s, String goal) {
        if (s.equals(goal)) {
            return true;
        }

        for (int i =0; i < s.length(); i++) {
            s = sift(
                    s
            );
            if (s.equals(goal)) {
                return true;
            }


        }

        return false;
       }

    public static boolean Helper (String s, String goal, int index) {
        if (index == s.length()) {
            return false;
        }

        s = sift(s);

        if (s.equals(goal)) {
            return true;
        }
      return   Helper(s, goal, index + 1);
    }

    public static String sift(String s) {
        char ch = s.charAt(0);
        s = s.substring(1);
        return s + ch;
    }
    public static void main(String[] args) {
         String s = "abcde";
         String goal = "abcde";
        System.out.println(rotateString(s, goal));
    }
}
