package baekjoon.dfs;

import java.util.*;
import java.io.*;

public class Question13565_noVisited {
    final static int MAX = 1000 + 10;
    static int M, N;
    static boolean[][] map;
    static int[] dirRow = new int[]{-1, +1, 0, 0};
    static int[] dirCol = new int[]{0, 0, -1, +1};
    static boolean answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new boolean[MAX][MAX];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 1; j <= N; j++) {
                map[i][j] = str.charAt(j - 1) == '0';
            }
        }


        for (int j = 1; j <= N; j++) {
            if (map[1][j]) {
                dfs(1, j);
            }
        }

        if (answer == true) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        br.close();
        bw.close();
    }

    private static void dfs(int row, int col) {
        map[row][col] = false;

        if (row == M) {
            answer = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newRow = row + dirRow[i];
            int newCol = col + dirCol[i];
            if (map[newRow][newCol]) {
                dfs(newRow, newCol);
            }
        }
    }

}
