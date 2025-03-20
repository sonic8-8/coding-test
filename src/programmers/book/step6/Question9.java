package programmers.book.step6;

import java.util.Stack;

public class Question9 {
    public static String solution(int decimal) {

        // 10진수를 2진수로 변환

        Stack<Integer> stack = new Stack<>();

        while (decimal > 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(27));
    }
}
