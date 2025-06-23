package baekjoon.grpah;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Question2667 {
    static int N;
    static boolean[][] map;
    static boolean[][] visited;
    static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int apartment;
    static ArrayList<Integer> apartments = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new boolean[N + 2][N + 2];
        visited = new boolean[N + 2][N + 2];

        for (int row = 1; row <= N; row++) {
            String str = br.readLine();
            for (int col = 1; col <= N; col++) {
                map[row][col] = str.charAt(col - 1) == '1';
            }
        }

        int complexCount = 0;

        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N; col++) {
                if (!visited[row][col] && map[row][col]) {
                    apartment = 0;
                    complexCount++;

                    dfs(row, col);

                    apartments.add(apartment);
                }
            }
        }

        sb.append(complexCount).append("\n");

        Collections.sort(apartments);
        for (int apartment : apartments) {
            sb.append(apartment).append("\n");

        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;
        apartment++;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];

            if (!visited[newRow][newCol] && map[newRow][newCol]) {
                dfs(newRow, newCol);
            }
        }
    }
}
