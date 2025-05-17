package baekjoon.math;

import java.util.*;
import java.io.*;

public class Question10872 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int answer = 1;
        for (int i = 2; i <= N; i++) {
            answer *= i;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
