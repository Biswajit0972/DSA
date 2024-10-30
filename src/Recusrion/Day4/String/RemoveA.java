package Recusrion.Day4.String;

public class RemoveA {

    public static String usingIterator (String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch =  str.charAt(i);

            if (ch != 'a') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String skip (String  str) {
        if (str.isEmpty()) {
            return "";
        }

        char ch = str.charAt(0);

        if (ch == 'a') {
           return skip(str.substring(1));
        }

        return ch + skip(str.substring(1));
    } 

    public static void main(String[] args) {
        String str =  "bacccd";
        // ans should be bccd
        System.out.println(skip("bal"));
    }
}
