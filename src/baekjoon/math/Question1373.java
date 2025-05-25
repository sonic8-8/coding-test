package baekjoon.math;

import java.io.*;
import java.util.*;

public class Question1373 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        if (str.length() % 3 != 0) {
            for (int i = 0; i < str.length() % 3; i++) {
                str = "0" + str;
            }
        }

        for (int i = 0; i < str.length(); i += 3) {
            String threeBits = str.substring(i, i + 3);
            int decimal = Integer.parseInt(threeBits, 2);
            sb.append(decimal);
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
