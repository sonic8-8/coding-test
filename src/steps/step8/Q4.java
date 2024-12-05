package steps.step8;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        // 초기 점 4개
        // 중앙에 점을 찍어서 개수를 늘려나감
        // 패턴
        // 2 * 2 - (1) : 2
        // 3 * 3 - (2) : (1) + 2^0
        // 5 * 5 - (3) : (2) + 2^1
        // 9 * 9 - (4) : (3) + 2^2

        Scanner sc = new Scanner(System.in);
        double input = sc.nextInt();

        double sidePointCount = 2.0;

        for (int i = 0; i < input; i++) {
            sidePointCount += Math.pow(2.0, i);
        }

        double totalPointCount = sidePointCount * sidePointCount;

        System.out.println((int) totalPointCount);
    }
}
