package baekjoon.im;

import java.io.*;
import java.util.*;

public class Question2578 {
    static Map<Integer, int[]> numberToPosition = new HashMap<>();
    static boolean[][] marked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                numberToPosition.put(Integer.parseInt(st.nextToken()), new int[]{i, j});
            }
        }

        marked = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int called = Integer.parseInt(st.nextToken());
                int[] positions = numberToPosition.get(called);

                int x = positions[0];
                int y = positions[1];

                marked[x][y] = true;
                int count = getBingoCount();

                if (count >= 3) {
                    System.out.println(i * 5 + j + 1);
                    return;
                }
            }
        }

        br.close();
    }

    private static int getBingoCount() {
        int count = 0;

        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (!marked[i][j]) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) {
                count++;
            }
        }

        for (int j = 0; j < 5; j++) {
            boolean isBingo = true;
            for (int i = 0; i < 5; i++) {
                if (!marked[i][j]) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) {
                count++;
            }
        }

        boolean isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][i]) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) {
            count++;
        }

        isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][4 - i]) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) {
            count++;
        }

        return count;
    }
}