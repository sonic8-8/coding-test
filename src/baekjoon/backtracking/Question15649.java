package baekjoon.backtracking;

import java.io.*;
import java.util.*;

/**
 * 아이디어:
 * 모든 경우의 수를 구해야 한다. (브루트 포스)
 * 중복되는 수열이 출력되면 안된다. (백트래킹으로 전환)
 *
 * 중복 방지와 백트래킹 구현을 위해
 * visited 배열을 사용한다.
 *
 * depth가 M일 경우 종료한다. (가지치기)
 *
 * 하나의 수열을 만들었다면 다음 탐색을 위해
 * visited 배열을 복원한다. (상태복원)
 *
 * 현재 수열은 numbers 배열에 저장한다.
 *
 * 결과 출력은 StringBuilder로 한 번에 처리한다.
 */

/**
 * 메모리: 23296 KB
 * 시간: 228 ms
 * 난이도: 실버 3
 */
public class Question15649 {
    static int N, M;
    static boolean[] visited;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 백트래킹 시
        // 1부터 N까지 자연수를 직관적으로 사용하기 위해
        // 1-based 인덱스를 사용합니다.
        visited = new boolean[N + 1];

        // 현재 탐색중인 수열은 M 크기로 만듭니다.
        numbers = new int[M];

        // 아직 재귀함수가 호출 된 적 없기 때문에
        // depth는 0부터 시작합니다.
        // 호출될 때 마다 depth는 1씩 증가합니다.
        backtrack(0);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backtrack(int depth) {
        // 현재 depth가 M일 경우
        // 현재 수열은 마지막 인덱스인 M-1까지
        // 모두 채워진 상태입니다.
        if (depth == M) {
            for (int number : numbers) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                // 중복 방문을 방지합니다.
                visited[i] = true;
                // 현재 수열에 값을 추가합니다.
                numbers[depth] = i;
                // 재귀함수 호출로 depth가 1만큼 증가합니다.
                backtrack(depth + 1);
                // 다음 경우의 수를 탐색하기 위해 상태를 복원합니다.
                visited[i] = false;
            }
        }
    }
}