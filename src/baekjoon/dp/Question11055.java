package baekjoon.dp;

import java.io.*;
import java.util.*;

public class Question11055 {
    static int N;
    static int[] array;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        array = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp = array.clone();
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i-1; j++) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + array[i]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }
}
