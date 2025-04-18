package programmers.book.step12;

public class Question46 {
    int size;
    boolean[] cols;
    boolean[] diagUpRight; // x + y 가 모두 같음
    boolean[] diagDownRight; // x - y 가 일치함 음수 보정하려면 size 더해야됨
    int maxCount;

    public int solution(int n) {
        size = n;
        cols = new boolean[n];
        diagUpRight = new boolean[2 * n];
        diagDownRight = new boolean[2 * n];
        maxCount = 0;

        placeQueen(0);
        return maxCount;
    }

    public void placeQueen(int row) {
        if (row == size) {
            maxCount++;
            return;
        }

        for (int col = 0; col < size; col++) {
            int upRightCond = row + col;
            int downRightCond = row - col + size;

            //퀸이 서로 공격하는 조건이 아니도록 가지치기
            if (cols[col] || diagDownRight[downRightCond] || diagUpRight[upRightCond]) {
                continue;
            }
            cols[col] = diagDownRight[downRightCond] = diagUpRight[upRightCond] = true;
            placeQueen(row + 1);
            cols[col] = diagDownRight[downRightCond] = diagUpRight[upRightCond] = false;
        }
    }
}
