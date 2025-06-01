package baekjoon.bruteforce_bitmask;

import java.io.*;
import java.util.*;

public class Question11723 {
    static int M;
    static int answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                answer |= (1 << (x - 1));
                continue;
            }

            if (cmd.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                answer &= ~(1 << (x - 1));
                continue;
            }

            if (cmd.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append((answer & (1 << (x - 1))) != 0 ? 1 : 0).append("\n");
                continue;
            }

            if (cmd.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                answer ^= (1 << (x - 1));
                continue;
            }

            if (cmd.equals("all")) {
                answer = (1 << 20) - 1;
                continue;
            }

            if (cmd.equals("empty")) {
                answer = 0;
                continue;
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
