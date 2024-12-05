package steps.step5;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        // 1. 테스트 케이스 T개
        // 2. 첫글자와 마지막글자를 출력

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // 공백 입력 제거
        sc.nextLine();

        // 문자열 입력
        String[] array = new String[T];
        for (int i = 0 ; i < T ; i++) {
            array[i] = sc.nextLine();
        }

        for (int i = 0 ; i < T ; i++) {
            int length = array[i].length();
            char max = array[i].charAt(length-1);
            char min = array[i].charAt(0);
            System.out.println(min + "" + max);
        }

    }
}
