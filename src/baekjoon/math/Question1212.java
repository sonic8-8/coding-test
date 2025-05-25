package baekjoon.math;

import java.io.*;
import java.util.*;

public class Question1212 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String octalBits = br.readLine();
        for (int i = 0; i < octalBits.length(); i++) {
            int octalBit = octalBits.charAt(i) - '0';
            String binaryBits = Integer.toBinaryString(octalBit);

            while (i != 0 && binaryBits.length() < 3) {
                binaryBits = "0" + binaryBits;
            }
            sb.append(binaryBits);
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
