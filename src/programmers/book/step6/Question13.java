package programmers.book.step6;

import java.util.Stack;

public class Question13 {
    public static void main(String[] args) {
        Question13 question = new Question13();
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(question.solution2(board, moves));
        System.out.println(question.solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        //moves에는 row의 index가 들어감
        //board[row][col]
        //moves[row]
        //moves의 row에 따라 board의 row 중에서 col을 순서대로 뒤져서 0이 아닌 것을 옮기면 됨

        //문제1: 인형을 뽑아서 통에 넣으면 "가까운것끼리 상쇄돼서 사라짐"
        //-> Stack 구조로 중복 체크

        //문제2: moves의 값대로 board의 인형을 가져올때 어떻게 위에 있는 것부터 뽑히게 할거임?
        //-> moves의 값은 board의 col와 같음
        //-> board의 col와 일치하는 것 중에서 row를 0부터 조회하며 값이 0이 아닌 첫번째 수를 가져오면 됨

        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        A:
        for (int i = 0; i < moves.length; i++) {
            int col = moves[i] - 1;

            for (int j = 0; j < board.length; j++) {
                if (board[j][col] != 0) {

                    if (!stack.isEmpty() && stack.peek() == board[j][col]) {
                        stack.pop();
                        answer += 2;

                        continue A;
                    }
                    stack.push(board[j][col]);
                    board[j][col] = 0;

                    continue A;
                }
            }
        }
        return answer;
    }

    public int solution2(int[][] board, int[] moves) {
        //문제3: 2차원 배열의 값을 처리할때 인덱스 등 계산할게 너무 많음
        //2차원 배열을 Stack에 담아서 처리하면 pop()으로 간단히 처리 가능
        //근데 예외처리를 좀 해줘야됨 pop() 같은거 할때

        Stack<Integer>[] lanes = new Stack[board.length];
        for (int i = 0; i < board.length; i++) {
            lanes[i] = new Stack<>();
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                int doll = board[i][j];
                if (doll > 0) {
                    lanes[i].push(doll);
                }
            }
        }

        Stack<Integer> bucket = new Stack<>();
        int answer = 0;

        for (int i = 0; i < moves.length; i++) {

            if (!lanes[moves[i] - 1].isEmpty()) {
                int doll = lanes[moves[i] - 1].pop();

                if (!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(doll);
                }

            }
        }

        return answer;
    }
}

