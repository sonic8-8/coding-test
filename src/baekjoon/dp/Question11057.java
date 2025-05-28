package baekjoon.dp;

import java.io.*;
import java.util.*;

public class Question11057 {
    static int N;
    static final int MOD = 10007;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new long[N + 1][10]; //[길이][끝자리수]
        for (int j = 0; j <= 9; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
                }
            }
        }

        long answer = 0;
        for (int j = 0; j <= 9; j++) {
            answer += dp[N][j];
        }
        answer %= MOD;

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
