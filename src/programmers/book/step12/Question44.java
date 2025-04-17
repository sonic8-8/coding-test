package programmers.book.step12;

import java.util.Arrays;

public class Question44 {
    public int[][] solution(int[][] board) {
        solve(board);
        return board;
    }

    // 백트래킹 기반 스도쿠 풀이
    private boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) { // 빈칸이면 숫자 넣기 시도
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) return true; // 다음 빈칸 재귀
                            board[row][col] = 0; // 백트래킹
                        }
                    }
                    return false; // 어떤 숫자도 안됨 → 백트래킹
                }
            }
        }
        return true; // 모든 칸 채움
    }

    // 현재 위치에 num이 들어갈 수 있는지 확인
    private boolean isValid(int[][] board, int row, int col, int num) {
        // 행, 열 체크
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) return false;
        }

        // 3x3 박스 체크
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;

        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }
}
