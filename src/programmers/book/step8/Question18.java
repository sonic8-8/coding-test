package programmers.book.step8;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class Question18 {
    public static boolean solution(int[] arr, int target) {
        //n개의 양의 정수로 이루어진 배열 arr
        //문제1: 합이 target인 숫자 2개가 arr에 있는지 확인
        //-> 간단하게는 이중 for문으로 처리 가능할듯?
        //-> HashMap으로 처리한다면 for문 1번으로 처리 가능할듯?
        //-> 미리 target이 되게 만드는 값을 구해놓고 contains 사용하면 될듯?

        int[] needs = new int[arr.length];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);

            if (target - arr[i] <= 0) {
                needs[i] = -1;
            } else {
                needs[i] = target - arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (queue.contains(needs[i])) {
                return true;
            }
        }

        return false;
    }

    public static boolean solution2(int[] arr, int target) {
        //HashSet을 이용해서 풀 수 있음
        //Hash 단원이니까 이용해보면 좋을듯
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {

            if (hashSet.contains(target - arr[i])) {
                return true;
            }

            hashSet.add(arr[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        boolean answer1 = solution(new int[]{1, 2, 3, 4, 8}, 6);
        System.out.println("answer1 기대값: true");
        System.out.println("answer1 실제값: " + answer1);

        boolean answer2 = solution(new int[]{1, 2, 3, 4, 8}, 6);
        System.out.println("answer2 기대값: true");
        System.out.println("answer2 실제값: " + answer2);
    }
}
