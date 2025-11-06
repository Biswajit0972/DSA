package SEP.work1.Thu;

public class Solutions {
    public static boolean checkValidString(String s) {
       int min =0;
       int max = 0;

       for (int i = 0; i < s.length(); i++) {
           if (s.charAt(i) == '(') {
               max++;
               min++;
           } else if (s.charAt(i) == ')') {
               min--;

               max--;
           }else {
               min--;

               max++;
           }
           if (min < 0) {
               min = 0;
           }

           if (max < 0) {
               return false;
           }
       }

       return min == 0;
    }

    public static boolean checkValidStringHelper(String s, int idx, int count) {
        // base case
        if (idx == s.length() && count == 0) {
            return true;
        }
        if (idx == s.length() || count < 0) {
            return false;
        }

        if (s.charAt(idx) == '(') {
            return checkValidStringHelper(s, idx + 1, count + 1);
        } else if (s.charAt(idx) == ')') {
            return checkValidStringHelper(s, idx + 1, count - 1);
        } else {
            //! first check for empty, open and close.
            return checkValidStringHelper(s, idx + 1, count) || checkValidStringHelper(s, idx+1, count + 1) || checkValidStringHelper(s, idx+1, count - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(checkValidString("**************************************************))))))))))))))))))))))))))))))))))))))))))))))))))))"));
    }
}
