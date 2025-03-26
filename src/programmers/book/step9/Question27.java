package programmers.book.step9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question27 {
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
//그림부터가 트리
        //이익 10%를 추천인에게 주고 90%는 갖는다
        //10% 계산시 원단위는 빼고 계산

        //enroll, feferral
        //seller, amount

        //전위, 중위, 후위의 문제가 아니라 그냥 트리 형태임을 확인하고 계산을 직접 해봐야하는듯?
        //문제1: 트리를 만들어야함
        //-> referral을 반복문으로 돌면서 대응하는 enroll을 추가하면 됨
        //-> enroll을 추가할 때 몇명이 될지 모르니까 ArrayList로 구현하면 될듯

        //문제2: 돈 계산해야됨
        //-> HashMap<판매자 String, 판매수 Integer> 만들고
        //-> 만들어진 트리에 HashMap을 돌면서 돈 계산하면 될듯?

        //재귀를 구현해야되는데 그럼 index를 매개변수로 넣어야하나..?
        //뭔가 너무 복잡하게 만든듯?

        HashMap<String, String> parent = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }

        //sellerMap을 따로 만들기보단 정산금을 저장할 totalMap을 만들자
        //sellerMap 대신 for문과 while문으로 처리하기

        HashMap<String, Integer> total = new HashMap<>();

        //seller 배열과 amount 배열로 처리
        for (int i = 0; i < seller.length; i++) {
            String current = seller[i];
            int money = amount[i] * 100;

            while (!current.equals("-") && money > 0) {
                int fee = money - (money / 10);
                total.put(current, total.getOrDefault(current, 0) + fee);
                current = parent.get(current);
                money /= 10;
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = total.getOrDefault(enroll[i], 0);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] answer = solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10});

        System.out.println("기댓값: [360, 958, 108, 0, 450, 18, 180, 1080]");
        System.out.println("실제값: " + Arrays.toString(answer));
    }
}
