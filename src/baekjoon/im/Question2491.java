package baekjoon.im;

import java.io.*;
import java.util.*;

public class Question2491 {
    static int N;
    static int[] array;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        array = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int increase = 1;
        int decrease = 1;
        int max = 1;

        for (int i = 1; i < N; i++) {
            if (array[i] >= array[i - 1]) {
                increase++;
            } else {
                increase = 1;
            }

            if (array[i] <= array[i - 1]) {
                decrease++;
            } else {
                decrease = 1;
            }

            max = Math.max(max, Math.max(increase, decrease));
        }

        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }
}
