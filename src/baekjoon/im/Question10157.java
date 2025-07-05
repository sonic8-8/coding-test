package baekjoon.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question10157 {
    static int C, R;
    static int K;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[R + 1][C + 1];

        K = Integer.parseInt(br.readLine());

        int totalSeats = C * R;
        if (totalSeats < K) {
            System.out.println(0);
            return;
        }

        int count = 1;
        int x = 1;
        int y = 1;
        int dir = 0;

        visited[y][x] = true;

        while (count < K) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            boolean isInBounds = 1 <= nx && nx <= C && 1 <= ny && ny <= R;

            if (isInBounds && !visited[ny][nx]) {
                visited[ny][nx] = true;

                x = nx;
                y = ny;

                count++;
            } else {
                dir = (dir + 1) % 4;
            }
        }

        System.out.println(x + " " + y);
        br.close();
    }
}