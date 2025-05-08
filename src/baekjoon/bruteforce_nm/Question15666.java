package baekjoon.bruteforce_nm;

import java.util.*;
import java.io.*;

public class Question15666 {
    static int N, M;
    static int[] array;
    static int[] sub;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N];
        sub = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        backtrack(0, 0);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backtrack(int depth, int start) {
        if (depth == M) {
            for (int num : sub) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        for (int i = start; i < N; i++) {
            if (prev != array[i]) {
                sub[depth] = array[i];
                prev = array[i];
                backtrack(depth + 1, i);
            }
        }
    }
}
