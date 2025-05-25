package baekjoon.math;

import java.io.*;
import java.util.*;

public class Question17087 {
    static int N, S;
    static int[] differences;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        differences = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            differences[i] = Math.abs(S - Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = gcd(result, differences[i]);
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
