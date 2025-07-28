package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class Question2563 {
    static int N;
    static boolean[][] papers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        papers = new boolean[100][100];

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            for (int row = r; row < r + 10; row++) {
                for (int col = c; col < c + 10; col++) {
                    papers[row][col] = true;
                }
            }
        }

        int area = 0;
        for (int row = 0; row < 100; row++) {
            for (int col = 0; col < 100; col++) {
                if (papers[row][col]) {
                    area++;
                }
            }
        }

        bw.write(String.valueOf(area));

        br.close();
        bw.close();
    }
}
