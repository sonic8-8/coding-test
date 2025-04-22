package baekjoon.dfs;

//트리, 각 노드의 부모 노드를 구한다 (= 탐색), 노드 -> DFS
//노드 개수 N: 100,000 -> ArrayList

import java.util.*;
import java.io.*;

public class Question11725 {
    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        answer = new int[N + 1];

        for (int i = 0 ; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void dfs(int current) {
        visited[current] = true;

        for (int i = 0; i < graph[current].size(); i++) {
            int next = graph[current].get(i);
            if (!visited[next]) {
                answer[next] = current;
                dfs(next);
            }
        }
    }
}
