package baekjoon.bruteforce_perm;

import java.io.*;
import java.util.StringTokenizer;

public class Question10971 {
    static int N;
    static int[][] board;
    static boolean[] visited;
    static int[] route;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        route = new int[N];

        for (int row = 1; row <= N; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= N; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 도시 1로 고정
        visited[1] = true;
        route[0] = 1;
        backtrack(0 + 1);

        bw.write(String.valueOf(min));

        br.close();
        bw.close();
    }

    private static void backtrack(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                int from = route[i];
                int to = route[i + 1];
                if (board[from][to] == 0) {
                    return;
                }
                sum += board[from][to];
            }

            int last = route[N - 1];
            int start = route[0];
            if (board[last][start] == 0) {
                return;
            }
            sum += board[last][start];
            min = Math.min(min, sum);
            return;
        }

        for (int city = 2; city <= N; city++) {
            if (!visited[city]) {
                visited[city] = true;
                route[depth] = city;
                backtrack(depth + 1);
                visited[city] = false;
            }
        }
    }
}
