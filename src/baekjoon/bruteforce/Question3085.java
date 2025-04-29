package baekjoon.bruteforce;

import java.io.*;

public class Question3085 {
    final static int MAX = 50 + 10;
    static int N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new char[MAX][MAX];

        for (int row = 1; row <= N; row++) {
            String str = br.readLine();
            for (int col = 1; col <= N; col++) {
                map[row][col] = str.charAt(col - 1);
            }
        }

        int answer = 0;

        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N; col++) {
                // row 교환
                swap(row, col, row + 1, col);
                answer = Math.max(answer, check());
                swap(row, col, row + 1, col);

                // col 교환
                swap(row, col, row, col + 1);
                answer = Math.max(answer, check());
                swap(row, col, row, col + 1);
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static void swap(int row1, int col1, int row2, int col2) {
        char temp = map[row1][col1];
        map[row1][col1] = map[row2][col2];
        map[row2][col2] = temp;
    }

    private static int check() {
        int max = 1;
        int count = 1;

        // row 확인
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N; col++) {
                if (map[row][col] == map[row][col - 1]) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
            count = 1;
        }

        // col 확인
        for (int col = 1; col <= N; col++) {
            for (int row = 1; row <= N; row++) {
                if (map[row][col] == map[row - 1][col]) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
            count = 1;
        }

        return max;
    }
}
