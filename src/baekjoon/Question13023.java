package baekjoon;

import java.io.*;
import java.util.*;

public class Question13023 {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean isExist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(1, i);
            visited[i] = false;

            if (isExist) {
                break;
            }
        }

        bw.write(isExist ? "1" : "0");

        br.close();
        bw.close();
    }

    private static void dfs(int depth, int current) {
        if (depth == 5) {
            isExist = true;
            return;
        }

        for (int next : graph[current]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(depth + 1, next);
                visited[next] = false;
            }
        }
    }
}
