package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class Question11047 {
    static int N, K;
    static int[] array;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i >= 0; i--) {
            if (array[i] <= K) {
                answer += K / array[i];
                K %= array[i];
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
