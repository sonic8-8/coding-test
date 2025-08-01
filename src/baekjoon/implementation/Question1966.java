package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class Question1966 {
    static int T;
    static int N, M;
    static Queue<int[]> documents;
    static Queue<Integer> priorityQueue;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            documents = new ArrayDeque<>();
            priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int weight = Integer.parseInt(st.nextToken());
                documents.add(new int[]{i, weight});
                priorityQueue.add(weight);
            }

            int order = 0;
            while (!documents.isEmpty()) {
                int[] document = documents.poll();
                int index = document[0];
                int weight = document[1];

                if (weight == priorityQueue.peek()) {
                    priorityQueue.poll();
                    order++;

                    if (index == M) {
                        sb.append(order).append("\n");
                        break;
                    }
                    continue;
                }
                if (weight != priorityQueue.peek()) {
                    documents.add(document);
                }
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}