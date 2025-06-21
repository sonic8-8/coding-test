package baekjoon.grpah;

import java.io.*;
import java.util.*;

public class Question1260 {
    static int N, M, V;
    static boolean[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        visited = new boolean[N + 1];
        dfs(V);

        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void dfs(int current) {
        visited[current] = true;
        sb.append(current).append(" ");

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[current][i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int current) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(current);
        visited[current] = true;

        while (!q.isEmpty()) {
            int next = q.poll();
            sb.append(next).append(" ");

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && graph[next][i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
