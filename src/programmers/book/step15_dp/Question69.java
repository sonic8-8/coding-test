package programmers.book.step15_dp;

public class Question69 {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 3, 3, 2}, {2, 1, 4, 1}, {1, 5, 2, 3}};
        System.out.println(solution(arr1));
        int[][] arr2 = {{1, 7, 13, 2, 6}, {2, -4, 2, 5, 4}, {5, 3, 5, -3, 1}};
        System.out.println(solution(arr2));
    }

    private static int solution(int[][] arr) {
        //row에 적어도 하나의 조약돌
        //조약돌 놓으면 상하좌우에 다른 조약돌 못놓음

        //최대 가중치의 합을 반환해야함
        //브루트 포스 -> 그리디 -> dp -> 백트래킹

        //초깃값은 다 -1임
        //조약돌을 놓으면 1로 변경
        //상하좌우는 0으로 변경

        //그리디로는 해결이 안됨
        //dp니까 조금 더 잘게 쪼개기
        //모든 row를 고려해야 최대치인데? 흠..

        //전체 범위를 고려하기 위해서 패턴(조합)을 이용해서 커버리지
        //위
        //가운데
        //아래
        //위 아래

        //패턴 기록용 배열
        int[][] dp = new int[4][arr[0].length];

        //초기화
        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        dp[2][0] = arr[2][0];
        dp[3][0] = arr[0][0] + arr[2][0];

        for (int i = 1; i < arr[0].length; i++) {
            dp[0][i] = arr[0][i] + Math.max(dp[1][i - 1], dp[2][i - 1]);
            dp[1][i] = arr[1][i] + Math.max(Math.max(dp[0][i - 1], dp[2][i - 1]), dp[3][i - 1]);
            dp[2][i] = arr[2][i] + Math.max(dp[0][i - 1], dp[1][i - 1]);
            dp[3][i] = arr[0][i] + arr[2][i] + dp[1][i - 1];
        }
        int last = arr[0].length - 1;
        return Math.max(Math.max(dp[0][last], dp[1][last]), Math.max(dp[2][last], dp[3][last]));
    }
}
