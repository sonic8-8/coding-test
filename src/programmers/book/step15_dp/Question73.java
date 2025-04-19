package programmers.book.step15_dp;

import java.util.Arrays;

public class Question73 {
    int solution(int[][] land) {
        int n = land.length;

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < 4; col++) {
                int maxPrev = 0;
                for (int prevCol = 0; prevCol < 4; prevCol++) {
                    if (col != prevCol) {
                        int prevRow = row - 1;
                        maxPrev = Math.max(maxPrev, land[prevRow][prevCol]);
                    }
                }
                land[row][col] += maxPrev;
            }
        }
        return Arrays.stream(land[n - 1]).max().getAsInt();
    }

    public int solution2(int[][] land) {
        int size = land.length;
        for (int i = 1; i < size; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }
        return Math.max(land[size - 1][0], Math.max(land[size - 1][1], Math.max(land[size - 1][2], land[size - 1][3])));
    }
}
