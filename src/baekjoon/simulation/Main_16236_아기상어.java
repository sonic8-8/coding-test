package baekjoon.simulation;

import java.io.*;
import java.util.*;

public class Main_16236_아기상어 {
    static int N;
    static int[][] board;

    static final int[] DIR_ROW = {-1, 0, 1, 0};
    static final int[] DIR_COL = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    queue.add(new int[]{i, j, 2, 0}); // row, col, size, ateCount
                }
            }
        }

        // 1초에 한 칸씩 이동
        // 크기가 작은 물고기만 먹을 수 있음
        // 크기가 큰 물고기가 있는 칸은 먹을 순 없지만 이동은 가능

        // 크기와 같은 수의 물고기 먹을 때마다 크기 1 증가

        // 더 이상 먹을 수 있는 물고기가 없으면 도움 요청
        // 거리가 가까운 물고기 먹기 (최솟값으로 이동)
        // 위에 있는 물고기 여러 마리면 가장 왼쪽에 있는 물고기


        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int size = current[2];
            int eatCount = current[3];
            int time = current[4];

            time++;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                }
            }
            
            for (int i = 0; i < 4; i++) {
                
            }
        }

        bw.write();

        br.close();
        bw.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();

    }
}
