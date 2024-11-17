package phase7;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        // 행렬 N * M
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    matrix[j][k] += sc.nextInt();
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j]);
                if (j == 2) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
            }
        }
    }
}
