package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class Question12015 {
    static int N;
    static int[] array;
    static ArrayList<Integer> lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        array = new int[N];
        lis = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int preIndex = Collections.binarySearch(lis, array[i]);
            int index = preIndex < 0 ? (preIndex + 1) * -1 : preIndex;

            if (index >= lis.size()) {
                lis.add(array[i]);
            } else {
                lis.set(index, array[i]);
            }
        }

        int answer = lis.size();

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}