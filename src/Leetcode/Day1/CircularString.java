package Leetcode.Day1;

public class CircularString {
    public static boolean isCircularSentence(String sentence) {
        String regex = "[,\\.\\s]";
        String [] str = sentence.split(regex);

        if (str.length == 1){
            return str[0].charAt(0) == str[0].charAt(str[0].length()-1);
        }

        String last = str[str.length-1];
        return  str[0].charAt(0) == last.charAt(last.length() - 1) && isHelper(str, 0);
    }

    public static boolean isHelper (String [] str, int index) {
        // base case
        if (index == str.length - 1) {
            return true;
        }

        if (isMatch(str[index], str[index + 1])) {
           return isHelper(str, index+1);
        }else{
            return false;
        }
    }

    public static boolean isMatch (String str1, String str2) {
        return str1.charAt(str1.length() - 1) == str2.charAt(0);
    }

    public static void main(String[] args) {
     String s = "leetcode exercises sound delightful";
        System.out.println(isCircularSentence(s));
    }
}
