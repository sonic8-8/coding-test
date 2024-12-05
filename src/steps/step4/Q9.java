package steps.step4;

import java.util.Scanner;

public class Q9 {

    // 바구니 N개
    // 바꿀 횟수 M번
    // i번째 바구니와 j번째 바구니 순서를 역순으로 만든다.

    // 1. int n 입력받아서 크기가 n인 배열 생성 후 초기화
    // 2. int m 입력받아서 반복 횟수로 설정
    // 3. int i, j 입력받아서 index 역순으로 바꾸기

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int left = 0;
        int right = 0;

        // ------------------------------------------------

        // n 입력받기
        int n = sc.nextInt();

        // 배열 생성
        int[] array = new int[n];

        // 초기화
        for (int k = 0; k < n; k++) {
            array[k] = k+1;
        }

        // ------------------------------------------------

        // m 입력받기
        int m = sc.nextInt();

        // 반복횟수로 설정
        for (int k = 0; k < m; k++) {


            // ------------------------------------------------

            // i, j 입력받기
            int i = sc.nextInt();
            int j = sc.nextInt();

            // ★★ 주의 ★★
            // i가 j보다 클 수 있음

            // 작은 수와 큰 수를 설정
            if (i >= j) {
                left = j;
                right = i;
            } else {
                left = i;
                right = j;
            }

            // 교환
            while (left < right) {

                int temp = array[left-1];
                array[left-1] = array[right-1];
                array[right-1] = temp;

                left++;
                right--;
            }
        }

        for (int temp : array) {
            System.out.print(temp + " ");
        }

    }
}
