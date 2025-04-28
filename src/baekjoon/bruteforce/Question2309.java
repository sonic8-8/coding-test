package baekjoon.bruteforce;

import java.util.*;
import java.io.*;

public class Question2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> numbers = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
            sum += numbers.get(i);
        }

        int target = sum - 100;

        int first = 0;
        int second = 0;

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j< numbers.size(); j++) {
                if (numbers.get(i) + numbers.get(j) == target) {
                    first = i;
                    second = j;
                    break;
                }
            }
            if (first != 0) {
                break;
            }
        }

        if (first > second) {
            numbers.remove(first);
            numbers.remove(second);
        } else {
            numbers.remove(second);
            numbers.remove(first);
        }

        Collections.sort(numbers);

        numbers.stream()
                .forEach(System.out::println);
    }
}
