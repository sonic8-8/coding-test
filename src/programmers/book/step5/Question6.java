package programmers.book.step5;

import java.util.HashMap;

public class Question6 {
    public int[] solution(int N, int[] stages) {

        //도전자
        int[] challenger = new int[N + 2]; //단계를 직관적으로 표현
        for (int i = 0; i < stages.length; i++) {
            challenger[stages[i]] += 1;
        }

        //총 도달한 플레이어 수
        int total = stages.length;

        //실패율 구하기 (challenger/total), 0명일 경우 fails가 double이니까 0.0으로 표현해줘야됨
        HashMap<Integer, Double> fails = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) {
                fails.put(i, 0.0);
            } else {
                fails.put(i, (double) challenger[i] / total);
                total -= challenger[i];
            }
        }

        //실패율을 내림차순으로 정렬 후 그에 맞는 스테이지 번호 배열을 return
        //-> 실패율을 map으로 만들기
        return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(HashMap.Entry::getKey).toArray();
    }
}
