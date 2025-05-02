package baekjoon.dp;

import java.util.*;
import java.io.*;

public class Question14002 {
    static int N;
    static int[] array;
    static int[] dp;
    static int[] prev;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        array = new int[N + 1];
        dp = new int[N + 1];
        prev = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int lastIndex = 1;
        int maxLength = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (array[i] > array[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (maxLength < dp[i]) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }
        sb.append(maxLength).append("\n");

        Stack<Integer> stack = new Stack<>();
        while (lastIndex != 0) {
            stack.push(array[lastIndex]);
            lastIndex = prev[lastIndex];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        bw.write(String.valueOf(sb));

        br.close();
        bw.close();
    }
}
