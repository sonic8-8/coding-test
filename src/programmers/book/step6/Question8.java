package programmers.book.step6;

import java.util.Stack;

public class Question8 {
    public static boolean solution(String s) {
        // ()()
        // (가 왔을때 )가 와야 true
        // (가 없는데 )가 온다면 false

        // stack에 character를 넣는다
        // 하나씩 꺼내면서 ( 다음에 )가 오는지 확인한다

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char target = s.charAt(i);

            if (target == '(') {
                stack.push('(');
            }

            if (target == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
    }
}
