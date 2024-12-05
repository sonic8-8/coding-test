package steps.step4;

import java.util.Scanner;

public class Q8 {

    // 문제
    // 정수 10개 입력받고 각각 42로 나눈 나머지 구하기
    // 서로 다른 나머지가 몇 개 인지 확인하기
    // 0 < 정수 <= 1000

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int array[] = new int[10];

        for (int i = 0; i < 10; i++) {
            int num = sc.nextInt();
            array[i] = num % 42;
        }


        // 나머지를 모두 넣어놓은 배열을 생성했음
        // 필요한 한 것은 비교해서 같은지 다른지 확인하는 것
        // 같은 값이면 count++
        // 전체 횟수에서 count를 빼면 서로 다른 나머지
        int count = 0;


        for (int i = 0 ; i < 10 ; i++) {
            for (int j = i + 1 ; j < 10 ; j++) {
                if (array[i] == array[j]) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(10 - count);

    }
}
