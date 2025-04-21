package baekjoon.dfs;

//무방향 그래프, 깊이 우선 탐색 -> DFS
//내림차순 방문
//N 100,000 -> ArrayList로 graph
//방문 순서를 출력 -> 연결된 요소 유형

import java.util.*;
import java.io.*;

public class Question24480 {
    static int N, M, R;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int[] answer;
    static int order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        //초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        answer = new int[N + 1];
        order = 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Comparator.reverseOrder());
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void dfs(int current) {
        visited[current] = true;
        answer[current] = order;
        order++;

        for (int i = 0; i < graph[current].size(); i++) {
            int next = graph[current].get(i);
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
