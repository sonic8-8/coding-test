package programmers.book.step13;

import java.util.Arrays;
import java.util.Comparator;

public class Question53 {
    public long solution(long n) {
        //여기선 프레미티브 타입 객체라서 Comparator.reverseOrder() 같은 정렬 기준을
        //Arrays.sort(arr, 여기); "여기"에 넣질 못함
        //만약 꼭 넣어야겠다면 arr 를 Character[]로 만들어줘야함
        char[] arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder(new String(arr)).reverse();
        return Long.parseLong(sb.toString());
    }
}
