package baekjoon.dp;

import java.io.*;
import java.util.*;

public class Question17404 {
    public static final int INF = 1000000000;
    static int N;
    static int[][] rgb;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        rgb = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = INF;

        for (int firstColor = 0; firstColor < 3; firstColor++) {
            dp = new int[N + 1][3];

            for (int color = 0; color < 3; color++) {
                if (firstColor == color) {
                    dp[1][color] = rgb[1][color];
                    continue;
                }
                dp[1][color] = INF;
            }

            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];
            }

            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (firstColor == lastColor) {
                    continue;
                }
                answer = Math.min(answer, dp[N][lastColor]);
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
