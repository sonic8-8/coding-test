package baekjoon.dp;

import java.io.*;
import java.util.*;

public class Question2225_2 {
    static int N, K;
    static final int MOD = 1000000000;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // K개의 수로 N을 만드는 방법
        // row: 기준(phase) col: 변화하는 값(target)
        dp = new int[K + 1][N + 1];
        for (int n = 0; n <= N; n++) {
            dp[1][n] = 1;
        }
        for (int k = 1; k <= K; k++) {
            dp[k][0] = 1;
        }

        for (int k = 1; k <= K; k++) {
            for (int n = 1; n <= N; n++) {
                dp[k][n] = (dp[k][n-1] + dp[k-1][n]) % MOD;
            }
        }

        bw.write(String.valueOf(dp[K][N]));

        br.close();
        bw.close();
    }
}
