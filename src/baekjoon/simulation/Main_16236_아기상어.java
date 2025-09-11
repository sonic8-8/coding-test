package baekjoon.simulation;

import java.io.*;
import java.util.*;

public class Main_16236_아기상어 {
    static int N;
    static int[][] board;
    static boolean[][] visited;

    static final int[] DIR_ROW = {-1, 0, 1, 0};
    static final int[] DIR_COL = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        Shark shark = new Shark(0, 0, 0, 0, 0);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    shark = new Shark(i, j, 2, 0, 0);
                    board[i][j] = 0;
                }
            }
        }

        bfs(shark);

        bw.write(String.valueOf(shark.time));

        br.close();
        bw.close();
    }

    public static class Shark {
        int row;
        int col;
        int size;
        int eatCount;
        int time;

        public Shark(int row, int col, int size, int eatCount, int time) {
            this.row = row;
            this.col = col;
            this.size = size;
            this.eatCount = eatCount;
            this.time = time;
        }
    }

    private static void bfs(Shark shark) {
        while (true) {
            Queue<int[]> queue = new ArrayDeque<>(); // 탐색 시뮬레이션 큐
            visited = new boolean[N][N];

            queue.add(new int[]{shark.row, shark.col, 0});
            visited[shark.row][shark.col] = true;

            List<int[]> candidates = new ArrayList<>();
            int minDist = Integer.MAX_VALUE;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                int dist = current[2];

                if (minDist < dist) {
                    break;
                }

                // 실제로 아기 상어가 이동함
                // 이번에 방문할 위치에 물고기가 있고
                // 아기 상어보다 크기가 작다면
                if (0 < board[row][col] && board[row][col] < shark.size) {
                    candidates.add(new int[]{row, col, dist});
                    minDist = dist;
                }

                for (int i = 0; i < 4; i++) {
                    int nextRow = row + DIR_ROW[i];
                    int nextCol = col + DIR_COL[i];

                    if (nextRow < 0 || N <= nextRow || nextCol < 0 || N <= nextCol) {
                        continue;
                    }

                    if (visited[nextRow][nextCol]) {
                        continue;
                    }

                    // 잡아먹을 수 있는 물고기거나 빈 칸일 경우
                    if (board[nextRow][nextCol] <= shark.size) {
                        // 방문할 위치 후보에 넣기
                        visited[nextRow][nextCol] = true;
                        queue.add(new int[]{nextRow, nextCol, dist + 1});
                    }
                }
            }

            if (candidates.isEmpty()) {
                break;
            }

            // 문제 우선순위대로 정렬
            candidates.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            int[] next = candidates.get(0);

            shark.row = next[0];
            shark.col = next[1];
            shark.eatCount++;
            shark.time += next[2];

            if (shark.eatCount == shark.size) {
                shark.size++;
                shark.eatCount = 0;
            }

            board[shark.row][shark.col] = 0;
        }
    }
}