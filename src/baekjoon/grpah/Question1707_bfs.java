package baekjoon.grpah;

import java.io.*;
import java.util.*;

public class Question1707_bfs {
    static int K;
    static int V, E;
    static List<Integer>[] graph;
    static int[] color;
    static StringBuilder sb = new StringBuilder();
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            color = new int[V + 1];
            graph = new ArrayList[V + 1];

            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
                graph[y].add(x);
            }

            isBipartite = true;

            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    bfs(i);
                }
            }

            sb.append(isBipartite ? "YES" : "NO").append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);

        int startColor = 1;
        color[node] = startColor;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (color[next] == 0) {
                    int nextColor = color[current] * -1;
                    color[next] = nextColor;
                    queue.add(next);
                    continue;
                }
                if (color[next] == color[current]) {
                    isBipartite = false;
                    return;
                }
            }
        }
    }
}