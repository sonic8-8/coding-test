package baekjoon.dp;

import java.io.*;
import java.util.*;

public class Question2156 {
    static int N;
    static int[] wines;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        wines = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = wines[0];
        if (N >= 2) {
            dp[1] = wines[0] + wines[1];
        }
        if (N >= 3) {
            dp[2] = Math.max(Math.max(dp[0] + wines[2], wines[1] + wines[2]), dp[1]);
        }

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(Math.max(dp[i-2] + wines[i], dp[i-3] + wines[i-1] + wines[i]), dp[i-1]);
        }

        bw.write(String.valueOf(dp[N-1]));

        br.close();
        bw.close();
    }
}
