package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Question15652 {
    static int N, M;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];

        backtrack(0, 1);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backtrack(int depth, int start) {
        if (depth == M) {
            for (int number : numbers) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            numbers[depth] = i;
            backtrack(depth + 1, i);
        }
    }
}

