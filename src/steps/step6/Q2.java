package steps.step6;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        int[] chessSet = {1,1,2,2,2,8};
        int[] inputSet = new int[6];

        Scanner sc = new Scanner(System.in);

        // 입력
        for (int i = 0; i < chessSet.length; i++) {
            inputSet[i] = sc.nextInt();
        }

        // inputSet - chessSet
        for (int i = 0; i < chessSet.length; i++) {
            System.out.print(chessSet[i] - inputSet[i]);
            if (i != chessSet.length - 1) {
                System.out.print(" ");
            }
        }
    }
}
