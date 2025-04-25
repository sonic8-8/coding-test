package baekjoon.bruteforce;

import java.util.*;
import java.io.*;

class Question2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int number = 1; number < N; number++) {
            String str = String.valueOf(number);
            int sum = number;

            for (int j = 0; j < str.length(); j++) {
                sum += Integer.parseInt(String.valueOf(str.charAt(j)));
            }

            if (sum == N) {
                System.out.println(number);
                return;
            }
        }

        System.out.println(0);

        br.close();
    }
}
