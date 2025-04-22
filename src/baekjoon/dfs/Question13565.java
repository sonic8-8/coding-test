package baekjoon.dfs;

// 2차원 배열
// row 1번에서 시작 상하좌우로 전달 -> DFS 같은 부류 찾기
// row 마지막까지 도달하는지 출력
// M X N 행렬
// M, N: 1,000 -> boolean[][]

import java.util.*;
import java.io.*;

public class Question13565 {
    final static int MAX = 1000 + 10;
    static int M, N;
    static boolean[][] map;
    static boolean[][] visited;
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
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 1; j <= N; j++) {
                map[i][j] = str.charAt(j - 1) == '0';
            }
        }


        for (int j = 1; j <= N; j++) {
            if (!visited[1][j] && map[1][j]) {
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
        visited[row][col] = true;

        if (row == M) {
            answer = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newRow = row + dirRow[i];
            int newCol = col + dirCol[i];
            if (!visited[newRow][newCol] && map[newRow][newCol]) {
                dfs(newRow, newCol);
            }
        }
    }
}
