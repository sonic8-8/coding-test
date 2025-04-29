package baekjoon.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

class Question1476 {
    static int E, S, M;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = 0;
        int count = 1;
        while (answer == 0) {
            if ((count - 1) % 15 + 1 == E &&
                    (count - 1) % 28 + 1 == S &&
                    (count - 1) % 19 + 1 == M) {
                answer = count;
            }
            count++;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}