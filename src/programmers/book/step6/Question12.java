package programmers.book.step6;

import java.util.Stack;

public class Question12 {
    public int[] solution(int[] prices) {
        //주식가격을 배열로 받는데 숫자 비교가 필요함
        //문제1: "가격이 떨어지지 않은" "기간"을 return한다
        //-> 직전 요소와 현재 요소 크기 비교해야함
        //-> 직전 값을 stack에 넣기
        //-> 현재 값과 직전 값을 비교해서 가격이 떨어졌다면 loss를 증가

        //-> 전체 기간 - 값이 떨어진 기간
        //-> total - loss

        //이중 for문 불가능

        //문제를 잘못읽었음
        //answer가 int 배열임
        //문제3: 각 prices의 요소 하나하나마다 끝까지 가격이 떨어졌는지를 확인해야됨
        //-> 미리 int[] answer를 만들어두고 "가격이 떨어진 시점"에 -1씩 해주면 됨

        //Q: 3 2 3 4 3 2
        //전: 5 4 3 2 1 0
        //기: 0 1 0 0 1 1
        //후: 2 2 1 0 0 0 (X)

        //-> prices의 각 요소와 가격이 같거나 큰 경우만 숫자를 증가시키기
        //Q: 3 2 3 4 3 2
        //후: 3 4 2 0 0 0 (O)
        //근데 이건 이중 for문으로 구현해야됨

        Stack<Integer> stack = new Stack<>();

        int total = prices.length;
        int[] answer = new int[total];

        for (int i = 0; i < total; i++) {
            for (int j = i + 1; j < total; j++) {
                int standard = prices[i];
                if (standard <= prices[j]) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }

    public int[] solution2(int[] prices) {
        //이중 for문을 O(N)으로 최적화하는 방법
        //for + while + Stack 구조를 사용하면 특정 패턴에서 시간복잡도를 최적화할 수 있음
        //구체적으로는 stack에 배열의 인덱스를 넣고 pop() 하면서
        //"조건에 맞는 것만 반복 처리해서" 불필요한 중복을 줄일 수 있음

        Stack<Integer> stack = new Stack<>();
        int total = prices.length;
        int[] answer = new int[total];

        for (int index = 0; index < prices.length; index++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[index]) {
                int before = stack.pop();
                answer[before] = index - before;
            }
            stack.push(index);
        }

        while (!stack.isEmpty()) {
            int target = stack.pop();
            answer[target] = total - target - 1;
        }

        return answer;
    }
}

