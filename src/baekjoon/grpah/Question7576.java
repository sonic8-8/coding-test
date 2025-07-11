package baekjoon.grpah;

import java.io.*;
import java.util.*;

public class Question7576 {
    static int M, N;
    static int[][] box;
    static int[] dirRow = new int[]{0, 1, 0, -1};
    static int[] dirCol = new int[]{1, 0, -1, 0};
    static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        bfs();

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, box[i][j]);
            }
        }

        System.out.println(max - 1);

        br.close();
        bw.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int row = now[0];
            int col = now[1];

            for (int i = 0; i < 4; i++) {
                int newRow = row + dirRow[i];
                int newCol = col + dirCol[i];

                if (0 <= newRow && newRow < N &&
                        0 <= newCol && newCol < M) {
                    if (box[newRow][newCol] == 0) {
                        box[newRow][newCol] = box[row][col] + 1;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
        }
    }
}