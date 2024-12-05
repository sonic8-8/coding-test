package coding_test.data_structure;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        // 백준: 1546번

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        ArrayList<Integer> grades = new ArrayList<>();
        for (int i = 0; i < input; i++) {
            grades.add(sc.nextInt());
        }

        double max = grades.stream()
                .mapToDouble(x -> x)
                .max()
                .getAsDouble();

        double sum = grades.stream()
                .mapToDouble(x -> x)
                .sum();

        System.out.println((sum / max * 100) / input);
    }
}
