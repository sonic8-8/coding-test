package baekjoon.im;

import java.io.*;
import java.util.*;

public class Question10163 {
    static int N;
    static int[][] grid;
    static int[] area;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        grid = new int[1000 + 1][1000 + 1];
        area = new int[N];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());

            int x2 = x1 + dx;
            int y2 = y1 + dy;

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    grid[x][y] = i;
                }
            }
        }

        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                if (grid[i][j] != 0) {
                    area[grid[i][j] - 1]++;
                }
            }
        }

        for (int a : area) {
            sb.append(a).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
