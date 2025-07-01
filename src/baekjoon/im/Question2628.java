package baekjoon.im;

import java.io.*;
import java.util.*;

public class Question2628 {
    static int R, C;
    static int N;
    static List<Integer> xList = new ArrayList<>();
    static List<Integer> yList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        xList.add(0);
        xList.add(C);

        yList.add(0);
        yList.add(R);

        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int div = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (div == 0) {
                yList.add(num);
            }
            if (div == 1) {
                xList.add(num);
            }
        }

        Collections.sort(xList);
        Collections.sort(yList);

        int max = 0;

        for (int i = 1; i < yList.size(); i++) {
            for (int j = 1; j < xList.size(); j++) {
                int width = xList.get(j) - xList.get(j - 1);
                int height = yList.get(i) - yList.get(i - 1);

                max = Math.max(max, width * height);
            }
        }

        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }
}
