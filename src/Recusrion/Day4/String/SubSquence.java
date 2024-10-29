package Recusrion.Day4.String;

public class SubSquence {
    public static void PrintSubSequence (String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        // took
        PrintSubSequence(p + ch, up.substring(1));
//        ignore it
        PrintSubSequence(p, up.substring(1));
    }
    public static void main(String[] args) {
     String str = "abc";
     PrintSubSequence("", str);
    }
}
