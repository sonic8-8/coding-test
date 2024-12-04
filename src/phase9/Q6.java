package phase9;

import java.util.ArrayList;
import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        ArrayList<Integer> candidates = new ArrayList<>();
        for (int i = 2; i <= input; i++) {
            candidates.add(i);
        }

        ArrayList<Integer> primeNumbers = new ArrayList<>();
        while (true) {
            int candidate = candidates.getFirst();

            primeNumbers.add(candidate);
            candidates.removeIf(n -> n % candidate == 0);

            // 더 이상 나누어지는게 없을때
            if (candidates.isEmpty()) {
                break;
            }
        }

        while (!primeNumbers.isEmpty()) {
            if (input % primeNumbers.getFirst() == 0) {
                input /= primeNumbers.getFirst();
                System.out.println(primeNumbers.getFirst());
            } else {
                primeNumbers.removeFirst();
            }
        }

    }
}
