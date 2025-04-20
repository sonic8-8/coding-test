package baekjoon;

import java.io.*;
import java.util.*;

public class Question2606 {
    static int computerCount;
    static int pairCount;
    static boolean[] visited;
    static boolean[][] graph;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        computerCount = Integer.parseInt(br.readLine());
        pairCount = Integer.parseInt(br.readLine());

        graph = new boolean[computerCount + 1][computerCount + 1];
        visited = new boolean[computerCount + 1];

        int x, y;
        for (int i = 0; i < pairCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(1);

        bw.write(String.valueOf(answer - 1));

        br.close();
        bw.close();
    }

    private static void dfs(int current) {
        visited[current] = true;
        answer++;

        for (int i = 1; i <= computerCount; i++) {
            if (!visited[i] && graph[current][i]) {
                dfs(i);
            }
        }
    }
}
