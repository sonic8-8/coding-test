package baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class Question10809 {
    static int[] alphabetIndices;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        alphabetIndices = new int[26];
        Arrays.fill(alphabetIndices, -1);
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (alphabetIndices[ch - 'a'] == -1) {
                alphabetIndices[ch - 'a'] = i;
            }
        }

        for (int idx : alphabetIndices) {
            sb.append(idx).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
