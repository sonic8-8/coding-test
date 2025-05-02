package baekjoon.dp;

import java.util.*;
import java.io.*;

public class Question11053_binarysearch_greedy {
    static int N;
    static int[] array;
    static ArrayList<Integer> dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        array = new int[N + 1];
        dp = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int last = dp.size() - 1;
            if (dp.isEmpty() || dp.get(last) < array[i]) {
                dp.add(array[i]);
            } else {
                int index = Collections.binarySearch(dp, array[i]);
                if (index < 0) {
                    index = -(index + 1);
                }
                dp.set(index, array[i]);
            }
        }

        bw.write(String.valueOf(dp.size()));

        br.close();
        bw.close();
    }
}
