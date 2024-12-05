package steps.step5;

import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {
        // 단어 개수 세기 ( 중복된 단어도 세어야 함 )
        // 1번째 줄 문자열 입력

        Scanner sc = new Scanner(System.in);

        // 주의할점
        // next()와 nextLine()을 구분해서 사용해야함
        // next()는 공백을 무시하기 때문에 띄어쓰기가 들어간 문장을 입력하면 공백이 나왔을때 더 이상 입력을 받지 않음

        String s = sc.nextLine();

        // 스페이스 바 1번만 입력할 경우 1이 출력되는 문제 해결
        if (s.equals(" ")) {
            System.out.println(0);
            return;
        }

        // 문자열 앞뒤 공백을 제거하는 방법
        // (1) 문자열.strip()
        // (2) 문자열.trim()
        // strip()은 모든 공백을 제거할 수 있고
        // trim()은 스페이스 바와 탭으로 생긴 공백만 제거해줌


        String[] sArray = s.strip().split(" ");

        // array의 개수를 출력할 수 있음
        System.out.println(sArray.length);

    }
}
