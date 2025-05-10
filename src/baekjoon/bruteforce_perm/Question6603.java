package baekjoon.bruteforce_perm;

import java.util.*;
import java.io.*;

public class Question6603 {
    static int K;
    static int[] array;
    static int[] lotto;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0) {
                break;
            }

            array = new int[K];
            lotto = new int[6];

            for (int i = 0; i < K; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            backtrack(0, 0);

            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backtrack(int depth, int start) {
        if (depth == 6) {
            for (int num : lotto) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < K; i++) {
            lotto[depth] = array[i];
            backtrack(depth + 1, i + 1);
        }
    }
}
