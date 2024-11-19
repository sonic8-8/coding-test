package phase7;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {

        // 넓이는 점 개수로 파악 가능

        Scanner sc = new Scanner(System.in);

        int totalPaperCount = sc.nextInt();
        int[][] matrix = new int[100][100];

        for (int paperCount = 0; paperCount < totalPaperCount; paperCount++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int i = 0; i < 10; i++) {
                for (int j = 0 ; j < 10; j++) {
                    matrix[y + i][x + j] = 1;
                }
            }

        }

        int area = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (matrix[i][j] == 1) {
                    area++;
                }
            }
        }
        System.out.println(area);

    }
}
