package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class Main_1244_스위치켜고끄기 {
    static int N;
    static int[] switches;
    static int S;

    static StringBuilder sb = new StringBuilder();

    static final int MALE = 1;
    static final int FEMALE = 2;

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
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            // 배수 뒤집기
            if (gender == MALE) {
                flipMultiplies(number);
                continue;
            }
            // 구간 뒤집기
            if (gender == FEMALE) {
                flipArea(number);
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

    private static void flipMultiplies(int number) {
        for (int i = number; i <= N; i += number) {
            switches[i] = 1 - switches[i];
        }
    }

    private static void flipArea(int number) {
        switches[number] = 1 - switches[number];

        int left = number - 1;
        int right = number + 1;

        while (1 <= left && right <= N && switches[left] == switches[right]) {
            switches[left] = 1 - switches[left];
            switches[right] = 1 - switches[right];

            left--;
            right++;
        }
    }
}
