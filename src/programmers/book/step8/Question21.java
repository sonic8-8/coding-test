package programmers.book.step8;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;

public class Question21 {
    public static String[] solution(String[] record) {

        //조건: record.length로 이중for문 X

        //문제1: 닉네임을 변경하면 이전에 남겨져있던 메세지의 닉네임도 모두 변경됨
        //-> 예전에 바꿨던 것들도 자료구조에서 바로 찾은 다음 수정할 수 있어야함
        //-> HashMap을 사용하면 될듯

        //문제2: Enter 아이디 닉네임, 같은 형식으로 record가 남는다
        //-> 우선 아이디로 구분하기
        //-> 아이디가 일치할 경우 닉네임을 모두 변경하는 방식?
        //-> 마지막에 아이디에 대응하는 닉네임으로 바꾸기

        //문제3: 닉네임 변경 방식은 2가지다
        //-> 나갔다가 들어올때 변경
        //-> 채팅방 안에서 변경

        //문제4: result를 담아놓은 자료구조는 순서가 중요하고 중복이 가능함
        //-> Queue 사용?

        Queue<String> result = new ArrayDeque<>();
        HashMap<String, String> mapper = new HashMap<>();

        for (int i = 0; i < record.length; i++) {
            String[] splits = record[i].split(" ");
            if (splits[0].equals("Enter")) {
                result.add(splits[1] + " 들어왔습니다.");
                mapper.put(splits[1], splits[2]);
            }
            if (splits[0].equals("Leave")) {
                result.add(splits[1] + " 나갔습니다.");
            }
            if (splits[0].equals("Change")) {
                mapper.put(splits[1], splits[2]);
            }
        }

        // poll()하면서 닉네임 맵핑해주면 끝?
        String[] answer = new String[result.size()];
        for (int i = 0; i < answer.length; i++) {
            String target = result.poll();
            String[] splits = target.split(" ");
            answer[i] = mapper.get(splits[0]) + "님이 " + splits[1];
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] answer = solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        System.out.println("기대값: [Prodo님이 들어왔습니다., Ryan님이 들어왔습니다., Prodo님이 나갔습니다., Prodo님이 들어왔습니다.]");

        System.out.println("실제값: " + Arrays.toString(answer));
    }
}
