package baekjoon.im;

import java.io.*;
import java.util.*;

public class Question2564 {
    static int C, R;
    static int N;
    static int[] dists;
    static int xDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());

        dists = new int[N];

        for (int i = 0; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            int position = 0;

            // 북
            if (dir == 1) {
                position = dist;
            }

            // 남
            if (dir == 2) {
                position = C + R + (C - dist);
            }

            // 서
            if (dir == 3) {
                position = 2 * (C + R) - dist;
            }

            // 동
            if (dir == 4) {
                position = C + dist;
            }

            if (i == N) {
                xDist = position;
                break;
            }
            dists[i] = position;
        }

        int sum = 0;
        int totalDist = 2 * (C + R);
        for (int dist : dists) {
            int difference = Math.abs(dist - xDist);
            sum += Math.min(difference, totalDist - difference);
        }

        bw.write(String.valueOf(sum));

        br.close();
        bw.close();
    }
}