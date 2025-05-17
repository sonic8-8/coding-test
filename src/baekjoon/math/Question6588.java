package baekjoon.math;

import java.io.*;
import java.util.*;

public class Question6588 {
    static boolean[] isPrime;
    static boolean isFound;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            isFound = false;

            for (int i = 2; i <= N / 2; i++) {
                if (isPrime[i] && isPrime[N - i]) {
                    sb.append(N).append(" = ")
                            .append(i).append(" + ")
                            .append(N - i).append("\n");
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
