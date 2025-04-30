package baekjoon.bruteforce;

import java.io.*;

// 5 입력받으면 12345 이런식
// for문으로 하기엔 시간 제한이 있음

public class Question1748 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int start = 1;
        int end = (start * 10) - 1;
        int currentDigits = 1;
        int sum = 0;

        while (start * 10 <= N) {
            end = start * 10 - 1;
            sum += (end - start + 1) * currentDigits;
            currentDigits++;
            start *= 10;
        }

        sum += (N - start + 1) * currentDigits;

        bw.write(String.valueOf(sum));

        br.close();
        bw.close();
    }
}
