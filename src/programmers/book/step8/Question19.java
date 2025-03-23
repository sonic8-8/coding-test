package programmers.book.step8;

import java.util.HashMap;

public class Question19 {
    public static String solution(String[] participant, String[] completion) {
        //문제1: 완주하지 못한 선수의 이름만 출력
        //-> 배열에서 위치를 파악해야하는데 순차적으로 찾으면 비효율적
        //-> 존재하는지 확인만 하면 해결되도록 HashSet을 이용해서 처리

        //이중for문 X

        //문제2: 동명이인이 있을 수 있다
        //-> 이러면 HashSet을 못쓰는 상황이네?
        //-> 한 번 찾은 선수는 삭제해서 중복을 제거하면 될 듯
        //-> HashMap을 사용하자

        HashMap<String, Integer> pMap = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            if (pMap.containsKey(participant[i])) {
                pMap.put(participant[i], pMap.get(participant[i]) + 1);
            } else {
                pMap.put(participant[i], 1);
            }
        }
        System.out.println(pMap);

        for (int i = 0; i < completion.length; i++) {
            if (pMap.containsKey(completion[i])) {
                pMap.put(completion[i], pMap.get(completion[i]) - 1);
            }
        }
        System.out.println(pMap);

        for (String name : participant) {
            if (pMap.get(name) == 1) {
                return name;
            }
        }
        return "";
    }

    public static String solution2(String[] participant, String[] completion) {
        HashMap<String, Integer> cMap = new HashMap<>();
        for (int i = 0; i < completion.length; i++) {
            cMap.put(completion[i], cMap.getOrDefault(completion[i], 0) + 1);
        }

        for (String name : participant) {
            if (cMap.getOrDefault(name, 0) == 0) {
                return name;
            }
            cMap.put(name, cMap.get(name) - 1);
        }
        return "";
    }

    public static void main(String[] args) {
        String answer = solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
        System.out.println("기대값: leo");
        System.out.println("실제값: " + answer);

        String answer2 = solution2(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
        System.out.println("기대값: leo");
        System.out.println("실제값: " + answer2);
    }
}
