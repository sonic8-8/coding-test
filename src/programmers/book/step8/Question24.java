package programmers.book.step8;

import java.util.*;

public class Question24 {

    private static HashMap<Integer, HashMap<String, Integer>> courseMap;

    public static String[] solution(String[] orders, int[] course) {
        //함께 주문한 요리 2가지 이상 -> 코스요리 후보
        //최소 2명이상에게 주문된 조합만 코스요리 후보

        //문제1: 함께 주문한 요리 조합을 구해야함
        //-> course[i]에 따라 개수가 달라짐

        //-> 1번째 사람이 4개를 주문했을 경우
        //-> (1) 조합은 2개, 3개, 4개인데 이때 조합을 저장해놓고 각각 비교해야함?
        //-> 이중 for문 필수

        //A B C F G
        //A C
        //C D E
        //A C D E
        //B C F G
        //A C D E H

        //HashMap<주문조합String, HashMap<조합개수Integer, 조합String[]>>
        //이렇게하고 for문을 도는수밖에?

        //-> (2) AB 조합이 있는지 확인할 경우
        //-> HashMap에 1번째: ABCFG 라고 저장돼있다면
        //-> 반복문 돌면서 1번째에 A와 B가 있는지 확인하는 식
        //-> 근데 이러면 조합을 또 다 일일이 설정해줘야하는거 아님?

        //문제2: 주문 횟수가 중복될 경우 배열에 담아 return 한다
        //-> 코스요리 후보는 배열로 관리한다. String[], ArrayList 등

        //HashMap<조합개수 Integer, 조합 String[]> 이걸 다 꺼내보면서
        //2를 key로 꺼낼때, 3을 key로 꺼낼때
        //HashMap<조합 String, 총횟수 Integer>에 추가
        //내림차순 정렬하기
        //총횟수가 가장많은 것 = 첫번째의 key를 answer[]에 담기
        //entrySet으로 만들어서 getKey()로 가져오면 됨
        //만약 총횟수가 동일한게 있다면 같이 담기

        //최대횟수를 담을 HashMap<course수 Integer, 총횟수 Integer>를 만들기

        //문제3: 조합을 만들어야함
        //-> 재귀함수를 이용해서 조합을 만들어주면 됨
        //-> HashMap<course요리수 Integer, HashMap<조합 String, 총횟수 Integer>>

        courseMap = new HashMap<>();
        for (int i : course) {
            courseMap.put(i, new HashMap<>());
        }

        for (String order : orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combinations(0, orderArray, "");
        }

        ArrayList<String> answer = new ArrayList<>();

        for (HashMap<String, Integer> count : courseMap.values()) {
            count.values().stream()
                    .max(Comparator.comparingInt(o -> o))
                    .ifPresent(cnt -> count.entrySet().stream()
                            .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
                            .forEach(entry -> answer.add(entry.getKey())));
        }
        Collections.sort(answer);
        return answer.toArray(String[]::new);

    }

    public static void combinations(int index, char[] order, String result) {
        if (courseMap.containsKey(result.length())) {
            HashMap<String, Integer> map = courseMap.get(result.length());
            map.put(result, map.getOrDefault(result, 0) + 1);
        }

        for (int i = index; i < order.length; i++) {
            combinations(i + 1, order, result + order[i]);
        }
    }

    public static void main(String[] args) {
        String[] answer = solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
        System.out.println("기댓값: [AC, ACDE, BCFG, CDE]");
        System.out.println("실제값: " + Arrays.toString(answer));
    }
}
