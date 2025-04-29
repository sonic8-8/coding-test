package baekjoon.bruteforce;

import java.util.*;
import java.io.*;

// 최대한 N과 가까운 숫자를 입력하고
// +나 -로 이동시키기

class Question1107 {
    static int N, M;
    static boolean[] broken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        broken = new boolean[10];

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int min = Math.abs(100 - N);

        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            boolean canPress = true;

            for (int j = 0; j < str.length(); j++) {
                if (broken[str.charAt(j) - '0'] == true) {
                    canPress = false;
                    break;
                }
            }

            if (canPress) {
                min = Math.min(min, str.length() + Math.abs(i - N));
            }
        }

        bw.write(String.valueOf(min));

        br.close();
        bw.close();
    }
}
