package programmers.bruteforce;

// 에라토스테네스의 체 -> 소수 찾기
// 중복 제거 -> Set

import java.util.*;

class Question1 {

    Set<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        // 1. 모든 조합의 수를 만든다
        recursive("", numbers);

        // 2. 소수의 개수만 센다
        Iterator<Integer> it = numberSet.iterator();

        int count = 0;
        while (it.hasNext()) {
            int number = it.next();
            if (isPrime(number)) {
                count++;
            }
        }

        // 3. 소수의 개수를 반환한다
        return count;
    }

    private void recursive(String current, String others) {
        // 1. 현재 조합을 set에 추가한다
        if (!current.equals("")) {
            numberSet.add(Integer.valueOf(current));
        }

        // 2. 남은 숫자 중 한 개를 더해 새로운 조합을 만든다
        for (int i = 0; i < others.length(); i++) {
            recursive(current + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }

    private boolean isPrime(int number) {
        // 1. 0과 1은 소수가 아니다
        if (number == 0 || number == 1) {
            return false;
        }

        // 2. 에라토스테네스의 체의 limit 숫자를 계산한다
        int limit = (int) Math.sqrt(number);

        // 3. 에라토스테네스의 체에 따라 limit까지 배수 여부를 확인한다
        for (int i = 2; i <= limit; i++) {
            if (number % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question1 q = new Question1();
        System.out.println(q.solution("17"));
    }
}
