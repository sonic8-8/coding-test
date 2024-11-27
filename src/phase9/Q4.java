package phase9;

import java.util.ArrayList;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        // prime number search

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (int i = 0; i < count; i++) {
            numbers.add(sc.nextInt());
        }

        int primeCount = count;
        for (int i = 0; i < count; i++) {

            if (numbers.get(i) == 1) {
                primeCount -= 1;
            }

            for (int j = 2; j < numbers.get(i); j++) {
                if (numbers.get(i) % j == 0) {
                    primeCount -= 1;
                    break;
                }
            }
        }

        System.out.println(primeCount);

    }
}
