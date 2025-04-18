package programmers.book.step16_greedy;

import java.util.*;

public class Question77 {

    private static int[] solution(int amount) {
        // 화폐 단위 1, 10, 50, 100을 최소한으로 사용한 화폐 리스트 반환
        int[] moneys = new int[]{100, 50, 10, 1};
        ArrayList<Integer> result = new ArrayList<>();

        for (int money : moneys) {
            int count = amount / money;
            amount %= money;

            for (int i = 0; i < count; i++) {
                result.add(money);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(123)));
        System.out.println(Arrays.toString(solution(350)));
    }
}
