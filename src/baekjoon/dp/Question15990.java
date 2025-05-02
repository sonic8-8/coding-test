package baekjoon.dp;

import java.util.*;
import java.io.*;

public class Question15990 {
    static final int MAX = 100000 + 10;
    static final int MOD = 1000000009;
    static int T, N;
    static long[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        dp = new long[MAX][3 + 1];

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < MAX; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            long answer = (dp[N][1] + dp[N][2] + dp[N][3]) % MOD;
            sb.append(answer).append("\n");
        }

        bw.write(String.valueOf(sb));

        br.close();
        bw.close();
    }
}
