package programmers.book.step12_backtracking;

import java.util.ArrayList;

public class Question43 {

    private ArrayList<ArrayList<Integer>> result;
    private int n;

    private void backtrack(int sum, ArrayList<Integer> selectedNums, int start) {
        //정답 조건
        if (sum == 10) {
            result.add(selectedNums);
            return;
        }

        for (int i = start; i < n; i++) {
            if (sum <= 10) {
                ArrayList<Integer> list = new ArrayList<>(selectedNums);
                list.add(i);
                backtrack(sum + i, list, i + 1);
            }
        }
    }

    private ArrayList<ArrayList<Integer>> solution(int N) {
        result = new ArrayList<>();
        n = N;

        backtrack(0, new ArrayList<>(), 1);
        return result;
    }
}
