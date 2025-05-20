package baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class Question10799 {
    static Stack<Character> stack = new Stack<>();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                stack.push('(');
            }
            if (ch == ')') {
                stack.pop();

                if (str.charAt(i - 1) == '(') {
                    count += stack.size();
                } else {
                    count += 1;
                }
            }
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}
