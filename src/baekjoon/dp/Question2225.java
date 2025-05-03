package baekjoon.dp;

import java.util.*;
import java.io.*;

public class Question2225 {
    static final int MAX = 200 + 10;
    static final int MOD = 1000000000;
    static int N, K;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new long[MAX][MAX];

        for (int i = 0; i <= K; i++) {
            dp[0][i] = 1;
        }

        for (int n = 1; n <= N; n++) {
            for (int k = 1; k <= K; k++) {
                dp[n][k] = (dp[n - 1][k] + dp[n][k - 1]) % MOD;
            }
        }

        bw.write(String.valueOf(dp[N][K] % MOD));

        br.close();
        bw.close();
    }
}
