package baekjoon.im;

import java.io.*;
import java.util.*;

public class Question2309 {
    static List<Integer> candidates = new ArrayList<>();
    static int[] fakes;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sum = 0;
        for (int i = 0; i < 9; i++) {
            candidates.add(Integer.parseInt(br.readLine()));
            sum += candidates.get(i);
        }

        Collections.sort(candidates);
        fakes = new int[2];

        outer:
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - (candidates.get(i) + candidates.get(j)) == 100) {
                    fakes[0] = candidates.get(i);
                    fakes[1] = candidates.get(j);
                    break outer;
                }
            }
         }

        StringBuilder sb = new StringBuilder();
        for (int candidate : candidates) {
            if (candidate == fakes[0] || candidate == fakes[1]) {
                continue;
            }
            sb.append(candidate).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
