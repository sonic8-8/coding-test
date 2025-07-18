package baekjoon.grpah;

import java.io.*;
import java.util.*;

public class Question11724 {
    static int N, M;
    static boolean[][] graph;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }

    private static void dfs(int current) {
        visited[current] = true;

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[current][i]) {
                dfs(i);
            }
        }
    }
}
