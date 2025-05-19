package baekjoon.data_structure;

import java.io.*;

public class Question17413 {
    static StringBuilder sb = new StringBuilder();
    static StringBuilder wordBuilder = new StringBuilder();
    static boolean isInTag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '<') {
                sb.append(wordBuilder.reverse());
                wordBuilder.setLength(0);
                isInTag = true;
                sb.append(ch);
            } else if (ch == '>') {
                isInTag = false;
                sb.append(ch);
            } else if (isInTag) {
                sb.append(ch);
            } else {
                if (ch == ' ') {
                    sb.append(wordBuilder.reverse()).append(' ');
                    wordBuilder.setLength(0);
                } else {
                    wordBuilder.append(ch);
                }
            }
        }

        sb.append(wordBuilder.reverse());

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
