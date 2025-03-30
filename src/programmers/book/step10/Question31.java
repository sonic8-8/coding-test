package programmers.book.step10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Question31 {
    public static int solution(int[] nums) {
        //3 1 2 3
        //3번: 2마리
        //1번: 1마리
        //2번: 1마리

        //다양한 종류의 폰켓몬을 원함
        //중복되지 않게 선택해야됨

        //폰켓몬 번호: 200,000이하 자연수
        //이중 for문 x

        //문제1: nums의 길이의 절반만큼 폰켓몬을 선택한다
        //문제2: 폰켓몬의 종류가 중복되면 안된다
        //-> Set 사용하면 됨

        //3 1 2 3 -> 2종류
        //3 3 3 2 2 4 -> 3종류

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int choiceCount = nums.length / 2;

        if (set.size() >= choiceCount) {
            return choiceCount;
        } else {
            return set.size();
        }
    }

    public int solution2(int[] nums) {
        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        int choiceCount = nums.length / 2;

        return Math.min(set.size(), choiceCount);
    }

    public static void main(String[] args) {
        int answer = solution(new int[]{3,1,2,3});
        System.out.println("기댓값: 2");
        System.out.println("실제값: " + answer);
    }
}
