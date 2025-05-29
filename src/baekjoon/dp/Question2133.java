package baekjoon.dp;

import java.io.*;
import java.util.*;

public class Question2133 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        if (N % 2 != 0) {
            System.out.println(0);
            return;
        }

        dp = new int[N + 1];

        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= N; i += 2) {
            dp[i] = dp[i-2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }
        }

        bw.write(String.valueOf(dp[N]));

        br.close();
        bw.close();
    }
}
