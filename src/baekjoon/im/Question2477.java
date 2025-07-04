package baekjoon.im;

import java.io.*;
import java.util.*;

public class Question2477 {
    static int K;
    static int[] dir;
    static int[] len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        dir = new int[6];
        len = new int[6];

        int maxWidth = 0;
        int maxHeight = 0;

        int maxWidthIdx = -1;
        int maxHeightIdx = -1;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());

            if (dir[i] == 1 || dir[i] == 2) {
                if (maxWidth < len[i]) {
                    maxWidth = len[i];
                    maxWidthIdx = i;
                }
            } else if (dir[i] == 3 || dir[i] == 4) {
                if (maxHeight < len[i]) {
                    maxHeight = len[i];
                    maxHeightIdx = i;
                }
            }
        }

        int minWidth = Math.abs(len[(maxHeightIdx + 5) % 6] - len[(maxHeightIdx + 1) % 6]);
        int minHeight = Math.abs(len[(maxWidthIdx + 5) % 6] - len[(maxWidthIdx + 1) % 6]);

        int area = (maxWidth * maxHeight) - (minWidth * minHeight);

        bw.write(String.valueOf(area * K));

        br.close();
        bw.close();
    }
}