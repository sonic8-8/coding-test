package baekjoon.bruteforce_recursion;

import java.io.*;

public class Question1248 {
    static int N;
    static char[][] signs;
    static int[] perm;
    static StringBuilder sb = new StringBuilder();
    static boolean isSolved;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        signs = new char[N][N];
        perm = new int[N];

        String str = br.readLine();
        int index = 0;
        for (int row = 0; row < N; row++) {
            for (int col = row; col < N; col++) {
                signs[row][col] = str.charAt(index++);
            }
        }

        backtrack(0);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backtrack(int depth) {
        if (isSolved) {
            return;
        }

        if (depth == N) {
            for (int num : perm) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            isSolved = true;
            return;
        }

        for (int i = -10; i <= 10; i++) {
            perm[depth] = i;

            if (isValid(depth)) {
                backtrack(depth + 1);
            }
        }
    }

    private static boolean isValid(int depth) {
        for (int i = 0; i <= depth; i++) {
            int sum = 0;
            for (int j = i; j <= depth; j++) {
                sum += perm[j];
            }

            char sign = signs[i][depth];

            if (sign == '+' && sum <= 0) {
                return false;
            }
            if (sign == '-' && sum >= 0) {
                return false;
            }
            if (sign == '0' && sum != 0) {
                return false;
            }
        }
        return true;
    }
}
