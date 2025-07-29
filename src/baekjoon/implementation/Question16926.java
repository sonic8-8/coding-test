package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class Question16926 {
    static int N, M, R;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layerCount = Math.min(N, M) / 2;
        for (int layer = 0; layer < layerCount; layer++) {
            rotate(layer);
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                sb.append(board[row][col]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void rotate(int layer) {
        List<Integer> elements = new ArrayList<>();

        int top = layer, bottom = N - 1 - layer;
        int left = layer, right = M - 1 - layer;

        // 1. 레이어 요소 추출 (← ↓ → ↑ 순서)
        for (int col = left; col < right; col++) {
            elements.add(board[top][col]);
        }
        for (int row = top; row < bottom; row++) {
            elements.add(board[row][right]);
        }
        for (int col = right; col > left; col--) {
            elements.add(board[bottom][col]);
        }
        for (int row = bottom; row > top; row--) {
            elements.add(board[row][left]);
        }

        // 2. 회전 (반시계 방향)
        Collections.rotate(elements, -R); // ← 여기 핵심

        // 3. 회전된 값을 다시 삽입
        int idx = 0;
        for (int col = left; col < right; col++) {
            board[top][col] = elements.get(idx++);
        }
        for (int row = top; row < bottom; row++) {
            board[row][right] = elements.get(idx++);
        }
        for (int col = right; col > left; col--) {
            board[bottom][col] = elements.get(idx++);
        }
        for (int row = bottom; row > top; row--) {
            board[row][left] = elements.get(idx++);
        }
    }

}