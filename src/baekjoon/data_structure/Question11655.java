package baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class Question11655 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                sb.append((char) ((ch - 'A' + 13) % 26 + 'A'));
            } else if (Character.isLowerCase(ch)) {
                sb.append((char) ((ch - 'a' + 13) % 26 + 'a'));
            } else {
                sb.append(ch);
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
