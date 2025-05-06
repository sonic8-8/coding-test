package baekjoon.bruteforce_nm;

import java.util.*;
import java.io.*;

public class Question15654 {
    static int N, M;
    static int[] array;
    static int[] sub;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N];
        sub = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        dfs(0);

        bw.write(String.valueOf(sb));

        br.close();
        bw.close();
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int num : sub) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sub[depth] = array[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}