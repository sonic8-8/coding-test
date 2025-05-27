package baekjoon.dp;

import java.io.*;
import java.util.*;

public class Question15988 {
    static int T;
    static long[] dp;
    static final int MAX = 1000000 + 10;
    static final int MOD = 1000000009;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new long[MAX];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < MAX; i++) {
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % MOD;
        }

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
