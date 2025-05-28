package baekjoon.dp;

import java.io.*;
import java.util.*;

public class Question9465 {
    static int T, N;
    static int[][] stickers;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            stickers = new int[2][N];
            dp = new int[2][N];

            for (int row = 0; row < 2; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int col = 0; col < N; col++) {
                    stickers[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];
            if (N > 1) {
                dp[0][1] = stickers[0][1] + dp[1][0];
                dp[1][1] = stickers[1][1] + dp[0][0];
            }

            for (int i = 2; i < N; i++) {
                dp[0][i] = stickers[0][i] + Math.max(dp[1][i-1], dp[1][i-2]);
                dp[1][i] = stickers[1][i] + Math.max(dp[0][i-1], dp[0][i-2]);
            }

            int max = Math.max(dp[0][N-1], dp[1][N-1]);
            sb.append(max).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
