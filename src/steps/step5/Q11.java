package steps.step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11 {
    public static void main(String[] args) {

        // 입력받은대로 출력하기 ( 앞뒤 공백 x )
        // 발견 : 최대 100자를 입력받지만 어디까지 입력받는지 안나옴
        // 즉, 몇글자까지 입력받을지 모름
        // 전형적인 EOF (End of File) 패턴임 다시말해 파일의 끝을 알아내기.

        // 계속 입력받지만 ( 반복문 ) 어디까지 입력받는지 안나옴
        // 발견 : 입력받다가 마지막에 공백이 나오면 거기서 입력 받기 중단
        // 정의대로 표현 : 조건문으로 표현하기

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = null;

            // null이 아닐때까지 입력받기
            while ( (input = br.readLine()) != null ) {
                System.out.println(input);
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
