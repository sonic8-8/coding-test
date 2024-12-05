package steps.step6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q7 {
    public static void main(String[] args) {
        // 그룹단어
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();

        String[] words = new String[count];

        for (int i = 0; i < count; i++) {
            words[i] = sc.nextLine();
        }

        Set<String> duplicateCheckSet = new HashSet<>();
        String prev = "";

        boolean[] groupWordStatuses = new boolean[count];
        Arrays.fill(groupWordStatuses, true);

        for (int i = 0; i < words.length; i++) {
            for (String current : words[i].split("")) {
                if (!current.equals(prev)) {
                    if (duplicateCheckSet.contains(current)) {
                        groupWordStatuses[i] = false;
                    }
                }
                prev = current;
                duplicateCheckSet.add(current);
            }
            duplicateCheckSet.clear();
        }
        int groupWordCount = 0;

        for (boolean groupWordStatus : groupWordStatuses) {
            if (groupWordStatus == true) {
               groupWordCount++;
            }
        }

        System.out.println(groupWordCount);

        // 1번째 방법
        // a를 기준으로 인덱스를 모두 기록해놔
        // 0 1 2 6 이렇게 되겠지
        // 0을 기준으로 1씩 더해가면서 마지막 인덱스가 나오는지 확인

        // 2번째 방법
        // a를 기준으로 인덱스를 기록하는 건 맞음
        // 예상된 다음 값을 변수에 담아놔
        // 예상된 값은 현재 인덱스에 1을 더한 값임
        // 예상된 값이 실제 값과 맞거나 실제 값이 존재하지 않는다면 통과
        // 예상된 값이 실제 값과 다르다면 그룹 단어가 아님

        // 3번째 방법 시도
        // stream API를 이용한 중복제거
        // stream.distinct()를 사용하기
        // 근데 stream.distinct()는 aabba같은 문자열도 ab로 바꿔버림.
        // 말그대로 중복되기만 하면 삭제하는거임

        // 4번째 방법
        // Set을 이용해 중복된 문자가 있는지 확인하는 방법


    }
}
