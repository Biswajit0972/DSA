package recursion_1sep;

public class Solutions {
    public static void main(String[] args) {

    }

    public static int binaryExpoentiation  (int x, int y) {
        if (y == 0) {
            return 1;
        }

        if (y < 0) {
            return 1 / binaryExpoentiation(x, -y);
        }

        if (x % 2  == 1) {
            return x * binaryExpoentiation(x, y - 1);
        }else {
            return binaryExpoentiation(x, y / 2);
        }
    }
}
