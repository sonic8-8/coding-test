package baekjoon.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

// 5가지 테트로미노 중 하나로 숫자의 최대 합 구하기

public class Question14500 {
    final static int MAX = 500 + 10;
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dirRow = new int[]{0, 0, -1, +1};
    static int[] dirCol = new int[]{+1, -1, 0, 0};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[MAX][MAX];
        visited = new boolean[MAX][MAX];
        answer = 0;

        for (int row = 1; row <= N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= M; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= M; col++) {
                visited[row][col] = true;
                dfs(row, col, 1, map[row][col]);
                visited[row][col] = false;
                checkT(row, col);

            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static void dfs(int row, int col, int depth, int sum) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newRow = row + dirRow[i];
            int newCol = col + dirCol[i];
            if (inRange(newRow, newCol) && !visited[newRow][newCol]) {
                visited[newRow][newCol] = true;
                dfs(newRow, newCol, depth + 1, sum + map[newRow][newCol]);
                visited[newRow][newCol] = false;
            }
        }
    }

    private static boolean inRange(int row, int col) {
        if (1 <= row && row <= N && 1 <= col && col <= M) {
            return true;
        }
        return false;
    }

    private static void checkT(int row, int col) {
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;

        if (1 <= row - 1 && col + 2 <= M) {
            first = map[row][col] + map[row][col + 1] + map[row][col + 2] + map[row - 1][col + 1];
        }
        if (row + 1 <= N && col + 2 <= M) {
            second = map[row][col] + map[row][col + 1] + map[row][col + 2] + map[row + 1][col + 1];
        }
        if (row + 2 <= N && col + 1 <= M) {
            third = map[row][col] + map[row + 1][col] + map[row + 2][col] + map[row + 1][col + 1];
        }
        if (row + 2 <= N && 1 <= col - 1) {
            fourth = map[row][col] + map[row + 1][col] + map[row + 2][col] + map[row + 1][col - 1];
        }

        int max = Math.max(Math.max(first, second), Math.max(third, fourth));
        answer = Math.max(answer, max);
    }
}
