package baekjoon.grpah;

import java.io.*;
import java.util.*;

public class Question4963 {
    static boolean[][] map;
    static boolean[][] visited;
    static int W, H;
    static int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (H == 0 && W == 0) {
                break;
            }

            map = new boolean[H + 2][W + 2];
            visited = new boolean[H + 2][W + 2];

            for (int row = 1; row <= H; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 1; col <= W; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken()) == 1;
                }
            }

            int island = 0;

            for (int row = 1; row <= H; row++) {
                for (int col = 1; col <= W; col++) {
                    if (!visited[row][col] && map[row][col]) {
                        dfs(row, col);
                        island++;
                    }
                }
            }
            sb.append(island).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < 8; i++) {
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];

            if (!visited[newRow][newCol] && map[newRow][newCol]) {
                dfs(newRow, newCol);
            }
        }
    }
}
