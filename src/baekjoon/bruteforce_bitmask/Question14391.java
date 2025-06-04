package baekjoon.bruteforce_bitmask;

import java.io.*;
import java.util.*;

public class Question14391 {
    static int N, M;
    static int[][] board;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int row = 0; row < N; row++) {
            String str = br.readLine();
            for (int col = 0; col < M; col++) {
                board[row][col] = str.charAt(col) - '0';
            }
        }

        for (int mask = 0; mask < (1 << (N * M)); mask++) {
            int sum = 0;

            for (int row = 0; row < N; row++) {
                int rowSum = 0;
                for (int col = 0; col < M; col++) {
                    int index = row * M + col;
                    if ((mask & (1 << index)) != 0) {
                        rowSum = rowSum * 10 + board[row][col];
                        continue;
                    }
                    sum += rowSum;
                    rowSum = 0;
                }
                sum += rowSum;
            }

            for (int col = 0; col < M; col++) {
                int colSum = 0;
                for (int row = 0; row < N; row++) {
                    int index = row * M + col;
                    if ((mask & (1 << index)) == 0) {
                        colSum = colSum * 10 + board[row][col];
                        continue;
                    }
                    sum += colSum;
                    colSum = 0;
                }
                sum += colSum;
            }

            max = Math.max(max, sum);
        }

        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }
}
