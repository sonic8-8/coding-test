package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class Question1080 {
    static int N, M;
    static int[][] arrayA;
    static int[][] arrayB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrayA = new int[N + 1][M + 1];
        arrayB = new int[N + 1][M + 1];

        for (int row = 1; row <= N; row++) {
            String str = br.readLine();
            for (int col = 1; col <= M; col++) {
                arrayA[row][col] = str.charAt(col - 1) - '0';
            }
        }

        for (int row = 1; row <= N; row++) {
            String str = br.readLine();
            for (int col = 1; col <= M; col++) {
                arrayB[row][col] = str.charAt(col - 1) - '0';
            }
        }

        int count = 0;
        for (int row = 1; row <= N - 2; row++) {
            for (int col = 1; col <= M - 2; col++) {
                if (arrayA[row][col] != arrayB[row][col]) {
                    flip(row, col);
                    count++;
                }
            }
        }

        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= M; col++) {
                if (arrayA[row][col] != arrayB[row][col]) {
                    count = -1;
                    break;
                }
            }
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }

    private static void flip(int row, int col) {
        for (int i = row; i <= row + 2; i++) {
            for (int j = col; j <= col + 2; j++) {
                arrayA[i][j] = 1 - arrayA[i][j];
            }
        }
    }
}
