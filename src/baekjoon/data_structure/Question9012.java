package baekjoon.data_structure;

import java.io.*;
import java.util.Stack;

public class Question9012 {
    static int T;
    static Stack<Character> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();
            boolean isVPS = true;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    stack.push('(');
                }

                if (str.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        isVPS = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!stack.isEmpty()) {
                isVPS = false;
            }

            sb.append(isVPS ? "YES" : "NO").append("\n");
            stack.clear();
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
