package baekjoon.math;

import java.io.*;
import java.util.*;

public class Question17103 {
    static int T, N;
    static boolean[] isPrime;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        isPrime = new boolean[1000000 + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= (int) Math.sqrt(1000000); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            int count = 0;

            for (int i = 2; i <= N / 2; i++) {
                if (isPrime[i] && isPrime[N - i]) {
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}