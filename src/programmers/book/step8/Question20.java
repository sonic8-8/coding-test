package programmers.book.step8;

import java.util.HashMap;

public class Question20 {
    public static int solution(String[] want, int[] number, String[] discount) {
        //일정한 금액 지불 -> 10일 회원자격
        //14일간 판매한다면, 10일 회원자격이 유지되는 동안 물건을 모두 구매해야됨
        //물건을 하루에 1개씩 구매가능

        //문제1: 원하는 물건 목록을 10일동안 매일 연속으로 살 수 있어야함
        //-> want 요소에 해당하지 않는 discount 요소가 있다면 그 아이템 요소 판매 날짜 이후에 회원 등록
        //-> 기준 요소 이후 10일간 판매 물품이 want 목록과 일치하는 확인

        //문제2: 회원등록시 원하는 제품을 모두 할인 받을 수 있는 등록 날짜를 return

        //문제3:
        //-> for문 한 번 돌면서 미리 10일 후 물건을 몇 개 얻을 수 있는지를 HashMap에 넣어놓으면 될듯?

        //HashMap 2개를 비교하기만 하면 되는데 HashMap에 HashMap을 넣어버리려고 시도함
        //1일차: 얻을 수 있는 HashMap
        //2일차: 얻을 수 있는 HashMap
        //이런식으로 하려고 함
        //근데 이러면 나중에 비교할때 굳이 1일차인지 2일차인지 확인하면서 for문을 돌아야하는데 비효율적임
        //그냥 HashMap끼리 비교하면 됨

        //HashMap끼리 equals()로 모든 key:value가 같은지 확인할 수 있음!!
        //이걸 이용하면 편할듯
        //비교하려면 key가 모두 같아야하니까 discount를 모두 넣진 말아야함

        //문제4: 요소를 제거하고 다시 넣으려니까 복잡함
        //-> 애초에 제거하는 로직 자체를 없애버리자
        //-> 매번 새로 만들어버리는게 더 간단함

        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        System.out.println(wantMap);

        HashMap<String, Integer> expectedMap = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < discount.length - 9; i++) {

            for (int j = i; j < i + 10; j++) {
                if (wantMap.containsKey(discount[j])) {
                    expectedMap.put(discount[j], expectedMap.getOrDefault(discount[j], 0) + 1);
                }
            }

            if (wantMap.equals(expectedMap)) {
                answer++;
            }

            System.out.println(expectedMap);
            expectedMap.clear();
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println("기댓값: 3");
        System.out.println("실제값: " + solution(
                new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));

    }
}
