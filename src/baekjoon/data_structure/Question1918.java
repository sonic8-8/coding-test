package baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class Question1918 {
    static Stack<Character> signStack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String infix = br.readLine();

        for (char ch : infix.toCharArray()) {
            if (Character.isLetter(ch)) {
                sb.append(ch);
            } else {
                if (ch == '(') {
                    signStack.push(ch);
                } else if (ch == ')') {
                    while (!signStack.isEmpty() && signStack.peek() != '(') {
                        sb.append(signStack.pop());
                    }
                    signStack.pop();
                } else {
                    while (!signStack.isEmpty() && precedenceScore(signStack.peek()) >= precedenceScore(ch)) {
                        sb.append(signStack.pop());
                    }
                    signStack.push(ch);
                }
            }
        }

        while (!signStack.isEmpty()) {
            sb.append(signStack.pop());
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static int precedenceScore(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else {
            return 0;
        }
    }
}
