package phase8;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {

        // Integer.valueOf() 메서드로 바로 구할 수 있지만 직접 구현해봄

        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        int base = sc.nextInt();

        int numberLength = number.length();
        int total = 0;

        char[] numberCharArray = new char[number.length()];
        int[] numberIntArray = new int[numberLength];

        for (int i = 0; i < numberLength; i++) {
            numberCharArray[i] = number.charAt(i);
        }

        for (int i = 0; i < numberLength; i++) {
            if (numberCharArray[i] - 48 < 10) {
                numberCharArray[i] -= 48;
            }

            if (numberCharArray[i] - 55 >= 10) {
                numberCharArray[i] -= 55;
            }

            numberIntArray[i] = (int) numberCharArray[i];
        }


        for (int i = 0; i < numberLength; i++) {
            for (int j = 0; j < numberLength - i - 1; j++) {
                numberIntArray[i] *= base;
            }
        }

        for (int element : numberIntArray) {
            total += element;
        }

        System.out.println(total);

    }
}
