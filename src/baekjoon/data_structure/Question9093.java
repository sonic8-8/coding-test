package baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class Question9093 {
    static int T;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                sb.append(new StringBuilder(st.nextToken()).reverse()).append(" ");
            }

            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
