package programmers.book.step8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Question23 {
    public static int[] solution(String[] id_list, String[] report, int k) {
        //1번에 1명
        //동일한 유저에 대한 신고는 1회로 처리
        //k번 신고당하면 정지하고 신고한 유저들에게 메일 발송

        //report로 이중for문 X

        //문제1: 정지당한 유저를 알려줘야함
        //-> 정지당한 유저를 담을 자료구조 필요

        //문제2: 신고한회원 신고당한회원
        //-> 중복신고되지 않도록 회원별 report를 담을 자료구조 필요
        //-> HashMap이면 될듯

        //문제3: 신고한회원으로 Key를 설정했더니 해결방법이 떠오르지 않음
        //HashMap에 담을때 Key를 신고당한 회원으로 해야 신고한 사람 수를 쉽게 파악가능함


       HashMap<String, HashSet<String>> reportedMap = new HashMap<>();

       for (String names : report) {
           String[] splits = names.split(" ");
           String user = splits[0];
           String reportedUser = splits[1];

           if (!reportedMap.containsKey(reportedUser)) {
               reportedMap.put(reportedUser, new HashSet<>());
           }

           reportedMap.get(reportedUser).add(user);
       }

       HashMap<String, Integer> countMap = new HashMap<>();

       for (Map.Entry<String, HashSet<String>> entry : reportedMap.entrySet()) {
           if (entry.getValue().size() >= k) {
               for (String user : entry.getValue()) {
                   countMap.put(user, countMap.getOrDefault(user, 0) + 1);
               }
           }
       }
       int[] answer = new int[id_list.length];
       for (int i = 0; i < id_list.length; i++) {
           answer[i] = countMap.getOrDefault(id_list[i], 0);
       }
       return answer;
    }

    public static void main(String[] args) {
        int[] answer = solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
        System.out.println("기댓값: [2, 1, 1, 0]");
        System.out.println("실제값: " + Arrays.toString(answer));
    }
}
