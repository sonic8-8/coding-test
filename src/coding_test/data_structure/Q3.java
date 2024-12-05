package coding_test.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3 {
    public static void main(String[] args) throws IOException {
        // 합 배열
        // 합 배열을 하나 만들어서 풀면 될듯
        // 1억번 연산 = 대략 1초

        // 백준: 11659번
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int size = Integer.parseInt(tokens[0]);
        int count = Integer.parseInt(tokens[1]);

        String[] numbers = br.readLine().split(" ");
        int[] S = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            S[i] = S[i - 1] + Integer.parseInt(numbers[i - 1]);
        }

        for (int k = 0; k < count; k++) {
            String[] ranges = br.readLine().split(" ");
            int i = Integer.parseInt(ranges[0]);
            int j = Integer.parseInt(ranges[1]);
            System.out.println(S[j] - S[i - 1]);
        }

    }
}
