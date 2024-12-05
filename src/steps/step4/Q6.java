package steps.step4;

import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
//        n개 바구니; ( 1 ~ 100 )
//        바구니 1번 : 공 1번;
//        바구니 2번 : 공 2번;
//        바구니 N번 : 공 N번;
//        M번 공을 바꿈; ( 1 ~ 100 )
//        바꿀 바구니 2개 선택해서 교환;
//        i번과 j번 교환;
//
//        1) N개 바구니 공 M번 교환;
//        2) M번 교환 진행 ( i번과 j번 교환 )

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];

        for (int temp = 0 ; temp < n ; temp++) {
            array[temp] = temp + 1;
        }

        int m = sc.nextInt();

        for (int count = 0 ; count < m ; count++) {

            int i = sc.nextInt();
            int j = sc.nextInt();

            int temp = array[i - 1];
            array[i - 1] = array[j - 1];
            array[j - 1] = temp;
        }

        for (int temp = 0 ; temp < n ; temp++) {
            if ( temp == (n-1) ) {
                System.out.println(array[temp]);
            } else {
                System.out.print(array[temp] + " ");
            }
        }

    }
}
