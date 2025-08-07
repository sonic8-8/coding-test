package baekjoon.dp;

import java.io.*;
import java.util.*;

/**
 * 아이디어:
 * M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
 * i번째 수부터 j번째 수까지 합을 출력하라.
 * -> 브루트 포스, DP 풀이 가능
 * -> 시간 단축을 위해 DP로 풀이합니다.
 *
 * array 배열과 dp 배열을 사용한다.
 * array 배열을 초기화하면서 dp 배열도 함께 초기화합니다.
 * -> 이전까지 더한 누적합 + 이번에 더할 값
 * -> dp[i - 1] + array[i]
 *
 * i를 left, j를 right라고 할 때,
 * left, right를 입력받아 구간합을 구합니다.
 * -> 전체 누적합 - 구간합 대상이 아닌 영역의 누적합
 * -> dp[right] - dp[left - 1]
 */

/**
 * 메모리: 53176 KB
 * 시간: 544 ms
 * 난이도: 실버 3
 */
public class Main_11659_구간합구하기4 {
    static int N, M;
    static int[] array;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N + 1];
        dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            dp[i] = array[i] + dp[i - 1];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            int sum = dp[right] - dp[left - 1];
            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}


