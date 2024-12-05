package steps.step5;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        // String을 CharArray로 변환 후 int형으로 바꾸기
        System.out.println((int)input.toCharArray()[0]);
    }
}
