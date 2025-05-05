package baekjoon.greedy;

import java.io.*;

// 최대한 1로 만들어야됨 -> 0이 2개가 되게끔 최소한의 횟수로 뒤집기

public class Question1285 {
    static int N;
    static int[][] board;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        answer = Integer.MAX_VALUE;

        for (int row = 1; row <= N; row++) {
            String str = br.readLine();
            for (int col = 1; col <= N; col++) {
                board[row][col] = str.charAt(col - 1) == 'H' ? 1 : 0;
            }
        }

        for (int bit = 0; bit < (1 << N); bit++) {
            flipRowsByBit(bit);

            int minZeroCount = 0;
            for (int col = 1; col <= N; col++) {
                int nonFlipZeroCount = countColZero(col);
                int afterFlipZeroCount = N - nonFlipZeroCount;
                minZeroCount += Math.min(nonFlipZeroCount, afterFlipZeroCount);
            }

            answer = Math.min(answer, minZeroCount);

            flipRowsByBit(bit);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static void flipRowsByBit(int bit) {
        for (int row = 1; row <= N; row++) {
            if ((bit & (1 << (row - 1))) != 0) {
                flipRow(row);
            }
        }
    }

    private static void flipRow(int row) {
        for (int col = 1; col <= N; col++) {
            board[row][col] = 1 - board[row][col];
        }
    }

    private static int countColZero(int col) {
        int count = 0;
        for (int row = 1; row <= N; row++) {
            if (board[row][col] == 0) {
                count++;
            }
        }
        return count;
    }
}
