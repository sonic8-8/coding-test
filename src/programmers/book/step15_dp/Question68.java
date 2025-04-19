package programmers.book.step15_dp;

import java.util.Arrays;

public class Question68 {
    public static void main(String[] args) {
        System.out.println(lis(new int[]{1, 4, 2, 3, 1, 5, 7, 3}));
        System.out.println(lis(new int[]{3, 2, 1}));
    }

    private static int lis(int[] nums) {
        //dp 배열
        int[] dp = new int[nums.length];

        //초기화
        Arrays.fill(dp, 1);

        //반복문
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
