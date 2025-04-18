package programmers.book.step13_sorting;

import java.util.*;

public class Question51 {
    private static int[] solution(int[] arr1, int[] arr2) {
        //merge sort 구현
        //쪼갠 다음 다시 합치면서 정렬
        //todo: merge sort 구현

        //sort 메서드 사용 연습
        int[] merged = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            merged[i] = arr1[i];
        }

        for (int i = arr1.length; i < arr1.length + arr2.length; i++) {
            merged[i] = arr2[i - arr1.length];
        }

        Arrays.sort(merged);
        return merged;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 5}, new int[]{2, 4, 6})));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3}, new int[]{4, 5, 6})));
    }
}
