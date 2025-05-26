package baekjoon.math;

import java.io.*;
import java.util.*;

public class Question11576 {
    static int A, B, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int decimal = 0;
        while (M-- > 0) {
            int ABit = Integer.parseInt(st.nextToken());
            decimal = decimal * A + ABit;
        }

        String BBits = Integer.toString(decimal, B);
        for (int i = 0; i < BBits.length(); i++) {
            char ch = BBits.charAt(i);

            if (Character.isDigit(ch)) {
                sb.append(BBits.charAt(i)).append(" ");
            } else if (Character.isAlphabetic(ch)) {
                sb.append(ch - 'a' + 10).append(" ");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
