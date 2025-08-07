package baekjoon.dp;

import java.io.*;
import java.util.*;

/**
 * 아이디어:
 * 다음 M개의 줄에는 네 개의 정수 x1, y1, x2, y2 가 주어지며,
 * (x1, y1)부터 (x2, y2)의 합을 구해 출력해야 한다.
 * -> 브루트 포스, DP 풀이 가능
 * -> 시간 단축을 위해 DP로 풀이합니다.
 *
 * board 배열과 dp 배열을 사용한다.
 * board 배열을 초기화하면서 dp 배열도 함께 초기화합니다.
 * -> 이전까지 더한 누적합 + 이번에 더할 값
 * -> (dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]) + board[i][j]
 * -> 겹치는 영역은 한 번 빼줍니다. (dp[i - 1][j - 1])
 *
 * x1, y1, x2, y2를 입력받아 구간합을 구합니다.
 * -> 전체 누적합 - 구간합 대상이 아닌 영역의 누적합
 * -> dp[x2][y2] - (dp[x1 - 1][y2] + dp[x2][y1 - 1] - dp[x1 - 1][y1 - 1])
 * -> 겹치는 영역은 한 번 빼줍니다. (dp[x1 - 1][[y1 - 1]
 */

/**
 * 메모리: 122540 KB
 * 시간: 740 ms
 * 난이도: 실버 1
 */
public class Main_11660_구간합구하기5 {
    static int N, M;
    static int[][] board;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = board[i][j] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}

