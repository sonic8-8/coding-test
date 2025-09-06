package baekjoon.simulation;

import java.io.*;
import java.util.*;

/**
 * 아이디어:
 * - CCTV 타입마다 볼 수 있는 방향을 미리 하드코딩(DIRECTIONS)으로 정의
 * - DFS로 각 CCTV 방향을 하나씩 정하면서 모든 경우 탐색
 * - 모든 CCTV 배치가 끝나면 사각지대(0의 개수)를 세어 최소값 갱신
 */

/**
 * 메모리: 55,392 KB
 * 시간: 248 ms
 * 난이도: 골드 3
 */
public class Main_15683_감시 {
    static int N, M;
    static int[][] board;

    static List<int[]> cctvs; // row, col, type

    static final int UP = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;

    static final int[] DIR_ROW = {-1, 0, 1, 0};
    static final int[] DIR_COL = {0, 1, 0, -1};

    static final int EMPTY = 0;
    static final int WALL = 6;

    static final int[][][] DIRECTIONS = {
            {{}}, // dummy
            {{UP}, {RIGHT}, {DOWN}, {LEFT}}, // 1번
            {{LEFT, RIGHT}, {UP, DOWN}}, // 2번
            {{UP, RIGHT}, {RIGHT, DOWN}, {DOWN, LEFT}, {LEFT, UP}}, // 3번
            {{LEFT, UP, RIGHT}, {UP, RIGHT, DOWN}, {RIGHT, DOWN, LEFT}, {DOWN, LEFT, UP}}, // 4번
            {{UP, RIGHT, DOWN, LEFT}} // 5번
    };

    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        cctvs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= board[i][j] && board[i][j] <= 5) {
                    cctvs.add(new int[]{i, j, board[i][j]});
                }
            }
        }

        min = Integer.MAX_VALUE;
        dfs(0, board);

        bw.write(String.valueOf(min));

        br.close();
        bw.close();
    }

    /**
     * DFS로 CCTV 방향을 하나씩 설정하면서 모든 경우의 수 탐색
     * index: 현재 설정할 CCTV 번호
     * currentBoard: 지금까지 감시 영역이 표시된 시뮬레이션 보드
     */
    private static void dfs(int index, int[][] currentBoard) {
        if (index == cctvs.size()) {
            min = Math.min(min, countBlind(currentBoard));
            return;
        }

        int[] cctv = cctvs.get(index);
        int row = cctv[0];
        int col = cctv[1];
        int type = cctv[2];

        for (int[] directions : DIRECTIONS[type]) {
            int[][] nextBoard = copyBoard(currentBoard);
            for (int direction : directions) {
                simulate(nextBoard, row, col, direction);
            }

            dfs(index + 1, nextBoard);
        }
    }

    private static int countBlind(int[][] board) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // 현재 보드를 깊은 복사 (다른 DFS 가지에 영향 주지 않도록)
    private static int[][] copyBoard(int[][] board) {
        int[][] simulationBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                simulationBoard[i][j] = board[i][j];
            }
        }
        return simulationBoard;
    }

    /**
     * CCTV에서 주어진 방향으로 직선 감시
     * 벽(6)을 만나면 중단, 빈 칸(0)은 감시 영역(-1)으로 표시
     */
    private static void simulate(int[][] board, int row, int col, int direction) {
        int nextRow = row + DIR_ROW[direction];
        int nextCol = col + DIR_COL[direction];

        while (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < M) {
            if (board[nextRow][nextCol] == WALL) {
                break;
            }
            if (board[nextRow][nextCol] == EMPTY) {
                board[nextRow][nextCol] = -1;
            }
            nextRow += DIR_ROW[direction];
            nextCol += DIR_COL[direction];
        }
    }
}