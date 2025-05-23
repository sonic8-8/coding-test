package baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class Question10820 {
    static int[] counts;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        counts = new int[4];

        String str;
        while ((str = br.readLine()) != null) {
            for (char ch : str.toCharArray()) {
                if (Character.isLowerCase(ch)) {
                    counts[0] += 1;
                } else if (Character.isUpperCase(ch)) {
                    counts[1] += 1;
                } else if (Character.isDigit(ch)) {
                    counts[2] += 1;
                } else if (ch == ' ') {
                    counts[3] += 1;
                }
            }

            for (int count : counts) {
                sb.append(count).append(" ");
            }
            sb.append("\n");

            Arrays.fill(counts, 0);
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}