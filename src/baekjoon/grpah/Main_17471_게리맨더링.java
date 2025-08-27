package baekjoon.grpah;

import java.io.*;
import java.util.*;

/**
 * 아이디어:
 * 부분 집합 + BFS
 * 위 2가지를 이용해 풀었습니다.
 * <p>
 * 1. "부분 집합"으로 그룹을 2개로 나누는 모든 경우의 수 구하기
 * 2. "BFS를 이용해" 한 그룹의 모든 노드가 서로 연결됐는지 확인하기
 * <p>
 * 이 방법 (완전 탐색 풀이) 말고도
 * 규칙이나 패턴을 이용해 해결할 수 있는지 고민해봤으나
 * 오히려 구현하기가 더 복잡해지는 것 같습니다
 * 부분 집합 풀이를 추천합니다
 */

/**
 * 메모리: 15,364 KB
 * 시간: 132 ms
 * 난이도: 골드3
 */
public class Main_17471_게리맨더링 {
    static int N;
    static int[] population;
    static List<Integer>[] graph;
    static List<Integer> groupA;
    static List<Integer> groupB;
    static boolean[] visited;

    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        population = new int[N + 1];
        graph = new ArrayList[N + 1];
        groupA = new ArrayList<>();
        groupB = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                int node = Integer.parseInt(st.nextToken());
                graph[i].add(node);
            }
        }

        min = Integer.MAX_VALUE;
        subset(1);

        // 문제 요구 사항에 따라 두 선거구로 나눌 없는 경우에는 -1을 출력
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }

        bw.write(String.valueOf(min));

        br.close();
        bw.close();
    }

    // 부분 집합을 이용해 그룹을 2개로 만드는 모든 경우를 생성
    private static void subset(int index) {
        if (index == N + 1) {
            if (!groupA.isEmpty() && !groupB.isEmpty()) {
                if (isConnected(groupA) && isConnected(groupB)) {
                    int diff = Math.abs(calculateSum(groupA) - calculateSum(groupB));
                    min = Math.min(min, diff);
                }
            }
            return;
        }

        // 그룹 A에 포함
        groupA.add(index);
        subset(index + 1);
        groupA.remove(groupA.size() - 1);

        // 그룹 B에 포함
        groupB.add(index);
        subset(index + 1);
        groupB.remove(groupB.size() - 1);
    }

    private static int calculateSum(List<Integer> group) {
        int sum = 0;
        for (int index : group) {
            sum += population[index];
        }
        return sum;
    }

    // BFS를 사용해 그룹 내 모든 노드가 연결되었는지 확인
    private static boolean isConnected(List<Integer> group) {
        visited = new boolean[N + 1];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(group.get(0));
        visited[group.get(0)] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (!visited[next] && group.contains(next)) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count == group.size();
    }
}