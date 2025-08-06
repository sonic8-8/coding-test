package baekjoon.bfs;

import java.io.*;
import java.util.*;

/**
 * 아이디어:
 * 1. 한 번의 해킹으로 여러 개의 컴퓨터를 해킹한다.
 * A가 B를 신뢰하면, B를 해킹할 때 A도 해킹할 수 있다.
 * -> a. "신뢰 방향"과 "해킹 가능 방향"은 서로 반대다.
 * -> 즉, 관심사는 신뢰가 아니라 해킹이다.
 * -> computers 배열을 해킹 가능 방향으로 초기화하기
 *
 * 2. 한 번에 가장 많은 컴픂터를 해킹하는 컴퓨터 번호를 출력한다.
 * -> a. bfs로 연결된 해킹 가능 컴퓨터를 넓게 탐색하기
 * -> b. hacked 배열로 특정 컴퓨터를 해킹했을때, 연결된 해킹 가능한 컴퓨터 개수를 각 컴퓨터 별로 기록하기
 * -> c. 최대 해킹 가능 컴퓨터 개수는 max 변수로 확인합니다.
 *
 * 3. 최대 해킹 가능 컴퓨터가 여러 대라면 오름차순으로 출력한다.
 * -> a. for문으로 1부터 N번 컴퓨터까지 순서대로 살핀다.
 */

/**
 * 메모리: 307556 KB
 * 시간: 10752 ms
 * 난이도: 실버 1
 */
public class Main_1325_효율적인해킹 {
    static int N, M;
    static List<Integer>[] computers;
    static boolean[] visited;
    static int[] hacked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        computers = new ArrayList[N + 1]; // 해킹 가능한 컴퓨터 연결 관계
        hacked = new int[N + 1]; // 해킹 가능 컴퓨터 개수

        for (int i = 1; i <= N; i++) {
            computers[i] = new ArrayList<>();
        }

        // 1. 신뢰 방향이 아닌, 해킹 가능 방향으로 초기화 합니다.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computers[b].add(a); // a. 해킹 가능 방향으로 초기화
        }

        // 2. bfs로 특정 컴퓨터를 해킹 했을 때, 연결된 해킹 가능한 컴퓨터 개수를 탐색합니다.
        int max = 0;
        for (int i = 1; i <= N; i++) {
            int hackedCount = calculateHackedCountByBfs(i); // a. bfs로 넓게 탐색합니다.
            hacked[i] = hackedCount; // b. 해킹 가능한 컴퓨터 개수를 기록합니다.
            max = Math.max(max, hackedCount); // c. 최대 해킹 가능 컴퓨터 개수를 계산합니다.
        }

        // 3. 오름차순으로 출력하기 위해 1번 컴퓨터부터 N번 순으로 확인합니다.
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) { // a. 1번부터 순서대로 살핍니다.
            if (hacked[i] == max) {
                sb.append(i).append(" ");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static int calculateHackedCountByBfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited = new boolean[N + 1];
        int hackedCount = 0;

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            hackedCount++;

            for (int next : computers[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return hackedCount;
    }
}

