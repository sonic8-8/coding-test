package steps.step8;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int base = sc.nextInt();

        String result = Integer.toString(number, base);
        System.out.println(result.toUpperCase());


    }
}
