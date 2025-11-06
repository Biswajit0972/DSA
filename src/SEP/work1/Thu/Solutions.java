package SEP.work1.Thu;

import java.util.Arrays;

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

    static class  Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public static int maxMeetings(int start[], int end[]) {
       Meeting [] meetings = new Meeting[start.length];
       for (int i = 0; i < start.length; i++) {
           meetings[i] = new Meeting(start[i], end[i]);
       }

       //! sort the meetings by thier ending time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a.end, b.end));

       for (int i = 0; i < meetings.length; i++) {
           System.out.println(meetings[i].start + " " + meetings[i].end);
       }
       int count = 1;
       Meeting curr = meetings[0];

       for (int i = 1; i < meetings.length; i++) {
          if (curr.end  < meetings[i].start) {
              count++;
              curr = meetings[i];
          }
       }

       return count;
    }

    public static void main(String[] args) {
        System.out.println(maxMeetings(new int[]{1, 3, 0, 5, 8, 5}, new int[]{2, 4, 6, 7, 9, 9}));
    }
}
