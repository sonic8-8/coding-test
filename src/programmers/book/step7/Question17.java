package programmers.book.step7;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Question17 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        //문제1: 카드를 "순서대로" 한 장씩 사용한다

        //문제2: 한 번 사용한 카드는 다시 사용할 수 없다
        //-> 자료구조에서 삭제

        //문제3: 카드를 사용하지 않고 다음 카드로 넘어갈 수 없다, 단어 순서를 바꿀 수 없다
        //-> 순서가 정해져있음 = 큐를 사용하면 될듯

        Queue<String> cards1Queue = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> cards2Queue = new ArrayDeque<>(Arrays.asList(cards2));
        Queue<String> goalQueue = new ArrayDeque<>(Arrays.asList(goal));

        for (int i = 0; i < goal.length; i++) {
            String target = goalQueue.poll();
            if (!cards1Queue.isEmpty() && cards1Queue.peek().equals(target)) {
                cards1Queue.poll();
            } else if (!cards2Queue.isEmpty() && cards2Queue.peek().equals(target)) {
                cards2Queue.poll();
            } else {
                return "No";
            }
        }
        return "Yes";

    }

    public static void main(String[] args) {
        Question17 question = new Question17();
        String answer = question.solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"});
        String answer2 = question.solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"});
        System.out.println("answer:" + answer);
        System.out.println("answer2:" + answer2);
    }
}
