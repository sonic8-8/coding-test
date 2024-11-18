package phase7;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        // String이 아닌 char형을 이용해서 문자 다루기

        char[][] matrix = new char[5][15];

        Scanner sc = new Scanner(System.in);

        for (int row = 0; row < 5; row++) {
            String line = sc.nextLine();
            for (int col = 0; col < line.length(); col++) {
                matrix[row][col] = line.charAt(col);
            }
        }

        for (int col = 0; col < 15; col++) {
            for (int row = 0; row < 5; row++) {
                if (matrix[row][col] != '\0') {
                    System.out.print(matrix[row][col]);
                }
            }
        }

    }
}
