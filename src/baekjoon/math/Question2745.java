package baekjoon.math;

import java.io.*;
import java.util.*;

public class Question2745 {
    static String N;
    static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = st.nextToken().toLowerCase();
        B = Integer.parseInt(st.nextToken());

        int decimal = Integer.parseInt(N, B);

        bw.write(String.valueOf(decimal));

        br.close();
        bw.close();
    }
}
