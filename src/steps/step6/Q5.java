package steps.step6;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Q5 {
    public static void main(String[] args) {
        // 대문자, 소문자를 구분하지 않고 가장 많이 사용된 알파벳 알아내는 프로그램
        // 그냥 알파벳 개수 등장할때 1개씩 증가시키고
        // 이전에 있었던 문자라면 거기에 더하면 되는거 아님?
        // 마지막에는 가장 숫자가 높은 문자 출력
        // key-value 형식이 나을듯?
        // Map 자료형 사용해보기

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String upperCase = input.toUpperCase();

        Map<Character, Long> upperCaseMap = upperCase.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Long, List<Character>> groupedByValueMap = upperCaseMap.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        Long maxValue = Collections.max(groupedByValueMap.keySet());
        List<Character> maxValueAlphabets = groupedByValueMap.get(maxValue);

        if (maxValueAlphabets.size() > 1) {
            System.out.println("?");
        } else {
            System.out.println(maxValueAlphabets.getFirst());
        }
    }
}
