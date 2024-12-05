package steps.step8;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        // 1.24$ -> 124
        // 쿼터 : 0.25$ -> 25
        // 다임 : 0.10 -> 10
        // 니켈 : 0.05 -> 5
        // 페니 : 0.01 -> 1
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int[][] coins = new int[testCase][4];
        int[] standards = { 25, 10, 5, 1 };

        for (int i = 0; i < testCase; i++) {
            int input = sc.nextInt();
            for (int j = 0; j < 4; j++) {
                coins[i][j] = input / standards[j];
                input %= standards[j];
            }
        }
        for (int i = 0; i < testCase; i++) {
            for (int j = 0; j < 4; j++) {
                if (j != 3) {
                    System.out.print(coins[i][j] + " ");
                } else {
                    System.out.print(coins[i][j]);
                }
            }
            System.out.println();
        }
    }
}
