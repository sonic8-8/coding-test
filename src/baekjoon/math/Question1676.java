package baekjoon.math;

import java.util.*;
import java.io.*;

public class Question1676 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 5; i <= N; i *= 5) {
            count += N / i;
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}
