package baekjoon.dfs;

import java.util.*;
import java.io.*;

public class Question2644_BFS {
    static int N, start, end, M;
    static boolean[][] graph;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        answer = -1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        bfs(start);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static void bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] nodeInfo = queue.poll();
            int current = nodeInfo[0];
            int level = nodeInfo[1];

            if (current == end) {
                answer = level;
                return;
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && graph[current][i]) {
                    queue.add(new int[]{i, level + 1});
                    visited[i] = true;
                }
            }
        }
    }
}
