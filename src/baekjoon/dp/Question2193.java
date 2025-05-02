package baekjoon.dp;

import java.util.*;
import java.io.*;

public class Question2193 {
    static final int MAX = 90 + 10;
    static int N;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new long[MAX][1 + 1];

        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[3][0] = 1;
        dp[3][1] = 1;

        for (int i = 4; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        long answer = dp[N][0] + dp[N][1];
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
