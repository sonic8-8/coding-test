package baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class Question11656 {
    static StringBuilder sb = new StringBuilder();
    static String[] suffixes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        suffixes = new String[str.length()];

        for (int i = 0; i < str.length(); i++) {
            suffixes[i] = str.substring(i);
        }

        Arrays.sort(suffixes);

        for (String suffix : suffixes) {
            sb.append(suffix).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
