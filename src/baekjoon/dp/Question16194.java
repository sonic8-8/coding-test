package baekjoon.dp;

import java.io.*;
import java.util.*;

public class Question16194 {
    final static int MAX = 1000 + 10;
    static int N;
    static int[] price;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        price = new int[MAX];
        dp = new int[MAX];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + price[j]);
            }
        }

        bw.write(String.valueOf(dp[N]));

        br.close();
        bw.close();
    }
}
