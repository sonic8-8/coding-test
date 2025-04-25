package baekjoon.bruteforce;

import java.util.*;
import java.io.*;

class Question2798 {
    static int N, M;
    static int[] cards;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
        cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        recursive(0, 0, 0);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static void recursive(int current, int count, int sum) {
        if (sum > M) {
            return;
        }

        if (count == 3) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = current; i < N; i++) {
            recursive(i + 1, count + 1, sum + cards[i]);
        }
    }
}
