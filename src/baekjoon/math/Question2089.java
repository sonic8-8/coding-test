package baekjoon.math;

import java.io.*;
import java.util.*;

public class Question2089 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            sb.append(0);
        }

        while (N != 0) {
            int remainder = N % -2;
            N /= -2;

            if (remainder < 0) {
                remainder += 2;
                N += 1;
            }

            sb.append(remainder);
        }

        bw.write(sb.reverse().toString());

        br.close();
        bw.close();
    }
}
