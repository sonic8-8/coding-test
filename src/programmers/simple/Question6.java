package programmers.simple;

import java.util.*;

public class Question6 {
    public int solution(String dartResult) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);

            if (Character.isDigit(ch)) {
                if (ch == '1' && dartResult.charAt(i + 1) == '0') {
                    stack.push(10);
                    i++;
                } else {
                    stack.push(Integer.parseInt(String.valueOf(ch)));
                }
            } else if (ch == 'S') {
                stack.push((int) Math.pow(stack.pop(), 1));
            } else if (ch == 'D') {
                stack.push((int) Math.pow(stack.pop(), 2));
            } else if (ch == 'T') {
                stack.push((int) Math.pow(stack.pop(), 3));
            } else if (ch == '*') {
                if (stack.size() >= 2) {
                    int number1 = stack.pop() * 2;
                    int number2 = stack.pop() * 2;
                    stack.push(number2);
                    stack.push(number1);
                } else {
                    int number1 = stack.pop() * 2;
                    stack.push(number1);
                }
            } else if (ch == '#') {
                stack.push(stack.pop() * -1);
            }
        }

        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        return answer;
    }
}
