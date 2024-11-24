package phase8;

import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        // 1 1 = 2

        // 1 2 = 3
        // 2 1 = 3

        // 3 1 = 4
        // 2 2 = 4
        // 1 3 = 4

        // 1 4 = 5

        int[] numbers = { 0, 0 };

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        int floor = 1;
        int room = 1;

        // 층수 구하기
        while (input > room) {
            input -= room;
            floor++;
            room++;
        }

        // 홀수층, 짝수층 첫번째 분수 초기화
        if (floor % 2 == 0) {
            numbers[0] = 1;
            numbers[1] = floor;
        } else {
            numbers[0] = floor;
            numbers[1] = 1;
        }

        // 분수 계산
        for (int i = 0; i < input - 1; i++) {

            if (floor % 2 == 0) {
                numbers[0]++;
                numbers[1]--;
            } else {
                numbers[0]--;
                numbers[1]++;
            }
        }

        System.out.println(numbers[0] + "/" + numbers[1]);

    }
}
