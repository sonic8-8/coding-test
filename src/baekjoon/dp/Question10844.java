package baekjoon.dp;

import java.util.*;
import java.io.*;

public class Question10844 {
    static final int MAX = 100 + 10;
    static final int MOD = 1000000000;
    static int N;
    static long[][] dp;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new long[MAX][9 + 1];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j <= 8) {
                    dp[i][j] += dp[i - 1][j + 1];
                }
                if (j >= 1) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                dp[i][j] %= MOD;
            }
        }

        for (int i = 0; i <= 9; i++) {
            answer += dp[N][i];
        }

        answer = answer % MOD;
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}

// 12 23 34 45 56 67 78 89
// 98 87 76 65 54 43 32 21 10
// dp[2][0]:    10
// dp[2][1]:    21
// dp[2][2]: 12 32
// dp[2][3]: 23 43
// dp[2][8]: 78 98
// dp[2][9]: 89

// dp[3][0]: 210
// dp[3][1]: 101 121 321
// dp[3][2]: 212 232 432
// dp[3][3]: 123 323 343 543
// dp[3][4]: 234 434 454 654
// dp[3][8]: 678 878 898
// dp[3][9]: 789 989
