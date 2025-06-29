package baekjoon.im;

import java.io.*;
import java.util.*;

public class Question2605 {
    static int N;
    static List<Integer> orders = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int ticket = Integer.parseInt(st.nextToken());
            orders.add(i - 1 - ticket, i);
        }

        for (int order : orders) {
            sb.append(order).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
