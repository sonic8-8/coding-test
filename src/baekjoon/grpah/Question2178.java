package baekjoon.grpah;

import java.io.*;
import java.util.*;

public class Question2178 {
    static boolean[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static int N, M;
    static int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N + 2][M + 2];
        visited = new boolean[N + 2][M + 2];
        dist = new int[N + 2][M + 2];

        for (int row = 1; row <= N; row++) {
            String str = br.readLine();
            for (int col = 1; col <= M; col++) {
                map[row][col] = str.charAt(col - 1) == '1';
            }
        }

        bfs(1, 1);

        bw.write(String.valueOf(dist[N][M]));

        br.close();
        bw.close();
    }

    private static void bfs(int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;
        dist[row][col] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curRow = current[0];
            int curCol = current[1];

            for (int i = 0; i < 4; i++) {
                int newRow = curRow + dir[i][0];
                int newCol = curCol + dir[i][1];

                if (!visited[newRow][newCol] && map[newRow][newCol]) {
                    queue.add(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                    dist[newRow][newCol] = dist[curRow][curCol] + 1;
                }
            }
        }
    }
}
