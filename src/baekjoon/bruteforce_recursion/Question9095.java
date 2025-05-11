package baekjoon.bruteforce_recursion;

import java.util.*;
import java.io.*;

public class Question9095 {
    static int T, N;
    static int count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            count = 0;
            backtrack(0);

            sb.append(count).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backtrack(int sum) {
        if (sum == N) {
            count++;
        }

        if (sum > N) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            backtrack(sum + i);
        }
    }
}
