package baekjoon.dfs;

//DFS, BFS 결과 출력
//오름차순 방문
//N 1,000 -> boolean[][]
//양방향 연결

import java.util.*;
import java.io.*;

public class Question1260 {
    static int N, M, V;
    static boolean[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(V);
        System.out.println();

        bfs(V);

        br.close();
    }

    private static void dfs(int current) {
        visited[current] = true;
        System.out.print(current + " ");

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[current][i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int current) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1];

        queue.add(current);
        visited[current] = true;

        while (!queue.isEmpty()) {
            int next = queue.poll();
            System.out.print(next + " ");

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && graph[next][i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
