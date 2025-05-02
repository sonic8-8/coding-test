package baekjoon.dp;

import java.util.*;
import java.io.*;

public class Question1912 {
    static int N;
    static int[] array;
    static int[] dp;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        array = new int[N + 1];
        dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MIN_VALUE;
        }

        answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            answer = Math.max(answer, dp[i]);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
