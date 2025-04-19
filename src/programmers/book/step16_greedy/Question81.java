package programmers.book.step16_greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Question81 {
    public int solution(int k, int[] tangerine) {
        //귤 수확해서 k개가 한 상자 (limit = k개)
        //귤 크기로 종류를 나눔. 서로 다른 종류의 수가 "최소"가 되도록 해야함
        //기준: 가장 많이 나오는 걸 우선 넣어보기 그래야 최소 종류가 될 듯?

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Comparator.comparing(o -> -o.getValue()));

        System.out.println(entries.toString());

        int typeCount = 0;
        int limit = k;

        for (Map.Entry<Integer, Integer> entry : entries) {
            int count = entry.getValue();
            if (limit > count) {
                limit -= count;
                typeCount++;
            } else {
                typeCount++;
                break;
            }
        }
        return typeCount;
    }

    public int solution2(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        ArrayList<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Comparator.reverseOrder());

        int typeCount = 0;
        int remaining = k;

        for (int count : counts) {
            remaining -= count;
            typeCount++;

            if (remaining <= 0) {
                break;
            }
        }
        return typeCount;
    }
}
