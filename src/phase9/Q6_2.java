package phase9;

import java.util.ArrayList;
import java.util.Scanner;

public class Q6_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        ArrayList<Integer> primeFactors = new ArrayList<Integer>();

        for (int candidate = 2; candidate <= Math.sqrt(input); candidate++) {
            while (input % candidate == 0) {
                input /= candidate;
                primeFactors.add(candidate);
            }
        }

        for (Integer primeFactor : primeFactors) {
            System.out.println(primeFactor);
        }

        if (input > 1) {
            System.out.println(input);
        }

    }
}
