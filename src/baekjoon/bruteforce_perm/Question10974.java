package baekjoon.bruteforce_perm;

import java.io.*;

public class Question10974 {
    static int N;
    static int[] array;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        array = new int[N];
        visited = new boolean[N];

        backtrack(0);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backtrack(int depth) {
        if (depth == N) {
            for (int num : array) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[depth] = i + 1;
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }
}
