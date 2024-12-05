package steps.step6;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {

        // n = 5
        // 4 3 2 1 0 1 2 3 4 공백
        // 5 - 1, 5 - 2,
        // 1 3 5 7 9 7 5 3 1 별
        // 9번째 줄까지 출력하는데 9가 중간에 들어가는 별 개수

        // n = 1
        // 0
        // 1
        // 중간 별 1개

        // n = 2
        // 1 0 1
        // 1 3 1

        // n = 3
        // 2 1 0 1 2
        // 1 3 5 3 1

        // n = 4
        // 3 2 1 0 1 2 3
        // 1 3 5 7 5 3 1

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        // 윗부분
        for (int i = 0; i < number ; i++) {
            for (int j = i; j < number - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (i+1) * 2 - 1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 아랫부분
        for (int i = 0; i < number - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (number - 1 -  i) * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
