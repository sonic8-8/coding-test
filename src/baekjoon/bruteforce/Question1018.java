package baekjoon.bruteforce;

import java.util.*;
import java.io.*;

public class Question1018 {
    static int N, M;
    static String[] board;
    static String[] white = new String[]{"WBWBWBWB", "BWBWBWBW"};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }

        // 1. 체스판 자르기
        answer = Integer.MAX_VALUE;
        for (int row = 0; row <= N - 8; row++) {
            for (int col = 0; col <= M - 8; col++) {
                int count = getRepaintCount(row, col);
                answer = Math.min(answer, count);
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static int getRepaintCount(int row, int col) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[row + i].charAt(col + j) != white[i % 2].charAt(j)) {
                    count++;
                }
            }
        }
        return Math.min(count, 64 - count);
    }
}
