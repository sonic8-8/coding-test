package baekjoon.bruteforce_recursion;

import java.util.*;
import java.io.*;

public class Question15661 {
    static int N;
    static int[][] board;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int row = 1; row <= N; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= N; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack(0, 1);

        bw.write(String.valueOf(min));

        br.close();
        bw.close();
    }

    private static void backtrack(int depth, int start) {
        if (1 <= depth && depth <= N - 1) {
            calculateDiff();
        }

        for (int i = start; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static void calculateDiff() {
        int teamA = 0;
        int teamB = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (visited[i] && visited[j]) {
                    teamA += board[i][j] + board[j][i];
                } else if (!visited[i] && !visited[j]) {
                    teamB += board[i][j] + board[j][i];
                }
            }
        }

        min = Math.min(Math.abs(teamA - teamB), min);
    }
}
