package swea;

import java.io.*;
import java.util.*;

class Question1959 {
    static int T;
    static int N, M;
    static int[] A, B;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }



            int diff = Math.abs(M - N);
            int[] shortArray = N >= M ? B : A;
            int[] longArray = N >= M ? A : B;

            int max = 0;

            for (int d = 0; d <= diff; d++) {
                int sum = 0;
                for (int i = 0; i < shortArray.length; i++) {
                    sum += shortArray[i] * longArray[i + d];
                }
                max = Math.max(max, sum);
            }

            sb.append('#').append(t).append(' ').append(max).append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}