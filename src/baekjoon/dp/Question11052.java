package baekjoon.dp;

import java.util.*;
import java.io.*;

// 최댓값 구하기

public class Question11052 {
    final static int MAX = 1000 + 10;
    static int N;
    static int[] dp;
    static int[] price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new int[MAX];
        price = new int[MAX];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + price[j]);
            }
        }

        bw.write(String.valueOf(dp[N]));

        br.close();
        bw.close();
    }
}
