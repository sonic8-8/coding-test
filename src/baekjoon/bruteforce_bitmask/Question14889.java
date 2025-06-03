package baekjoon.bruteforce_bitmask;

import java.io.*;
import java.util.*;

public class Question14889 {
    static int N;
    static int[][] board;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int row = 0; row < N; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int full = (1 << N);
        for (int mask = 0; mask < full; mask++) {
            if (Integer.bitCount(mask) != N / 2) {
                continue;
            }

            ArrayList<Integer> teamA = new ArrayList<>();
            ArrayList<Integer> teamB = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) {
                    teamA.add(i);
                    continue;
                }
                teamB.add(i);
            }

            int scoreA = getTeamScore(teamA);
            int scoreB = getTeamScore(teamB);

            min = Math.min(min, Math.abs(scoreA - scoreB));
        }

        bw.write(String.valueOf(min));

        br.close();
        bw.close();
    }

    static int getTeamScore(List<Integer> team) {
        int sum = 0;
        for (int row : team) {
            for (int col : team) {
                sum += board[row][col];
            }
        }
        return sum;
    }
}
