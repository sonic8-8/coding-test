package steps.step4;

import java.util.Scanner;

public class Q10 {
    public static void main(String[] args) {

        // 과목 개수 N개 입력 받기
        // 현재 성적 입력받기, 최댓값이 M
        // 점수 수정 : (점수 / M) * 100
        // 새로운 평균 구하기

        // 1. 과목 개수 입력받기
        // 2. 성적 입력받기, 최댓값 찾는 로직
        // 3. 점수 수정하기
        // 4. 새로운 평균 구하기 ( 소수점 2번째 자리 )

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = 0;
        int array[] = new int[N];

        for (int i = 0 ; i < N ; i++) {
            array[i] = sc.nextInt();

            if (array[i] >= M) {
                M = array[i];
            }

        }

        double total = 0;

        for (int i = 0 ; i < N ; i++) {
            int temp = array[i];

            double change = ( (double)temp / M ) * 100;

            total += change;
        }

        double avg = total / N;
        System.out.println(avg);


    }
}
