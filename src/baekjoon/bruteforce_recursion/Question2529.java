package baekjoon.bruteforce_recursion;

import java.util.*;
import java.io.*;

public class Question2529 {
    static int K;
    static char[] signs;
    static ArrayList<String> perms = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        signs = new char[K];
        visited = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            signs[i] = st.nextToken().charAt(0);
        }

        backtrack(0, "");

        Collections.sort(perms);
        sb.append(perms.get(perms.size() - 1)).append("\n").append(perms.get(0));

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backtrack(int depth, String perm) {
        if (depth == K + 1) {
            perms.add(perm);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                if (depth == 0 || isValid(perm.charAt(depth - 1) - '0', i, signs[depth - 1])) {
                    visited[i] = true;
                    backtrack(depth + 1, perm + i);
                    visited[i] = false;
                }
            }
        }
    }

    private static boolean isValid(int a, int b, char sign) {
        if (sign == '<') {
            return a < b;
        }
        if (sign == '>') {
            return a > b;
        }
        return false;
    }
}