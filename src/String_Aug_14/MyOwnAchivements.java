package String_Aug_14;

import java.util.Arrays;

public class MyOwnAchivements {
    public static void main(String[] args) {

    }
    // ! String Question Sort Characters by frequency

    /*
    * This solution is perfect only for where string contains only lowercase characters and uppercase characters.
    * We simply use a tracker class to keep track of the frequency of each character.
    * We then sort the tracker array based on the frequency and then the alphabetically.
    * We then append each character to the final string.
    * tracker array tracker uppercase from 0 to 25 and lowercase from 26 to 51.
    * */

    static class Tracker {
        int count;
        char ch;

        public Tracker(int count, char ch) {
            this.count = count;
            this.ch = ch;
        }
    }

    public String frequencySort(String s) {

        Tracker [] tracker = new Tracker[52];

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            int index;

            if (Character.isUpperCase(currChar)) {
                index = currChar - 'A'; // 0–25
            } else {
                index = 26 + (currChar - 'a'); // 26–51
            }

            if (tracker[index] == null) {
                tracker[index] = new Tracker(1, currChar);
            } else {
                tracker[index].count++;
            }
        }

        Arrays.sort(tracker, (a, b) -> {
            if (a == null && b == null)
                return 0;
            if (a == null)
                return 1; // push nulls to the end
            if (b == null)
                return -1;

            if (b.count != a.count) {
                return Integer.compare(b.count, a.count); // higher freq first
            } else {
                return Character.compare(a.ch, b.ch); // alphabetically if tie
            }
        });

        StringBuilder sb = new StringBuilder();

        for (Tracker t : tracker) {
            if (t != null) {
                while (t.count-- > 0) {
                    sb.append(t.ch);
                }
            }
        }

        return sb.toString();
    }
}
