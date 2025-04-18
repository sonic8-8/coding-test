package programmers.book.step16_greedy;

import java.util.*;

public class Question80 {
    public int solution(int[] people, int limit) {
        //구명보트 최대 2명씩, 무게 제한 o
        //"최소" 구명보트
        //"최대한 사람을 태울 수 있으면 태우라는 것"
        //그리디 의심
        //독립된 조건인가?

        //베낭 문제랑 비슷함
        //조건 설정이 중요
        //가벼운 사람과 무거운 사람이 같이 탈 수 있음

        Arrays.sort(people);

        int boatCount = 0;

        int light = 0;
        int heavy = people.length - 1;

        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) {
                light++;
            }
            heavy--;
            boatCount++;
        }
        return boatCount;
    }

}
