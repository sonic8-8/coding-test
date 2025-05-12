package baekjoon.bruteforce_recursion;

import java.util.*;
import java.io.*;

public class Question14501 {
    static int N;
    static int[][] board;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        board = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
        }

        backtrack(1, 0);

        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }

    private static void backtrack(int day, int sum) {
        if (day == N + 1) {
            max = Math.max(max, sum);
            return;
        }

        if (day > N + 1) {
            return;
        }

        if (day + board[day][0] <= N + 1) {
            backtrack(day + board[day][0], sum + board[day][1]);
        }
        backtrack(day + 1, sum);
    }
}
