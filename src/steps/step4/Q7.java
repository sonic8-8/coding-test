package steps.step4;

import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        // 30명
        // 제출 안 한 2명 구하기
        // 랜덤 번호를 넣으면 제출하지 않은 학생들 번호를 구해줌
        // 1) 입력받기 28번
        // 2) 그 중에서 없는 번호 찾기
        // 3) 작은 번호 먼저 출력하기

        // 1번째 시도
        // 미리 1 ~ 30까지 숫자를 적어놓은 배열을 두기
        // 새로 숫자를 입력받은 배열을 생성
        // 입력받은 배열과 1 ~ 30까지 배열을 반복문으로 비교하기
        // 만약 일치하는게 없다면 변수 num1에 저장하기
        // 마찬가지로 나머지도 찾고 변수 num2에 저장하기
        // num1과 num2 비교해서 작은것 먼저 출력하기

        // 2번째 시도
        // 반복문 사용하기
        // 30칸짜리 배열 생성해서 0으로 초기화
        // 1을 넣으면 index 0
        // 2를 넣으면 index 1
        // 3을 넣으면 index 2
        // 에 설정해두고 입력받아서 배열에 넣기
        // 반복문으로 값이 0인 배열의 index 찾기


        int array[] = new int[30];
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 28; i++) {
            int num = sc.nextInt();
            array[num-1] = num;
        }

        for (int i = 0; i < 30; i++) {
            if (array[i] == 0)  {
                System.out.print(i+1 + " ");
            }
        }



    }
}
