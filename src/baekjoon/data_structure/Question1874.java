package baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class Question1874 {
    static int N;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int current = 1;

        for (int i = 1; i <= N; i++) {
            int target = Integer.parseInt(br.readLine());

            while (current <= target) {
                stack.push(current++);
                sb.append("+").append("\n");
            }

            if (stack.peek() == target) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}