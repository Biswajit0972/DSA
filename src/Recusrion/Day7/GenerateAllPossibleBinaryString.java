package Recusrion.Day7;

import java.util.Arrays;

public class GenerateAllPossibleBinaryString {
    public static void Print (int k, char [] ch, int index) {
        if (k == index) {
            System.out.println(Arrays.toString(ch));
            return;
        }

        if (ch[index - 1] == '0') {
            // I have two choice put 0 first
            ch[index] = '0';
            Print(k, ch, index+1);

            // put 1
            ch[index] = '1';
            Print(k, ch, index+1);
        }

        if (ch[index - 1] ==  '1') {
            ch[index] = '0';
            Print(k, ch, index+1);
        }
    }
    public static void main(String[] args) {
        char [] stCh = new char[3];
        stCh[0] = '0';
        Print(3, stCh, 1);
    }
}
