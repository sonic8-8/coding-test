package programmers.book.step5;

import java.util.Arrays;

public class Question1 {

    // 정수 배열을 정렬해서 반환하는 solution() 함수를 완성하세요

    // 제약 조건
    // 정수 배열 길이: 2 이상 10^5 이하
    // 정수 배열의 각 데이터 값: -100,000 이상 100,000 이하
    // 제한 시간: 3초

    private int[] solution(int[] array) {
        Arrays.sort(array);
        return array;
    }

    // 제약 조건이 100,000 이니까
    // 버블 정렬 같은 O(N^2)은 사용할 수 없음
    // 1억번 연산을 1초라고 생각하면 되는데
    // 10초 걸림

    private int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j +1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
