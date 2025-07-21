package baekjoon.grpah;

import java.io.*;
import java.util.*;

public class Question16940 {
    static int N;
    static List<Integer>[] graph;
    static int[] order;
    static int[] position;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N];
        position = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            order[i] = Integer.parseInt(st.nextToken());
            position[order[i]] = i;
        }

        for (int i = 1; i <= N; i++) {
            graph[i].sort(Comparator.comparingInt(a -> position[a]));
        }

        bfs();

        br.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;

        int index = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (!visited[next]) {
                    if (order[index++] != next) {
                        System.out.println(0);
                        return;
                    }
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        System.out.println(1);
    }
}
