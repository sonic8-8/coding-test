package baekjoon.backtracking;

import java.io.*;
import java.util.*;

/**
 * 아이디어:
 * DFS와 그리디를 이용해 풀이합니다.
 *
 * 위, 중간, 아래 순서로 파이프를 연결할 수 있는지 체크하고
 * 연결할 수 없다면 즉시 탐색을 중단하고 다음 경로를 탐색합니다.
 * -> 이를 구현하기 위해 일반적인 DFS처럼 void를 반환하지 않고 boolean을 반환합니다.
 * -> 그리디하게 탐색하기 위해 boolean을 반환하는 것입니다.
 *
 * -> 구체적으로 일반적인 백트래킹은
 * -> "하나의 시작점"에서 위쪽 경로로 가서 파이프 연결에 성공했지만
 * -> 혹시 같은 시작점에서 중간이나 아래 경로로 갔을때도 파이프 연결에 성공할 수 있을까?
 * -> 같은 생각으로 모든 경로를 다 탐색하는 방식입니다.
 *
 * -> 하지만 그리디하게 탐색하는 것은
 * -> "하나의 시작점"에서 위쪽 경로로 가서 파이프 연결에 성공했다면
 * -> 즉시 그 시작점을 넘어가고, "다음 시작점"의 위쪽 경로부터 탐색하는 방식입니다.
 */

/**
 * 메모리: 49112 KB
 * 시간: 396 ms
 * 난이도: 골드 2
 */
public class Main_3109_빵집 {
    static int R;
    static int C;

    static int[][] map;
    static boolean[][] visited;

    static final int[] DIR_ROW = {-1, 0, 1};
    static final int[] DIR_COL = {1, 1, 1};

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new boolean[R][C];

        for (int row = 0; row < R; row++) {
            String line = br.readLine();
            for (int col = 0; col < C; col++) {
                if (line.charAt(col) == '.') {
                    map[row][col] = 0;
                }
                if (line.charAt(col) == 'x') {
                    map[row][col] = 1;
                    visited[row][col] = true;
                }
            }
        }

        // 시작점이 x일 경우를 체크합니다.
        for (int row = 0; row < R; row++) {
            if (map[row][0] == 0) {
                visited[row][0] = true;
                canConnectPipeDFS(row, 0);
            }
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }

    // 그리디하게 탐색하기 위해 boolean을 반환합니다.
    private static boolean canConnectPipeDFS(int row, int col) {
        if (col == C - 1) {
            count++;
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nextRow = row + DIR_ROW[i];
            int nextCol = col + DIR_COL[i];

            if (nextRow < 0 || R <= nextRow || nextCol < 0 || C <= nextCol) {
                continue;
            }

            if (!visited[nextRow][nextCol] && map[nextRow][nextCol] == 0) {
                visited[nextRow][nextCol] = true;
                if (canConnectPipeDFS(nextRow, nextCol)) {
                    return true;
                }
            }
        }
        return false;
    }
}