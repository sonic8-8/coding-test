package baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class Question1935 {
    static int N;
    static Stack<Double> stack = new Stack<>();
    static double[] alphabetValues;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        String postfix = br.readLine();

        alphabetValues = new double[N];
        for (int i = 0; i < N; i++) {
            alphabetValues[i] = Double.parseDouble(br.readLine());
        }

        for (char ch : postfix.toCharArray()) {
            if (Character.isLetter(ch)) {
                stack.push(alphabetValues[ch - 'A']);
            } else {
                double b = stack.pop();
                double a = stack.pop();

                if (ch == '+') {
                    stack.push(a + b);
                } else if (ch == '-') {
                    stack.push(a - b);
                } else if (ch == '*') {
                    stack.push(a * b);
                } else if (ch == '/') {
                    stack.push(a / b);
                }
            }
        }

        bw.write(String.format("%.2f", stack.pop()));

        br.close();
        bw.close();
    }
}
