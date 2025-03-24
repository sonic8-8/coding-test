package programmers.book.step8;

import java.util.*;
import java.util.stream.Stream;

public class Question22 {
    public static int[] solution(String[] genres, int[] plays) {
        //고유 번호, 수록 기준
        //장르, 재생수 높은 것 두개까지 모은다

        //문제1: 장르랑 재생수가 따로 배열에 담겨있음
        //-> HashMap에 넣어서 비교하면 편할듯

        //문제2: 노래마다 고유번호 (인덱스)가 있음
        //-> HashMap 인덱스가 있어서 나중에 맵핑해줘야됨

        //문제3: 장르별 > 재생수 > 같을 경우 고유번호 낮은 것
        //장르별로 나눈 다음 노래별로 비교를 한 번 더 해야함
        //Map으로 한 번 더 정렬?

        //문제4: 장르가 뭐가 올지 정해져있는게 아님 뭐가 올지 모름

        //문제5: 장르, 재생수, 인덱스 3개가 물려있어서 복잡하게 느껴짐
        //-> 구조가 좀 복잡하긴한데 HashMap<String, ArrayList<int[인덱스, 재생수]>> 이렇게 하면
        //-> 장르, 재생수, 인덱스를 다 묶을 수 있음

        //play별로 정렬
        //많이 재생된 것 2개 계산하려고

        //문제6: o1, o2 인식이 안됨
        //매개변수가 int[] 라는것을 명시적으로 표시해줘야됨!

        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        HashMap<String, Integer> totalPlayMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (!genreMap.containsKey(genres[i])) {
                genreMap.put(genres[i], new ArrayList<>());
            }
            genreMap.get(genres[i]).add(new int[]{i, plays[i]});
            totalPlayMap.put(genres[i], totalPlayMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        totalPlayMap.entrySet().stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))
                .forEach(entry -> {
                    genreMap.get(entry.getKey()).stream()
                            .sorted(Comparator.comparingInt((int[] o) -> o[1]).reversed())
                            .limit(2)
                            .forEach(song -> answer.add(song[0]));
                });
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] answer = solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        System.out.println("기댓값: [4, 1, 3, 0]");
        System.out.println("실제값: " + Arrays.toString(answer));
    }
}
