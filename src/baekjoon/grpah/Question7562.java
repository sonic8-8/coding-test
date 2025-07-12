package baekjoon.grpah;

import java.io.*;
import java.util.*;

public class Question7562 {
    static int T, N;
    static int x, y;
    static int nx, ny;
    static int[][] board;
    static int[] dirCol = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dirRow = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    static Queue<int[]> queue = new ArrayDeque<>();
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            visited = new boolean[N][N];

            queue.clear();

            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            nx = Integer.parseInt(st.nextToken());
            ny = Integer.parseInt(st.nextToken());

            if (x == nx && y == ny) {
                sb.append(0).append("\n");
                continue;
            }

            queue.add(new int[]{y, x});
            visited[y][x] = true;

            bfs();

            sb.append(board[ny][nx]).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int row = now[0];
            int col = now[1];

            for (int i = 0; i < 8; i++) {
                int newCol = col + dirCol[i];
                int newRow = row + dirRow[i];

                if (0 <= newRow && newRow < N
                        && 0 <= newCol && newCol < N
                        && !visited[newRow][newCol]) {
                    board[newRow][newCol] = board[row][col] + 1;

                    queue.add(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;

                    if (newCol == nx && newRow == ny) {
                        return;
                    }
                }
            }
        }
    }
}
