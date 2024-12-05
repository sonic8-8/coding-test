package steps.step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10 {
    public static void main(String[] args) {

        // 타겟 : 다이얼을 거는데 필요한 시간 구하기
        // 1. 알파벳 대문자 단어 입력 ( 2 <= 단어 길이 <= 15 )
        // 1() 2(ABC) 3(DEF) ... 9(WXYZ) 0 순서로 나열돼있음
        // 1번 누를때 2초, 9번 누를때 10초 걸림, 0번 11초

        // 1. 문자열 입력받기, 단어 길이 조건
        // 2. 문자열 쪼개기 및 배열에 담기 ( split() 메서드 사용 )
        // 3. 각 문자열 아스키 코드로 표현하기 ( 정의대로 표현 = char형으로 바꾸기 )
        // 알파벳 대문자 A ~ Z = 아스키코드 65 ~ 90
        // 4. for - if문으로 3개씩 범위 나누기
        // 5. 범위마다 시간 맵핑하고 배열 전체 돌면서 더하기
        // 6. 단어길이만큼 시간 더하기

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            StringTokenizer st = new StringTokenizer(br.readLine(), "");

            String input = br.readLine();
            while (input.length() < 2 || input.length() > 15) {
                input = br.readLine();
            }

            String[] array = input.split("");

            int total = 0;

            for (String temp : array) {
                if ('A' <= temp.charAt(0) && temp.charAt(0) <= 'C') {
                    total += 2;
                } else if ('D' <= temp.charAt(0) && temp.charAt(0) <= 'F') {
                    total += 3;
                } else if ('G' <= temp.charAt(0) && temp.charAt(0) <= 'I') {
                    total += 4;
                } else if ('J' <= temp.charAt(0) && temp.charAt(0) <= 'L') {
                    total += 5;
                } else if ('M' <= temp.charAt(0) && temp.charAt(0) <= 'O') {
                    total += 6;
                } else if ('P' <= temp.charAt(0) && temp.charAt(0) <= 'S') {
                    total += 7;
                } else if ('T' <= temp.charAt(0) && temp.charAt(0) <= 'V') {
                    total += 8;
                } else if ('W' <= temp.charAt(0) && temp.charAt(0) <= 'Z') {
                    total += 9;
                }
            }

            System.out.println(total + input.length());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
