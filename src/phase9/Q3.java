package phase9;

import java.util.ArrayList;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int factorSum = 0;

        while (true) {

            int input = sc.nextInt();
            ArrayList<Integer> factors = new ArrayList<Integer>();

            if (input == -1) {
                break;
            }

            // 약수 구하기
            for (int i = 1; i < input; i++) {
                if (input % i == 0) {
                    factors.add(i);
                    factorSum += i;
                }
            }

            if (input == factorSum) {
                System.out.print(input + " = ");

                for (int i = 0; i < factors.size(); i++) {
                    System.out.print(factors.get(i));
                    if (i < factors.size() - 1) {
                        System.out.print(" + ");
                    } else {
                        System.out.println();
                    }
                }
            } else {
                System.out.println(input + " is NOT perfect.");
            }

            factorSum = 0;
            factors = null;

        }
    }
}
