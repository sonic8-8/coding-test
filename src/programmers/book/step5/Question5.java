package programmers.book.step5;

public class Question5 {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length; // 어차피 c1이랑 같음
        int c2 = arr2[0].length;

        int[][] answer = new int[r1][c2];

        for (int m = 0; m < r1; m++) {
            for (int n = 0; n < c2; n++) {
                for (int k = 0; k < r2; k++) {
                    answer[m][n] += arr1[m][k] * arr2[k][n];
                }
            }
        }

        return answer;

    }
}
