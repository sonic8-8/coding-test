package programmers.book.step15_dp;

public class Question71 {
    public int solution(int n) {
        //타일: 가로2 세로1
        //바닥: 가로n 세로2
        //가득 채우기

        // 가로 길이를 기준으로 경우의 수
        //패턴
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        // dp[3] = 3;
        // dp[4] = 5;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i -2] + dp[i - 1]) % 1000000007;
        }
        return dp[n];
    }
}
