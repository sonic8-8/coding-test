package baekjoon.dp;

import java.util.*;
import java.io.*;

// 최댓값 구하기

public class Question11052_dfs {
    final static int MAX = 1000 + 10;
    static int N;
    static int[] dp;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new int[MAX];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        dfs(0, 0);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static void dfs(int money, int sum) {
        if (sum == N) {
            answer = Math.max(answer, money);
            return;
        }

        if (sum > N) {
            return;
        }

        for (int i = 1; i <= N; i++) {
            dfs(money + dp[i], sum + i);
        }
    }
}
