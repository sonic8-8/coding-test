package programmers.book.step10;

import java.util.ArrayList;
import java.util.HashSet;

public class Question32 {
    public int[] solution(int n, String[] words) {
        //가장 먼저 탈락하는 사람 번호
        //자신의 몇 번째 차례에서 탈락하는지 구하기
        //[번호, 차례]
        //n: 참여자 수
        //words: 단어 순서 배열

        //문제1: 중복인지 아닌지 확인해야됨
        //-> Set을 사용

        //문제2: 자신의 차례를 구할 수 있어야함
        //-> words의 배열 크기를 사람 수로 나누면 될듯

        HashSet<String> set = new HashSet<>();

        ArrayList<Integer> answer = new ArrayList<>();

        String beforeLast = "";

        for (int i = 0; i < words.length; i++) {
            //중복 검증
            if (set.contains(words[i]) && answer.isEmpty()) {
                answer.add((i % n) + 1);
                answer.add((i / n) + 1);
            }
            //규칙 못지켰을 경우
            String[] wordSplits = words[i].split("");
            String first = wordSplits[0];
            if (!beforeLast.equals(first)) {
                answer.add((i % n) + 1);
                answer.add((i / n) + 1);
            }

            beforeLast = wordSplits[words[i].length() - 1];
            set.add(words[i]);
        }

        if (answer.isEmpty()) {
            answer.add(0);
            answer.add(0);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution2(int n, String[] words) {
        HashSet<String> set = new HashSet<>();

        //첫 번째 단어의 첫글자로 초기화
        String beforeLast = words[0].split("")[0];

        for (int i = 0; i < words.length; i++) {
            //중복 검증 + 첫 글자와 이전 단어 끝 글자가 일치하는지 확인
            String[] wordSplits = words[i].split("");
            String first = wordSplits[0];

            if (set.contains(words[i]) || !beforeLast.equals(first)) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }

            beforeLast = wordSplits[words[i].length() - 1];
            set.add(words[i]);
        }

        return new int[]{0, 0};
    }

    public int[] solution3(int n, String[] words) {
        //solution2는 시간 초과가 나옴
        //split() 메서드는 배열을 만들어야하기때문
        HashSet<String> set = new HashSet<>();

        //첫 번째 단어의 첫글자로 초기화
        char beforeLast = words[0].charAt(0);

        for (int i = 0; i < words.length; i++) {
            //중복 검증 + 첫 글자와 이전 단어 끝 글자가 일치하는지 확인
            char currentFirst = words[i].charAt(0);

            if (set.contains(words[i]) || beforeLast != currentFirst) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }

            beforeLast = words[i].charAt(words[i].length() - 1);
            set.add(words[i]);
        }

        return new int[]{0, 0};
    }
}
