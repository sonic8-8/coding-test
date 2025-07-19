package swea;

import java.io.*;
import java.util.*;

public class Question1961 {
    static int T;
    static int N;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];


            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append('#').append(t).append('\n');

            for (int i = 0; i < N; i++) {
                // 90도
                for (int j = 0; j < N; j++) {
                    sb.append(board[N - 1 - j][i]);
                }
                sb.append(' ');

                // 180도
                for (int j = 0; j < N; j++) {
                    sb.append(board[N - 1 - i][N - 1 - j]);
                }
                sb.append(' ');

                // 270도
                for (int j = 0; j < N; j++) {
                    sb.append(board[j][N - 1 - i]);
                }
                sb.append('\n');
                }
            }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
