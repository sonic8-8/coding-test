package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class Question2109 {
    static int N;
    static int[][] lectures;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        lectures = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lectures, Comparator.comparingInt(o -> o[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(lectures[i][0]);
            if (pq.size() > lectures[i][1]) {
                pq.poll();
            }
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}