package baekjoon.dfs;

// T: 테스트 케이스 개수
// M: 배추밭 가로길이
// N: 배추밭 세로길이
// K: 배추가 심어진 위치 개수
// X Y: 배추의 위치

// 이미 가공된 2차원 배열 -> 같은 부류 찾기
// visited도 2차원 배열

import java.util.*;
import java.io.*;

public class Question1012 {
    final static int MAX = 50 + 10;
    static int T, N, M, K;
    static boolean[][] map;
    static boolean[][] visited;
    static int answer;

    static int[] dirX = new int[]{-1, +1, 0, 0};
    static int[] dirY = new int[]{0, 0, -1, +1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];
            answer = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) + 1;
                int y = Integer.parseInt(st.nextToken()) + 1;

                map[y][x] = true;
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (!visited[i][j] && map[i][j]) {
                        dfs(i, j);
                        answer++;
                    }
                }
            }

            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newY = row + dirY[i];
            int newX = col + dirX[i];

            if (!visited[newY][newX] && map[newY][newX]) {
                dfs(newY, newX);
            }
        }
    }
}
