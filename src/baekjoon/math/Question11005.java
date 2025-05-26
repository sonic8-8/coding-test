package baekjoon.math;

import java.io.*;
import java.util.*;

public class Question11005 {
    static int N, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        String bits = Integer.toString(N, B);

        bw.write(bits.toUpperCase());

        br.close();
        bw.close();
    }
}
