package baekjoon.im;

import java.io.*;
import java.util.*;

public class Question2527 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());

            // d: 공통 x
            if (p1 < x2 || q1 < y2 || p2 < x1 || q2 < y1) {
                sb.append("d").append("\n");
                continue;
            }

            // c: 점
            if ((p1 == x2 && q1 == y2) || (p1 == x2 && q2 == y1)
                    || (p2 == x1 && q1 == y2) || (p2 == x1 && q2 == y1)) {
                sb.append("c").append("\n");
                continue;
            }

            // b: 선분
            if (p1 == x2 || q1 == y2 || p2 == x1 || q2 == y1) {
                sb.append("b").append("\n");
                continue;
            }

            // a: 직사각형
            sb.append("a").append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
