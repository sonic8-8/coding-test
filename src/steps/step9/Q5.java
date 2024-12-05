package steps.step9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        int max = sc.nextInt();

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int number = min; number <= max; number++) {
            numbers.add(number);
        }

        List<Integer> primeNumbers = numbers.stream()
                .filter(number -> isPrimeNumber(number))
                .toList();
//                .collect(toList()); 백준에선 toList()를 인식을 못함 16버전부터 추가된거라

        if (primeNumbers.isEmpty()) {
            System.out.println(-1);
        } else {

            int sum = primeNumbers.stream()
                    .mapToInt(number -> number)
                    .sum();
            System.out.println(sum);

            primeNumbers.stream()
                    .min(Integer::compareTo)
                    .ifPresent(System.out::println);
        }
    }

    private static boolean isPrimeNumber(Integer number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
