package baekjoon.grpah;

import java.io.*;
import java.util.*;

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

        // 하나의 그래프를 2개의 집합으로 나누어야한다
        // 각 집합의 원소 숫자 차이가 최소여야한다
        // 전체 원소의 개수를 절반으로 나눈다
        // 절반 절반으로 집합을 만들 수 있는지 확인한다

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

        if (min == Integer.MAX_VALUE) {
            min = -1;
        }

        bw.write(String.valueOf(min));

        br.close();
        bw.close();
    }

    private static void subset(int index) {
        if (index == N + 1) {
            if (!groupA.isEmpty() && !groupB.isEmpty()) {
                if (isAConnectedByBfs() && isBConnectedByBfs()) {
                    int diff = Math.abs(calculateSum(groupA) - calculateSum(groupB));
                    min = Math.min(min, diff);
                }
            }
            return;
        }

        // 그룹 A에 포함
        groupA.add(index);
        subset(index + 1);
        groupA.remove(groupA.size() -1);

        // 그룹 B에 포함
        groupB.add(index);
        subset(index + 1);
        groupB.remove(groupB.size() -1);
    }

    private static int calculateSum(List<Integer> group) {
        int sum = 0;
        for (int index : group) {
            sum += population[index];
        }
        return sum;
    }

    private static boolean isAConnectedByBfs() {
        visited = new boolean[N + 1];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(groupA.get(0));
        visited[groupA.get(0)] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (!visited[next] && groupA.contains(next)) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count == groupA.size();
    }

    private static boolean isBConnectedByBfs() {
        visited = new boolean[N + 1];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(groupB.get(0));
        visited[groupB.get(0)] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (!visited[next] && groupB.contains(next)) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count == groupB.size();
    }
}