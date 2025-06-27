package baekjoon.im;

import java.io.*;
import java.util.*;

public class Question13300 {
    static int N, K;
    static int S, Y; // 0: 여자, 1: 남자
    static int[][] people;
    static int room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        people = new int[6 + 1][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            people[Y][S]++;
        }

        room = 0;
        for (int y = 1; y <= 6; y++) {
            for (int s = 0; s < 2; s++) {
                room += (people[y][s] + K - 1) / K;
            }
        }

        bw.write(String.valueOf(room));

        br.close();
        bw.close();
    }
}
