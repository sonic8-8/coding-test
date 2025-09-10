package baekjoon.simulation;

import java.io.*;
import java.util.*;

public class Main_13335_트럭_복습 {
    static int N, W, L;

    static int[] truckWeights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        truckWeights = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            truckWeights[i] = Integer.parseInt(st.nextToken());
        }

        int time = 0;
        int totalWeight = 0;
        int index = 0;

        Queue<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < W; i++) {
            bridge.add(0);
        }

        while (index < N) {
            time++;

            totalWeight -= bridge.poll();

            if (totalWeight + truckWeights[index] <= L) {
                bridge.add(truckWeights[index]);
                totalWeight += truckWeights[index];
                index++;
            } else {
                bridge.add(0);
            }
        }

        bw.write(String.valueOf(time + W));

        br.close();
        bw.close();
    }
}