package steps.step5;

import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String voca = sc.nextLine();

        // 문자열.indexOf(매개변수)
        // 문자열 중에 매개변수에 해당하는 것이 있다면 그에 해당하는
        // 인덱스를 반환해주는 메서드

        for (char temp = 97 ; temp <= 122 ; temp++) {
            System.out.print(voca.indexOf(temp) + " ");
        }

    }
}
