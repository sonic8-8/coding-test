package steps.step5;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        // String S
        // int i
        // S의 i번째 글자 출력하기

        // 1. S와 i 입력받기
        // 2. String의 index를 i-1과 대응시키기

        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        int i = sc.nextInt();

        System.out.println(S.charAt(i-1));
    }
}
