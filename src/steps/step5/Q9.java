package steps.step5;

import java.util.Scanner;

public class Q9 {
    public static void main(String[] args) {
        // 같지 않은 세자리 수 2개를 입력받음
        // 입력받은 값을 역순으로 바꿈
        // 역순으로 바뀐 두 수를 비교

        // 같지 않음 + 세자리
        // 역순으로 바꾸기
        // 비교하기

        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        // 세자리 수
        while (num1 < 100 || num1 > 999) {
            num1 = sc.nextInt();
        }

        while (num2 < 100 || num2 > 999) {
            num2 = sc.nextInt();
        }

        // 중복 방지
        while (num1 == num2) {
            num2 = sc.nextInt();
            if (num2 < 100 || num2 > 999) {
                return;
            }
        }

        // 나눌 대상을 mod 10 계산해서 배열 변수에 담기
        // 나눌 대상을 10으로 나눠주기

        int target1 = num1;
        int target2 = num2;
        int[] digitArray1 = new int[3];
        int[] digitArray2 = new int[3];

        for (int i = 0 ; i < 3 ; i++) {
            digitArray1[i] = target1 % 10;
            target1 /= 10;
            digitArray2[i] = target2 % 10;
            target2 /= 10;
        }

        // 역순 배열 숫자 생성하기
        int reverseNum1 = digitArray1[0] * 100 + digitArray1[1] * 10 + digitArray1[2];
        int reverseNum2 = digitArray2[0] * 100 + digitArray2[1] * 10 + digitArray2[2];

        if (reverseNum1 > reverseNum2) {
            System.out.println(reverseNum1);
        } else {
            System.out.println(reverseNum2);
        }

    }
}
