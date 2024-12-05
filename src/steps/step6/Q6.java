package steps.step6;

import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        // 배열에 넣으면 되나?

        String[] croatiaAlphabets = new String[]
                {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        int count = 0;

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        for (String element : croatiaAlphabets) {
            input = input.replaceAll(element,"!");
        }

        count = input.length();

        System.out.println(count);
    }
}
