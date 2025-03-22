package programmers.book.step7;

import java.util.ArrayDeque;

public class Question15 {
    public static int solution(int n, int k) {
        //n: 원형으로 서있는 사람 수
        //k: 임의의 숫자
        //시작: 1번
        //k번째 사람 제거, 제거한 다음 사람을 기준으로 다시 k번째 사람 제거

        //문제1: 원형으로 서있는 것을 구현해야함
        //-> node 개념을 사용해야하나?
        //-> Queue를 사용해도 될 듯? 만약 k가 2라고 하면
        //-> 1 2 3 4 5
        //-> 2 3 4 5 1
        //-> 3 4 5 1 2
        //-> 4 5 1 2
        //-> 2번 뒤로 보내고 그 대상을 삭제하면 됨

        //문제2: 시작 index가 1임
        //-> index가 0부터 시작할텐데 어떻게 구현할 것임?
        //-> ArrayDeque를 사용하면 인덱스를 생각 안해도 되는거 아님?

        //문제3: 1을 기준으로 k번째 사람을 제거하면, 그 다음 사람이 다시 기준이 되야함
        //-> 기준을 잡는 로직이 필요함
        //-> ArrayDeque를 사용하면 기준을 잡는 로직을 따로 작성하지 않아도 되는듯?

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        System.out.println(deque);

        while (deque.size() > 1) {
            int count = 1;
            while (count < k) {
                deque.add(deque.poll());
                count++;
                System.out.println(deque);
            }
            deque.poll();
            System.out.println(deque);
        }
        return deque.peek();
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 2));

        System.out.println(3 + "나와야 됨");
    }
}
