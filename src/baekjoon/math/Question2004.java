package baekjoon.math;

import java.util.*;
import java.io.*;

public class Question2004 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int twoCount = countFactor(N, 2) - countFactor(M, 2) - countFactor(N - M, 2);
        int fiveCount = countFactor(N, 5) - countFactor(M, 5) - countFactor(N - M, 5);
        int answer = Math.min(twoCount, fiveCount);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static int countFactor(int n, int prime) {
        int count = 0;
        for (long i = prime; i <= n; i *= prime) {
            count += (int) (n / i);
        }
        return count;
    }
}
