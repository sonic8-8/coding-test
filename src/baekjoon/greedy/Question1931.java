package baekjoon.greedy;

import java.util.*;
import java.io.*;

// 회의 최대 개수
// 시작 시간, 끝나는 시간

public class Question1931 {
    static int N;
    static int[][] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        times = new int[N + 1][2];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int count = 0;
        int endTime = 0;
        for (int i = 1; i <= N; i++) {
            if (endTime <= times[i][0]) {
                endTime = times[i][1];
                count++;
            }
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}
