package programmers.book.step15_dp;

public class Question72 {
    public int solution(int[][] triangle) {
        //이동하면서 값을 더하는데 최댓값이 되도록 해야됨
        //최적해를 찾는데 전체 범위를 고려해야됨 -> DP
        //백트래킹도 가능하긴 하지만 가지치기 할 조건이 없음. 사실상 브루트 포스랑 다를바가 없음
        //이진탐색? 정렬되는 조건이 X 불가능
        int n = triangle.length;
        int[][] dp = new int[n + 1][n + 1];

        dp[1][1] = triangle[0][0];

        dp[2][1] = dp[1][1] + triangle[1][0];
        dp[2][2] = dp[1][1] + triangle[1][1];

//         dp[3][1] = dp[2][1] + triangle[3][1];
//         dp[3][2] = Math.max(dp[2][1], dp[2][2]) + triangle[3][2];
//         dp[3][3] = dp[2][2] + triangle[3][3];

//         dp[4][1] = dp[3][1] + triangle[4][1];
//         dp[4][2] = Math.max(dp[3][1], dp[3][2]) + triangle[4][2];
//         dp[4][3] = Math.max(dp[3][2], dp[3][3]) + triangle[4][3];
//         dp[4][4] = dp[3][3] + triangle[4][4];

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (1 < j && j < i) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j] + triangle[i - 1][j - 1];
                }
            }
        }
        int maxSum = 0;
        for (int i = 2; i <= n; i++) {
            if (maxSum < Math.max(dp[n][i], dp[n][i - 1])) {
                maxSum = Math.max(dp[n][i], dp[n][i - 1]);
            }
        }
        return maxSum;
    }

    public int solution2(int[][] triangle) {
        //이동하면서 값을 더하는데 최댓값이 되도록 해야됨
        //최적해를 찾는데 전체 범위를 고려해야됨 -> DP -> 백트래킹도 가능하긴 할듯??
        //이진탐색으로도 될 것 같은데?
        int n = triangle.length;
        int[][] dp = new int[n][n];

        //거꾸로 아래에서 위로 올라가기
        //초기화
        for (int col = 0; col < n; col++) {
            dp[n - 1][col] = triangle[n - 1][col];
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[row][col] = Math.max(dp[row + 1][col], dp[row + 1][col + 1]) + triangle[row][col];
            }
        }
        return dp[0][0];
    }
}
