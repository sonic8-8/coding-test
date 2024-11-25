package phase9;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            int first = sc.nextInt();
            int second = sc.nextInt();

            if (first == 0 && second == 0) {
                return;
            }

            if (second % first == 0) {
                System.out.println("factor");
            }

            if (first % second == 0) {
                System.out.println("multiple");
            }

            if (first % second != 0 && second % first != 0) {
                System.out.println("neither");
            }


        }


    }
}
