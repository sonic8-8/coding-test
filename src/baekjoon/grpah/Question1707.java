package baekjoon.grpah;

import java.io.*;
import java.util.*;

public class Question1707 {
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
                    dfs(i, 1);
                }
            }

            sb.append(isBipartite ? "YES" : "NO").append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void dfs(int current, int c) {
        color[current] = c;

        for (int next : graph[current]) {
            if (color[next] == c) {
                isBipartite = false;
                return;
            }

            if (color[next] == 0) {
                int nextColor = c * -1;
                dfs(next, nextColor);

                if (!isBipartite) {
                    return;
                }
            }
        }
    }
}
