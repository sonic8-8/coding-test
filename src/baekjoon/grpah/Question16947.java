package baekjoon.grpah;

import java.io.*;
import java.util.*;

public class Question16947 {
    static int N;
    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean[] isCycle;
    static int[] distance;
    static int[] parentTracker; // DFS 경로 추적용


    static int cycleStartNode = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        isCycle = new boolean[N + 1];
        distance = new int[N + 1];
        parentTracker = new int[N + 1]; // 부모 노드를 저장할 배열

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            graph[p].add(q);
            graph[q].add(p);
        }

        markCycleNodesByDfs(1, -1);

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(distance[i]).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    // DFS를 통해 사이클을 찾아 isCycle 배열을 마킹하는 함수
    private static boolean markCycleNodesByDfs(int current, int parent) {
        visited[current] = true;
        parentTracker[current] = parent; // 현재 노드의 부모를 기록

        for (int next : graph[current]) {
            if (next == parent) continue; // 부모 노드로 돌아가는 경우는 건너뛰기

            if (visited[next]) { // 이미 방문한 노드를 만났고, 부모 노드가 아니라면 사이클 발견!
                cycleStartNode = next; // 사이클의 시작 노드를 next로 설정
                isCycle[current] = true; // 현재 노드는 사이클의 일부
                return true; // 사이클을 찾았으므로 true 반환
            }

            // 방문하지 않은 노드라면 DFS 계속 진행
            if (markCycleNodesByDfs(next, current)) {
                // 사이클을 찾았고, 현재 노드가 사이클의 시작 노드가 아니라면
                // 현재 노드도 사이클의 일부
                if (cycleStartNode != -1) { // 사이클 노드 마킹이 진행 중이라면
                    isCycle[current] = true;
                    // 만약 현재 노드가 사이클의 시작 노드라면 마킹을 끝낸다
                    if (current == cycleStartNode) {
                        cycleStartNode = -1; // 사이클 노드 마킹 종료
                    }
                }
                return true;
            }
        }
        return false; // 사이클을 찾지 못함
    }

    // 사이클 노드로부터 최소 거리 계산을 위해 BFS
    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        // 거리를 -1로 초기화
        Arrays.fill(distance, -1);

        for (int i = 1; i <= N; i++) {
            // 사이클 노드일 경우
            if (isCycle[i]) {
                // 거리는 0
                distance[i] = 0;
                queue.add(i);
            }
        }

        // 사이클 노드가 아닌 경우만 남음
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph[current]) {
                // 아직 거리를 측정하지 않은 노드일 경우
                if (distance[next] == -1) {
                    // 사이클 노드부터 시작해 1씩 거리를 더해가며 거리 측정
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
