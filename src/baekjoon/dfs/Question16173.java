package baekjoon.dfs;

// (1, 1) 시작
// 오른쪽, 아래쪽으로만 이동 가능
// 마지막칸 도달하면 승리
// 칸에 쓰여진 숫자만큼만 이동가능

import java.util.*;
import java.io.*;

public class Question16173 {
    final static int MAX = 3 + 100 + 10;
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dirRow = new int[]{0 , 1};
    static int[] dirCol = new int[]{1 , 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new int[MAX][MAX];
        visited = new boolean[MAX][MAX];

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int row = 1; row <= N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= N; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 1);

        if (visited[N][N]) {
            bw.write("HaruHaru");
        } else {
            bw.write("Hing");
        }

        br.close();
        bw.close();
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;
        int count = map[row][col];

        for (int i = 0; i < 2; i++) {
            int newRow = row + dirRow[i] * count;
            int newCol = col + dirCol[i] * count;
            if (!visited[newRow][newCol]) {
                dfs(newRow, newCol);
            }
        }
    }
}
