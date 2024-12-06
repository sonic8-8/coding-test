package coding_test.data_structure;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        // 백준: 2018번
        // O(n)의 시간복잡도인 투 포인터를 사용

        // 하나하나 더한다는 개념이 아니라 뭉탱이로 봐야함
        // 합이 크면 범위를 줄이기 위해 left++
        // 합이 작으면 범위를 키우기 위해 right++

        // [1 2 3 4 5 6] 7 -> [21] 7 8 9
        // 0 [2 3 4 5 6] 7 -> [20] 7 8 9
        // 0 0 [3 4 5 6] 7 -> [18] 7 8 9
        // 0 0 0 [4 5 6] 7 -> [15] 7 8 9
        // 0 0 0 0 [5 6] 7 -> [11] 7 8 9

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        int left = 1;
        int right = 1;
        int sum = 1;
        int count = 0;

        while (left <= input) {

            if (sum == input) {
                count++;
                sum -= left;
                left++;
            }
            if (sum < input) {
                right++;
                sum += right;
            }
            if (sum > input) {
                sum -= left;
                left++;

            }
        }
        System.out.println(count);

    }
}
