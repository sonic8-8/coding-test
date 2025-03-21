package programmers.book.step6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Question14 {
    public static String solution(int n, int k, String[] cmd) {

        //문제1: 행을 "삭제하면 순서대로 밀려 올라온다"
        //-> 효율성 테스트까지 있으니까 자료구조가 중요함
        //-> ArrayList를 사용하면 될 것 같은데 일단 시간 복잡도는 증가함
        //-> Stack 구조? 근데 약간 애매함 일단은

        //문제2: Z는 "가장 최근에" 삭제한 것을 복구하는 기능이다
        //-> 복구가 가능하려면 삭제한 것을 담아놓을 자료구조가 필요함
        //-> 가장 최근에 삭제한 것이니까 Stack이 적절

        //row 개수: n
        //시작 row: k
        //명령어 배열: cmd

        //문제3: 삭제된 행을 X로 멀쩡한 행을 O로 나타내서 배열로 return
        //-> 따로 ArrayList 같은게 주어진 게 아니니까 인덱스를 기록하고 이걸 바탕으로 배열을 만들어야할듯
        //-> stack에 들어간 row만 삭제된 것으로 만들면 됨

        //이중 for문 X

        //문제4: cmd를 입력받긴하는데 "U 2" 이런건 어떻게 처리할거임?
        //-> split() 같은걸 사용해야되나?
        //-> split()으로 나누면 이걸 배열에 담아주니까 인덱스를 이용해서 처리하기

        //문제5: 인덱스 오류가 발생함
        //-> ArrayList에서 값을 삭제하면 arrayList 요소의 index를 stack에 넣을게 아니라
        //-> arrayList 요소의 값을 stack에 넣어야함

        //문제6: 가장 최근에 삭제한 인덱스를 다시 삭제했던 위치로 옮기는데 실패함
        //-> 마지막으로 삭제됐던 그 위치를 기억해놔야됨

        //문제7: current 인덱스가 더해지거나 삭제되질 않음
        //-> == 비교가 아니라 eqauls()로 해야됨 String이니까

        //문제8: index를 원복시키려는데 너무 까다로움
        //-> 이중 연결리스트 구조를 사용해서 prev, next 포인터 개념을 만들어서 사용하기

        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        int current = k + 1;

        Stack<Integer> deleted = new Stack<>();

        for (String command : cmd) {
            if (command.equals("C")) {
                deleted.push(current);
                down[up[current]] = down[current];
                up[down[current]] = up[current];
                current = n < down[current] ? up[current] : down[current];
            } else if (command.equals("Z")) {
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            } else {
                String[] splits = command.split(" ");
                if (splits[0].equals("U")) {
                    for (int i = 0; i < Integer.parseInt(splits[1]); i++) {
                        current = up[current];
                    }
                } else {
                    for (int i = 0; i < Integer.parseInt(splits[1]); i++) {
                        current = down[current];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');

        for (int index : deleted) {
            answer[index - 1] = 'X';
        }

        return new String(answer);
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));

    }

}
