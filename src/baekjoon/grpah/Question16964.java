package baekjoon.grpah;

import java.io.*;
import java.util.*;

public class Question16964 {
    static int N;
    static List<Integer>[] graph;
    static int[] order;
    static int[] position;
    static boolean[] visited;

    static int index = 0;
    static boolean isValid = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        order = new int[N];
        position = new int[N + 1];
        visited = new boolean[N + 1];

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

        dfs(1);

        System.out.println(isValid ? "1" : "0");

        br.close();
    }

    private static void dfs(int current) {
        if (!isValid) {
            return;
        }

        if (order[index] != current) {
            isValid = false;
            return;
        }

        index++;
        visited[current] = true;

        for (int next : graph[current]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}

