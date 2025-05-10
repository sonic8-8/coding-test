package baekjoon.bruteforce_perm;

import java.util.*;
import java.io.*;

public class Question10819_nextPerm {
    static int N;
    static int[] array;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        max = 0;

        do {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(array[i] - array[i + 1]);
            }
            max = Math.max(max, sum);
        } while (hasNextPerm());

        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }

    private static boolean hasNextPerm() {
        int i = N - 1;
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }
        if (i == 0) {
            return false;
        }

        int j = N - 1;
        while (array[i - 1] >= array[j]) {
            j--;
        }
        swap (i - 1, j);
        reverse(i, N - 1);
        return true;
    }

    private static void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static void reverse(int start, int end) {
        while (start < end) {
            swap(start++, end--);
        }
    }
}
