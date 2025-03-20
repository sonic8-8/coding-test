package programmers.book.step6;

import java.util.HashMap;
import java.util.Stack;

public class Question10 {
    public static int solution(String s) {
        // dequeue를 사용해야할듯?
        // 규칙1: 문자열 길이가 6이라면 6번 회전해봐야됨
        // 괄호는 stack으로 결과 확인하는 로직 작성하기
        // character는 그냥 통채로 올바른 문자열 취급함

        // 문제1: 문자열을 회전시킨값을 어떻게 만들것임?
        // -> dequeue를 사용해서 양쪽에 하나씩 넣고 빼면 될듯
        // 왼쪽꺼 하나 빼고 오른쪽에 넣기

        // 문제2: 올바른 문자열인지 확인은 어떻게 할 것임?
        // -> stack으로 올바른 문자열 판독기를 만들기

        // 문제3: Dequeue를 어떻게 만드는지를 모름
        // -> 012345
        // -> 123450
        // -> 234501

        HashMap<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(i, s.charAt(i));
        }

        int answer = 0;

        Stack<Character> stack = new Stack<>();

        HashMap<Character, Character> pairCheckMap = new HashMap<>();
        pairCheckMap.put(')', '(');
        pairCheckMap.put('}', '{');
        pairCheckMap.put(']', '[');

        A: for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i < s.length(); i++) {

                int index = i + j;
                if (index >= s.length()) {
                    index -= s.length();
                }

                char target = map.get(index);
                if (target == '(' || target == '{' || target == '[') {
                    stack.push(target);
                } else if (target == ')' || target == '}' || target == ']') {
                    if (stack.isEmpty() || !stack.contains(pairCheckMap.get(target))) {
                        continue A;
                    }
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
            stack.clear();
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("[)(]"));
    }
}
