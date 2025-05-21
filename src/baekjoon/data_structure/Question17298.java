package baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class Question17298 {
    static int N;
    static int[] array;
    static int[] nge;
    static Stack<Integer> indexStack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        array = new int[N];
        nge = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            while (!indexStack.isEmpty() && array[indexStack.peek()] < array[i]) {
                nge[indexStack.pop()] = array[i];
            }
            indexStack.push(i);
        }

        while (!indexStack.isEmpty()) {
            nge[indexStack.pop()] = -1;
        }

        for (int num : nge) {
            sb.append(num).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
