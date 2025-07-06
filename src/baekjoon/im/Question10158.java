package baekjoon.im;

import java.io.*;
import java.util.*;

public class Question10158 {
    static int w, h;
    static int p, q;
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        t = Integer.parseInt(br.readLine());

        int widthCycle = 2 * w;
        int x = (p + t) % widthCycle;
        if (x > w) {
            x = widthCycle - x;
        }

        int heightCycle = 2 * h;
        int y = (q + t) % heightCycle;
        if (y > h) {
            y = heightCycle - y;
        }

        System.out.println(x + " " + y);

        br.close();
    }
}
