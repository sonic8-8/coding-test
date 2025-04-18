package programmers.book.step13;

import java.util.*;

public class Question50 {
    public static String solution(String s) {
        // counting sort 구현
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Comparator.comparing(Map.Entry<Character, Integer>::getKey).thenComparing(Map.Entry::getValue));

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entries) {
            sb.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("hello"));
        System.out.println(solution("algorithm"));
    }

}
