package steps.step5;

import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        // 문자열 S 입력받기
        // R번 반복해서 새로운 문자열 P 만들기

        // 1. 테스트 케이스 개수 T개
        // 2. 반복 횟수 R, 문자열 S ( 길이는 1 이상 20이하 )

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        String P = "";
        String[] PArray = new String[T];

        for (int i = 0 ; i < T; i++) {

            int R = sc.nextInt();

            String S = sc.next();

            // ----------------------------------------------------
            // nextLine()과 next()의 차이!
            // next()는 개행문자를 무시하고 문자열을 읽음!
            // nextLine()은 개행문자를 무시하지 못함
            // ----------------------------------------------------

            if (S.length() < 1 || S.length() > 20) {
                S = sc.nextLine();
            }

            String[] SSplitArray = S.split("");

            for (int j = 0 ; j < S.length() ; j++) {
                String repeat = SSplitArray[j].repeat(R);
                P += repeat;
            }
            PArray[i] = P;
            P = "";
        }

        for (String temp : PArray) {
            System.out.println(temp);
        }

        // 문자열 글자 1개씩 반복 출력하는 방법
        // 1. for문 + charAt() 조합
        // 2. split("") + for문 + repeat() 조합

    }

}
