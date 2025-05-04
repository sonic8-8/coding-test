package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class Question11399 {
    static int N;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        array = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int total = 0;
        int prefix = 0;
        for (int i = 1; i <= N; i++) {
            prefix += array[i];
            total += prefix;
        }

        bw.write(String.valueOf(total));

        br.close();
        bw.close();
    }
}
