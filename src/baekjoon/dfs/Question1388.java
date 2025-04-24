package baekjoon.dfs;

// N, M
// -가 나오면 오른쪽에 -가 더 나오는지 확인하기
// |가 나오면 아래쪽에 |가 더 나오는지 확인하기

import java.io.*;
import java.util.StringTokenizer;

public class Question1388 {
    final static int MAX = 50 + 10;
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[MAX][MAX];
        visited = new boolean[MAX][MAX];
        answer = 0;

        for (int row = 1; row <= N; row++) {
            String line = br.readLine();
            for (int col = 1; col <= M; col++) {
                map[row][col] = line.charAt(col - 1);
            }
        }

        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= M; col++) {
                if (!visited[row][col]) {
                    dfs(row, col);
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;

        if (map[row][col] == '-' && map[row][col + 1] == '-') {
            dfs(row, col + 1);
        }
        if (map[row][col] == '|' && map[row + 1][col] == '|') {
            dfs(row + 1, col);
        }

    }
}
