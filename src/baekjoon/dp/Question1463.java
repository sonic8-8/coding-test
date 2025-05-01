package baekjoon.dp;

import java.util.*;
import java.io.*;

// 최솟값 -> 최적해 찾기
// 브루트 포스 ,그리디 , DP

public class Question1463 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }

        bw.write(String.valueOf(dp[N]));

        br.close();
        bw.close();
    }
}
