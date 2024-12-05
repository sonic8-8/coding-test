package steps.step6;

import java.util.Arrays;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        // 단어가 팰린드롬인지 확인?
        // 앞으로 읽는것과 거꾸로 읽는게 같은것

        boolean palindrome = false; // 0이면 false, 1이면 true

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringBuffer sb = new StringBuffer(input);
        String reverse = sb.reverse().toString();

        String[] splitInput = input.split("");
        String[] splitReverse = reverse.split("");

        palindrome = Arrays.equals(splitInput, splitReverse);

        if (palindrome) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
