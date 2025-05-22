package baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class Question10808 {
    static int[] alphabetCounts;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        alphabetCounts = new int[26];

        for (char ch : str.toCharArray()) {
            alphabetCounts[ch - 'a'] += 1;
        }

        for (int count : alphabetCounts) {
            sb.append(count).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
