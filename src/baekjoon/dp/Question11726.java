package baekjoon.dp;

import java.io.*;

public class Question11726 {
    final static int MAX = 1000 + 10;
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new int[MAX];

        // 2개의 case
        // map[][]을 처음에 만들었으나 dp[] 하나로 해결 가능한 것을 직접 나열해보고 확인

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        bw.write(String.valueOf(dp[N]));

        br.close();
        bw.close();
    }
}
