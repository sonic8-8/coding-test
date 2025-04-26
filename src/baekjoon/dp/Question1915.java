package baekjoon.dp;

import java.util.*;
import java.io.*;

class Question1915 {
    static int N, M;
    static int[][] array;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];

        for (int row = 1; row <= N; row++) {
            String str = br.readLine();
            for (int col = 1; col <= M ; col++) {
                array[row][col] = Integer.parseInt(String.valueOf(str.charAt(col - 1)));
            }
        }

        int length = 0;
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= M; col++) {
                if (array[row][col] == 1) {
                    dp[row][col] = Math.min(dp[row-1][col], Math.min(dp[row][col-1], dp[row-1][col-1])) + 1;
                }
                length = Math.max(length, dp[row][col]);
            }
        }

        bw.write(String.valueOf(length * length));

        br.close();
        bw.close();
    }
}