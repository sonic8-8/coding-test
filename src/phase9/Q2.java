package phase9;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int index = sc.nextInt() - 1;

        ArrayList<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }

        int totalFactorCount = factors.size();

        if (totalFactorCount > index) {
            System.out.println(factors.get(index));
        } else {
            System.out.println(0);
        }

    }
}
