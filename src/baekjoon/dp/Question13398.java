package baekjoon.dp;

import java.io.*;
import java.util.*;

public class Question13398 {
    static int N;
    static int[] array;
    static int[] left;
    static int[] right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        array = new int[N];
        left = new int[N];
        right = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int max = array[0];
        left[0] = array[0];
        for (int i = 1; i < N; i++) {
            left[i] = Math.max(array[i], left[i-1] + array[i]);
            max = Math.max(max, left[i]);
        }

        right[N-1] = array[N-1];
        for (int i = N - 2; i >= 0; i--) {
            right[i] = Math.max(array[i], right[i+1] + array[i]);
        }

        for (int i = 1; i < N - 1; i++) {
            max = Math.max(max, left[i-1] + right[i+1]);
        }

        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }
}