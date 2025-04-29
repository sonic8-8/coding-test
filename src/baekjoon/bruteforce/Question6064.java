package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Question6064 {
    static int T;
    static int M, N, x, y;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            answer = -1;

            for (int i = x; i <= lcm(N, M); i += M) {
                if ((i - 1) % N + 1 == y) {
                    answer = i;
                    break;
                }
            }
            System.out.println(answer);
        }

        br.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return (int) ((long) a * b / gcd(a, b));
    }
}