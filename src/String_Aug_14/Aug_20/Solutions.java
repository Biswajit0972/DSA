package String_Aug_14.Aug_20;

public class Solutions {
    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }
    public static int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                depth++;
            }else if (ch == ')') {
                maxDepth = Math.max(depth, maxDepth);
                depth--;
            }
        }

        return maxDepth;
    }

    public static int romanToInt(String s) {
        char prev = s.charAt(s.length() - 1);
        int sum = romanValue(prev);

        int n = s.length();

        for (int i = n - 2; i >= 0; i--) {
              char curr = s.charAt(i);
              if (romanValue(curr) >= romanValue(prev)) {
                  sum += romanValue(curr);
              }else {
                  sum -= romanValue(curr);
              }
              prev = curr;
        }

        return sum;
    }

    public static int romanValue(char symbol) {
        return switch (symbol) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> throw new IllegalArgumentException("Invalid Roman symbol: " + symbol);
        };
    }
}
