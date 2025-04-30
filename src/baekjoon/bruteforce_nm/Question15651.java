package baekjoon.bruteforce_nm;

import java.util.*;
import java.io.*;

public class Question15651 {
    static int N, M;
    static int[] array;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[M];

        dfs(0);

        bw.write(String.valueOf(sb));

        br.close();
        bw.close();
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int number : array) {
                sb.append(number + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            array[depth] = i;
            dfs(depth + 1);
        }
    }
}
