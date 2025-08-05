package baekjoon.bfs;

import java.io.*;
import java.util.*;

/**
 * 아이디어:
 * 연결 관계가 주어졌는데 1번이 동시에 여러 개와 연결될 수 있다.
 * 예를 들어, 1번 - 2번, 3번
 * -> 기본형 이중 배열을 사용할 수 없다.
 * -> List<Integer>[]를 이용하기
 *
 * 상근의 친구와 친구의 친구까지만 초대한다.
 * -> DFS나 BFS로 그래프 탐색을 하자
 * -> 상근의 depth가 0이라면
 * -> depth 1과 2만 초대하도록 구현하면 된다.
 *
 * List<Integer[]에 넣을 때 양방향으로 넣는다
 * -> visited 배열을 사용해서 중복 방문을 방지한다.
 * -> visited를 사용하지 않을 경우
 * -> 예를 들어, a와 b가 친구라고 한다면,
 * -> a -> b -> a -> b 가 계속 반복된다.
 */

/**
 * 메모리: 18916 KB
 * 시간: 176 ms
 * 난이도: 실버 2
 */
public class Main_5567_결혼식 {
    static int N, M;
    static List<Integer>[] friends;
    static int[] depths; // BFS 구현을 위해 depths 배열을 사용했습니다.
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        friends = new ArrayList[N + 1];
        depths = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 양방향 친구 관계 추가
            friends[x].add(y);
            friends[y].add(x);
        }

        bfs();

        int inviteCount = 0;
        for (int i = 1; i <= N; i++) {
            if (1 <= depths[i] && depths[i] <= 2) {
                inviteCount++;
            }
        }

        bw.write(String.valueOf(inviteCount));

        br.close();
        bw.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(1);
        visited[1] = true;
        depths[1] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : friends[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    depths[next] = depths[current] + 1;
                    queue.add(next);
                }
            }
        }
    }
}

