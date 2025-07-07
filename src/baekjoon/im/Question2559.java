package baekjoon.im;

import java.io.*;
import java.util.*;

public class Question2559 {
    static int N, K;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        array = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += array[i];
        }

        int max = sum;

        for (int i = K; i < N; i++) {
            sum = sum - array[i - K] + array[i];
            max = Math.max(max, sum);
        }

        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }
}
