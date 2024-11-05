package Leetcode.Day4;

public class StringComperison {
    public static String compressedString(String word) {
      StringBuilder sb = new StringBuilder(); // for memory mangement
      int count = 1; // assume that first character is unique, it may have some duplicates
        int n = word.length() - 1;

        for (int i  = 1; i <= n; i++) {
            char currentChar = word.charAt(i);
            char prevChar = word.charAt(i-1);
            if (prevChar == currentChar) {
                count++;
                if (count == 9) {
                    sb.append(count).append(currentChar);
                    count = 0;
                }
            }else {
                if (count > 0) {
                    sb.append(count).append(prevChar);
                }
                count = 1;
            }
        }

        if (count > 0) {
            sb.append(count).append(word.charAt(n));
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "aaaaaaaaaaaaaabb";
        System.out.println(compressedString(str));
    }
}
