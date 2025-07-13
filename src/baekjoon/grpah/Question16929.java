package baekjoon.grpah;

import java.io.*;
import java.util.*;

public class Question16929 {
    static int N, M;
    static char[][] board;
    static int[] dirRow = new int[]{-1, 0, 1, 0};
    static int[] dirCol = new int[]{0, 1, 0, -1};
    static boolean[][] visited;
    static boolean isCyclic;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, -1, -1, board[i][j]);
                }
            }
        }

        if (isCyclic) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");

        br.close();
    }

    private static void dfs(int row, int col, int prevRow, int prevCol, char color) {

        for (int i = 0; i < 4; i++) {
            int newRow = row + dirRow[i];
            int newCol = col + dirCol[i];

            // 게임 보드 범위 초과
            if (newRow < 0 || N <= newRow || newCol < 0 || M <= newCol) {
                continue;
            }

            // 다른 색일 경우
            if (board[newRow][newCol] != color) {
                continue;
            }

            // 직전 위치일 경우
            if (newRow == prevRow && newCol == prevCol) {
                continue;
            }

            // 처음 위치 재방문 여부
            if (visited[newRow][newCol]) {
                isCyclic = true;
                return;
            }

            visited[newRow][newCol] = true;
            dfs(newRow, newCol, row, col, color);

        }
    }
}
