package programmers.book.step5;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class Question2 {

    // 배열 제어하기
    // 정수 배열 받아서 중복 값 제거하고 내림차순을 정렬해서 반환하는 solution() 함수 구현하기

    // 제약 조건
    // 배열 길이: 1,000 이하
    // 각 배열 데이터 값: -100,000 ~ 100,000

    // 만들어진 API 를 적극적으로 사용하자
    private int[] solution(int[] array) {

        Integer[] result = Arrays.stream(array).boxed().distinct().toArray(number -> new Integer[number]);
        Arrays.sort(result, Collections.reverseOrder());

        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }


    // 직접 작성할 경우 아래와 같음
    private int[] solution2(int[] array) {

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }

        int[] result = new int[set.size()];
        for (int i = 0; i < array.length; i++) {
            result[i] = set.pollFirst();
        }

        return result;
    }


}
