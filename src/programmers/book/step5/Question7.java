package programmers.book.step5;

import java.util.HashMap;
import java.util.HashSet;

public class Question7 {

    class Solution {
        public int solution(String dirs) {

            //문제1: 중복 경로는 포함하지 거리에 포함하지 않는다
            //-> Set을 이용한다
            //int[]를 Set에 넣으면 객체의 주솟값을 체크하기 때문에 값이 같더라도 다른 객체로 인식함
            //좌표를 넣는게 아니라 경로 그 자체를 Set에 넣어야함

            //문제2: 좌표에 음수가 있다
            //-> 중심을 (5, 5)로 바꾼다

            //규칙을 찾으려고 시도함, UD, LR이 서로 상쇄되는지? -> 실패
            //Map에 Character: new int[]{0, 1} 처럼 이동 방향 저장해두고 대응시키기

            //중앙 좌표
            int x = 5;
            int y = 5;

            //HashMap에 문자에 대응하는 좌표 설정
            HashMap<Character, int[]> direction = new HashMap<>();
            direction.put('U', new int[]{0, 1});
            direction.put('D', new int[]{0, -1});
            direction.put('L', new int[]{-1, 0});
            direction.put('R', new int[]{1, 0});

            HashSet<String> memory = new HashSet<>();

            for (int i = 0; i < dirs.length(); i++) {
                int[] offset = direction.get(dirs.charAt(i));

                int nx = x + offset[0];
                int ny = y + offset[1];

                if (nx > 10 || nx < 0 || ny > 10 || ny < 0) {
                    continue;
                }

                memory.add(x + "," + y + "->" + nx + "," + ny);
                memory.add(nx + "," + ny + "->" + x + "," + y);

                x = nx;
                y = ny;
            }

            return memory.size() / 2;
        }
    }
}
