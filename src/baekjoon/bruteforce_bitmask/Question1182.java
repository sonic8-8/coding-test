package baekjoon.bruteforce_bitmask;

import java.io.*;
import java.util.*;

public class Question1182 {
    static int N, S;
    static int[] array;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        array = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < (1 << N); i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += array[j];
                }
            }
            if (S == sum) {
                count++;
            }
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}
