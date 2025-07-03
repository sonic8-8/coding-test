package baekjoon.im;

import java.io.*;
import java.util.*;

public class Question1244 {
    static int N;
    static int[] switches;
    static int S;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        switches = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine());

        while (S-- > 0) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int i = 1; i <= N; i++) {
                    if (i % number == 0) {
                        switches[i] = 1 - switches[i];
                    }
                }
            }
            if (gender == 2) {
                int left = number - 1;
                int right = number + 1;
                switches[number] = 1 - switches[number];

                while (1 <= left && right <= N && switches[left] == switches[right]) {
                    switches[left] = 1 - switches[left];
                    switches[right] = 1 - switches[right];

                    left--;
                    right++;

                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(switches[i]).append(" ");

            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}