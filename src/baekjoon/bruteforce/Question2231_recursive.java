package baekjoon.bruteforce;

import java.io.*;

public class Question2231_recursive {
    static int N;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        answer = 0;

        recursive(1);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static void recursive(int number) {
        String str = String.valueOf(number);
        int sum = number;

        for (int j = 0; j < str.length(); j++) {
            sum += Integer.parseInt(String.valueOf(str.charAt(j)));
        }

        if (sum == N) {
            answer = number;
            return;
        }

        recursive(number + 1);
    }
}
