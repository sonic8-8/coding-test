package baekjoon.bruteforce_perm;

import java.util.*;
import java.io.*;

public class Question10819 {
    static int N;
    static int[] array;
    static int[] perm;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        array = new int[N];
        visited = new boolean[N];
        perm = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        max = 0;
        backtrack(0);

        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }

    private static void backtrack(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(perm[i] - perm[i + 1]);
            }
            max = Math.max(max, sum);
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm[depth] = array[i];
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }
}
