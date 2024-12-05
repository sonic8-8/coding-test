package steps.step7;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        int maxValue = 0;
        int maxValueRow = 0;
        int maxValueCol = 0;

        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                matrix[row][col] = sc.nextInt();
            }
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (maxValue < matrix[row][col]) {
                    maxValue = matrix[row][col];
                    maxValueRow = row;
                    maxValueCol = col;
                }
            }
        }

        System.out.println(maxValue);
        System.out.println((maxValueRow + 1) + " " + (maxValueCol + 1));
    }
}
