package baekjoon.implementation;

import java.io.*;
import java.util.*;

/**
 * 아이디어:
 * 그림의 개수와 가장 넓은 그림의 넓이 구하기
 *
 * 상하좌우에 인접한 것은 연결된 것이다.
 * -> DFS나 BFS로 상하좌우를 탐색하기
 *
 * 중복 탐색을 방지해야함
 * -> visited 배열 사용하기
 *
 * 전체 배열을 모두 돌면서 그림의 개수를 탐색해야함
 * -> 이중 for문으로 전체 배열을 돌고 방문하지 않았을 경우 count를 증가시킨다.
 */

/**
 * 메모리: 49280 KB
 * 시간: 376 ms
 * 난이도: 실버1
 */
public class Question1926 {
    static int N, M;
    static int[][] board;
    static boolean[][] visited; // 중복 탐색 방지용

    // 북동남서를 탐색하기 위한 방향 인덱스
    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};

    static int count; // 그림의 개수
    static int max; // 제일 큰 그림의 넓이

    static int area;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    visited[i][j] = true;
                    count++;
                    bfs(i, j);
                }
            }
        }

        sb.append(count).append("\n").append(max);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r, c});

        int area = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = row + dirRow[i];
                int nextCol = col + dirCol[i];

                // 인덱스 범위를 체크합니다. 범위를 벗어날 경우 continue
                if (nextRow < 0 || N <= nextRow || nextCol < 0 || M <= nextCol) {
                    continue;
                }

                // 방문한 적 없고 그림(1)이면 연결된 그림(1)이다.
                if (!visited[nextRow][nextCol] && board[nextRow][nextCol] == 1) {
                    visited[nextRow][nextCol] = true;
                    area++;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }
        max = Math.max(max, area);
    }

    private static void dfs(int row, int col) {
        // 북동남서를 봐야하는데
        // r이랑 c -> 좌표
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dirRow[i];
            int nextCol = col + dirCol[i];

            if (nextRow < 0 || N <= nextRow || nextCol < 0 || M <= nextCol) {
                continue;
            }

            if (!visited[nextRow][nextCol] && board[nextRow][nextCol] == 1) {
                visited[nextRow][nextCol] = true;
                area++;
                dfs(nextRow, nextCol);
            }
        }
    }
}
