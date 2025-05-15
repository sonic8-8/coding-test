package baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class Question1158 {
    static int N, K;
    static Deque<Integer> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        sb.append("<");
        while (N-- > 0) {
            for (int i = 0; i < K - 1; i++) {
                deque.add(deque.poll());
            }
            sb.append(deque.poll()).append(N == 0 ? "" : ", ");
        }
        sb.append(">");

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
