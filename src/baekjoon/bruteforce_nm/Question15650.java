package baekjoon.bruteforce_nm;

import java.util.*;
import java.io.*;

public class Question15650 {
    static int N, M;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[M];

        dfs(0, 1);

        br.close();
     }

    private static void dfs(int depth, int start) {
        if (depth == M) {
            Arrays.stream(array)
                    .forEach(o -> System.out.print(o + " "));
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            array[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
}
