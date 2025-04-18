package programmers.book.step16_greedy;

import java.util.*;

public class Question78 {
    public static void main(String[] args) {
        int[][] items1 = {{10, 19}, {7, 10}, {6, 10}};
        System.out.println(solution(items1, 15));
        int[][] items2 = {{10, 60}, {20, 100}, {30, 120}};
        System.out.println(solution(items2, 50));
    }

    private static double solution(int[][] items, int weight_limit) {
        // 부분 베낭 문제
        // 무게를 쪼갤 수 있음

        // 그릇: weight_limit
        // 목표: "최대" 가치로 채우기

        // item[][무게, 가치]
        // 기준: 무게당 가치 높은 것 우선으로 넣기

        Arrays.sort(items, Comparator.comparingDouble(o -> - (double) o[1] / o[0]));

        double totalValue = 0;

        for (int[] item : items) {
            int item_weight = item[0];
            int item_value = item[1];
            double valuePerWeight = (double) item_value / item_weight;

            if (weight_limit >= item_weight) {
                totalValue += item_value;
                weight_limit -= item_weight;
            } else {
                totalValue += valuePerWeight * weight_limit;
                break;
            }
        }
        return totalValue;
    }
}
