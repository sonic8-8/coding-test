package baekjoon.dp;

import java.io.*;
import java.util.*;

public class Question11054 {
    static int N;
    static int[] array;
    static int[] lis;
    static int[] lds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        array = new int[N];

        lis = new int[N];
        Arrays.fill(lis, 1);

        lds = new int[N];
        Arrays.fill(lds, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (array[j] < array[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, lis[i] + lds[i] - 1);
        }

        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }
}
