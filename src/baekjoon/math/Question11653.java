package baekjoon.math;

import java.io.*;
import java.util.*;

public class Question11653 {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 2; i <= (int) Math.sqrt(N); i++) {
            while (N % i == 0) {
                sb.append(i).append("\n");
                N /= i;
            }
        }

        if (N > 1) {
            sb.append(N).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
