package coding_test.data_structure;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        // 백준: 11720번

        // 로직을 바로 작성하는 습관 X
        // 근거: N이 100까지 있음
        // 결론: int나 long으로 받을 수 없으니 String으로 받아라
        // 힌트: toCharArray()를 이용하라

        // 복잡한 문제일 경우
        // 1. 손으로 풀어보기
        // 2. 슈도코드 작성하기
        // 3. 코드 구현하기

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.nextLine();

        ArrayList<Integer> integers = new ArrayList<>();
        String numbers = sc.nextLine();

        char[] numbersCharArray = numbers.toCharArray();

        for (char numberChar : numbersCharArray) {
            integers.add((int) numberChar - 48);
        }

        int sum = integers.stream()
                .mapToInt(x -> x)
                .sum();

        System.out.println(sum);


    }
}
