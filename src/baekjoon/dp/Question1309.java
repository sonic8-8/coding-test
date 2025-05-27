package baekjoon.dp;

import java.io.*;
import java.util.*;

public class Question1309 {
    static int N;
    static int[][] dp;
    static final int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][3];
        dp[1][0] = 1; // 배치 X
        dp[1][1] = 1; // 배치 왼쪽
        dp[1][2] = 1; // 배치 오른쪽

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }

        int answer = (dp[N][0] + dp[N][1] + dp[N][2]) % MOD;

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
