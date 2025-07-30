package baekjoon.backtracking;

import java.io.*;
import java.util.*;

/**
 * 아이디어:
 * 길이가 M인 수열을 모두 구한다. (브루트 포스)
 *
 * =====
 * ❗ N과 M (1), (2)와 차이점
 * 중복 허용
 * =====
 *
 * -> 중복 순열
 *
 */
public class Question15651 {
    static int N, M;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];

        backtrack(0);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backtrack(int depth) {
        if (depth == M) {
            for (int number : numbers) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            numbers[depth] = i;
            backtrack(depth + 1);
        }
    }
}

