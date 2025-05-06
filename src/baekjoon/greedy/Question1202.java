package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class Question1202 {
    static int N, K;
    static int[][] jewels;
    static int[] bags;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewels = new int[N][2];
        bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i][0] = Integer.parseInt(st.nextToken());
            jewels[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        answer = 0;
        int j = 0;

        for (int i = 0; i < K; i++) {
            while (j < N && jewels[j][0] <= bags[i]) {
                pq.add(jewels[j][1]);
                j++;
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
