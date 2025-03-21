package programmers.book.step6;

import java.util.Stack;

public class Question11 {
    public int solution(String s) {

        //짝짓는다 = 가까운것들끼리 뭔가 작업을 해야됨
        //-> stack을 떠올릴 수 있음

        //문제1: 같은 알파벳 2개가 붙어있는 "짝"을 찾는다.
        //-> 문자열을 Character로 나눠서 하나씩 stack에 넣어놓는다

        //문제2: 짝을 제거한다
        //-> stack에 마지막에 넣었던 것과 현재 넣을 대상이 같은 알파벳일 경우에 제거
        //-> 만약 알파벳이 연속으로 나오지 않을 경우는 그냥 넣어놓으면 됨
        //-> 만약 stack이 마지막에 비워지면 1을 return

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            char target = s.charAt(i);

            System.out.println(stack.toString());

            if (!stack.isEmpty()) {
                if (stack.peek() == target) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(target);
        }

        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
