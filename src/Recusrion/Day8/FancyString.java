package Recusrion.Day8;

import java.util.HashMap;

// Leet Code day 1
public class FancyString {
    public static void PrintFancy(String str) {
        StringBuilder res = new StringBuilder(); // Use StringBuilder for efficiency
        int count = 1; // Counter to track consecutive characters

        res.append(str.charAt(0)); // Start with the first character
        for (int index = 1; index < str.length(); index++) {
            if (str.charAt(index) == str.charAt(index - 1)) {
                count++;
            } else {
                count = 1; // Reset count for a new character
            }

            if (count < 3) {
                res.append(str.charAt(index)); // Append only if count is less than 3
            }
        }

        System.out.println(res.toString());
    }
    public static void main(String[] args) {
        String str = "leeetcode";
        PrintFancy(str);
    }
}
