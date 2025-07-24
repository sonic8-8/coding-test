package baekjoon.bfs;

import java.io.*;
import java.util.*;

/**
 * 아이디어: 이동할 수 있는 경로를
 * 동시에 탐색하며 (BFS)
 * 1. 방문 여부와 (visited 배열)
 * 2. 도달 시간을 이용해 (time 배열)
 * 가장 빠른 시간 (최단 거리)를 구한다.
 */

/**
 * 문제: 1697번
 * 난이도: 실버 1
 * 메모리: 20460 KB
 * 시간: 152 ms
 */
public class Question1697 {
    static int N, K;

    // 배열의 최대 크기를 설정합니다.
    // 문제 조건에서 0 ~ 100,000까지 이동할 수 있으므로
    // 배열의 크기는 +1을 더해서 100,001로 생성합니다.
    static final int MAX = 100000 + 1;

    // 시간 기록용 배열을 입력합니다.
    // BFS는 물감이 퍼지듯 모든 경로를 한 번에 확인하기 때문에
    // 먼저 도달한 경로가 최단 시간이 되도록
    // time[next] = time[currnet] + 1;
    // 같은 형식으로 활용합니다.
    static int[] time;

    // 이미 방문한 위치를 다시 탐색하지 않도록 체크합니다.
    // visited를 생략하고 time 배열 하나만으로도
    // visited의 역할까지 수행할 수 있지만,
    // 가독성을 위해 배열을 둘로 나눴습니다.
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = new int[MAX];
        visited = new boolean[MAX];

        bfs();

        bw.write(String.valueOf(time[K]));

        br.close();
        bw.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        time[N] = 0;
        visited[N] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 가지치기로 시간을 단축합니다.
            if (current == K) {
                return;
            }

            // 현재 위치에서 이동할 수 있는 세 가지 경우를 순회합니다.
            for (int next : new int[] {current - 1, current + 1, current * 2}) {
                // 범위를 체크합니다.
                if (0 <= next && next < MAX && !visited[next]) {
                    queue.add(next);
                    time[next] = time[current] + 1;
                    visited[next] = true;
                }
            }
        }
    }
}

