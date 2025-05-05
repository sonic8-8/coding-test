package baekjoon.greedy;

import java.io.*;

public class Question2138 {
    static final int MAX = 100000 + 10;
    static int N;
    static int[] arrayA;
    static int[] arrayB;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arrayA = new int[MAX];
        arrayB = new int[MAX];


        String strA = br.readLine();
        String strB = br.readLine();
        for (int i = 1; i <= N; i++) {
            arrayA[i] = strA.charAt(i -1) - '0';
            arrayB[i] = strB.charAt(i -1) - '0';
        }

        int firstPress = simulate(true);
        int notFirstPress = simulate(false);

        if (firstPress == -1 && notFirstPress != -1) {
            count = notFirstPress;
        } else if (firstPress != -1 && notFirstPress == -1) {
            count = firstPress;
        } else {
            count = Math.min(firstPress, notFirstPress);
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }

    private static void toggleSwitch(int index, int[] array) {
        for (int i = index - 1; i <= index + 1; i++) {
            if (i >= 1 && i <= N) {
                array[i] = 1 - array[i];
            }
        }
    }

    private static int simulate(boolean isFirstPress) {
        int[] cloneArrayA = arrayA.clone();
        int count = 0;

        if (isFirstPress) {
            toggleSwitch(1, cloneArrayA);
            count++;
        }

        for (int i = 2; i <= N; i++) {
            if (cloneArrayA[i - 1] != arrayB[i - 1]) {
                toggleSwitch(i, cloneArrayA);
                count++;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (cloneArrayA[i] != arrayB[i]) {
                return -1;
            }
        }
        return count;
    }
}
