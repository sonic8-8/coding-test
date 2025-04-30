package baekjoon.bruteforce_nm;

import java.util.*;
import java.io.*;

public class Question15649 {
    final static int MAX = 8 + 10;
    static int N, M;
    static boolean[] visited;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[MAX];
        array = new int[M];

        dfs(0);

        br.close();
    }

    private static void dfs(int depth) {
        if (depth == M) {
            Arrays.stream(array)
                    .forEach(o -> System.out.print(o + " "));
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}