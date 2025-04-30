package baekjoon.bruteforce;

import java.io.*;

public class Question9095 {
    static int T;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int target = Integer.parseInt(br.readLine());
            count = 0;

            dfs(0, target);

            System.out.println(count);
        }

        br.close();
    }

    private static void dfs(int sum, int target) {
        if (sum == target) {
            count++;
            return;
        }

        if (sum > target) {
            return;
        }

        dfs(sum + 1, target);
        dfs(sum + 2, target);
        dfs(sum + 3, target);
    }
}
