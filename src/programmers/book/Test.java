package programmers.book;

import java.util.*;

public class Test {
    public static int solution(int[][] problems) {
        // 브루트 포스 + Set으로 접근
        // caseCount에 따라서 몇 개의 case가 생성될지가 달라짐
        // 2라면 1, 4 / 2, 3 / 3, 2 / 4, 1 이렇게 쪼개진다는건데
        // 여기서 겹치는거 빼면 1, 4 / 2, 3 이렇게 조합해서 리스트에 넣고
        // 2개
        // 이걸로 다시 만들 수 있는 경우의 수 구하면
        // 0, 1, 4, 5
        // 0 ,2, 3, 5
        // 이걸로 모든 케이스 커버
        // 이중 for문으로 다 더한 다음 Set에 넣기

        // 4라면 1, 3 / 2, 2 / 3, 1 에서
        // 중복 빼면 1, 3 / 2, 2
        // 2개

        // caseCount가 1이라면
        // 5일때, 리스트에 0개
        // 모든 경우의 수 0 5

        // caseCount가 3이라면
        // 5일때, 3 1 1 / 2 2 1
        // 10일때, 8 1 1 / 7 2 1 / 6 3 1 / 6 2 2 / 5 4 1 / 5 3 2
        // 이렇게 되면 수학인데??

//        ArrayList[] problemSplits = new ArrayList[];

        for (int[] problem : problems) {
            int score = problem[0];
            int caseCount = problem[1];

            int[][] parts = new int[problems.length][caseCount];

        }
        return 0;
    }

    public static void main(String[] args) {
        solution(new int[][]{{6, 2}, {4, 2}});
        solution(new int[][]{{10, 1}, {3, 1}, {6, 3}});
    }
}
