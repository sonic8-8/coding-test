package baekjoon.dp;

import java.io.*;

public class Question9095 {
    final static int MAX = 11 + 10;
    static int T, N;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        dp = new int[MAX];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            for (int i = 4; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            sb.append(dp[N]).append("\n");
        }

        bw.write(String.valueOf(sb));

        br.close();
        bw.close();
    }
}
