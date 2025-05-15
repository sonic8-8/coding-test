package baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class Question1406 {
    static int M;
    static Stack<Character> left = new Stack<>();
    static Stack<Character> right = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }

        M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char ch = st.nextToken().charAt(0);

            if (ch == 'P') {
                left.push(st.nextToken().charAt(0));
            }
            if (ch == 'L') {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            }
            if (ch == 'D') {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            }
            if (ch == 'B') {
                if (!left.isEmpty()) {
                    left.pop();
                }
            }
        }

        while (!left.isEmpty()) {
            sb.append(left.pop());
        }

        sb.reverse();

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
