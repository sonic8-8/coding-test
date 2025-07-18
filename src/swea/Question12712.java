package swea;

import java.io.*;
import java.util.*;

public class Question12712 {
    static int T;
    static int N, M;
    static int[][] board;

    static int[] vertRow = new int[]{0, 1, 0, -1};
    static int[] vertCol = new int[]{1, 0, -1, 0};
    static int[] diagRow = new int[]{-1, 1, 1, -1};
    static int[] diagCol = new int[]{1, 1, -1, -1};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            board = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = Integer.MIN_VALUE;

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    int vertSum = board[row][col];
                    int diagSum = board[row][col];

                    for (int range = 1; range < M; range++) {
                        for (int i = 0; i < 4; i++) {
                            int newRow = row + vertRow[i] * range;
                            int newCol = col + vertCol[i] * range;

                            if (0 <= newRow && newRow < N
                                    && 0 <= newCol && newCol < N) {
                                vertSum += board[newRow][newCol];
                            }

                            newRow = row + diagRow[i] * range;
                            newCol = col + diagCol[i] * range;

                            if (0 <= newRow && newRow < N
                                    && 0 <= newCol && newCol < N) {
                                diagSum += board[newRow][newCol];
                            }
                        }
                    }
                    max = Math.max(max, Math.max(diagSum, vertSum));
                }
            }
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
