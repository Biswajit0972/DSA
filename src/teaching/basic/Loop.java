package teaching.basic;

public class Loop {
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }

        int i = 1;
        while (i <= 10) {
            System.out.print(i + " ");
            i++;
        }
        i =  1;

        do {
            System.out.println(i + " ");
            i++;
        }while(i <= 10);
    }
}
